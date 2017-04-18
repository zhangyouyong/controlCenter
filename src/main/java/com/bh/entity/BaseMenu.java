package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * base_menu
 * 资源表（菜单）
 * @author EntityGenerateTool
 */
@Table(tableName="base_menu")
public class BaseMenu extends AbstractEntity implements Cloneable{
	/** menuid INT */
	@PrimaryKey(primaryKeyName = "menuid")
	@Entity(columnName = "menuid")
	protected java.lang.Integer menuid;//菜单ID
	/** appid INT */
	@Entity(columnName = "appid")
	protected java.lang.Integer appid;//
	/** orgid INT */
	@Entity(columnName = "orgid")
	protected java.lang.Integer orgid;//
	/** name VARCHAR */
	@Entity(columnName = "name")
	protected java.lang.String name;//
	/** description VARCHAR */
	@Entity(columnName = "description")
	protected java.lang.String description;//
	/** parent_id INT */
	@Entity(columnName = "parent_id")
	protected java.lang.Integer parentId;//父id
	/** level INT */
	@Entity(columnName = "level")
	protected java.lang.Integer level;//等级
	/** node VARCHAR */
	@Entity(columnName = "node")
	protected java.lang.String node;//菜单节点 x-x-x-x
	/** url VARCHAR */
	@Entity(columnName = "url")
	protected java.lang.String url;//连接url地址
	/** type INT */
	@Entity(columnName = "type")
	protected java.lang.Integer type;//菜单类型 1 菜单资源 2 功能资源3Api链接
	/** icon VARCHAR */
	@Entity(columnName = "icon")
	protected java.lang.String icon;//菜单的ICON
	/** delete_flag INT */
	@Entity(columnName = "delete_flag")
	protected java.lang.Integer deleteFlag;//默认0,1表示删除，0表示未删除
	/** create_userid INT */
	@Entity(columnName = "create_userid")
	protected java.lang.Integer createUserid;//数据创建用户id
	/** create_date DATETIME */
	@Entity(columnName = "create_date")
	protected java.util.Date createDate;//创建时间
	/** update_userid INT */
	@Entity(columnName = "update_userid")
	protected java.lang.Integer updateUserid;//数据修改用户id
	/** update_date DATETIME */
	@Entity(columnName = "update_date")
	protected java.util.Date updateDate;//

	/**
	 * @Title: menuid
	 * @Description: 菜单ID
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getMenuid() {
		return menuid;
	}

	/**
	 * @Title: menuid
	 * @Description: 菜单ID
	 * @param java.lang.Integer
	 */
	public void setMenuid(java.lang.Integer menuid) {
		this.menuid = menuid;
	}
	/**
	 * @Title: appid
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getAppid() {
		return appid;
	}

	/**
	 * @Title: appid
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setAppid(java.lang.Integer appid) {
		this.appid = appid;
	}
	/**
	 * @Title: orgid
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getOrgid() {
		return orgid;
	}

	/**
	 * @Title: orgid
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setOrgid(java.lang.Integer orgid) {
		this.orgid = orgid;
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
	 * @Title: description
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * @Title: description
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	/**
	 * @Title: parent_id
	 * @Description: 父id
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getParentId() {
		return parentId;
	}

	/**
	 * @Title: parent_id
	 * @Description: 父id
	 * @param java.lang.Integer
	 */
	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * @Title: level
	 * @Description: 等级
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getLevel() {
		return level;
	}

	/**
	 * @Title: level
	 * @Description: 等级
	 * @param java.lang.Integer
	 */
	public void setLevel(java.lang.Integer level) {
		this.level = level;
	}
	/**
	 * @Title: node
	 * @Description: 菜单节点 x-x-x-x
	 * @return java.lang.String
	 */
	public java.lang.String getNode() {
		return node;
	}

	/**
	 * @Title: node
	 * @Description: 菜单节点 x-x-x-x
	 * @param java.lang.String
	 */
	public void setNode(java.lang.String node) {
		this.node = node;
	}
	/**
	 * @Title: url
	 * @Description: 连接url地址
	 * @return java.lang.String
	 */
	public java.lang.String getUrl() {
		return url;
	}

	/**
	 * @Title: url
	 * @Description: 连接url地址
	 * @param java.lang.String
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	/**
	 * @Title: type
	 * @Description: 菜单类型 1 菜单资源 2 功能资源3Api链接
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getType() {
		return type;
	}

	/**
	 * @Title: type
	 * @Description: 菜单类型 1 菜单资源 2 功能资源3Api链接
	 * @param java.lang.Integer
	 */
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	/**
	 * @Title: icon
	 * @Description: 菜单的ICON
	 * @return java.lang.String
	 */
	public java.lang.String getIcon() {
		return icon;
	}

	/**
	 * @Title: icon
	 * @Description: 菜单的ICON
	 * @param java.lang.String
	 */
	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}
	/**
	 * @Title: delete_flag
	 * @Description: 默认0,1表示删除，0表示未删除
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @Title: delete_flag
	 * @Description: 默认0,1表示删除，0表示未删除
	 * @param java.lang.Integer
	 */
	public void setDeleteFlag(java.lang.Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * @Title: create_userid
	 * @Description: 数据创建用户id
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCreateUserid() {
		return createUserid;
	}

	/**
	 * @Title: create_userid
	 * @Description: 数据创建用户id
	 * @param java.lang.Integer
	 */
	public void setCreateUserid(java.lang.Integer createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * @Title: create_date
	 * @Description: 创建时间
	 * @return java.util.Date
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * @Title: create_date
	 * @Description: 创建时间
	 * @param java.util.Date
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @Title: update_userid
	 * @Description: 数据修改用户id
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getUpdateUserid() {
		return updateUserid;
	}

	/**
	 * @Title: update_userid
	 * @Description: 数据修改用户id
	 * @param java.lang.Integer
	 */
	public void setUpdateUserid(java.lang.Integer updateUserid) {
		this.updateUserid = updateUserid;
	}
	/**
	 * @Title: update_date
	 * @Description: 
	 * @return java.util.Date
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @Title: update_date
	 * @Description: 
	 * @param java.util.Date
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.BaseMenu
	 */
	@Override
	protected BaseMenu clone() throws CloneNotSupportedException {
		return (BaseMenu)super.clone();
	}
}
