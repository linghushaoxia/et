package com.linghushaoxia.et.translate.parse.xml;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.linghushaoxia.et.translate.model.Dict;
import com.linghushaoxia.et.translate.model.KingDictXml;
import com.linghushaoxia.et.translate.model.Word;
import com.linghushaoxia.et.translate.util.ValidateUtil;

/**功能说明：
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
     * 功能说明:
     * @param inputStream
     * @param cla
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
}

/**
* 现实就是实现理想的过程。
* 
*/