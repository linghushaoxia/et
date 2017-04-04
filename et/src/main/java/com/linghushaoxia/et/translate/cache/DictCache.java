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

package com.linghushaoxia.et.translate.cache;

import java.util.HashMap;
import java.util.Map;

import com.linghushaoxia.et.translate.model.king.Dict;

/**功能说明：词典缓存
 * @author:linghushaoxia
 * @time:2016年12月23日下午9:34:29
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
public class DictCache {
    	//内存map缓存查询的单词
	private static Map<String, Dict> dictMap = new HashMap<String, Dict>();
	/**
	 * 
	 * 功能说明:获取缓存中的单词释义
	 * @param key
	 * @return Dict
	 * @time:2017年4月2日下午7:34:10
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public static Dict getDict(String key){
		return dictMap.get(key);
	}
	/**
	 * 
	 * 功能说明:写入缓存
	 * @param key
	 * 单词
	 * @param value 
	 * 查询结果
	 * @time:2017年4月2日下午7:34:16
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public static void put(String key,Dict value){
		dictMap.put(key, value);
	}
	/**
	 * 
	 * 功能说明: 清空缓存
	 * @time:2017年4月2日下午7:34:23
	 * @author:linghushaoxia
	 * @exception:
	 *
	 */
	public static void clear(){
		dictMap.clear();
	}
}

/**
* 现实就是实现理想的过程
*/