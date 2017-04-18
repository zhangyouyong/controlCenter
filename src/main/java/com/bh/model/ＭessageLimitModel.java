package com.bh.model;

import java.util.Date;

public class ＭessageLimitModel {
	private String phone;//手机号码
	private int count;//请求次数
	private Date updateLastTime;//最后更新时间
	private String ip; //用戶请求ip
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getUpdateLastTime() {
		return updateLastTime;
	}
	public void setUpdateLastTime(Date updateLastTime) {
		this.updateLastTime = updateLastTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ＭessageLimitModel(String phone, int count, Date updateLastTime) {
		super();
		this.phone = phone;
		this.count = count;
		this.updateLastTime = updateLastTime;
	}
	
	
	
}
