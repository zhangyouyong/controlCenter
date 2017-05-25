package com.bh.service;

import java.util.List;

import com.bh.entity.SysFile;

public interface SysFileService {
	 long addSysFile(SysFile sysFile);
	 void updateSysFile(Long fileId,String fileUrl);
	 List<Object> homeLogoInfo(String fileType);
}
