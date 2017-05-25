package com.bh.dao;

import java.util.List;
import java.util.Map;

import com.bh.entity.SysFile;

public interface SysFileDao{
 	long addSysFile(SysFile file);
 	void updateSysFile(Long fileId,String fileUrl);
 	List homeLogoInfo(String fileType);
}
