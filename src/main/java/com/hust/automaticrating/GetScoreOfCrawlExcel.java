package com.hust.automaticrating;

import java.util.List;

import com.hust.utils.readExcel;

public class GetScoreOfCrawlExcel {
	
	private double scaleOfRow=0.25;
	private double scaleOfValide=0.5;
	
	public int getScore(String filepath)
	{
		List<List<String>> excel = readExcel.read(filepath); //读取excel
		if (excel !=null) {
			int row ,cell=0;
			row=excel.size();  //获取行数
		
			List<String> list = excel.get(0);
			cell = list.size(); //获取列数
			int result,type;
			result=(int) (setResultOfRow(row)*scaleOfRow+setResultOfValide(excel)*scaleOfValide);
			return result;
		}
		return 0;
		
	}
	
	//根据行数得出分数
	private int setResultOfRow(int row) 
	{
		int result=0;
		if (row>1000)
		{
			result = 100;
		}
		else {
			result=(int) (60+0.4*(row/10));
		}
		return result;
		
	}

	//如果每条数据有一个字段为空则为无效数据，每10个无效数据扣一分
	private int setResultOfValide(List<List<String>> excel)
	{
		int invalide = 0;
		for (List<String> list : excel) 
		{
			for (String string : list) {
				if (string=="") 
				{
					invalide++;
					break;
				}
				
			}
		}
		int result;
		double r,t;
		r = 1-(double)invalide/excel.size();//存储
		t= r*40;
		result = (int)t+60;
		return result;
		
	}
	
}
