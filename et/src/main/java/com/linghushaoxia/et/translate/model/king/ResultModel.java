package com.linghushaoxia.et.translate.model.king;

import java.util.List;

import com.linghushaoxia.et.translate.config.ConfigConst;
import com.linghushaoxia.et.translate.util.ValidateUtil;
/**
 * 功能说明：视图模型结果，展示页面文本
 * @author:linghushaoxia
 * @time:2016年12月24日下午4:06:22
 * @version:1.0
 *
 */
public class ResultModel {
	/**
	 * 
	 * 功能说明:将dict对象转为页面展示的文本
	 * @param dict
	 * @return String
	 * @time:2016年12月24日下午2:44:15
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public static String getViewText(Dict dict){
	    String result="无翻译结果";
	    if(dict==null|| (dict.getExt()==null&&(dict.getWods()==null||dict.getWods().size()==0))){
		return result;
	    }
	    StringBuilder builder = new StringBuilder();
	    if (dict.getExt()!=null&&ConfigConst.IS_TRUE.equals(dict.getExt().get(ConfigConst.SEARCH_TYPE_PARAGRAPH))) {
		builder.append("原文:\n").append(dict.getExt().get(ConfigConst.SEARCH_PARAGRAPH_ORIGINAL)).append("\n");
		builder.append("译文:\n").append(dict.getExt().get(ConfigConst.SEARCH_PARAGRAPH_TRANSLATED)).append("\n");
	    }else {
		 //音标
		    if(!ValidateUtil.isBlank(dict.getPs())){
			builder.append("音标: [").append(dict.getPs()).append("]").append("\n");
		    }
		    //发音
		    if(!ValidateUtil.isBlank(dict.getPron())){
			builder.append("发音: ").append(dict.getPron()).append("").append("\n");
		    }
		    List<Word> words= dict.getWods();
		    builder.append("释义:").append("\n");
		    for(Word word:words){
			builder.append(word.getPos()).append(" ").append(word.getMean()).append("\n");
		    }
	    }
	   
	    result=builder.toString();
	    return result;
	}
	
}
