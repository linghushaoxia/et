package com.linghushaoxia.et.translate.parse;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.alibaba.fastjson.JSON;
import com.linghushaoxia.et.translate.model.king.Dict;
import com.linghushaoxia.et.translate.model.king.KingDictJson;
import com.linghushaoxia.et.translate.model.king.KingDictXml;
import com.linghushaoxia.et.translate.model.king.Mean;
import com.linghushaoxia.et.translate.model.king.Part;
import com.linghushaoxia.et.translate.model.king.Symbol;
import com.linghushaoxia.et.translate.model.king.Word;
import com.linghushaoxia.et.translate.util.CodeUtil;
import com.linghushaoxia.et.translate.util.ValidateUtil;

/**功能说明：解析xml
 * @author:linghushaoxia
 * @time:2016年12月23日下午11:02:49
 * @version:1.0
 * 为中国孱弱的技术，
 * 撑起一片自立自强的天空
 */
public class Parse {
    /**
     * 
     * 功能说明:将url的返回的xml结果,解析为javaBean
     * @param url
     * 包含请求参数的完整url地址
     * @param cla
     * 解析xml
     * @return T
     * @time:2016年12月23日下午11:27:16
     * @author:linghushaoxia
     * @exception:
     *
     */
    @SuppressWarnings("unchecked")
    public <T>  T xmlToBean(String url,Class<T> cla) {
	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(cla);
	    Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
	    T bean= (T) unmarshaller.unmarshal(new URL(url));
	     return bean;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return null;
    }
    /**
     * 
     * 功能说明:将输入流转为JavaBean
     * @param inputStream
     * xml数据流
     * @param cla
     * 约束类
     * @return T
     * @time:2016年12月24日下午1:02:26
     * @author:linghushaoxia
     * @exception:
     *
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(InputStream inputStream,Class<T> cla){
	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(cla);
	    Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
	    T bean= (T) unmarshaller.unmarshal(inputStream);
	     return bean;
	} catch (Exception e) {
	   e.printStackTrace();
	}
	return null;
    }
    /**
     * 
     * 功能说明:将json字符串解析为JavaBean
     * @param json
     * json字符串
     * @param cla
     * 约束类
     * @return T
     * @time:2017年4月3日上午12:56:48
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static <T> T jsonToBean(String json,Class<T> cla){
	try {
	    //标准化
	    json = stdJson(json);
	    //处理中文
	    json= CodeUtil.decodeUnicode(json);
	    return JSON.parseObject(json, cla);
	} catch (Exception e) {
	   e.printStackTrace();
	}
	return null;
    }
    /**
     * 
     * 功能说明:标准化json字符串,使之符合驼峰式命名规范
     * @param json
     * @return String
     * @time:2017年4月3日下午2:47:01
     * @author:linghushaoxia
     * @exception:
     *
     */
    private static String stdJson(String json) {
	if (json == null || "".equals(json.trim())) {
	    return "";
	}
	int len = json.length();
	StringBuilder sb = new StringBuilder(len);
	for (int i = 0; i < len; i++) {
	    char c = json.charAt(i);
	    //处理下划线,ascii码是95
	    if (c == 95) {
		if (++i < len) {
		    sb.append(Character.toUpperCase(json.charAt(i)));
		}
	    } else {
		sb.append(c);
	    }
	}
	return sb.toString();

    }
    
   /**
    * 
    * 功能说明:将业务逻辑对象转为视图模型对象
    * @param businessObj
    * @param viewModel
    * @return B
    * @time:2016年12月24日下午2:00:08
    * @author:linghushaoxia
    * @exception:
    *
    */
    @SuppressWarnings("unchecked")
    public static <B,V> V bussinessToViewModel(B bo){
	if(bo instanceof KingDictXml){
	    return (V) kingXmlDictToDcit((KingDictXml) bo);
	}
	if (bo instanceof KingDictJson) {
	    return (V) kingJsonDictToDcit((KingDictJson) bo);
	}
	return null;
    }
    /**
     * 
     * 功能说明:将金山词霸的xml对象转为页面展示对象
     * @param kingDictXml
     * @return Dict
     * @time:2016年12月24日下午2:25:59
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static Dict kingXmlDictToDcit(KingDictXml kingDictXml){

	Dict result = null;
	if(kingDictXml==null){
	    return result;
	}
	Dict dict = new Dict();
	if(!ValidateUtil.isBlank(kingDictXml.getPron())){
		dict.setPron(kingDictXml.getPron().get(0));
	}
	if(!ValidateUtil.isBlank(kingDictXml.getPs())){
		dict.setPs(kingDictXml.getPs().get(0));
	}
	List<Word> words = new ArrayList<Word>();
	//翻译结果
	List<String> acceptations= kingDictXml.getAcceptations();
	//词性
	List<String> posList = kingDictXml.getPos();
	if(!ValidateUtil.isBlank(acceptations)){
	    for(int i=0;i<acceptations.size();i++){
		Word word = new Word();
		word.setMean(acceptations.get(i));
		word.setPos(posList.get(i));
		words.add(word);
	    }
	}
	
	dict.setWods(words);
	result = dict;
	return result;
    }
    /**
     * 
     * 功能说明:将KingDictJson转为Dict类型
     * @param kingDictJson
     * @return Dict
     * @time:2017年4月3日下午5:46:16
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static Dict kingJsonDictToDcit(KingDictJson kingDictJson) {
	// 返回结果
	Dict result = null;
	if (kingDictJson == null) {
	    return result;
	}
	Dict dict = new Dict();
	// 音标、发音
	if (!ValidateUtil.isBlank(kingDictJson.getSymbols())) {
	    dict.setPs(kingDictJson.getSymbols().get(0).getWordSymbol());
	    dict.setPron(kingDictJson.getSymbols().get(0).getSymbolMp3());
	}

	List<Word> words = new ArrayList<Word>();
	/**
	 * 翻译结果
	 */
	List<Symbol> symbols = kingDictJson.getSymbols();
	for (Symbol symbol : symbols) {
	    List<Part> parts = symbol.getParts();
	    if (!ValidateUtil.isBlank(parts)) {
		for (Part part : parts) {
		    Word word = new Word();
		    //词性
		    word.setPos(part.getPartName());
		    StringBuilder meanBuilder = new StringBuilder();
		    // 获取全部意思
		    if (!ValidateUtil.isBlank(part.getMeans())) {
			for (Mean mean : part.getMeans()) {
			    meanBuilder.append(mean.getWordMean()).append(";");
			}
		    }
		    word.setMean(meanBuilder.delete(meanBuilder.length() - 1, meanBuilder.length()).toString());
		    words.add(word);
		}
	    }
	}
	dict.setWods(words);
	result = dict;
	return result;

    }
}

/**
* 现实就是实现理想的过程。
* 
*/