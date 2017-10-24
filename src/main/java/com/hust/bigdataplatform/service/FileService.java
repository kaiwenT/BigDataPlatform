package com.hust.bigdataplatform.service;

import com.hust.bigdataplatform.model.File;

public interface FileService {
	
	
	public int delete(String fileId);
	
	public File selectById(String fileId);

	int insert(File file);

}
