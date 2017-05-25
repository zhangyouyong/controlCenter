package com.bh.service;

import com.bh.entity.SysFile;

public interface SysFileService {
	 long addSysFile(SysFile sysFile);
	 void updateSysFile(Long fileId,String fileUrl);
}
