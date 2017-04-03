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