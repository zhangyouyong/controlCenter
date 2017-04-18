package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * user_group
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="user_group")
public class UserGroup extends AbstractEntity implements Cloneable{
	/** id INT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Integer id;//
	/** name VARCHAR */
	@Entity(columnName = "name")
	protected java.lang.String name;//
	/** group_parent INT */
	@Entity(columnName = "group_parent")
	protected java.lang.Integer groupParent;//
	/** group_describe VARCHAR */
	@Entity(columnName = "group_describe")
	protected java.lang.String groupDescribe;//
	/** cread_time DATETIME */
	@Entity(columnName = "cread_time")
	protected java.util.Date creadTime;//
	/** cread_by BIGINT */
	@Entity(columnName = "cread_by")
	protected java.lang.Long creadBy;//

	/**
	 * @Title: id
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * @Title: id
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
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
	 * @Title: group_parent
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getGroupParent() {
		return groupParent;
	}

	/**
	 * @Title: group_parent
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setGroupParent(java.lang.Integer groupParent) {
		this.groupParent = groupParent;
	}
	/**
	 * @Title: group_describe
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getGroupDescribe() {
		return groupDescribe;
	}

	/**
	 * @Title: group_describe
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setGroupDescribe(java.lang.String groupDescribe) {
		this.groupDescribe = groupDescribe;
	}
	/**
	 * @Title: cread_time
	 * @Description: 
	 * @return java.util.Date
	 */
	public java.util.Date getCreadTime() {
		return creadTime;
	}

	/**
	 * @Title: cread_time
	 * @Description: 
	 * @param java.util.Date
	 */
	public void setCreadTime(java.util.Date creadTime) {
		this.creadTime = creadTime;
	}
	/**
	 * @Title: cread_by
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getCreadBy() {
		return creadBy;
	}

	/**
	 * @Title: cread_by
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setCreadBy(java.lang.Long creadBy) {
		this.creadBy = creadBy;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.UserGroup
	 */
	@Override
	protected UserGroup clone() throws CloneNotSupportedException {
		return (UserGroup)super.clone();
	}
}
