package com.linghushaoxia.et.translate.util;

import java.util.Collection;

/**功能说明：校验工具
 * @author:linghushaoxia
 * @time:2016年12月22日下午10:23:32
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
public class ValidateUtil {
	/***
	 * 
	 * 功能说明:校验字符串是否为空
	 * @param text
	 * @return boolean
	 * @time:2016年12月22日下午10:26:07
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public static boolean isBlank(String text){
		if(text==null){
			return true;
		}
		if("".trim().equals(text)||"null".equals(text)){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * 功能说明:判断集合是否为空
	 * @param collection
	 * @return boolean
	 * @time:2016年12月24日下午6:00:24
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public static boolean isBlank(Collection<?> collection){
	  return collection==null||collection.size()==0;
	}
}

/**
* 现实就是实现理想的过程
*/