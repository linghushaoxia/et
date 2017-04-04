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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**功能说明：属性文件读取工具
 * @author:linghushaoxia
 * @time:2016年12月22日下午10:54:25
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
public class PropertiesUtil {
	//配置文件路径
	private static String configPath="/config.properties";
	//属性文件对象
	private static Properties properties=new Properties();
	static{
		InputStream inputStream  = PropertiesUtil.class.getResourceAsStream(configPath);
		try {
		    properties.load(inputStream);
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}finally{
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * 功能说明:获取指定的key对应的值
	 * @param key
	 * @return String
	 * @time:2016年12月22日下午11:06:19
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public static String getConfigValue(String key) {
		String result="";
		try {
			result= properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
	    System.out.println(PropertiesUtil.getConfigValue("king_api_url"));
	}
}

/**
* 现实就是实现理想的过程
*/