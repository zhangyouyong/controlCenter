package com.bh.daoImpl;

import com.bh.entity.SysFile;
import com.bh.dao.SysFileDao;
import com.shuyin.framework.database.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository("SysFileDao")
public class SysFileDaoImpl extends BaseDao<SysFile> implements SysFileDao{

	@Override
	public long addSysFile(SysFile file) {
		return create(file);
	}

	@Override
	public void updateSysFile(Long fileId,String fileUrl) {
		SysFile sysFile = findOneById(fileId);
		sysFile.setFileUrl(fileUrl);
		modify(sysFile);
	}
	
}
