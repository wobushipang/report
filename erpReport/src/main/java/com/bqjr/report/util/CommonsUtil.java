package com.bqjr.report.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class CommonsUtil {

	/**
	 * 粗略判断获取文件的中文编码，
	 * 一般文件的前三个字节表示编码，读出三个字节做判断
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String getFileCNCharset(InputStream in) throws IOException{
		String charset = "GBK";
		if (in == null || in.available() <= 0) {
			return charset;
		}
		 byte[] b = new byte[3];
		 in.read(b);
		 in.close();
		 if (b[0] == -17 && b[1] == -69 && b[2] == -65){
			 charset = "UTF-8"; 
		 }
		 return charset;
	}
	
	/**
	 * 验证字符串日期格式
	 * @param datatime
	 * @param format
	 * @return
	 */
	public static boolean validDataFormat(String datatime, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		boolean result = false;
		try {
			sdf.parse(datatime);
			result = true;
		} catch (ParseException e) {
			result = false;
		}
		
		return result;
	}
	
	/**
	 * uuid
	 * @return
	 */
	public static String getUUID32(){
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		uuid = uuid.toUpperCase();
		return uuid;
		
	}
	
	/**
	 * 根据驼峰转换成下划线字符串
	 * @param humpStr
	 * @return
	 */
	public static String convertUnderlineStr(String humpStr){
		if (StringUtils.isEmpty(humpStr)) {
			return humpStr;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < humpStr.length(); i++) {
	       if (Character.isUpperCase(humpStr.charAt(i))) {
	           sb.append("_");
	       }
	       sb.append(humpStr.charAt(i));
	    }
		return sb.toString().toUpperCase();
	}
	
	public static List<String> parseCSVLine(String str, boolean isHead){
		String reg = "\\G(?:^|,)(?:\"([^\"]*+(?:\"\"[^\"]*+)*+)\"|([^\",]*+))";
		Matcher matcherMain = Pattern.compile(reg).matcher("");
        Matcher matcherQuoto = Pattern.compile("\"\"").matcher("");
        matcherMain.reset(str);
        List<String> list = new ArrayList<String>();
        while (matcherMain.find()) {
            String field;
            if (matcherMain.start(2) >= 0) {
                field = matcherMain.group(2);
            } else {
                field = matcherQuoto.reset(matcherMain.group(1)).replaceAll("\"");
            }
            if (isHead && StringUtils.isEmpty(field)) {
				list.clear();
				break;
			}
            list.add(field);
        }
        return list;
	}
	
	public static Properties getProperties(String propPath){
		Properties properties = null;
		InputStream inputStream = null;
		try {
			inputStream = CommonsUtil.class.getClassLoader().getResourceAsStream(propPath);
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
}
