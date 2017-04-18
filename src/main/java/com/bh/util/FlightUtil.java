package com.bh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.entity.StringEntity;


public class FlightUtil {

    public static String convert(Object obj, Object[] codes, String[] view) {
        if (obj != null) {
            int index = indexOf(obj, codes);
            if (index != -1) {
                return view[index];
            } else {
                index = indexOf(obj, view);
                if (index == -1) {
                    StringBuffer sb1 = new StringBuffer();
                    StringBuffer sb2 = new StringBuffer();
                    for (int i = 0; i < codes.length; i++) {
                        sb1.append(codes[i] + ", ");
                        sb2.append(view[i] + ", ");
                    }
                    return obj.toString();
                }
                return codes[index].toString();
            }
        }
        return "";
    }

    public static String genSelectedForSearch(Object defaultSelect, String parameterName, boolean isReadOnly, Object[] codes, String[] view) {
        StringBuffer sb = new StringBuffer();
        String readOnly = isReadOnly ? " disabled='disabled' " : "";
        sb.append("<select name=\"" + parameterName + "\" " + readOnly + "id=\"" + parameterName + "\">");
        sb.append("<option value='-1' >全部</option>");
        for (int i = 0; i < codes.length; i++) {
            if (codes[i].equals(defaultSelect) || view[i].equals(defaultSelect)) {
                sb.append("<option value=\"" + codes[i] + "\" selected=\"true\">" + view[i] + "</option>");
            } else {
                sb.append("<option value=\"" + codes[i] + "\">" + view[i] + "</option>");
            }
        }
        sb.append("</select>");

        return sb.toString();
    }

    public static String genSelectedForChange(Object defaultSelect, String parameterName, boolean isReadOnly, Object[] codes, String[] view) {
        StringBuffer sb = new StringBuffer();
        String readOnly = isReadOnly ? " disabled='disabled' " : "";
        sb.append("<select name=\"" + parameterName + "\" " + readOnly + "id=\"" + parameterName + "\">");

        for (int i = 0; i < codes.length; i++) {
            if (codes[i].equals(defaultSelect) || view[i].equals(defaultSelect)) {
                sb.append("<option value=\"" + codes[i] + "\" selected=\"selected\">" + view[i] + "</option>");
            } else {
                sb.append("<option value=\"" + codes[i] + "\">" + view[i] + "</option>");
            }
        }
        sb.append("</select>");
        return sb.toString();
    }

    private static int indexOf(Object obj, Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public static String cleanJpQL(String queryString) {
        queryString = queryString.trim();
        if (queryString.endsWith(" where")) {
            return queryString.substring(0, queryString.length() - 5);
        }
        if (queryString.endsWith(" and")) {
            return queryString.substring(0, queryString.length() - 3);
        }
        if (queryString.endsWith(" or")) {
            return queryString.substring(0, queryString.length() - 2);
        }
        return queryString;
    }

    public static String numberUpper(int n) {
        String c = "";
        switch (n) {
            case 1:
                c = "一";
                break;
            case 2:
                c = "二";
                break;
            case 3:
                c = "三";
                break;
            case 4:
                c = "四";
                break;
            case 5:
                c = "五";
                break;
            case 6:
                c = "六";
                break;
            case 7:
                c = "七";
                break;
            case 8:
                c = "八";
                break;
            case 9:
                c = "九";
            case 10:
                c = "十";
                break;
            default:
                c = n + "";

        }
        return c;
    }

    /**
     * 读取配置文件某一项
     * @param filename
     * @param urlName
     * @return
     */
    public static synchronized String getProperties(String filename, String urlName) {
        try {
            Properties properties = new Properties();
            InputStream file = FlightUtil.class.getClassLoader().getResourceAsStream(filename);
            properties.load(file);
            return properties.getProperty(urlName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取配置文件
     * @return
     */
    public static synchronized Properties getProperties(String propFile) {
        try {
            Properties properties = new Properties();
            InputStream file = FlightUtil.class.getClassLoader().getResourceAsStream(propFile);
            properties.load(file);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到5位随机数
     * @return
     */
    public static String getCode() {
        Random random = new Random();
        Integer code = 10000 + random.nextInt(89999);
        return code.toString();
    }

    /**
    * MD5 加密方法
    *
    * @param password String
    * @return returnStr
    */
    public static String makeMD5(String password) {
        MessageDigest md;
        try {
            // 生成一个MD5加密计算摘要
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String pwd = new BigInteger(1, md.digest()).toString(16);
            return pwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public static String encryptMD5(String password) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String sign(String content, String key) throws Exception {
        String tosign = (content == null ? "" : content) + key;
        try {
            return DigestUtils.md5Hex(tosign.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new SignatureException("MD5签名[content = " + content + "; charset = utf-8" + "]发生异常!", e);
        }

    }

    public static boolean verify(String content, String sign, String key) throws Exception {
        String tosign = (content == null ? "" : content) + key;

        try {
            String mySign = DigestUtils.md5Hex(tosign.getBytes("utf-8"));

            return mySign.equals(sign) ? true : false;
        } catch (UnsupportedEncodingException e) {
            throw new SignatureException("MD5验证签名[content = " + content + "; charset =utf-8 " + "; signature = " + sign + "]发生异常!", e);
        }
    }

    /**
     * 
     * 保留两位小数
     */
    public static String dfFormat(String a, Object b) {
        DecimalFormat df = new DecimalFormat(a);
        return df.format(b);
    }

    public static String getMethod(String queryStr) {
        // 构造HttpClient的实例
        HttpClient httpClient = new HttpClient();
        // 创建GET方法的实例
        GetMethod getMethod = new GetMethod(queryStr);

        // 使用系统提供的默认的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        try {
            // 执行getMethod
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            // 读取内容
            byte[] responseBody = getMethod.getResponseBody();

            // 处理内容
            return new String(responseBody, "UTF-8");
        } catch (IOException e) {
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            e.printStackTrace();
        } finally {
            // 释放连接
            getMethod.releaseConnection();
        }
        return null;
    }
    /**
	 *  支付宝地址检验
	 * @author:  zyy
	 * @Date:2015年12月24日 下午4:30:44
	 * @version: 1.0
	 * doPost
	 * @param parameters
	 * @return String
	 * @throws Exception 
	 */
    public static String CheckUrl(String urlvalue){
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();
            //urlConnection.setRequestProperty("Accept", "*/*");
            //urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; CIBA)"); //模拟ie浏览器
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputLine;
    }
	/**
	 * httpCilent post 请求
	 * @author:  zyy
	 * @Date:2015年12月24日 下午4:30:44
	 * @version: 1.0
	 * doPost
	 * @param parameters
	 * @return String
	 * @throws Exception 
	 */
    public  static  String HttpClient(String url,Map<String,String>  parameters) throws Exception{
    	HttpClient client= new  HttpClient();
   
    	
    //	client.getHostConfiguration().setHost(url);
    	PostMethod post=new PostMethod(url);
    	Set<String> set= parameters.keySet();
    	for (Iterator it =set.iterator();it.hasNext();)
		{
			String key=(String)it.next();
			post.setParameter(key,parameters.get(key));
		}
    	
    	
    	client.executeMethod(post);
    	String reqPayStr = new String(post.getResponseBodyAsString().getBytes("ISO8859-1"),"utf-8");
		post.releaseConnection();
    	return reqPayStr;
    }
}
