package com.linghushaoxia.et.translate.util;

import java.util.regex.Pattern;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**功能说明：编码工具
 * @author:linghushaoxia
 * @time:2016年12月25日下午3:03:16
 * @version:1.0
 * 为中国孱弱的技术，
 * 撑起一片自立自强的天空
 */
public class CodeUtil {
    //中文正则表达式
    private static Pattern patternChinese;
    static{
	patternChinese=Pattern.compile(PropertiesUtil.getConfigValue("chinse_pattern"));
    }
    /**
     * 
     * 功能说明:生成请求的token
     * @see https://github.com/lsj9383/translate-set/blob/master/src/com/lsj/trans/impl/GoogleTranslator.java
     * @param val
     * @return String
     * @time:2017年4月3日下午8:25:15
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static String generateToken(String val){
	try {
	    String script ="function tk(a) {"
			+"var TKK = ((function() {var a = 561666268;var b = 1526272306;return 406398 + '.' + (a + b); })());\n"
			+"function b(a, b) { for (var d = 0; d < b.length - 2; d += 3) { var c = b.charAt(d + 2), c = 'a' <= c ? c.charCodeAt(0) - 87 : Number(c), c = '+' == b.charAt(d + 1) ? a >>> c : a << c; a = '+' == b.charAt(d) ? a + c & 4294967295 : a ^ c } return a }\n"
			+"for (var e = TKK.split('.'), h = Number(e[0]) || 0, g = [], d = 0, f = 0; f < a.length; f++) {"  
			+"var c = a.charCodeAt(f);"  
			+"128 > c ? g[d++] = c : (2048 > c ? g[d++] = c >> 6 | 192 : (55296 == (c & 64512) && f + 1 < a.length && 56320 == (a.charCodeAt(f + 1) & 64512) ? (c = 65536 + ((c & 1023) << 10) + (a.charCodeAt(++f) & 1023), g[d++] = c >> 18 | 240, g[d++] = c >> 12 & 63 | 128) : g[d++] = c >> 12 | 224, g[d++] = c >> 6 & 63 | 128), g[d++] = c & 63 | 128)"  
			+"}"      
			+"a = h;"  
			+"for (d = 0; d < g.length; d++) a += g[d], a = b(a, '+-a^+6');"  
			+"a = b(a, '+-3^+b+-f');"  
			+"a ^= Number(e[1]) || 0;"  
			+"0 > a && (a = (a & 2147483647) + 2147483648);"  
			+"a %= 1E6;"  
			+"return a.toString() + '.' + (a ^ h)\n"
			+"}";
	    ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
	    engine.eval(script);
	    Invocable inv = (Invocable) engine;
	    return (String) inv.invokeFunction("tk", val);
	} catch (Exception e) {
	    // TODO: handle exception
	}
	return "";
}
    /**
     * 
     * 功能说明:将包含unicode编码的字符转为普通字符串
     * @param ori
     * @return String
     * @time:2017年4月3日下午4:35:46
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static String decodeUnicode(final String ori) {     
	char aChar;
        int len = ori.length();
        StringBuilder outBuffer = new StringBuilder(len);
        for (int x = 0; x < len;) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            value = (value << 4) + aChar - '0';
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                            value = (value << 4) + 10 + aChar - 'a';
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            value = (value << 4) + 10 + aChar - 'A';
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
 
        }
        return outBuffer.toString();
     }  
    /**
     * 
     * 功能说明:判断字符串是否包含中文
     * @param text
     * @return boolean
     * @time:2016年12月25日下午3:07:33
     * @author:linghushaoxia
     * @exception:
     *
     */
    public static boolean containsChinese(String text){
	//匹配结果
	boolean result=false;
	if(ValidateUtil.isBlank(text)){
	    result=false;
	}
	//去除字符串的所有空白字符
	text = text.replaceAll("\\s*", "");
	result = patternChinese.matcher(text).find();
	return result;
    }
}

/**
* 现实就是实现理想的过程。
* 
*/