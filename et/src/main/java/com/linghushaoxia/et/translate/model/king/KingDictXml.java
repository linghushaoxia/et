package com.linghushaoxia.et.translate.model.king;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**功能说明：金山词霸返回的xml格式数据对应的pojo
 * @author:linghushaoxia
 * @time:2016年12月21日下午10:20:45
 * @version:1.0
 * 为中国羸弱的技术撑起一片自立自强的天空
 */
@XmlRootElement(name="dict")
public class KingDictXml implements Serializable{
	/**
	 *linghushaoxia
	 *2016 下午6:24:24 
	*/
	
	private static final long serialVersionUID = -2121638213390772336L;
	private String num;
	private String id;
	private String name;
	//查询的单词
	private String key;
	//音标
	private List<String> ps;
	//发音
	private List<String> pron;
	//词性
	private List<String> pos;
	private List<Sent> sents;
	private List<String> acceptations;
	@XmlElement(name="key")
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@XmlElements(value={@XmlElement(name="sent",type=Sent.class)})
	public List<Sent> getSents() {
		return sents;
	}
	public void setSents(List<Sent> sents) {
		this.sents = sents;
	}
	@XmlAttribute
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElements(value={@XmlElement(name="acceptation")})
	public List<String> getAcceptations() {
		return acceptations;
	}
	public void setAcceptations(List<String> acceptations) {
		this.acceptations = acceptations;
	}
	@XmlElements(value={@XmlElement(name="ps")})
	public List<String> getPs() {
		return ps;
	}
	public void setPs(List<String> ps) {
		this.ps = ps;
	}
	@XmlElements(value={@XmlElement(name="pron")})
	public List<String> getPron() {
		return pron;
	}
	public void setPron(List<String> pron) {
		this.pron = pron;
	}
	@XmlElements(value={@XmlElement(name="pos")})
	public List<String> getPos() {
		return pos;
	}
	public void setPos(List<String> pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "{\""
				+ (num != null ? "num\":\"" + num + "\",\"" : "")
				+ (id != null ? "id\":\"" + id + "\",\"" : "")
				+ (name != null ? "name\":\"" + name + "\",\"" : "")
				+ (key != null ? "key\":\"" + key + "\",\"" : "")
				+ (ps != null ? "ps\":\"" + ps + "\",\"" : "")
				+ (pron != null ? "pron\":\"" + pron + "\",\"" : "")
				+ (pos != null ? "pos\":\"" + pos + "\",\"" : "")
				+ (sents != null ? "sents\":\"" + sents + "\",\"" : "")
				+ (acceptations != null ? "acceptations\":\"" + acceptations
						: "") + "\"}";
	}
	
}

/**
* 现实就是实现理想的过程
*/