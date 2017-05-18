package com.bh.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ApplicationAccountModel {
	@SerializedName("mobile")
	private String mobile;
	@SerializedName("pwd")
	private String pwd;
	@SerializedName("bindingUserId")
	private Long bindingUserId;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getBindingUserId() {
		return bindingUserId;
	}
	public void setBindingUserId(Long bindingUserId) {
		this.bindingUserId = bindingUserId;
	}
	
	public String toString(){
		Gson gson=new Gson();
		return gson.toJson(this);
	}

}
