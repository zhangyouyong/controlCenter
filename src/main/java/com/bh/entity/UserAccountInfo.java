package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * user_account_info
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="user_account_info")
public class UserAccountInfo extends AbstractEntity implements Cloneable{
	/** id BIGINT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Long id;//
	/** card_number VARCHAR */
	@Entity(columnName = "card_number")
	protected java.lang.String cardNumber;//卡号
	/** deposit_bank VARCHAR */
	@Entity(columnName = "deposit_bank")
	protected java.lang.String depositBank;//开户行
	/** bank_address VARCHAR */
	@Entity(columnName = "bank_address")
	protected java.lang.String bankAddress;//银行地址
	/** account_balance DECIMAL */
	@Entity(columnName = "account_balance")
	protected java.math.BigDecimal accountBalance;//账户余额
	/** bank_account_name VARCHAR */
	@Entity(columnName = "bank_account_name")
	protected java.lang.String bankAccountName;//户主姓名
	/** storage_mode INT */
	@Entity(columnName = "storage_mode")
	protected java.lang.Integer storageMode;//1银行,2支付宝,3微信
	/** user_id BIGINT */
	@Entity(columnName = "user_id")
	protected java.lang.Long userId;//
	/** created_time DATETIME */
	@Entity(columnName = "created_time")
	protected java.util.Date createdTime;//创建时间
	/** created_by BIGINT */
	@Entity(columnName = "created_by")
	protected java.lang.Long createdBy;//创建人

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
	 * @Title: card_number
	 * @Description: 卡号
	 * @return java.lang.String
	 */
	public java.lang.String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @Title: card_number
	 * @Description: 卡号
	 * @param java.lang.String
	 */
	public void setCardNumber(java.lang.String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @Title: deposit_bank
	 * @Description: 开户行
	 * @return java.lang.String
	 */
	public java.lang.String getDepositBank() {
		return depositBank;
	}

	/**
	 * @Title: deposit_bank
	 * @Description: 开户行
	 * @param java.lang.String
	 */
	public void setDepositBank(java.lang.String depositBank) {
		this.depositBank = depositBank;
	}
	/**
	 * @Title: bank_address
	 * @Description: 银行地址
	 * @return java.lang.String
	 */
	public java.lang.String getBankAddress() {
		return bankAddress;
	}

	/**
	 * @Title: bank_address
	 * @Description: 银行地址
	 * @param java.lang.String
	 */
	public void setBankAddress(java.lang.String bankAddress) {
		this.bankAddress = bankAddress;
	}
	/**
	 * @Title: account_balance
	 * @Description: 账户余额
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @Title: account_balance
	 * @Description: 账户余额
	 * @param java.math.BigDecimal
	 */
	public void setAccountBalance(java.math.BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	/**
	 * @Title: bank_account_name
	 * @Description: 户主姓名
	 * @return java.lang.String
	 */
	public java.lang.String getBankAccountName() {
		return bankAccountName;
	}

	/**
	 * @Title: bank_account_name
	 * @Description: 户主姓名
	 * @param java.lang.String
	 */
	public void setBankAccountName(java.lang.String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	/**
	 * @Title: storage_mode
	 * @Description: 1银行,2支付宝,3微信
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getStorageMode() {
		return storageMode;
	}

	/**
	 * @Title: storage_mode
	 * @Description: 1银行,2支付宝,3微信
	 * @param java.lang.Integer
	 */
	public void setStorageMode(java.lang.Integer storageMode) {
		this.storageMode = storageMode;
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
	 * @Title: created_time
	 * @Description: 创建时间
	 * @return java.util.Date
	 */
	public java.util.Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @Title: created_time
	 * @Description: 创建时间
	 * @param java.util.Date
	 */
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @Title: created_by
	 * @Description: 创建人
	 * @return java.lang.Long
	 */
	public java.lang.Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @Title: created_by
	 * @Description: 创建人
	 * @param java.lang.Long
	 */
	public void setCreatedBy(java.lang.Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.UserAccountInfo
	 */
	@Override
	protected UserAccountInfo clone() throws CloneNotSupportedException {
		return (UserAccountInfo)super.clone();
	}
}
