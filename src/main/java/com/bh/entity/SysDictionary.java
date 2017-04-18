package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * sys_dictionary
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="sys_dictionary")
public class SysDictionary extends AbstractEntity implements Cloneable{
	/** dictid INT */
	@PrimaryKey(primaryKeyName = "dictid")
	@Entity(columnName = "dictid")
	protected java.lang.Integer dictid;//
	/** code VARCHAR */
	@Entity(columnName = "code")
	protected java.lang.String code;//
	/** parent_id INT */
	@Entity(columnName = "parent_id")
	protected java.lang.Integer parentId;//
	/** name VARCHAR */
	@Entity(columnName = "name")
	protected java.lang.String name;//
	/** value VARCHAR */
	@Entity(columnName = "value")
	protected java.lang.String value;//
	/** modular VARCHAR */
	@Entity(columnName = "modular")
	protected java.lang.String modular;//

	/**
	 * @Title: dictid
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getDictid() {
		return dictid;
	}

	/**
	 * @Title: dictid
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setDictid(java.lang.Integer dictid) {
		this.dictid = dictid;
	}
	/**
	 * @Title: code
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getCode() {
		return code;
	}

	/**
	 * @Title: code
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	/**
	 * @Title: parent_id
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getParentId() {
		return parentId;
	}

	/**
	 * @Title: parent_id
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * @Title: name
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @Title: name
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}
	/**
	 * @Title: value
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getValue() {
		return value;
	}

	/**
	 * @Title: value
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setValue(java.lang.String value) {
		this.value = value;
	}
	/**
	 * @Title: modular
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getModular() {
		return modular;
	}

	/**
	 * @Title: modular
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setModular(java.lang.String modular) {
		this.modular = modular;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.SysDictionary
	 */
	@Override
	protected SysDictionary clone() throws CloneNotSupportedException {
		return (SysDictionary)super.clone();
	}
}
