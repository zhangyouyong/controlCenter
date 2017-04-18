package com.bh.entity;

import java.io.Serializable;

import com.shuyin.framework.beans.AbstractEntity;
import com.shuyin.framework.beans.Entity;
import com.shuyin.framework.beans.PrimaryKey;
import com.shuyin.framework.beans.Table;
/**
 * sys_file
 * 
 * @author EntityGenerateTool
 */
@Table(tableName="sys_file")
public class SysFile extends AbstractEntity implements Cloneable{
	/** id BIGINT */
	@PrimaryKey(primaryKeyName = "id")
	@Entity(columnName = "id")
	protected java.lang.Long id;//
	/** file_name VARCHAR */
	@Entity(columnName = "file_name")
	protected java.lang.String fileName;//文件名称
	/** file_url VARCHAR */
	@Entity(columnName = "file_url")
	protected java.lang.String fileUrl;//文件路径
	/** file_type INT */
	@Entity(columnName = "file_type")
	protected java.lang.String fileType;//
	/** file_describe VARCHAR */
	@Entity(columnName = "file_describe")
	protected java.lang.String fileDescribe;//文件描述
	/** creadTime DATETIME */
	@Entity(columnName = "creadTime")
	protected java.util.Date creadtime;//创建时间
	/** creadBy VARCHAR */
	@Entity(columnName = "creadBy")
	protected java.lang.String creadby;//创建人

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
	 * @Title: file_name
	 * @Description: 文件名称
	 * @return java.lang.String
	 */
	public java.lang.String getFileName() {
		return fileName;
	}

	/**
	 * @Title: file_name
	 * @Description: 文件名称
	 * @param java.lang.String
	 */
	public void setFileName(java.lang.String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @Title: file_url
	 * @Description: 文件路径
	 * @return java.lang.String
	 */
	public java.lang.String getFileUrl() {
		return fileUrl;
	}

	/**
	 * @Title: file_url
	 * @Description: 文件路径
	 * @param java.lang.String
	 */
	public void setFileUrl(java.lang.String fileUrl) {
		this.fileUrl = fileUrl;
	}
	/**
	 * @Title: file_type
	 * @Description: 
	 * @return java.lang.Integer
	 */
	public java.lang.String getFileType() {
		return fileType;
	}

	/**
	 * @Title: file_type
	 * @Description: 
	 * @param java.lang.Integer
	 */
	public void setFileType(java.lang.String fileType) {
		this.fileType = fileType;
	}
	/**
	 * @Title: file_describe
	 * @Description: 文件描述
	 * @return java.lang.String
	 */
	public java.lang.String getFileDescribe() {
		return fileDescribe;
	}

	/**
	 * @Title: file_describe
	 * @Description: 文件描述
	 * @param java.lang.String
	 */
	public void setFileDescribe(java.lang.String fileDescribe) {
		this.fileDescribe = fileDescribe;
	}
	/**
	 * @Title: creadTime
	 * @Description: 创建时间
	 * @return java.util.Date
	 */
	public java.util.Date getCreadtime() {
		return creadtime;
	}

	/**
	 * @Title: creadTime
	 * @Description: 创建时间
	 * @param java.util.Date
	 */
	public void setCreadtime(java.util.Date creadtime) {
		this.creadtime = creadtime;
	}
	/**
	 * @Title: creadBy
	 * @Description: 创建人
	 * @return java.lang.String
	 */
	public java.lang.String getCreadby() {
		return creadby;
	}

	/**
	 * @Title: creadBy
	 * @Description: 创建人
	 * @param java.lang.String
	 */
	public void setCreadby(java.lang.String creadby) {
		this.creadby = creadby;
	}

	/**
	 * @Title: 克隆
	 * @Description: JAVA对象的克隆
	 * @param com.hfjy.base.entity.SysFile
	 */
	@Override
	protected SysFile clone() throws CloneNotSupportedException {
		return (SysFile)super.clone();
	}
}
