package com.linghushaoxia.et.translate.search;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.linghushaoxia.et.translate.cache.DictCache;
import com.linghushaoxia.et.translate.model.Dict;
import com.linghushaoxia.et.translate.model.KingDictXml;
import com.linghushaoxia.et.translate.model.ResultModel;
import com.linghushaoxia.et.translate.parse.xml.Parse;
import com.linghushaoxia.et.translate.util.HttpUtil;
import com.linghushaoxia.et.translate.util.PropertiesUtil;

/**功能说明：
 * @author:linghushaoxia
 * @time:2016年12月24日下午2:31:06
 * @version:1.0
 * 为中国孱弱的技术，
 * 撑起一片自立自强的天空
 */
public class Search {
    public String serachKing(String word){
	//返回结果
	String result ="";
	Dict dict=null;
	//除去开头结尾的空格
	word = word.trim();
	//从缓存获取
	dict=DictCache.getDict(word);
	/**
	 * 查询金山词霸
	 */
	if (dict==null) {
	    try {
		// api地址
		String url = PropertiesUtil.getConfigValue("king_api_url");
		//请求地址
		Map<String, String> mapParas = new HashMap<String, String>();
		// 申请的key
		mapParas.put("key", PropertiesUtil.getConfigValue("king_api_key"));
		mapParas.put("w", word);
		mapParas.put("type", "xml");
		InputStream inputStream = HttpUtil.httpGetStream(url, mapParas);
		KingDictXml kingDictXml = Parse.xmlToBean(inputStream, KingDictXml.class);
		dict = Parse.bussinessToViewModel(kingDictXml);
		DictCache.put(word, dict);
	    } catch (Exception e) {
		    e.printStackTrace();
		}
	}
	result = ResultModel.getViewText(dict);
	return result;
    }
}

/**
* 现实就是实现理想的过程。
* 
*/