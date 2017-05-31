package com.bh.dao;

import java.util.List;
import java.util.Map;

import com.bh.entity.SysFile;
import com.shuyin.framework.exception.BHException;

public interface SysFileDao{
 	long addSysFile(SysFile file);
 	void updateSysFile(Long fileId,String fileUrl)throws BHException;
 	List homeLogoInfo(String fileType);
}
