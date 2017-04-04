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

/**功能说明：
 * @author:linghushaoxia
 * @time:2016年12月22日下午11:52:07
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
public class Word implements Serializable{
	/**
	 *linghushaoxia
	 *2016 上午12:39:07 
	*/
	
	private static final long serialVersionUID = -6255855306069762731L;
	//词性
	private String pos;
	//含义
	private String mean;
	//备注
	private String remark;
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "{\"" + (pos != null ? "po\":\"" + pos + "\",\"" : "")
				+ (mean != null ? "meam\":\"" + mean + "\",\"" : "")
				+ (remark != null ? "remark\":\"" + remark : "") + "\"}";
	}
}

/**
* 现实就是实现理想的过程
*/