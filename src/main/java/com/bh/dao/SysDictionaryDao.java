package com.bh.dao;

import java.util.List;

import com.bh.model.SysDictionaryModel;


public interface SysDictionaryDao{
	List<SysDictionaryModel> dictionaryInfo(String code);
}
