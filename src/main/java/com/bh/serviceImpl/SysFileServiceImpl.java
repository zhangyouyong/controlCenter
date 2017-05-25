package com.bh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bh.dao.SysFileDao;
import com.bh.entity.SysFile;
import com.bh.service.SysFileService;

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

	@Override
	public List<Object> homeLogoInfo(String fileType) {
		return sysFileDao.homeLogoInfo(fileType);
	}

}
