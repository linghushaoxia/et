package com.linghushaoxia.et.translate.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.linghushaoxia.et.translate.model.Dict;
import com.linghushaoxia.et.translate.model.KingDictXml;
import com.linghushaoxia.et.translate.parse.xml.Parse;
/**
 * 功能说明：http请求工具
 * @author:linghushaoxia
 * @time:2016年12月24日下午4:05:15
 * @version:1.0
 *
 */
public class HttpUtil {
    /**
     * 
     * 功能说明:发送get请求
     * @param url
     * 远程地址
     * @param mapParas
     * 参数
     * @return String
     * @time:2016年12月22日下午10:38:33
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static String httpGet(String url,Map<String, String> mapParas){
  	  //返回结果
  	  String result = null;
  	  BufferedReader reader=null;
  	  try {
  		  /**
  		   * 组装请求参数
  		   */
  		  StringBuilder builder = new StringBuilder(30);
  		  Set<String> keSet= mapParas.keySet();
  		  builder.append(url).append("?");
  		  for(String key:keSet){
  			  builder.append(key).append("=").append(mapParas.get(key)).append("&");
  		  }
  		  //打开连接
  		  HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(builder.toString()).openConnection();
  		  /**
  		   * 设置通用参数
  		   */
  		  httpURLConnection.setRequestProperty("Charset", "UTF-8");
  		  httpURLConnection.setRequestProperty("Accept", "*/*");
  		  httpURLConnection.setRequestProperty("connection", "Keep-Alive");
  		  httpURLConnection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
  		  httpURLConnection.setRequestMethod("GET");
  		  /**
		   * 超时时间
		   */
		  httpURLConnection.setConnectTimeout(3000);
		  httpURLConnection.setReadTimeout(2000);
  		  httpURLConnection.connect();
  		  reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
  		  String temp=null;
  		  StringBuilder resultBuilder = new StringBuilder();
  		  while ((temp=reader.readLine())!=null) {
  			  resultBuilder.append(temp).append("\n");
  		  }
  		  result = resultBuilder.toString();
  	} catch (Exception e) {
  		e.printStackTrace();
  	}finally{
  		if (reader!=null) {
  			try {
  				reader.close();
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		}
  	}
  	  return result;
    }
    public static InputStream httpGetStream(String url,Map<String, String> mapParas){
	  //返回结果
	  InputStream result = null;
	  try {
		  /**
		   * 组装请求参数
		   */
		  StringBuilder builder = new StringBuilder(30);
		  Set<String> keSet= mapParas.keySet();
		  builder.append(url).append("?");
		  for(String key:keSet){
			  builder.append(key).append("=").append(mapParas.get(key)).append("&");
		  }
		  //打开连接
		  HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(builder.toString()).openConnection();
		  /**
		   * 设置通用参数
		   */
		  httpURLConnection.setRequestProperty("Charset", "UTF-8");
		  httpURLConnection.setRequestProperty("Accept", "*/*");
		  httpURLConnection.setRequestProperty("connection", "Keep-Alive");
		  httpURLConnection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		  httpURLConnection.setRequestMethod("GET");
		  /**
		   * 超时时间
		   */
		  httpURLConnection.setConnectTimeout(3000);
		  httpURLConnection.setReadTimeout(2000);
		  httpURLConnection.connect();
		  result = httpURLConnection.getInputStream();
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return result;
  }
    /**
     * 
     * 功能说明:发送post请求
     * @param url
     * 请求的地址
     * @param mapParas
     * 参数map
     * @return String
     * 返回结果
     * @time:2016年12月24日下午12:54:15
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static String httpPost(String url,Map<String, String> mapParas){
	  //返回结果
	  String result = null;
	  //发送请求参数
	  PrintWriter printWriter =null;
	  //读取返回的输入流
	  BufferedReader reader=null;
	  try {
		  /**
		   * 组装请求参数
		   */
		  StringBuilder param = new StringBuilder(30);
		  Set<String> keSet= mapParas.keySet();
		  for(String key:keSet){
		      param.append(key).append("=").append(mapParas.get(key)).append("&");
		  }
		  //打开连接
		  HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
		  /**
		   * 设置通用参数
		   */
		  httpURLConnection.setRequestProperty("Charset", "UTF-8");
		  httpURLConnection.setRequestProperty("accept", "*/*");
		  httpURLConnection.setRequestProperty("connection", "Keep-Alive");
		  httpURLConnection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		 /**
		  * post请求需要添加
		  */
		  httpURLConnection.setDoInput(true);
		  httpURLConnection.setDoOutput(true);
		  httpURLConnection.setRequestMethod("POST");
		  /**
		   * 超时时间
		   */
		  httpURLConnection.setConnectTimeout(3000);
		  httpURLConnection.setReadTimeout(2000);
		  /**
		   * 发送请求
		   */
		  printWriter = new PrintWriter(httpURLConnection.getOutputStream());
		  printWriter.write(param.toString());
		  printWriter.flush();
		  /**
		   * 接收请求参数
		   */
		  reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		  String temp=null;
		  StringBuilder resultBuilder = new StringBuilder();
		  while ((temp=reader.readLine())!=null) {
			  resultBuilder.append(temp).append("\n");
		  }
		  result = resultBuilder.toString();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		if (reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (printWriter!=null) {
		    printWriter.close();
		}
	}
	  return result;
  }
    /**
     * 
     * 功能说明:发送post请求,获取返回的输入流
     * @param url
     * 目标地址
     * @param mapParas
     * 请求参数
     * @return InputStream
     * 返回的输入流
     * @time:2016年12月24日下午12:57:31
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static InputStream httpPostStream(String url,Map<String, String> mapParas){
	  //返回结果
	  InputStream result = null;
	  //发送请求参数
	  PrintWriter printWriter =null;
	  try {
		  /**
		   * 组装请求参数
		   */
		  StringBuilder param = new StringBuilder(30);
		  Set<String> keSet= mapParas.keySet();
		  for(String key:keSet){
		      param.append(key).append("=").append(mapParas.get(key)).append("&");
		  }
		  //删除最后一个&
		  param.delete(param.length()-1, param.length());
		  //打开连接
		  HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
		  /**
		   * 设置通用参数
		   */
		  httpURLConnection.setRequestProperty("Charset", "UTF-8");
		  httpURLConnection.setRequestProperty("Accept", "*/*");
		  httpURLConnection.setRequestProperty("connection", "Keep-Alive");
		  httpURLConnection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		 /**
		  * post请求需要添加
		  */
		  httpURLConnection.setDoInput(true);
		  httpURLConnection.setDoOutput(true);
		  httpURLConnection.setRequestMethod("POST");
		  /**
		   * 超时时间
		   */
		  httpURLConnection.setConnectTimeout(3000);
		  httpURLConnection.setReadTimeout(2000);
		  /**
		   * 发送请求
		   */
		  printWriter = new PrintWriter(httpURLConnection.getOutputStream());
		  printWriter.write(param.toString());
		  printWriter.flush();
		  /**
		   * 接收请求参数
		   */
		  result = httpURLConnection.getInputStream();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		if (printWriter!=null) {
		    printWriter.close();
		}
	}
	  return result;
}
    public static void main(String[] args) {
	Map<String, String> mapParas = new HashMap<String, String>();
	mapParas.put("key", "CC4F915C575ACA633610E42A920E20A6");
	mapParas.put("w", "word");
	mapParas.put("type", "xml");
	InputStream inputStream=  HttpUtil.httpGetStream("http://dict-co.iciba.com/api/dictionary.php", mapParas);
	KingDictXml kingDictXml= Parse.xmlToBean(inputStream, KingDictXml.class);
	Dict dict= Parse.bussinessToViewModel(kingDictXml);
	System.out.println(dict);
    }

}
