package com.bh.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
/**
 * 获取ID
 * @author TangZhiQiang
 * @date 2013-9-9
 */
public class GetSqs {
	
	private static Integer refundSeq = 0;
	
	private static Integer manualSeq = 0;
	
	private static Integer enrechSeq = 0;
	
	
	private static Integer accSeq = 0;
	
	
	
	/**
	 * 获取退款ID
	 * @return
	 */
	public static String getRefundSeq() {
		Date date = new Date();
		String s = new String("0000");
		if(refundSeq >= 9999) {
			refundSeq = 0;
		}
		refundSeq = refundSeq + 1;
		System.out.println(refundSeq);
		// 两位随机数
		long pass = Math.round(Math.random() * 89 + 9);
		
		return DateUtil.formatDate(date, "yyyyMMddHHmmss") + pass + s.substring(0, 4 - refundSeq.toString().length()) + refundSeq.toString();
		 
	}
	
	/**
	 * 获取充值ID
	 * @return
	 */
	public static String getEnrechSeq() {
		Date date = new Date();
		String s = new String("0000");
		
		if(enrechSeq >= 9999) {
			enrechSeq = 0;
		}
		enrechSeq = enrechSeq + 1;
		// 两位随机数
		long pass = Math.round(Math.random() * 89 + 9);
		
		return DateUtil.formatDate(date, "yyyyMMddHHmmss") + pass + s.substring(0, 4 - enrechSeq.toString().length()) + enrechSeq.toString();
		 
	}
	
	/**
	 * 调账
	 * @return
	 */
	public static String getManualSeq() {
		Date date = new Date();
		String s = new String("0000");
		
		if(manualSeq >= 9999) {
			manualSeq = 0;
		}
		manualSeq = manualSeq + 1;
		// 随机数
		long pass = Math.round(Math.random() * 89 + 9);
		
		return DateUtil.formatDate(date, "yyyyMMddHHmmss") + pass + s.substring(0, 4 - manualSeq.toString().length()) + manualSeq.toString();
		 
	}
	
	/**
	 * 获取对照流水编号
	 * @return
	 */
	public static String getContrastSeq() {
		Date date = new Date();
		String s = new String("0000");
		
		if(enrechSeq >= 9999) {
			enrechSeq = 0;
		}
		enrechSeq = enrechSeq + 1;
		// 两位随机数
		long pass = Math.round(Math.random() * 89 + 9);
		
		return DateUtil.formatDate(date, "yyyyMMddHHmmss") + pass + s.substring(0, 4 - enrechSeq.toString().length()) + enrechSeq.toString();
		 
	}
	
	/**
	 * 获取流水编号
	 * @return
	 */
	public static String getPayBillSN() {
		Date date = new Date();
		String s = new String("0000");
		
		if(enrechSeq >= 9999) {
			enrechSeq = 0;
		}
		enrechSeq = enrechSeq + 1;
		// 两位随机数
		long pass = Math.round(Math.random() * 89 + 9);
		
		return DateUtil.formatDate(date, "yyyyMMddHHmmss") + pass + s.substring(0, 4 - enrechSeq.toString().length()) + enrechSeq.toString();
		 
	}
	/**
	 * 支付订单号
	 * @return
	 */
	public static String getPayOrderSN() {
		Date date = new Date();
		String s = new String("0000");
		
		if(enrechSeq >= 9999) {
			enrechSeq = 0;
		}
		enrechSeq = enrechSeq + 1;
		// 两位随机数
		long pass = Math.round(Math.random() * 89 + 9);
		
		return DateUtil.formatDate(date, "yyyyMMddHHmmss") + pass + s.substring(0, 4 - enrechSeq.toString().length()) + enrechSeq.toString();
		 
	}
	/**
	 * 
	* @Title: getUUID 
	* @Description: TODO
	* @param @return
	* @return String
	* @author:zyy
	* @date:2016年4月13日
	* @throws
	 */
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		String primaryKey =uuid.toString().replace("-","").toUpperCase();
		return primaryKey;
	} 

	/**
	 * 获取6位验证码
	* @Title: getAuthCode 
	* @Description: TODO
	* @param @return
	* @return String
	* @author:zyy
	* @date:2016年4月18日
	* @throws
	 */
	public static String getAuthCode(){
		Random rd=new Random();
		int x=rd.nextInt(999999-100000+1)+100000;
		return String.valueOf(x);
	}

	
}
