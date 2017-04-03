package com.linghushaoxia.et.translate.search;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.linghushaoxia.et.translate.cache.DictCache;
import com.linghushaoxia.et.translate.config.ConfigConst;
import com.linghushaoxia.et.translate.model.king.Dict;
import com.linghushaoxia.et.translate.model.king.KingDictJson;
import com.linghushaoxia.et.translate.model.king.KingDictXml;
import com.linghushaoxia.et.translate.model.king.ResultModel;
import com.linghushaoxia.et.translate.parse.Parse;
import com.linghushaoxia.et.translate.util.CodeUtil;
import com.linghushaoxia.et.translate.util.HttpUtil;
import com.linghushaoxia.et.translate.util.PropertiesUtil;

/**功能说明：搜索单词
 * @author:linghushaoxia
 * @time:2016年12月24日下午2:31:06
 * @version:1.0
 * 为中国孱弱的技术，
 * 撑起一片自立自强的天空
 */
public class Search {
    /**
     * 
     * 功能说明:查询词句,返回结果
     * @param word
     * @return String
     * @time:2017年4月4日上午12:01:49
     * @author:linghushaoxia
     * @exception:
     *
     */
    public synchronized static String  serach(String word){
	//返回结果
	String result ="";
	Dict dict=null;
	//除去开头结尾的空格,并转为小写,金山词霸不识别大写
	word = word.trim().toLowerCase();
	//从缓存获取
	dict=DictCache.getDict(word);
	/**
	 * 查询金山词霸
	 */
	if (dict==null) {
	    try {
		/**
		 * 1、单词使用金山词霸
		 * 2、长句子使用google
		 */
		if (selectEngine(word).equals(SearchEngine.GOOGLE.toString())) {
		    dict = searchByGoogle(word);
		}else {
		    dict=searchByKing(word);
		}
	    } catch (Exception e) {
		    e.printStackTrace();
		}
	}
	result = ResultModel.getViewText(dict);
	return result;
    }
    /**
     * 
     * 功能说明:通过金山词霸搜索
     * @param word
     * @return Dict
     * @time:2017年4月3日下午5:47:42
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static Dict searchByKing(String word) {
	
	// api地址
	String url = PropertiesUtil.getConfigValue("king_api_url");
	// 请求地址
	Map<String, String> mapParas = new HashMap<String, String>();
	// 申请的key
	mapParas.put("key", PropertiesUtil.getConfigValue("king_api_key"));
	mapParas.put("w", word);
	// 根据语言不同，选择不同的参数类型
	Dict dict=null;
	 if(CodeUtil.containsChinese(word)){
	     mapParas.put("type", "json");
	     String jsonResult= HttpUtil.httpGet(url, mapParas);
	     KingDictJson kingDictJson=Parse.jsonToBean(jsonResult, KingDictJson.class);
	     dict= Parse.bussinessToViewModel(kingDictJson);
	 }else {
	     mapParas.put("type", "xml");
	     InputStream inputStream = HttpUtil.httpGetStream(url, mapParas);
	     KingDictXml kingDictXml=  Parse.xmlToBean(inputStream, KingDictXml.class);
	     dict = Parse.bussinessToViewModel(kingDictXml);
	}
	 DictCache.put(word, dict);
	 return dict;
    }
    /**
     * 
     * 功能说明:通过google进行搜索
     * @param word
     * @return Dict
     * @time:2017年4月3日下午5:48:09
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static Dict searchByGoogle(String word) {
	try {
	    /**
	     * 构建请求参数
	     */
	    StringBuilder builder = new StringBuilder();
	    builder.append("client=t&");
	    //中文
	    if (CodeUtil.containsChinese(word)) {
		//sl,source language
		builder.append("sl=zh-CN&");
		//tl,targert language
		builder.append("tl=en&");
	    }else {
		//sl,source language
		builder.append("sl=en&");
		//tl,targert language
		builder.append("tl=zh-CN&");
	    }
	    builder.append("hl=zh-CN&");
	    builder.append("dt=at&");
	    builder.append("dt=bd&");
	    builder.append("dt=ex&");
	    builder.append("dt=ld&");
	    builder.append("dt=md&");
	    builder.append("dt=qca&");
	    builder.append("dt=rw&");
	    builder.append("dt=rm&");
	    builder.append("dt=ss&");
	    builder.append("dt=t&");
	    builder.append("ie=UTF-8&");
	    builder.append("oe=UTF-8&");
	    builder.append("source=btn&");
	    builder.append("ssel=3&");
	    builder.append("tsel=3&");
	    builder.append("kc=0&");
	    builder.append("tk=").append(CodeUtil.generateToken(word)).append("&");
	    builder.append("q=").append(URLEncoder.encode(word, "UTF-8"));
	    String json = HttpUtil.httpGet(PropertiesUtil.getConfigValue("google_http_url"), builder.toString());
	    /**
	     * 返回结果进行解析
	     */
	    JSONArray jsonArray= JSON.parseArray(json);
	    JSONArray jsonArray2 = jsonArray.getJSONArray(0);
	    JSONArray jsonArray3 = jsonArray2.getJSONArray(0);
	    //原始查询
	    String originalContext = (String) jsonArray3.get(1);
	    //翻译结果
	    String translatedContext= (String) jsonArray3.get(0);
	    /**
	     * 封装返回值
	     */
	    Dict dict = new Dict();
	    dict.setExt(new HashMap<String, String>());
	    dict.getExt().put(ConfigConst.SEARCH_TYPE_PARAGRAPH, ConfigConst.IS_TRUE);
	    dict.getExt().put(ConfigConst.SEARCH_PARAGRAPH_ORIGINAL, originalContext);
	    dict.getExt().put(ConfigConst.SEARCH_PARAGRAPH_TRANSLATED, translatedContext);
	    DictCache.put(word, dict);
	    return dict;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }
   
    /**
     * 
     * 功能说明:根据单词内容,选择需要使用的查询引擎
     * @param word
     * @return String
     * @time:2017年4月3日下午4:22:25
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static String selectEngine(String word){
	//根据长度和空格判断
	if (word.trim().contains(" ")||word.length()>10) {
	    return SearchEngine.GOOGLE.toString();
	}
	if (CodeUtil.containsChinese(word)&&word.length()>3) {
	    return SearchEngine.GOOGLE.toString();
	}
	return SearchEngine.KING.toString();
    }
}

/**
* 现实就是实现理想的过程。
* 
*/