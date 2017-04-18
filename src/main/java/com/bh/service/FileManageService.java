package com.bh.service;

import java.io.InputStream;

public interface FileManageService {
	  void saveFileFromInputStream(InputStream stream,String path,String filename) throws Exception;
}
