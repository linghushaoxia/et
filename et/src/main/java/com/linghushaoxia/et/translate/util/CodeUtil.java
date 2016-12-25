package com.linghushaoxia.et.translate.util;

import java.util.regex.Pattern;

/**功能说明：编码工具
 * @author:linghushaoxia
 * @time:2016年12月25日下午3:03:16
 * @version:1.0
 * 为中国孱弱的技术，
 * 撑起一片自立自强的天空
 */
public class CodeUtil {
    //中文正则表达式
    private static Pattern patternChinese;
    static{
	patternChinese=Pattern.compile(PropertiesUtil.getConfigValue("chinse_pattern"));
    }
    /**
     * 
     * 功能说明:判断字符串是否包含中文
     * @param text
     * @return boolean
     * @time:2016年12月25日下午3:07:33
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static boolean containsChinese(String text){
	//匹配结果
	boolean result=false;
	if(ValidateUtil.isBlank(text)){
	    result=false;
	}
	//去除字符串的所有空白字符
	text = text.replaceAll("\\s*", "");
	result = patternChinese.matcher(text).find();
	return result;
    }
}

/**
* 现实就是实现理想的过程。
* 
*/