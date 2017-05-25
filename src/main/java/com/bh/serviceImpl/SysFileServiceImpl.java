package com.bh.serviceImpl;

import com.bh.dao.SysFileDao;
import com.bh.entity.SysFile;
import com.bh.service.SysFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="SysFileService")
public class SysFileServiceImpl  implements SysFileService{
	@Autowired
	@Qualifier("SysFileDao")
	private SysFileDao sysFileDao;

	@Override
	public long addSysFile(SysFile sysFile) {
		
		return sysFileDao.addSysFile(sysFile);
	}

	@Override
	public void updateSysFile(Long fileId, String fileUrl) {
		sysFileDao.updateSysFile(fileId, fileUrl);
	}

}
