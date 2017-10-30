package com.hust.automaticrating;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hust.bigdataplatform.model.ExperimentScore;


public class GetExpScoreOfAllStudent {	
	
	private List<ExperimentScore> expScores;
	
	
	public GetExpScoreOfAllStudent() {
		expScores = new ArrayList<ExperimentScore>();
	}

	//获得filepath这个文件的所有子文件夹
	private List<String> getALLFile(String filePath)
	{
		List<String> list = new ArrayList<>();
		File f=new File(filePath); 
		if (f.isDirectory()) //如果filePath是路径
		{
			 File[] fList=f.listFiles();
			 for (File file : fList) {
				list.add(file.getPath());
			} 
			
		}
		return list;
		
	}
	
	public void getFinalExperimentScore(String filepath)
	{
		GetScoreOfCrawlExcel getScoreOfCrawlExcel = new GetScoreOfCrawlExcel();
		List<String> filelist = new ArrayList<>();
		filelist = getALLFile(filepath); //获取作业文件夹下所有的子文件夹
		for (String string : filelist) { //遍历子文件夹下所有的excel文件
			List<String> excellist = new ArrayList<>();
			excellist = getALLFile(string); //存放的是所有待打分的文件的路径
			int result = 0; //用于记录分数
			for (String excelfilepath : excellist) { //统计多个文件的总成绩
				result +=getScoreOfCrawlExcel.getScore(excelfilepath);
			}
			result = (int)(result/excellist.size());  //取平均成绩
			String[] strings = string.split("[\\\\|/]"); //以 /划分路径
			String studentid = strings[strings.length-1];  //学号
			strings = filepath.split("[\\\\|/]"); //以 /划分路径
			String expId = strings[strings.length-1];  //实验id
			
			ExperimentScore result2 = new ExperimentScore();
			//构造result对象
			result2.setResultsscore(result);
			result2.setStudentId(studentid);
			result2.setExperimentId(expId);
			expScores.add(result2);
			/*try {
				resultService.updateExperimentScore(result2); //更新数据库
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println(studentid+"的分数是"+result);
			System.out.println("********");
		}
	}
	
	public List<ExperimentScore> getExperimentScores(){
		return expScores;
	}
	
}
