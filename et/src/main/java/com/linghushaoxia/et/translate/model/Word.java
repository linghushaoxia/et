package com.linghushaoxia.et.translate.model;

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