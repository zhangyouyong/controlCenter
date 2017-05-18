package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * application_account
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="application_account")
public class ApplicationAccount extends AbstractEntity implements Cloneable{
	/** id BIGINT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Long id;//
	/** user_id BIGINT */
	@Entity(columnName = "user_id")
	protected java.lang.Long userId;//
	/** login_name VARCHAR */
	@Entity(columnName = "login_name")
	protected java.lang.String loginName;//
	/** application_id BIGINT */
	@Entity(columnName = "application_id")
	protected java.lang.Long applicationId;//
	/** phone VARCHAR */
	@Entity(columnName = "phone")
	protected java.lang.String phone;//
	/** createdBy BIGINT */
	@Entity(columnName = "createdBy")
	protected java.lang.Long createdby;//
	/** crearedTime DATETIME */
	@Entity(columnName = "crearedTime")
	protected java.util.Date crearedtime;//
	/** updatedBy BIGINT */
	@Entity(columnName = "updatedBy")
	protected java.lang.Long updatedby;//
	/** updatedTime DATETIME */
	@Entity(columnName = "updatedTime")
	protected java.util.Date updatedtime;//

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
	 * @return java.lang.Long
	 */
	public java.lang.Long getUserId() {
		return userId;
	}

	/**
	 * @Title: user_id
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}
	/**
	 * @Title: login_name
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getLoginName() {
		return loginName;
	}

	/**
	 * @Title: login_name
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setLoginName(java.lang.String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @Title: application_id
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getApplicationId() {
		return applicationId;
	}

	/**
	 * @Title: application_id
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setApplicationId(java.lang.Long applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @Title: phone
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * @Title: phone
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	/**
	 * @Title: createdBy
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getCreatedby() {
		return createdby;
	}

	/**
	 * @Title: createdBy
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setCreatedby(java.lang.Long createdby) {
		this.createdby = createdby;
	}
	/**
	 * @Title: crearedTime
	 * @Description: 
	 * @return java.util.Date
	 */
	public java.util.Date getCrearedtime() {
		return crearedtime;
	}

	/**
	 * @Title: crearedTime
	 * @Description: 
	 * @param java.util.Date
	 */
	public void setCrearedtime(java.util.Date crearedtime) {
		this.crearedtime = crearedtime;
	}
	/**
	 * @Title: updatedBy
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getUpdatedby() {
		return updatedby;
	}

	/**
	 * @Title: updatedBy
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setUpdatedby(java.lang.Long updatedby) {
		this.updatedby = updatedby;
	}
	/**
	 * @Title: updatedTime
	 * @Description: 
	 * @return java.util.Date
	 */
	public java.util.Date getUpdatedtime() {
		return updatedtime;
	}

	/**
	 * @Title: updatedTime
	 * @Description: 
	 * @param java.util.Date
	 */
	public void setUpdatedtime(java.util.Date updatedtime) {
		this.updatedtime = updatedtime;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.ApplicationAccount
	 */
	@Override
	protected ApplicationAccount clone() throws CloneNotSupportedException {
		return (ApplicationAccount)super.clone();
	}
}
