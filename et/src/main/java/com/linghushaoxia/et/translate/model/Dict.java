package com.linghushaoxia.et.translate.model;

import java.io.Serializable;
import java.util.List;

/**功能说明：
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
}

/**
* 现实就是实现理想的过程
*/