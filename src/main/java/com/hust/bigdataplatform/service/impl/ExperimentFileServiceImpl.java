package com.hust.bigdataplatform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.ExperimentDao;
import com.hust.bigdataplatform.dao.ExperimentFileDao;
import com.hust.bigdataplatform.dao.FileDao;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentFile;
import com.hust.bigdataplatform.model.ExperimentFileExample;
import com.hust.bigdataplatform.model.File;
import com.hust.bigdataplatform.model.ExperimentFileExample.Criteria;
import com.hust.bigdataplatform.service.ExperimentFileService;
import com.hust.bigdataplatform.service.ExperimentService;
@Service
public class ExperimentFileServiceImpl implements ExperimentFileService {

	@Autowired
	private ExperimentDao experimentDao;
	@Autowired
	private ExperimentFileDao experimentFileDao;
	@Autowired
	private FileDao fileDao;
	
	@Override
	public List<File> findFileByExperiment(String experimentId, String type) {
		if(experimentId == null || "".equals(experimentId)){
			return null;
		}
		List<File> files = new ArrayList<>();
		List<ExperimentFile> list = experimentFileDao.findByExperimentId(experimentId);
		if(list == null || list.isEmpty()){
			return files;
		}
		for(ExperimentFile ef : list){
			File f = fileDao.selectByFileId(ef.getFileId());			
			if(type == null || "".equals(type)){
				files.add(f);
			}else if(f != null && type.equals(f.getFileType())){
				files.add(f);
			}			
		}
				
		return files;
	}
	@Override
	public Experiment findExperimentByFile(String fileId) {
		// TODO Auto-generated method stub
		if(fileId == null || "".equals(fileId)){
			return null;
		}
		ExperimentFile ef = experimentFileDao.findByFileId(fileId);
		if(ef == null){
			return null;
		}
		List<Experiment> l = experimentDao.selectByExperimentId(ef.getExperimentId());
		if(l == null || l.isEmpty()){
			return null;
		}
		return l.get(0);
	}
	@Override
	public int add(String experimentId, File file) {
		ExperimentFile record = new ExperimentFile();
		record.setExperimentId(experimentId);
		record.setFileId(file.getFileId());
		System.out.println(experimentId);
		System.out.println(file.getFileId());
		return experimentFileDao.insert(record);
	}
	@Override
	public int update(ExperimentFile experimentFile) {
		// TODO Auto-generated method stub
		return experimentFileDao.update(experimentFile);
	}
	@Override
	public int deleteByExperiment(String experimentId) {
		ExperimentFileExample example = new ExperimentFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andExperimentIdEqualTo(experimentId);
		return experimentFileDao.delete(example);
	}
	@Override
	public int deleteByFile(String fileId) {
		ExperimentFileExample example = new ExperimentFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andFileIdEqualTo(fileId);
		return experimentFileDao.delete(example);
	}
	
}
