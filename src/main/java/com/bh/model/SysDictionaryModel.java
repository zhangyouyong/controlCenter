package com.bh.model;

import java.util.List;

public class SysDictionaryModel {
	private int dictid; //
	private String code;
	private List<SysDictionaryModel> childNode;//子节点
	private String name;//名称
	private String value;//值
	private String  modular;//所属功能块
	public int getDictid() {
		return dictid;
	}
	public void setDictid(int dictid) {
		this.dictid = dictid;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public List<SysDictionaryModel> getChildNode() {
		return childNode;
	}
	public void setChildNode(List<SysDictionaryModel> childNode) {
		this.childNode = childNode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getModular() {
		return modular;
	}
	public void setModular(String modular) {
		this.modular = modular;
	}
	
	
}
