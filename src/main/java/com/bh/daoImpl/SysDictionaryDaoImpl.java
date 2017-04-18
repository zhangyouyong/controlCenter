package com.bh.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bh.dao.SysDictionaryDao;
import com.bh.entity.SysDictionary;
import com.bh.model.SysDictionaryModel;
import com.shuyin.framework.database.dao.BaseDao;

@Repository("SysDictionaryDao")
public class SysDictionaryDaoImpl extends BaseDao<SysDictionary> implements SysDictionaryDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SysDictionaryModel> dictionaryInfo(String code) {
		List<SysDictionaryModel> SysDictionaryModel=getSqlSession().selectList("dictionary.dictionaryInfo", code);
		return SysDictionaryModel;
	}



}
