package com.bqjr.report.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 * 
 * @author Panda
 * @version 2016-10-22
 */
public class StringUtil extends StringUtils {

	private static final char SEPARATOR = '_';
	private static final String CHARSET_NAME = "UTF-8";
	private static int[] weight = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
	private static char[] vcode = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };

	private static String hzDigital = "([１一壹])|([２二贰])|([３三叁])|([４四肆])|([５五伍])|([６六陆])|([７七柒])|([８八捌])|([９九玖])|([０〇零])";
	private static Pattern dpattern = Pattern.compile(hzDigital);

	/**
	 * 转换为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		if (str != null) {
			try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 转换为字节数组
	 * 
	 * @param bytes
	 * @return
	 */
	public static String toString(byte[] bytes) {
		try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
	}

	/**
	 * 是否包含字符串
	 * 
	 * @param str
	 *            验证字符串
	 * @param strs
	 *            字符串组
	 * @return 包含返回true
	 */
	public static boolean inString(String str, String... strs) {
		if (str != null) {
			for (String s : strs) {
				if (str.equals(trim(s))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 替换为手机识别的HTML，去掉样式及属性，保留回车。
	 * 
	 * @param html
	 * @return
	 */
	public static String replaceMobileHtml(String html) {
		if (html == null) {
			return "";
		}
		return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
	}

	/**
	 * 替换为手机识别的HTML，去掉样式及属性，保留回车。
	 * 
	 * @param txt
	 * @return
	 */
	public static String toHtml(String txt) {
		if (txt == null) {
			return "";
		}
		return replace(replace(Encodes.escapeHtml(txt), "\n", "<br/>"), "\t", "&nbsp; &nbsp; ");
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String abbr2(String param, int length) {
		if (param == null) {
			return "";
		}
		StringBuffer result = new StringBuffer();
		int n = 0;
		char temp;
		boolean isCode = false; // 是不是HTML代码
		boolean isHTML = false; // 是不是HTML特殊字符,如&nbsp;
		for (int i = 0; i < param.length(); i++) {
			temp = param.charAt(i);
			if (temp == '<') {
				isCode = true;
			} else if (temp == '&') {
				isHTML = true;
			} else if (temp == '>' && isCode) {
				n = n - 1;
				isCode = false;
			} else if (temp == ';' && isHTML) {
				isHTML = false;
			}
			try {
				if (!isCode && !isHTML) {
					n += String.valueOf(temp).getBytes("GBK").length;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if (n <= length - 3) {
				result.append(temp);
			} else {
				result.append("...");
				break;
			}
		}
		// 取出截取字符串中的HTML标记
		String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)", "$1$2");
		// 去掉不需要结素标记的HTML标记
		temp_result = temp_result.replaceAll(
				"</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
				"");
		// 去掉成对的HTML标记
		temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
		// 用正则表达式取出标记
		Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
		Matcher m = p.matcher(temp_result);
		List<String> endHTML = Lists.newArrayList();
		while (m.find()) {
			endHTML.add(m.group(1));
		}
		// 补全不成对的HTML标记
		for (int i = endHTML.size() - 1; i >= 0; i--) {
			result.append("</");
			result.append(endHTML.get(i));
			result.append(">");
		}
		return result.toString();
	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-Real-IP");
		if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("X-Forwarded-For");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("Proxy-Client-IP");
		} else if (isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * 驼峰命名法工具
	 * 
	 * @return toCamelCase("hello_world") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		}

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder(s.length());
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	/**
	 * 驼峰命名法工具
	 * 
	 * @return toCamelCase("hello_world") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCapitalizeCamelCase(String s) {
		if (s == null) {
			return null;
		}
		s = toCamelCase(s);
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * 驼峰命名法工具
	 * 
	 * @return toCamelCase("hello_world") == "helloWorld"
	 *         toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 *         toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toUnderScoreCase(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i > 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}

	/**
	 * 转换为JS获取对象值，生成三目运算返回结果
	 * 
	 * @param objectString
	 *            对象串 例如：row.user.id
	 *            返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
	 */
	public static String jsGetVal(String objectString) {
		StringBuilder result = new StringBuilder();
		StringBuilder val = new StringBuilder();
		String[] vals = split(objectString, ".");
		for (int i = 0; i < vals.length; i++) {
			val.append("." + vals[i]);
			result.append("!" + (val.substring(1)) + "?'':");
		}
		result.append(val.substring(1));
		return result.toString();
	}

	/**
	 * 首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String capFirst(String str) {
		if (str == "" || str == null) {
			return "";
		}
		char[] cs = str.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}

	/**
	 * 首字母小写
	 * 
	 * @param str
	 * @return
	 */
	public static String uncapFirst(String str) {
		if (str == "" || str == null) {
			return "";
		}
		char[] cs = str.toCharArray();
		cs[0] += 32;
		return String.valueOf(cs);
	}

	/**
	 * 根据分隔符分割字符串并首字母大写
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	public static String capFirst(String str, String separator) {
		if (str == "" || str == null) {
			return "";
		}
		String arr[] = str.split(separator);
		StringBuffer temp = new StringBuffer();
		for (String string : arr) {
			temp.append(StringUtil.capFirst(string));
		}
		return temp.toString();
	}

	/**
	 * 根据分隔符分割字符串并首字母小写
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	public static String uncapFirst(String str, String separator) {
		if (str == "" || str == null) {
			return "";
		}
		String arr[] = str.split(separator);
		StringBuffer temp = new StringBuffer();
		for (String string : arr) {
			temp.append(StringUtil.uncapFirst(string));
		}
		return temp.toString();
	}

	/**
	 * 传入字符串不足位补特定字符
	 * 
	 * @param str
	 *            传入字符串
	 * @param len
	 *            输出字符串长度
	 * @param padChar
	 *            补充字符串
	 * @return
	 */
	public static String paddingChar(String str, int len, String padChar) {
		String targetStr = str;

		if (targetStr == null)
			targetStr = "";
		if (targetStr.length() >= len)
			return targetStr.substring(0, len);

		String tempStr = "";
		for (int i = 0; i < len - targetStr.length(); i++) {
			tempStr += padChar;
		}

		return tempStr + targetStr;
	}

	public static String filterControlChar(String str) {
		return str.replaceAll("\\p{Cntrl}", "");
	}

	/*
	 * 处理身份证号码
	 */
	public static String fixPID(String str) {
		String s = filterControlChar(str);

		String ID15 = fixDigital(s);

		if (ID15.length() != 15) {
			return ID15.toUpperCase();
		}
		StringBuffer ID18 = new StringBuffer(ID15);
		ID18.insert(6, "19");
		int vsum = 0;
		for (int i = 0; i < 17; i++) {
			vsum += Character.digit(ID18.charAt(i), 10) * weight[i];
		}
		ID18.append(vcode[(vsum % 11)]);
		return ID18.toString();
	}

	public static String fixDigital(String str) {
		Matcher m = dpattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			int g = 0;
			for (int i = 1; i <= 10; i++) {
				if (m.group(i) != null) {
					g = i;
					break;
				}
			}
			m.appendReplacement(sb, String.valueOf(g % 10));
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 
	 * @MethodName clearStartAndEndQuote <br/>
	 * @Description 去掉字符串前后字符串 for csv输出 <br/>
	 * @author YuanWei Yi
	 * @version 2017年8月15日 下午2:48:10
	 * 
	 * @param str
	 * @return
	 */
	public static String clearStartAndEndQuote(String str) {
		if (str != null && str.length() >= 2) {
			if (str.indexOf("\"") == 0)
				str = str.substring(1, str.length()); // 去掉第一个 "
			if (str.lastIndexOf("\"") == (str.length() - 1))
				str = str.substring(0, str.length() - 1); // 去掉最后一个 "

			str = str.replaceAll("\"\"", "\"");// 把两个双引号换成一个双引号
		}
		return str;
	}
	
	 /**
     * Returns the string representation of the {@code Object} argument.
     *
     * @param   obj   an {@code Object}.
     * @return  if the argument is {@code null}, then a string equal to
     *          {@code ""}; otherwise, the value of
     *          {@code obj.toString()} is returned.
     * @see     java.lang.Object#toString()
     */
    public static String valueOfNotNul(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }
	
}
