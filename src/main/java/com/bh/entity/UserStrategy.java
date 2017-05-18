package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * user_strategy
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="user_strategy")
public class UserStrategy extends AbstractEntity implements Cloneable{
	/** id BIGINT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Long id;//
	/** user_id BIGINT */
	@Entity(columnName = "user_id")
	protected java.lang.Long userId;//
	/** strategy_name VARCHAR */
	@Entity(columnName = "strategy_name")
	protected java.lang.String strategyName;//
	/** strategy_describe VARCHAR */
	@Entity(columnName = "strategy_describe")
	protected java.lang.String strategyDescribe;//
	/** meun_id BIGINT */
	@Entity(columnName = "meun_id")
	protected java.lang.Long meunId;//
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
	 * @Title: strategy_name
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getStrategyName() {
		return strategyName;
	}

	/**
	 * @Title: strategy_name
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setStrategyName(java.lang.String strategyName) {
		this.strategyName = strategyName;
	}
	/**
	 * @Title: strategy_describe
	 * @Description: 
	 * @return java.lang.String
	 */
	public java.lang.String getStrategyDescribe() {
		return strategyDescribe;
	}

	/**
	 * @Title: strategy_describe
	 * @Description: 
	 * @param java.lang.String
	 */
	public void setStrategyDescribe(java.lang.String strategyDescribe) {
		this.strategyDescribe = strategyDescribe;
	}
	/**
	 * @Title: meun_id
	 * @Description: 
	 * @return java.lang.Long
	 */
	public java.lang.Long getMeunId() {
		return meunId;
	}

	/**
	 * @Title: meun_id
	 * @Description: 
	 * @param java.lang.Long
	 */
	public void setMeunId(java.lang.Long meunId) {
		this.meunId = meunId;
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
	 * @param com.hfjy.base.entity.UserStrategy
	 */
	@Override
	protected UserStrategy clone() throws CloneNotSupportedException {
		return (UserStrategy)super.clone();
	}
}
