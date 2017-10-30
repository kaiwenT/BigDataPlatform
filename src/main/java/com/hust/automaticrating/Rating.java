package com.hust.automaticrating;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.model.ExperimentScore;
/**
 * 使用方法--用作业名去new对象，然后获取该作业的deadline,超过deadline的时间后，手动调用startRating开始评分
 * @author Jack
 *
 */

public class Rating {
	//存放作业名
	private String expName;
	//存放作业id
	private String expId;
	//存放学生学号
	private List<String> fileList;
	
	private List<ExperimentScore> expScores;

	public Rating(String expName, String expId){
		this.expName = expName;		
		this.expId = expId;
		fileList = new ArrayList<String>();
		expScores = new ArrayList<ExperimentScore>();
	//	init();
	}
	
	private void init(){
		System.out.println("11111expId"+expId);
		String path = Constant.DIRECTORY.EXPERIMENT_DATA_SUBMIT+expId;
		File taskFiles = new File(path);
		if(taskFiles.isDirectory()){
			File[] files = taskFiles.listFiles();
			System.out.println("files长度:"+files.length);
			for (File file : files) {
				System.out.println(file.getName());
				if(fileList==null)
					System.out.println("1111");;
				fileList.add(file.getName());
			}
		}else{
			System.out.println(path+"目录下没有作业存在！");
		}
	}

	/*
	 * 已知作业id--expId,
	 * 学生学号集合--fileList(存放着该作业下所有以提交作业的学生的学号)
	 */
	public void startRating(){
		init();
		switch (expName) {
		case "爬虫":	
		{
			GetExpScoreOfAllStudent task1 = new GetExpScoreOfAllStudent();
			String filepath = Constant.DIRECTORY.EXPERIMENT_DATA_SUBMIT+expId;
			task1.getFinalExperimentScore(filepath);
			expScores = task1.getExperimentScores();
		}
			break;
		case "数据预处理":	
		{
			for (String string : fileList) {
				GetScoreOfDataPreProcess task2 = new GetScoreOfDataPreProcess();
				int score = task2.getTotalResult(expId, string);
				ExperimentScore es = new ExperimentScore();
				es.setExperimentId(expId);
				es.setStudentId(string);
				es.setResultsscore(score);
				expScores.add(es);
			}
		}
			break;
		case "聚类":	
		{
			//实验三自动评分-----用线程池来并发计算学生的作业分数，每个线程处理一个学生的作业
			ExecutorService exec = Executors.newCachedThreadPool();  
	        ArrayList<Future<ExperimentScore>> results = new ArrayList<Future<ExperimentScore>>();
			for (String stuId : fileList) {
				results.add(exec.submit(new GetScoreOfClustering(stuId, expId)));				
			}
			for(Future<ExperimentScore> fs : results){
				while(!fs.isDone());{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					expScores.add(fs.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			exec.shutdown();
		}
			break;
		case "朴素贝叶斯分类":	
		{
			//实验四自动评分
			for (String string : fileList) {
				GetScoreOfClassification task4 = new GetScoreOfClassification();
				int result = task4.getTotalResult(expId,string);
				ExperimentScore es = new ExperimentScore();
				es.setExperimentId(expId);
				es.setStudentId(string);
				es.setResultsscore(result);
				expScores.add(es);
			}
		}
			break;
		default:
			System.out.println("自动评分失败");
			break;
		}
	}
	
	//返回成绩集合
	public List<ExperimentScore> getExperimentScores(){
		return expScores;
	}
}
