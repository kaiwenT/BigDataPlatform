package com.hust.automaticrating.utils;

import com.hust.automaticrating.Rating;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.service.ExperimentScoreService;
/**
 * 自动评分类
 * @author tankai
 *
 */
public class AutoRating {
	/**
	 * 自动评分方法
	 * @param exp 更新的实验
	 * @param oldName 更新的实验之前的名称
	 * @param experimentScoreService 实验分数Service
	 */
	public static void rating(Experiment exp, String oldName, ExperimentScoreService experimentScoreService) {
		
		// 获取评分类对象
		Rating rate = new Rating(exp.getExperimentName(), exp.getExperimentId());
		// 获取当前活跃的线程信息，找到要修改的作业之前开启的线程并关闭
		// 获取当前活跃的线程组
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		Thread thread = null;
		String threadName = oldName;
		// 找到指定名字的线程，即获取要停止运行的线程
		while (group != null) {
			Thread[] threads = new Thread[(int) (group.activeCount() * 1.2)];
			int count = group.enumerate(threads, true);
			for (int i = 0; i < count; i++) {
				System.out.println("线程名字：" + threads[i].getName());
				if (threadName.equals(threads[i].getName())) {
					thread = threads[i];
					break;
				}
			}
			group = group.getParent();
		}
		// 如果要停止运行的线程存在，即仍在运行，则打断线程
		if (thread != null) {
			thread.interrupt();
			System.out.println(oldName + "线程已被打断");
		} else {
			System.out.println("找不到线程！！！！");
		}
		// 以新的作业信息开启新线程
		new Thread(new AutoCheckThread(rate, exp.getExperimentDeadline(), experimentScoreService),
				exp.getExperimentName()).start();
	}
}
