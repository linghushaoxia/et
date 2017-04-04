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
package com.linghushaoxia.et.translate.model.king;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**功能说明：金山词霸词典实体
 * @author:linghushaoxia
 * @time:2016年12月22日下午11:41:47
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
public class Dict implements Serializable{
	/**
	 *linghushaoxia
	 *2016 上午12:00:17 
	*/
	
	private static final long serialVersionUID = 4989337380390787818L;
	//音标
	private String ps;
	//发音
	private String pron;
	//词义
	private List<Word> wods;
	//备注
	private String reamrk;
	private Map<String, String> ext;
	@Override
	public String toString() {
		return "{\"" + (ps != null ? "ps\":\"" + ps + "\",\"" : "")
				+ (pron != null ? "pron\":\"" + pron + "\",\"" : "")
				+ (wods != null ? "wods\":\"" + wods + "\",\"" : "")
				+ (reamrk != null ? "reamrk\":\"" + reamrk : "") + "\"}";
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getPron() {
		return pron;
	}
	public void setPron(String pron) {
		this.pron = pron;
	}
	public List<Word> getWods() {
		return wods;
	}
	public void setWods(List<Word> wods) {
		this.wods = wods;
	}
	public String getReamrk() {
		return reamrk;
	}
	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}
	public Map<String, String> getExt() {
	    return ext;
	}
	public void setExt(Map<String, String> ext) {
	    this.ext = ext;
	}
}

/**
* 现实就是实现理想的过程
*/