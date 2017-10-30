package com.hust.automaticrating.utils;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hust.automaticrating.Rating;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.service.ExperimentScoreService;

public class AutoCheckThread implements Runnable{
	
	private Date deadline;	//作业截至日期
	private Rating rate;	//自动评分类对象
	private ExperimentScoreService experimentScoreService ; //更新数据库里面experiment_score表的serveice对象（从controller层获取避免为空）
	//初始化对象
	public AutoCheckThread(Rating rate,Date deadline,ExperimentScoreService experimentScoreService) {
		// TODO Auto-generated constructor stub
		this.rate = rate;
		this.deadline = deadline;
		this.experimentScoreService = experimentScoreService;		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程名："+Thread.currentThread().getName()+"  线程ID:"+Thread.currentThread().getId()+" 已启动！");
//		Date deadline = rate.getDeadline();
		Long curTime = System.currentTimeMillis();
		while(curTime < deadline.getTime()){
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			curTime = System.currentTimeMillis();
		}
		//开始评分
		rate.startRating();
		//获取结果开始评分
		List<ExperimentScore> results = rate.getExperimentScores();
		for (ExperimentScore result : results) {
			try {
				experimentScoreService.update(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
