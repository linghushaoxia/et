package com.linghushaoxia.et.translate.cache;

import java.util.HashMap;
import java.util.Map;

import com.linghushaoxia.et.translate.model.Dict;

/**功能说明：
 * @author:linghushaoxia
 * @time:2016年12月23日下午9:34:29
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
public class DictCache {
	private static Map<String, Dict> dictMap = new HashMap<String, Dict>();
	public static Dict getDict(String key){
		return dictMap.get(key);
	}
	public static void put(String key,Dict value){
		dictMap.put(key, value);
	}
	public static void clear(){
		dictMap.clear();
	}
}

/**
* 现实就是实现理想的过程
*/