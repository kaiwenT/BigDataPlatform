package com.hust.bigdataplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.FileDao;
import com.hust.bigdataplatform.model.File;
import com.hust.bigdataplatform.service.FileService;
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao filedao;
	
	@Override
	public int insert(File file) {
		if (file==null) {
			return 0;
		}
		return filedao.insert(file);
	}

	@Override 
	public int delete(String fileId) {
		if (fileId==null) {
			return 0;
		}
		return filedao.deleteById(fileId);
	}

	@Override
	public File selectById(String fileId) {
		if (fileId==null) {
			return null;
		}
		return filedao.selectByFileId(fileId);
	}

}
