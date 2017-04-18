package com.bh.serviceImpl;

import java.util.List;

import com.bh.dao.SysDictionaryDao;
import com.bh.model.SysDictionaryModel;
import com.bh.service.SysDictionaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="SysDictionaryService")
public class SysDictionaryServiceImpl  implements SysDictionaryService{
	@Autowired
	@Qualifier("SysDictionaryDao")
	private SysDictionaryDao sysDictionaryDao;

	@Override
	public List<SysDictionaryModel> dictionaryInfo(String code) {
		// TODO Auto-generated method stub
		return sysDictionaryDao.dictionaryInfo(code);
	}

}
