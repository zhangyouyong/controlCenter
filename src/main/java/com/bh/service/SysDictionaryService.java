package com.bh.service;

import java.util.List;

import com.bh.model.SysDictionaryModel;

public interface SysDictionaryService {
	List<SysDictionaryModel> dictionaryInfo(String code);
}
