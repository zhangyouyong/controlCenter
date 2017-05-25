package com.bh.dao;

import com.bh.entity.SysFile;

public interface SysFileDao{
 	long addSysFile(SysFile file);
 	void updateSysFile(Long fileId,String fileUrl);
}
