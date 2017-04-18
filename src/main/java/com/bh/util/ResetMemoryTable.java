package com.bh.util;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ResetMemoryTable {
	
	private static Logger logger = LoggerFactory.getLogger(ResetMemoryTable.class);
	
	
	/**
	 * 刷新内存表
	 * @param tableName 表名
	 * @return 1：刷新成功 0:刷新失败
	 */
	@SuppressWarnings("deprecation")
	public static int resetTable(String tableName){
				
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(URLAddressUtil.HTTP_HOST, URLAddressUtil.HTTP_PORT);
		PostMethod post = new PostMethod("/zhxt/manage");
		
		post.setParameter("table", URLEncoder.encode(tableName));

		String reqPayStr = "";
		SendMail send = new SendMail();
		String mailAddress = URLAddressUtil.MAILADDRESS;
		if(tableName.equals("rate") || tableName.equals("user_rate")){
			mailAddress += URLAddressUtil.MAILADDRESS_RATE_USERRATE;
		}
		if(tableName.equals("config") || tableName.equals("user_config") || tableName.equals("bwuserlist")){
			mailAddress += URLAddressUtil.MAILADDRESS_CONFIG_USERCONFIG_BWUSERLIST;
		}
		
		try {
			client.executeMethod(post);
			reqPayStr = post.getResponseBodyAsString();
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("刷新数据表"+ tableName +"出现异常！");
			boolean ys = send.sendMails( "网络不通",mailAddress,"账户系统-刷新"+ tableName +"表");
			logger.info("失败邮件发送========================="+ ys);
			return 0;
		}
		post.releaseConnection();
		logger.info("刷新数据表"+ tableName +"===================="+ reqPayStr);
		if(!reqPayStr.equalsIgnoreCase("ok")) {
			boolean ys = send.sendMails( "网络不通",mailAddress,"账户系统-刷新"+ tableName +"表");
			logger.info("失败邮件发送========================="+ ys);
			return 0;
		}		
		return 1;
	}
}
