package com.bh.util;

import java.io.*;
import java.util.Properties;

import sun.misc.BASE64Decoder;

/**
 * 公共类
 * 
 * @author Administrator
 */
public class Common {
	@SuppressWarnings("unused")
	private static final String String = null;
	public static final String PUB_KEY = "/var/www/apps/key/pub.txt";

	public static final String PRI_KEY = "/var/www/apps/key/";

	//
	// public static final String PUB_KEY = "e:/key/pub.txt";
	//
	// public static final String PRI_KEY = "e:/key/";

	/**
	 * 读取配置文件
	 * 
	 * @param name
	 * @return
	 */
	public static String getProperties(String name) {
		try {
			// 定义一个properties文件的名字
			String propFile = "dictionary.properties";
			// 定义一个properties对象
			Properties properties = new Properties();
			// 读取properties
			InputStream file = Common.class.getClassLoader()
					.getResourceAsStream(propFile);
			// 加载properties文件
			properties.load(file);
			// 读取properties中的某一项
			String value = properties.getProperty(name);
			return value;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 通过rsa私钥存取文件名，获取私钥
	 * 
	 * @param file
	 *            rsa私钥存取文件名
	 * @return 以字符串的形式返回私钥
	 */
	// 读取私钥文件写入本地文件
	public static String WriteFile(String path, String prikey) {
		File f = new File(path);
		String msg = "ok";
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(f));
			w.write(prikey);
			w.flush();
			w.close();
		} catch (Exception e) {
			msg = "文件写入失败";
		}
		return msg;
	}

	public static String getPrivateKey(String file) {
		try {
			byte[] pri = new byte[1024];
			FileInputStream inpri = new FileInputStream(file);
			inpri.read(pri);
			inpri.close();
			String privateKey = new String(pri, "UTF-8");
			return privateKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 通过rsa私钥存取文件名，获取私钥
	 * 
	 * @param file
	 *            rsa私钥存取文件名
	 * @return 以字符串的形式返回私钥
	 */
	public static String getPubliceKey(String file) {
		try {
			byte[] pub = new byte[1024];
			FileInputStream in = new FileInputStream(file);
			in.read(pub);
			in.close();
			String publicKey = new String(pub, "UTF-8");
			return publicKey;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String getPriKey(String mid) {
		return getKey(mid);
	}

	public static String getPubKey(String mid) {
		return getKey(mid);
	}

	public static String getKey(String file) {
		try {
			byte[] pri = new byte[1024];
			FileInputStream inpri = new FileInputStream(file);
			inpri.read(pri);
			inpri.close();
			String privateKey = new String(pri, "UTF-8");
			return privateKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * base64 解码
	 * 
	 * @param s
	 *            传入的加密的字符串
	 * @return
	 */
	public static String getFromBASE64(String s) {
		if (s == null)
			return "";
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return "";
		}
	}

	public static String StringbyByte(String bt) {
		char[] chars = bt.toCharArray();
		String s = new String();
		for (int i = 0; i < chars.length; i++) {
			s+=(int)chars[i];
		}
		System.out.println("============"+s);
		return s;
	}

//	public static void main(String[] args) throws UnsupportedEncodingException {
//
//		String s = "新年快乐！";// 字符串
//		char[] chars = s.toCharArray(); // 把字符中转换为字符数组
//		System.out.println("\n\n汉字 ASCII\n----------------------");
//		for (int i = 0; i < chars.length; i++) {// 输出结果
//			System.out.println(" " + chars[i] + " " + (int) chars[i]);
//		}
//		
//		System.out.println(StringbyByte(s));
//	}
}
