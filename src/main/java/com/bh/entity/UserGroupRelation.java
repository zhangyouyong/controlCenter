package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * user_group_relation
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="user_group_relation")
public class UserGroupRelation extends AbstractEntity implements Cloneable{
	/** id BIGINT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Long id;//
	/** user_id INT */
	@Entity(columnName = "user_id")
	protected java.lang.Integer userId;//
	/** group_id INT */
	@Entity(columnName = "group_id")
	protected java.lang.Integer groupId;//
	/** cread_time DATETIME */
	@Entity(columnName = "cread_time")
	protected java.util.Date creadTime;//

	/**
	 * @Title: id
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * @Title: id
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	/**
	 * @Title: user_id
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getUserId() {
		return userId;
	}

	/**
	 * @Title: user_id
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	/**
	 * @Title: group_id
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getGroupId() {
		return groupId;
	}

	/**
	 * @Title: group_id
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setGroupId(java.lang.Integer groupId) {
		this.groupId = groupId;
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
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.UserGroupRelation
	 */
	@Override
	protected UserGroupRelation clone() throws CloneNotSupportedException {
		return (UserGroupRelation)super.clone();
	}
}
