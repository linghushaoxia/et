/**
 * Copyright 2016-2017 linghushaoxia
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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