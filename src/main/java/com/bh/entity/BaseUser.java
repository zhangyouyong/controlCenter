package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * base_user
 * 用户表
 * @author EntityGenerateTool
 */
@Table(tableName="base_user")
public class BaseUser extends AbstractEntity implements Cloneable{
	/** userid BIGINT */
	@PrimaryKey(primaryKeyName = "userid")
	@Entity(columnName = "userid")
	protected java.lang.Long userid;//用户ID
	/** appid INT */
	@Entity(columnName = "appid")
	protected java.lang.Integer appid;//
	/** orgid INT */
	@Entity(columnName = "orgid")
	protected java.lang.Integer orgid;//组织机构
	/** job_number VARCHAR */
	@Entity(columnName = "job_number")
	protected java.lang.String jobNumber;//工号（暂定6位）
	/** login_name VARCHAR */
	@Entity(columnName = "login_name")
	protected java.lang.String loginName;//用户登录系统的账户
	/** display_name VARCHAR */
	@Entity(columnName = "display_name")
	protected java.lang.String displayName;//显示名
	/** phone VARCHAR */
	@Entity(columnName = "phone")
	protected java.lang.String phone;//手机号码
	/** email VARCHAR */
	@Entity(columnName = "email")
	protected java.lang.String email;//邮箱
	/** password VARCHAR */
	@Entity(columnName = "password")
	protected java.lang.String password;//用户密码，MD5码              MD5=MD5(用户名+密码)
	/** name VARCHAR */
	@Entity(columnName = "name")
	protected java.lang.String name;//姓名
	/** pinyin VARCHAR */
	@Entity(columnName = "pinyin")
	protected java.lang.String pinyin;//
	/** user_source INT */
	@Entity(columnName = "user_source")
	protected java.lang.Integer userSource;//1 终端用户 2系统用户 3 合作方用户
	/** credit_limit DOUBLE */
	@Entity(columnName = "credit_limit")
	protected java.lang.Double creditLimit;//默认值
	/** type INT */
	@Entity(columnName = "type")
	protected java.lang.Integer type;//
	/** age INT */
	@Entity(columnName = "age")
	protected java.lang.Integer age;//年龄
	/** sex INT */
	@Entity(columnName = "sex")
	protected java.lang.Integer sex;//性别  1 男  2 女  关联字典表
	/** user_describe VARCHAR */
	@Entity(columnName = "user_describe")
	protected java.lang.String userDescribe;//
	/** user_parent BIGINT */
	@Entity(columnName = "user_parent")
	protected java.lang.Long userParent;//
	/** industry VARCHAR */
	@Entity(columnName = "industry")
	protected java.lang.String industry;//
	/** birthday DATETIME */
	@Entity(columnName = "birthday")
	protected java.util.Date birthday;//出生年月
	/** register_date DATETIME */
	@Entity(columnName = "register_date")
	protected java.util.Date registerDate;//注册时间
	/** photo VARCHAR */
	@Entity(columnName = "photo")
	protected java.lang.String photo;//
	/** status INT */
	@Entity(columnName = "status")
	protected java.lang.Integer status;//状态 0、禁用  1、可用  
	/** last_time DATETIME */
	@Entity(columnName = "last_time")
	protected java.util.Date lastTime;//
	/** last_ip VARCHAR */
	@Entity(columnName = "last_ip")
	protected java.lang.String lastIp;//
	/** last_terminal VARCHAR */
	@Entity(columnName = "last_terminal")
	protected java.lang.String lastTerminal;//
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
	 * @Title: userid
	 * @Description: 用户ID
	 * @return java.lang.Long
	 */
	public java.lang.Long getUserid() {
		return userid;
	}

	/**
	 * @Title: userid
	 * @Description: 用户ID
	 * @param java.lang.Long
	 */
	public void setUserid(java.lang.Long userid) {
		this.userid = userid;
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
	 * @Description: 组织机构
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getOrgid() {
		return orgid;
	}

	/**
	 * @Title: orgid
	 * @Description: 组织机构
	 * @param java.lang.Integer
	 */
	public void setOrgid(java.lang.Integer orgid) {
		this.orgid = orgid;
	}
	/**
	 * @Title: job_number
	 * @Description: 工号（暂定6位）
	 * @return java.lang.String
	 */
	public java.lang.String getJobNumber() {
		return jobNumber;
	}

	/**
	 * @Title: job_number
	 * @Description: 工号（暂定6位）
	 * @param java.lang.String
	 */
	public void setJobNumber(java.lang.String jobNumber) {
		this.jobNumber = jobNumber;
	}
	/**
	 * @Title: login_name
	 * @Description: 用户登录系统的账户
	 * @return java.lang.String
	 */
	public java.lang.String getLoginName() {
		return loginName;
	}

	/**
	 * @Title: login_name
	 * @Description: 用户登录系统的账户
	 * @param java.lang.String
	 */
	public void setLoginName(java.lang.String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @Title: display_name
	 * @Description: 显示名
	 * @return java.lang.String
	 */
	public java.lang.String getDisplayName() {
		return displayName;
	}

	/**
	 * @Title: display_name
	 * @Description: 显示名
	 * @param java.lang.String
	 */
	public void setDisplayName(java.lang.String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @Title: phone
	 * @Description: 手机号码
	 * @return java.lang.String
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * @Title: phone
	 * @Description: 手机号码
	 * @param java.lang.String
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	/**
	 * @Title: email
	 * @Description: 邮箱
	 * @return java.lang.String
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * @Title: email
	 * @Description: 邮箱
	 * @param java.lang.String
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	/**
	 * @Title: password
	 * @Description: 用户密码，MD5码              MD5=MD5(用户名+密码)
	 * @return java.lang.String
	 */
	public java.lang.String getPassword() {
		return password;
	}

	/**
	 * @Title: password
	 * @Description: 用户密码，MD5码              MD5=MD5(用户名+密码)
	 * @param java.lang.String
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	/**
	 * @Title: name
	 * @Description: 姓名
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * @Title: name
	 * @Description: 姓名
	 * @param java.lang.String
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}
	/**
	 * @Title: pinyin
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getPinyin() {
		return pinyin;
	}

	/**
	 * @Title: pinyin
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setPinyin(java.lang.String pinyin) {
		this.pinyin = pinyin;
	}
	/**
	 * @Title: user_source
	 * @Description: 1 终端用户 2系统用户 3 合作方用户
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getUserSource() {
		return userSource;
	}

	/**
	 * @Title: user_source
	 * @Description: 1 终端用户 2系统用户 3 合作方用户
	 * @param java.lang.Integer
	 */
	public void setUserSource(java.lang.Integer userSource) {
		this.userSource = userSource;
	}
	/**
	 * @Title: credit_limit
	 * @Description: 默认值
	 * @return java.lang.Double
	 */
	public java.lang.Double getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @Title: credit_limit
	 * @Description: 默认值
	 * @param java.lang.Double
	 */
	public void setCreditLimit(java.lang.Double creditLimit) {
		this.creditLimit = creditLimit;
	}
	/**
	 * @Title: type
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getType() {
		return type;
	}

	/**
	 * @Title: type
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	/**
	 * @Title: age
	 * @Description: 年龄
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getAge() {
		return age;
	}

	/**
	 * @Title: age
	 * @Description: 年龄
	 * @param java.lang.Integer
	 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}
	/**
	 * @Title: sex
	 * @Description: 性别  1 男  2 女  关联字典表
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getSex() {
		return sex;
	}

	/**
	 * @Title: sex
	 * @Description: 性别  1 男  2 女  关联字典表
	 * @param java.lang.Integer
	 */
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}
	/**
	 * @Title: user_describe
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getUserDescribe() {
		return userDescribe;
	}

	/**
	 * @Title: user_describe
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setUserDescribe(java.lang.String userDescribe) {
		this.userDescribe = userDescribe;
	}
	/**
	 * @Title: user_parent
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getUserParent() {
		return userParent;
	}

	/**
	 * @Title: user_parent
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setUserParent(java.lang.Long userParent) {
		this.userParent = userParent;
	}
	/**
	 * @Title: industry
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getIndustry() {
		return industry;
	}

	/**
	 * @Title: industry
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setIndustry(java.lang.String industry) {
		this.industry = industry;
	}
	/**
	 * @Title: birthday
	 * @Description: 出生年月
	 * @return java.util.Date
	 */
	public java.util.Date getBirthday() {
		return birthday;
	}

	/**
	 * @Title: birthday
	 * @Description: 出生年月
	 * @param java.util.Date
	 */
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @Title: register_date
	 * @Description: 注册时间
	 * @return java.util.Date
	 */
	public java.util.Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * @Title: register_date
	 * @Description: 注册时间
	 * @param java.util.Date
	 */
	public void setRegisterDate(java.util.Date registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * @Title: photo
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getPhoto() {
		return photo;
	}

	/**
	 * @Title: photo
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setPhoto(java.lang.String photo) {
		this.photo = photo;
	}
	/**
	 * @Title: status
	 * @Description: 状态 0、禁用  1、可用  
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getStatus() {
		return status;
	}

	/**
	 * @Title: status
	 * @Description: 状态 0、禁用  1、可用  
	 * @param java.lang.Integer
	 */
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	/**
	 * @Title: last_time
	 * @Description: 
	 * @return java.util.Date
	 */
	public java.util.Date getLastTime() {
		return lastTime;
	}

	/**
	 * @Title: last_time
	 * @Description: 
	 * @param java.util.Date
	 */
	public void setLastTime(java.util.Date lastTime) {
		this.lastTime = lastTime;
	}
	/**
	 * @Title: last_ip
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getLastIp() {
		return lastIp;
	}

	/**
	 * @Title: last_ip
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setLastIp(java.lang.String lastIp) {
		this.lastIp = lastIp;
	}
	/**
	 * @Title: last_terminal
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getLastTerminal() {
		return lastTerminal;
	}

	/**
	 * @Title: last_terminal
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setLastTerminal(java.lang.String lastTerminal) {
		this.lastTerminal = lastTerminal;
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
	 * @param com.hfjy.base.entity.BaseUser
	 */
	@Override
	protected BaseUser clone() throws CloneNotSupportedException {
		return (BaseUser)super.clone();
	}
}
