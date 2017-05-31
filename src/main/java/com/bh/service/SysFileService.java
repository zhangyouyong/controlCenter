package com.bh.service;

import java.util.List;

import com.bh.entity.SysFile;
import com.shuyin.framework.exception.BHException;

public interface SysFileService {
	 long addSysFile(SysFile sysFile);
	 void updateSysFile(Long fileId,String fileUrl) throws BHException;
	 List<Object> homeLogoInfo(String fileType);
}
