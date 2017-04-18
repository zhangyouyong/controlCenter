package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * authentification
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="authentification")
public class Authentification extends AbstractEntity implements Cloneable{
	/** id BIGINT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Long id;//
	/** auth_area INT */
	@Entity(columnName = "auth_area")
	protected java.lang.Integer authArea;//认证地区
	/** auth_mode INT */
	@Entity(columnName = "auth_mode")
	protected java.lang.Integer authMode;//1银行认证
	/** full_name VARCHAR */
	@Entity(columnName = "full_name")
	protected java.lang.String fullName;//姓名
	/** id_card VARCHAR */
	@Entity(columnName = "id_card")
	protected java.lang.String idCard;//身份证
	/** phone VARCHAR */
	@Entity(columnName = "phone")
	protected java.lang.String phone;//手机号
	/** user_id BIGINT */
	@Entity(columnName = "user_id")
	protected java.lang.Long userId;//用户id
	/** enterprise_name VARCHAR */
	@Entity(columnName = "enterprise_name")
	protected java.lang.String enterpriseName;//企业名称
	/** enterprise_auth_type INT */
	@Entity(columnName = "enterprise_auth_type")
	protected java.lang.Integer enterpriseAuthType;//1有效证件认证
	/** organization_code VARCHAR */
	@Entity(columnName = "organization_code")
	protected java.lang.String organizationCode;//组织结构代码
	/** license_no VARCHAR */
	@Entity(columnName = "license_no")
	protected java.lang.String licenseNo;//营业执照注册号
	/** license_image INT */
	@Entity(columnName = "license_image")
	protected java.lang.Integer licenseImage;//执照图片地址
	/** contact_name VARCHAR */
	@Entity(columnName = "contact_name")
	protected java.lang.String contactName;//联系人姓名
	/** enterprise_address VARCHAR */
	@Entity(columnName = "enterprise_address")
	protected java.lang.String enterpriseAddress;//企业地址
	/** user_auth_type INT */
	@Entity(columnName = "user_auth_type")
	protected java.lang.Integer userAuthType;//1个人认证 2企业认证
	/** auth_state INT */
	@Entity(columnName = "auth_state")
	protected java.lang.Integer authState;//1未审核 2审核中 3审核通过 4审核失败

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
	 * @Title: auth_area
	 * @Description: 认证地区
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getAuthArea() {
		return authArea;
	}

	/**
	 * @Title: auth_area
	 * @Description: 认证地区
	 * @param java.lang.Integer
	 */
	public void setAuthArea(java.lang.Integer authArea) {
		this.authArea = authArea;
	}
	/**
	 * @Title: auth_mode
	 * @Description: 1银行认证
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getAuthMode() {
		return authMode;
	}

	/**
	 * @Title: auth_mode
	 * @Description: 1银行认证
	 * @param java.lang.Integer
	 */
	public void setAuthMode(java.lang.Integer authMode) {
		this.authMode = authMode;
	}
	/**
	 * @Title: full_name
	 * @Description: 姓名
	 * @return java.lang.String
	 */
	public java.lang.String getFullName() {
		return fullName;
	}

	/**
	 * @Title: full_name
	 * @Description: 姓名
	 * @param java.lang.String
	 */
	public void setFullName(java.lang.String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @Title: id_card
	 * @Description: 身份证
	 * @return java.lang.String
	 */
	public java.lang.String getIdCard() {
		return idCard;
	}

	/**
	 * @Title: id_card
	 * @Description: 身份证
	 * @param java.lang.String
	 */
	public void setIdCard(java.lang.String idCard) {
		this.idCard = idCard;
	}
	/**
	 * @Title: phone
	 * @Description: 手机号
	 * @return java.lang.String
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * @Title: phone
	 * @Description: 手机号
	 * @param java.lang.String
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	/**
	 * @Title: user_id
	 * @Description: 用户id
	 * @return java.lang.Long
	 */
	public java.lang.Long getUserId() {
		return userId;
	}

	/**
	 * @Title: user_id
	 * @Description: 用户id
	 * @param java.lang.Long
	 */
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}
	/**
	 * @Title: enterprise_name
	 * @Description: 企业名称
	 * @return java.lang.String
	 */
	public java.lang.String getEnterpriseName() {
		return enterpriseName;
	}

	/**
	 * @Title: enterprise_name
	 * @Description: 企业名称
	 * @param java.lang.String
	 */
	public void setEnterpriseName(java.lang.String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * @Title: enterprise_auth_type
	 * @Description: 1有效证件认证
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getEnterpriseAuthType() {
		return enterpriseAuthType;
	}

	/**
	 * @Title: enterprise_auth_type
	 * @Description: 1有效证件认证
	 * @param java.lang.Integer
	 */
	public void setEnterpriseAuthType(java.lang.Integer enterpriseAuthType) {
		this.enterpriseAuthType = enterpriseAuthType;
	}
	/**
	 * @Title: organization_code
	 * @Description: 组织结构代码
	 * @return java.lang.String
	 */
	public java.lang.String getOrganizationCode() {
		return organizationCode;
	}

	/**
	 * @Title: organization_code
	 * @Description: 组织结构代码
	 * @param java.lang.String
	 */
	public void setOrganizationCode(java.lang.String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * @Title: license_no
	 * @Description: 营业执照注册号
	 * @return java.lang.String
	 */
	public java.lang.String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @Title: license_no
	 * @Description: 营业执照注册号
	 * @param java.lang.String
	 */
	public void setLicenseNo(java.lang.String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/**
	 * @Title: license_image
	 * @Description: 执照图片地址
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getLicenseImage() {
		return licenseImage;
	}

	/**
	 * @Title: license_image
	 * @Description: 执照图片地址
	 * @param java.lang.Integer
	 */
	public void setLicenseImage(java.lang.Integer licenseImage) {
		this.licenseImage = licenseImage;
	}
	/**
	 * @Title: contact_name
	 * @Description: 联系人姓名
	 * @return java.lang.String
	 */
	public java.lang.String getContactName() {
		return contactName;
	}

	/**
	 * @Title: contact_name
	 * @Description: 联系人姓名
	 * @param java.lang.String
	 */
	public void setContactName(java.lang.String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @Title: enterprise_address
	 * @Description: 企业地址
	 * @return java.lang.String
	 */
	public java.lang.String getEnterpriseAddress() {
		return enterpriseAddress;
	}

	/**
	 * @Title: enterprise_address
	 * @Description: 企业地址
	 * @param java.lang.String
	 */
	public void setEnterpriseAddress(java.lang.String enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}
	/**
	 * @Title: user_auth_type
	 * @Description: 1个人认证 2企业认证
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getUserAuthType() {
		return userAuthType;
	}

	/**
	 * @Title: user_auth_type
	 * @Description: 1个人认证 2企业认证
	 * @param java.lang.Integer
	 */
	public void setUserAuthType(java.lang.Integer userAuthType) {
		this.userAuthType = userAuthType;
	}
	/**
	 * @Title: auth_state
	 * @Description: 1未审核 2审核中 3审核通过 4审核失败
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getAuthState() {
		return authState;
	}

	/**
	 * @Title: auth_state
	 * @Description: 1未审核 2审核中 3审核通过 4审核失败
	 * @param java.lang.Integer
	 */
	public void setAuthState(java.lang.Integer authState) {
		this.authState = authState;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.Authentification
	 */
	@Override
	protected Authentification clone() throws CloneNotSupportedException {
		return (Authentification)super.clone();
	}
}
