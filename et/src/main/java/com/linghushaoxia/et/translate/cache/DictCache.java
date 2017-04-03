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