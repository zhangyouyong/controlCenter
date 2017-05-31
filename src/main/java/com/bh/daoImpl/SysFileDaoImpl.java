package com.bh.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bh.dao.SysFileDao;
import com.bh.entity.SysFile;
import com.shuyin.framework.database.dao.BaseDao;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;

@Repository("SysFileDao")
public class SysFileDaoImpl extends BaseDao<SysFile> implements SysFileDao{

	@Override
	public long addSysFile(SysFile file) {
		return create(file);
	}

	@Override
	public void updateSysFile(Long fileId,String fileUrl) throws BHException{
		SysFile sysFile = findOneById(fileId);
		if(sysFile==null){
			new BHException("系统找不到该图片！",BHExceptionType.FILE_NOTEXIST_ERROR);
		}
		sysFile.setFileUrl(fileUrl);
		modify(sysFile);
	}

	@Override
	public List homeLogoInfo(String fileType) {
		List result=getSqlSession().selectList("File.homeLogoInfo",fileType);
		return result;
	}
	
}
