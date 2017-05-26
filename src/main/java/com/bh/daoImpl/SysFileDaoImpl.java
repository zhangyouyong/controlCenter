package com.bh.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bh.dao.SysFileDao;
import com.bh.entity.SysFile;
import com.shuyin.framework.database.dao.BaseDao;

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

	@Override
	public List homeLogoInfo(String fileType) {
		List result=getSqlSession().selectList("File.homeLogoInfo",fileType);
		return result;
	}
	
}
