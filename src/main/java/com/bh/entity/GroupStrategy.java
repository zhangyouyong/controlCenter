package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * group_strategy
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="group_strategy")
public class GroupStrategy extends AbstractEntity implements Cloneable{
	/** id BIGINT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Long id;//
	/** group_id BIGINT */
	@Entity(columnName = "group_id")
	protected java.lang.Long groupId;//
	/** menu_id BIGINT */
	@Entity(columnName = "menu_id")
	protected java.lang.Long menuId;//
	/** created_by BIGINT */
	@Entity(columnName = "created_by")
	protected java.lang.Long createdBy;//
	/** created_time DATETIME */
	@Entity(columnName = "created_time")
	protected java.util.Date createdTime;//

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
	 * @Title: group_id
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getGroupId() {
		return groupId;
	}

	/**
	 * @Title: group_id
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setGroupId(java.lang.Long groupId) {
		this.groupId = groupId;
	}
	/**
	 * @Title: menu_id
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getMenuId() {
		return menuId;
	}

	/**
	 * @Title: menu_id
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setMenuId(java.lang.Long menuId) {
		this.menuId = menuId;
	}
	/**
	 * @Title: created_by
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @Title: created_by
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setCreatedBy(java.lang.Long createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @Title: created_time
	 * @Description: 
	 * @return java.util.Date
	 */
	public java.util.Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @Title: created_time
	 * @Description: 
	 * @param java.util.Date
	 */
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.GroupStrategy
	 */
	@Override
	protected GroupStrategy clone() throws CloneNotSupportedException {
		return (GroupStrategy)super.clone();
	}
}
