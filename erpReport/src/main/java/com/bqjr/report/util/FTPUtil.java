/******************************************************************************
 * Copyright (C) 2010-2020 Billions Finance. All Rights Reserved.
 * ============================================================================
 * 版权所有 2010-2020 佰仟金融服务有限公司，并保留所有权利
 * ----------------------------------------------------------------------------
 * 这不是一个自由软件！您不能在任何未经允许的前提下对程序代码进行修改和使用；不允许
 * 对程序代码以任何形式任何目的的再发布
 * ============================================================================
 *
 * @ProjectName erp
 * @PackageName com.bqjr.report.util
 * @FileName FTPUtil 
 * @author wei.huang02
 * @Date 2017年10月17日 上午10:08:44 
 *****************************************************************************/
package com.bqjr.report.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

/**
 * @ClassName FTPUtil.java
 * @Description FTP工具类
 * @author wei.huang02
 * @Date 2017年10月17日 上午10:08:44
 * @since JDK 1.8
 */
public class FTPUtil {
	private static Logger logger = Logger.getLogger(FTPUtil.class);
	private static FTPClient ftpClient;
	private final static String userName = "reader";
	private final static String password = "123456";
	private final static String ftpHostName = "10.89.1.79";
	private final static int port = 21;

	/**
	 * 读取文件
	 * @author wei.huang02
	 */
	public static class ReadFile {
		/**
		 * 从FTP读取文件
		 * 
		 * @param username
		 * @param password
		 * @param ftpHostName
		 * @param port
		 * @return
		 */
		public static Map<String, List<List<String>>> readFile() {
			Map<String, List<List<String>>> fileMap = new HashMap<String, List<List<String>>>();
			try {
				// 连接到服务器
				connectServer(userName, password, ftpHostName, port);
				// 读取指定目录下的文件名
				String folderName = getFolderName();
				List<String> fileNames = getFileList("/" + folderName);
				logger.info("开始读取【" + folderName + "】文件夹下的文件数据......");
				if (fileNames != null && fileNames.size() > 0) {
					for (String fileName : fileNames) {
						fileMap.put(fileName, readFileContent("/" + folderName + "/" + fileName));
					}
				} else {
					logger.info("The folder [" + folderName + "] is not exists or empty");
				}
				logger.info("本次共读取了文件的个数为:" + fileNames.size());
				closeServer();
				logger.debug("与ftp服务器断开连接成功");
			} catch (Exception e) {
				logger.error("读取文件异常，异常信息如下" + e.getMessage());
			}
			return fileMap;
		}
	}

	/**
	 * 获取要读取文件所在文件夹的名称
	 * 
	 * @return
	 */
	public static String getFolderName() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String folderName = "";
		try {
			
			folderName = sdFormat.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
			folderName = "2017-10-30";
		} catch (Exception e) {
			logger.error("日期转换错误", e);
			return "";
		}
		if ("1900-01-01".equals(folderName)) {
			folderName = "";
		}
		return folderName;
	}

	/**
	 * 连接到服务器
	 * 
	 * @param username
	 * @param password
	 * @param ftpHostName
	 * @param port
	 */
	public static void connectServer(String username, String password, String ftpHostName, int port) {
		ftpClient = new FTPClient();
		try {
			logger.debug("开始连接ftp服务器");
			// 连接
			ftpClient.connect(ftpHostName, port);
			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
			}
			// 登录
			logger.debug("开始登录！");
			ftpClient.login(username, password);
			// ftpClient.setBufferSize(256);
			// ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setControlEncoding("utf8");
			logger.debug("登录成功！");
		} catch (SocketException e) {
			logger.error("Socket异常", e);
		} catch (IOException e) {
			logger.error("文件流处理失败", e);
		}
	}

	/**
	 * @param path
	 * @return function:读取指定目录下的文件名
	 * @throws IOException
	 */
	public static List<String> getFileList(String path) {
		List<String> fileLists = new ArrayList<String>();
		// 获得指定目录下所有文件名
		FTPFile[] ftpFiles = null;
		try {
			ftpFiles = ftpClient.listFiles(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
			FTPFile file = ftpFiles[i];
			if (file.isFile()) {
				fileLists.add(file.getName());
			}
		}
		return fileLists;
	}

	/**
	 * 返回一个文件流
	 * 
	 * @param fileName
	 * @return
	 */
	public static List<List<String>> readFileContent(String fileName) {
		List<List<String>> result = new ArrayList<List<String>>();
		InputStream ins = null;
		BufferedReader reader = null;
		try {
			ins = ftpClient.retrieveFileStream(fileName);
			reader = new BufferedReader(new InputStreamReader(ins));
			String inLine = reader.readLine();
			while (inLine != null) {
				List<String> column = new ArrayList<String>();
				column = parseCSVLine(inLine, false);
				result.add(column);
				// result = (inLine + System.getProperty("line.separator"));
				inLine = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (ins != null) {
					ins.close();
				}
				// 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决返回null问题
				ftpClient.getReply();
			} catch (IOException e) {
				logger.error("文件流处理失败", e);
			}
		}
		return result;
	}

	/**
	 * 解析CSV文件（按行解析）
	 * 
	 * @param str
	 * @param isHead
	 * @return
	 */
	public static List<String> parseCSVLine(String str, boolean isHead) {
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

	/**
	 * function:关闭连接
	 */
	public static void closeServer() {
		if (ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				logger.error("ftp连接关闭异常", e);
			}
		}
	}
}
