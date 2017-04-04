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

import javax.xml.bind.annotation.XmlRootElement;

/**功能说明：
 * @author:linghushaoxia
 * @time:2016年12月21日下午10:32:07
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
@XmlRootElement(name="sent")
public class Sent implements Serializable{
	/**
	 *linghushaoxia
	 *2016 下午6:24:42 
	*/
	
	private static final long serialVersionUID = -3691139837528887742L;
	private String orig;
	private String trans;
	public String getOrig() {
		return orig;
	}
	public void setOrig(String orig) {
		this.orig = orig;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	@Override
	public String toString() {
		return "{\"" + (orig != null ? "orig\":\"" + orig + "\",\"" : "")
				+ (trans != null ? "trans\":\"" + trans : "") + "\"}";
	}
}

/**
* 现实就是实现理想的过程
*/