package com.bh.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.bh.util.security.DigestUtils;
import com.bh.util.security.MD5;
import com.mongodb.util.JSON;
import com.shuyin.framework3rd.redis.RedisClientTemplate;

@Component
public class MessageUtil {

	
		public static final String regionId = "cn-hangzhou";
	    public static final String accessKeyId = "LTAIHGtA98QvCDpY";
	    public static final String secret = "az86ZjLN5IwQLj7I66jAbfadGHmZ3H";
	    public static final String product = "Sms";
	    public static final String domain = "sms.aliyuncs.com";
	    public static final String signName="志愿服务保障";
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
    public static String aliyuMessageCode(String mobile,String templateCode)
    {
        String code = "";
        try
        {
            Map<String,String > map = new HashMap<>();
            code = GetSqs.getAuthCode();
            map.put("code",code);
            map.put("product",signName);
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
            DefaultProfile.addEndpoint(regionId, regionId, product,  domain);
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName(signName);//控制台创建的签名名称
            request.setTemplateCode(templateCode);//控制台创建的模板CODE
            request.setParamString(JSON.serialize(map));//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
            request.setRecNum(mobile);//接收号码
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
            System.out.println(httpResponse.toString());
            System.out.println(httpResponse.getRequestId()+"----"+httpResponse.getModel());
        }
        catch (ServerException e)
        {
            e.printStackTrace();
        }
        catch (ClientException e)
        {
            e.printStackTrace();
        }
        return code;
    }


 
}
