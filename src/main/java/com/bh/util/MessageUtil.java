package com.bh.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bh.util.security.DigestUtils;
import com.bh.util.security.MD5;
import com.mongodb.util.JSON;
import com.shuyin.framework3rd.redis.RedisClientTemplate;


public class MessageUtil {
	public static void toMessage(String phone,String content){
		StringBuffer messageBody; 
		String str;
		try {
			InputStream in = MessageUtil.class.getClassLoader()
					.getResourceAsStream("message.properties");
			Properties prop = new Properties();
			prop.load(in);
			String url = (String) prop.get("url");
			String name = (String) prop.get("name");
			String password = (String) prop.get("password");
			messageBody = new StringBuffer();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhssmm");
			String mttime = sdf.format(new Date());
			String pwd = MD5.MD5Encode(password + mttime).toLowerCase();
			String param = "name=" + name + "&pwd=" + pwd + "&phone=" + phone
					+ "&mttime=" + mttime + "&content=" + content;
			str = HttpUtil.sendPostRequest(url, param, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String sendMessageCode(String phone,String templateId){
		String result="";
		try {
			InputStream in = MessageUtil.class.getClassLoader()
					.getResourceAsStream("bhmassage.properties");
			Properties prop = new Properties();
			prop.load(in);
			String url = (String) prop.get("code-url");
			String appKey=(String) prop.get("App-key");
			String appSecret=(String) prop.get("App-Secret");
			Map <String,String> body=new HashMap<String, String>(); 
			body.put("mobile", phone);
		  	body.put("templateId", templateId);
		  	body.put("region", "86");
			Map <String,String> header=new HashMap<String, String>(); 
			String nonce=FlightUtil.getCode();
			String timestamp=String.valueOf(System.currentTimeMillis());
		  	header.put("App-Key", appKey);
		  	header.put("Nonce", nonce);
		  	header.put("Timestamp",timestamp);
		  	String Signature=DigestUtils.sha1Hex(appSecret+nonce+timestamp);
		  	header.put("Signature", Signature);
		  String resultJson=HttpUtil.sendPostRequest(url, header, body, "utf-8");
		 Map<String,Object> resultMap=  (Map<String,Object>)JSON.parse(resultJson);
		 if((!resultMap.isEmpty())&&resultMap!=null){
			if(resultMap.containsKey("code")&&(Integer)resultMap.get("code")==200){
				result=(String) resultMap.get("sessionId");
			}
		 }
		} catch (Exception e) {
			return result;
		}
		return result;
	}
	public static boolean sendMessageVerifyCode(String sessionId,String code){
		boolean result=false;
		try {
			InputStream in = MessageUtil.class.getClassLoader()
					.getResourceAsStream("bhmassage.properties");
			Properties prop = new Properties();
			prop.load(in);
			String url = (String) prop.get("verify-code-url");
			String appKey=(String) prop.get("App-key");
			String appSecret=(String) prop.get("App-Secret");
			Map <String,String> body=new HashMap<String, String>(); 
			body.put("sessionId", sessionId);
		  	body.put("code", code);
			Map <String,String> header=new HashMap<String, String>(); 
			String nonce=FlightUtil.getCode();
			String timestamp=String.valueOf(System.currentTimeMillis());
		  	header.put("App-Key", appKey);
		  	header.put("Nonce", nonce);
		  	header.put("Timestamp",timestamp);
		  	String Signature=DigestUtils.sha1Hex(appSecret+nonce+timestamp);
		  	header.put("Signature", Signature);
		  String resultJson=HttpUtil.sendPostRequest(url, header, body, "utf-8");
		 Map<String,Object> resultMap=  (Map<String,Object>)JSON.parse(resultJson);
		 if((!resultMap.isEmpty())&&resultMap!=null){
			if(resultMap.containsKey("code")&&(Integer)resultMap.get("code")==200){
				result=(boolean)resultMap.get("success");
			}
		 }
		} catch (Exception e) {
			return result;
		}
		return result;
	}

    public static void main(String[] args) throws Exception {
	/*	//System.out.println(MessageUtil.sendMessageCode("15221317798", "3Hymah4_4CdaHMEUyH3RiF"));
    	//System.out.println(MessageUtil.sendMessageVerifyCode("8M21T0QKkPS84RMJXMAgk8","455741"));
    	//System.out.println(DateUtil.formatDate2String(new Date(),"yyyy-MM-dd hh:mm:ss"));
        	ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");
        	RedisClientTemplate redisClient = (RedisClientTemplate)ctx.getBean("redisClientTemplate");
    	   	Map<String,String> map =new HashMap<String,String>();
    	   	map.put("aa", "aa");
    	   	map.put("bb", "bb");
    	   	List<Object> list=new ArrayList<Object>();
    	   	list.add(map);
//    	   byte[] l=	SerializeUtil.serializeList(list);
//    	   Object unserialize = SerializeUtil.unserialize(l);
//    	   System.out.println(unserialize);
    	   	redisClient.hmset("map",map);
        	System.out.println(redisClient.hgetAll("map"));
        	redisClient.hset("map", "bb", "dd");
        	System.out.println(redisClient.hgetAll("map"));
        	//System.out.println(redisClient.exists("app_token_6A123A4BC1D8417184336A318554A8E4"));
          //System.out.println(redisClient.expire("app_token_6A123A4BC1D8417184336A318554A8E4",60*60*24*7));	
*/  
    	
    	System.out.println(UUID.randomUUID());
    }
	
}
