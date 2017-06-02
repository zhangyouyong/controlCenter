package com.bh.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTTP相关的操作
 * @author bo.li
 * @Date 2011-10-9
 */
public class HttpUtil {

    public static final String CHARACTER_ENCODING = "UTF-8";
    public static final String PATH_SIGN          = "/";
    public static final String METHOD_POST        = "POST";
    public static final String METHOD_GET         = "GET";
    public static final String METHOD_DELETE      = "DELETE";
    public static final String METHOD_PUT         = "PUT";
    public static final String CONTENT_TYPE       = "Content-Type";
    static {
        System.setProperty("sun.net.client.defaultConnectTimeout", "50000");
        System.setProperty("sun.net.client.defaultReadTimeout", "50000");
    }

    /**
     * 获取客户端IP
     * 
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        if (request == null)
            return "";
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    /**
     * 获取操作系统
     * @param request
     * @return
     */
    public static String getOsInfo(HttpServletRequest request){  
        String  browserDetails  =   request.getHeader("User-Agent");  
        String  userAgent       =   browserDetails;  
  
        String os = "";  
  
        //=================OS Info=======================  
        if (userAgent.toLowerCase().indexOf("windows") >= 0 )  
        {  
            os = "Windows";  
        } else if(userAgent.toLowerCase().indexOf("mac") >= 0)  
        {  
            os = "Mac";  
        } else if(userAgent.toLowerCase().indexOf("x11") >= 0)  
        {  
            os = "Unix";  
        } else if(userAgent.toLowerCase().indexOf("android") >= 0)  
        {  
            os = "Android";  
        } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)  
        {  
            os = "IPhone";  
        }else{  
            os = "UnKnown, More-Info: "+userAgent;  
        }  
        return os;
    }
    /**
     * 获取浏览器信息
     * @param request
     * @return
     */
    public static String getdBrowserInfo(HttpServletRequest request){  
        String  browserDetails  =   request.getHeader("User-Agent");  
        String  userAgent       =   browserDetails;  
        String  user            =   userAgent.toLowerCase();  
  
        String browser = "";  
       
        //===============Browser===========================  
        if (user.contains("edge"))  
        {  
            browser=(userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");  
        } else if (user.contains("msie"))  
        {  
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];  
            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];  
        } else if (user.contains("safari") && user.contains("version"))  
        {  
            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]  
                    + "-" +(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];  
        } else if ( user.contains("opr") || user.contains("opera"))  
        {  
            if(user.contains("opera")){  
                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]  
                        +"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];  
            }else if(user.contains("opr")){  
                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))  
                        .replace("OPR", "Opera");  
            }  
  
        } else if (user.contains("chrome"))  
        {  
            browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");  
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  ||  
                (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) ||  
                (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) || (user.indexOf("mozilla/5") != -1) ) 
        {  
            browser = "Netscape-?";  
  
        } else if (user.contains("firefox"))  
        {  
            browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");  
        } else if(user.contains("rv"))  
        {  
            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");  
            browser="IE" + IEVersion.substring(0,IEVersion.length() - 1);  
        } else  
        {  
            browser = "UnKnown";  
        }  
  
        return  browser ;  
    }  

    /**
     * 获取对应ip的物理网卡地址
     * 
     * @param ip
     * @return
     */
    public String getMACAddress(String ip) {
        String str = "";
        String macAddress = "";
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }

    public static String getRootPath(ServletContext sctx) {
        String rootpath = sctx.getRealPath("/");
        if (rootpath != null) {
            rootpath = rootpath.replaceAll("\\", "/");
        } else {
            rootpath = "/";
        }
        if (!rootpath.endsWith("/")) {
            rootpath = rootpath + "/";
        }
        return rootpath;
    }

    @SuppressWarnings("unused")
    private static String inputStreamToString(InputStream is, String encode) throws Exception {
        StringBuffer buffer = new StringBuffer();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, encode));
        int ch;
        for (int length = 0; (ch = rd.read()) > -1; length++) {
            buffer.append((char) ch);
        }
        rd.close();
        return buffer.toString();
    }

    /**
     * 发送get请求，获取返回html
     * 
     * @param strUrl
     *            请求地址
     * @param encode
     *            页面编码
     * @return
     * @throws Exception
     */
    public static String sendGetRequest(String strUrl, String encode) throws Exception {
        URL newUrl = new URL(strUrl);
        HttpURLConnection hConnect = (HttpURLConnection) newUrl.openConnection();
        InputStream is = hConnect.getInputStream();
        String str = inputStreamToString(is, encode);
        is.close();
        hConnect.disconnect();
        return str;
    }

    /**
     * 发送delete请求，获取返回html
     * 
     * @param strUrl
     *            请求地址
     * @param encode
     *            页面编码
     * @return
     * @throws Exception
     */
    public static String sendDeleteRequest(String requestUrl, String encode) throws Exception {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_DELETE);// 提交模式
        conn.setConnectTimeout(5000);// 连接超时 单位毫秒
        conn.setReadTimeout(5000);// 读取超时 单位毫秒
        conn.setDoInput(true);
        conn.setUseCaches(false);

        InputStream is = conn.getInputStream();
        String str = inputStreamToString(is, encode);
        is.close();
        conn.disconnect();
        return str;
    }

    /**
     * 发送post请求
     * 
     * @param requestUrl
     *            请求URL地址
     * @param params
     *            请求参数 text1=aaa&text2=bbb
     * @param encode
     *            请求参数及页面的编码
     * @return 返回页面返回的html
     * @throws Exception
     */
    public static String sendPostRequest(String requestUrl, String params, String encode) throws Exception {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_POST);// 提交模式
        conn.setConnectTimeout(50000);// 连接超时 单位毫秒
        conn.setReadTimeout(50000);// 读取超时 单位毫秒
        conn.setDoOutput(true);// 是否输入参数
        conn.setDoInput(true);
        conn.setUseCaches(false);
        byte[] b = params.toString().getBytes(encode);
        OutputStream os = conn.getOutputStream();
        os.write(b);// 输入参数
        os.flush();
        os.close();

        InputStream is = conn.getInputStream();
        String str = inputStreamToString(is, encode);
        is.close();
        conn.disconnect();
        return str;
    }

    /**
     * 发送post请求
     * 
     * @param requestUrl
     *            请求URL地址
     * @param header    
     * 			  请求头      
     * @param params
     *           map
     * @param encode
     *            请求参数及页面的编码
     * @return 返回页面返回的html
     * @throws Exception
     */
    public static String sendPostRequest(String requestUrl,Map<String,String> header, Map<String, String> body, String encode) throws Exception {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_POST);// 提交模式
        Iterator<Entry<String, String>> it = header.entrySet().iterator();
        while(it.hasNext()){
        	Entry<String, String> entry = it.next();
        	conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        conn.setConnectTimeout(50000);// 连接超时 单位毫秒
        conn.setReadTimeout(50000);// 读取超时 单位毫秒
        conn.setDoOutput(true);// 是否输入参数
        conn.setDoInput(true);
        conn.setUseCaches(false);
        
        StringBuffer paramStr = new StringBuffer("");
        if (body != null && body.size() > 0) {
            for (String key : body.keySet()) {
                paramStr.append(key);
                paramStr.append("=");
                paramStr.append(encode(body.get(key)));
                paramStr.append("&");
            }
        }
        byte[] b = paramStr.toString().getBytes(encode);
        OutputStream os = conn.getOutputStream();
        os.write(b);// 输入参数
        os.flush();
        os.close();

        InputStream is = conn.getInputStream();
        String str = inputStreamToString(is, encode);
        is.close();
        conn.disconnect();
        return str;
    }
    /**
     * 发送post请求
     * 
     * @param requestUrl
     *            请求URL地址
     * @param header    
     * 			  请求头      
     * @param params
     *           String
     * @param encode
     *            请求参数及页面的编码
     * @return 返回页面返回的html
     * @throws Exception
     */
    public static String sendPostRequest(String requestUrl,Map<String,String> header, String paramStr, String encode) throws Exception {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_POST);// 提交模式
        Iterator<Entry<String, String>> it = header.entrySet().iterator();
        while(it.hasNext()){
        	Entry<String, String> entry = it.next();
        	conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
        conn.setConnectTimeout(50000);// 连接超时 单位毫秒
        conn.setReadTimeout(50000);// 读取超时 单位毫秒
        conn.setDoOutput(true);// 是否输入参数
        conn.setDoInput(true);
        conn.setUseCaches(false);

        byte[] b = paramStr.toString().getBytes(encode);
        OutputStream os = conn.getOutputStream();
        os.write(b);// 输入参数
        os.flush();
        os.close();

        InputStream is = conn.getInputStream();
        String str = inputStreamToString(is, encode);
        is.close();
        conn.disconnect();
        return str;
    }
    /**
     * 发送post请求
     * 
     * @param requestUrl
     *            请求URL地址
     * @param params
     *            Map类型的参数
     * @param encode
     *            请求参数及页面的编码
     * @return String
     * @throws Exception
     */
    public static String sendPostRequest(String requestUrl, Map<String, String> params, String encode) throws Exception {
        StringBuffer paramStr = new StringBuffer("");
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                paramStr.append(key);
                paramStr.append("=");
                paramStr.append(encode(params.get(key)));
                paramStr.append("&");
            }
        }
        return sendPostRequest(requestUrl, paramStr.toString(), encode);
    }

    /**
     * 发送put请求
     * 
     * @param requestUrl
     *            请求URL地址
     * @param params
     *            请求参数 text1=aaa&text2=bbb
     * @param encode
     *            请求参数及页面的编码
     * @return 返回页面返回的html
     * @throws Exception
     */
    public static String sendPutRequest(String requestUrl, String params, String encode) throws Exception {
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_PUT);// 提交模式
        conn.setConnectTimeout(5000);// 连接超时 单位毫秒
        conn.setReadTimeout(5000);// 读取超时 单位毫秒
        conn.setDoOutput(true);// 是否输入参数
        conn.setDoInput(true);
        conn.setUseCaches(false);

        byte[] b = params.toString().getBytes(encode);
        OutputStream os = conn.getOutputStream();
        os.write(b);// 输入参数
        os.flush();
        os.close();

        InputStream is = conn.getInputStream();
        String str = inputStreamToString(is, encode);
        is.close();
        conn.disconnect();
        return str;
    }

    /**
     * 发送带文件上传以及文本域的post请求
     * 
     * @param urlString
     *            post请求地址
     * @param params
     *            文本
     * @param files
     *            文件
     * @return 返回的html
     * @throws Exception
     */
    public static String sendPostFileRequest(String urlString, Map<String, String> params, Map<String, String> files, String encode) throws Exception {
        // 是否在控制台打印请求参数，方便调用
        boolean printArgs = false;

        // 构送请求http请求参数
        String BOUNDARY = "---------------------------7d4a6d158c9"; // 分隔线
        List<byte[]> headerList = new ArrayList<byte[]>();
        List<byte[]> contentList = new ArrayList<byte[]>();
        byte[] end = ("--" + BOUNDARY + "--\r\n").getBytes();
        int contentLength = 0;
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                byte[] header = ("--" + BOUNDARY + "\r\nContent-Disposition: form-data;name=\"" + key + "\"\r\n\r\n").getBytes(encode);
                byte[] content = params.get(key).getBytes(encode);
                headerList.add(header);
                contentList.add(content);
                contentLength += header.length + content.length + "\r\n".getBytes().length;
                if (printArgs) {
                    System.out.print(new String(header, encode));
                    System.out.print(new String(content, encode));
                    System.out.print(new String("\r\n".getBytes()));
                }
            }
        }
        if (files != null && files.size() > 0) {
            for (String key : files.keySet()) {
                String filename = files.get(key).substring(files.get(key).lastIndexOf("/") + 1);
                byte[] header = ("--" + BOUNDARY + "\r\nContent-Disposition: form-data; name=\"" + key + "\"; filename=\"" + filename + "\"\r\nContent-Type: multipart/form-data\r\n\r\n")
                    .getBytes(encode);
                byte[] content = org.apache.commons.io.FileUtils.readFileToByteArray(new File(files.get(key)));
                headerList.add(header);
                contentList.add(content);
                contentLength += header.length + content.length + "\r\n".getBytes().length;
                if (printArgs) {
                    System.out.print(new String(header, encode));
                    System.out.print(new String(content));
                    System.out.print(new String("\r\n".getBytes()));
                }
            }
        }
        contentLength += end.length;
        if (printArgs) {
            System.out.print(new String(end));
        }

        // 发送http请求
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(METHOD_POST);
        conn.setConnectTimeout(5000);// 连接超时 单位毫秒
        conn.setReadTimeout(5000);// 读取超时 单位毫秒
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
        conn.setRequestProperty("Content-Length", String.valueOf(contentLength));
        OutputStream os = conn.getOutputStream();
        for (int i = 0; i < headerList.size(); i++) {
            os.write(headerList.get(i));
            os.write(contentList.get(i));
            os.write("\r\n".getBytes());
        }
        os.write(end);
        os.flush();
        os.close();
        // 获取http请求结果
        InputStream is = conn.getInputStream();
        String str = inputStreamToString(is, encode);
        is.close();
        conn.disconnect();
        return str;
    }


    /**
     * url解码
     * 
     * @param str
     * @return 解码后的字符串,当异常时返回原始字符串。
     */
    public static String decode(String url) {
        if (url == null) {
            return null;
        }
        try {
            return URLDecoder.decode(url, CHARACTER_ENCODING);
        } catch (UnsupportedEncodingException ex) {
            return url;
        }
    }

    /**
     * url编码
     * 
     * @param str
     * @return 编码后的字符串,当异常时返回原始字符串。
     */
    public static String encode(String url) {
        if (url == null) {
            return null;
        }
        try {
            return URLEncoder.encode(url, CHARACTER_ENCODING);
        } catch (UnsupportedEncodingException ex) {
            return url;
        }
    }
    
    public static String linkParam(Map<String, Object> body) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer("");
        if (body != null && body.size() > 0) {
            for (String key : body.keySet()) {
            	sb.append(key);
            	sb.append("=");
            	Object object = body.get(key);
            	if (object instanceof String) {
            		String encode = URLEncoder.encode(object.toString(), "UTF-8");
            		sb.append(encode);
				}else {
					sb.append(body.get(key));
				}
            	sb.append("&");
            }
        }
		return sb.substring(0, sb.length()-1).toString();
	}

    public static void main(String[] args) throws Exception {
//        String str = "";
//        try {
//            str = HttpUtil.sendPostRequest("http://192.168.18.216:4002/app/manager", "target=refresh_cs", CHARACTER_ENCODING);
//        } catch (Exception e) {
//            System.out.println("aaa" + e);
//        }
//        System.out.println(str);
    	//String result=HttpUtil.sendGetRequest("http://192.168.1.241/DealWith.ashx?LogUser=admin&LogSign=9625d9e8b009d3d056fbaa5ddc7b162b&ReqFunction=TerminalCalculate&Rtime=2016-04-14%2010:30:45&Ctime=2016-04-14%2011:30:45&PlateNume=湘12345&AreaID=1","utf-8");
    	//System.out.println(result);
    	//System.out.println(HttpUtil.fileDownload("http://download.redis.io/releases/redis-3.2.8.tar.gz", "utf-8"));
    	Map <String,String> body=new HashMap<String, String>(); 
    	body.put("mobile", "15221317798");
    	body.put("templateId", "3Hymah4_4CdaHMEUyH3RiF");
    	body.put("region", "86");
    	Map <String,String> header=new HashMap<String, String>(); 
    	header.put("App-Key", "bmdehs6pdo82s");
    	header.put("Nonce", "14314");
    	header.put("Timestamp", "1408706337");
    	header.put("Signature", "67a296773ad5c3e3f9bb25f85480bd7a143717b5");
    	//HttpUtil.sendPostRequest("http://api.sms.ronghub.com/sendCode.json", header, body,"utf-8");
    	String str=HttpUtil.sendPostRequest("http://api.sms.ronghub.com/sendCode.json", header, body, "utf-8");
    	System.out.println(str);
    }
    public static void fileDownload(String strUrl, String encode,HttpServletResponse response) throws Exception {
        URL newUrl = new URL(strUrl);
        HttpURLConnection hConnect = (HttpURLConnection) newUrl.openConnection();
        InputStream is = hConnect.getInputStream();
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        response.reset();
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
        hConnect.disconnect();
    }
    

}