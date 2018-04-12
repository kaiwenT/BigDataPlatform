package com.hust.bigdataplatform.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class fileUtil {
	
	/**
	 * 获取某个文件夹中所有文件的名字
	 * @param road
	 * @return
	 */
	public static List<String> getFileName(String road)
	{
		File file = new File(road);
		File files[] = file.listFiles();
		List<String> files2 = new ArrayList<String>();
		if (files==null) {
			return null;
		}
		for(int i = 0; i< files.length; i++)
		{
			String strings= new String();
			strings = files[i].getName();
			files2.add(strings);
		}
		return files2;
	}
	/**
	 * 得到一个目录下指定类型的所有文件名（不带后缀）
	 * @param road 目录
	 * @param type 文件类型
	 * @return
	 */
	public static List<String> getFileName(String road, String type){
		File file = new File(road);
		File files[] = file.listFiles();
		List<String> files2 = new ArrayList<String>();
		if (files==null) {
			return null;
		}
		for(File f : files){
			String suffix = f.getName().substring(f.getName().lastIndexOf(".") + 1);
			String name = f.getName().substring(0, f.getName().lastIndexOf("."));
			System.out.println(suffix +"---"+name);
			if(type.equals(suffix)){
				files2.add(name);
			}
			
		}
		return files2;
	}
	 public static boolean updatename(String file, String newfile) 
     {
		 File file1 = new File(file);
         File newfile1 = new File(newfile);
         if (file1.renameTo(newfile1)) {
			return true;
		  }
         return false;  
    }
	 
	 public static void deleteSection(String road) 
     {
		 File file = new File(road);
		 File[] file2 = file.listFiles();
		 if (file2!=null) {
			 for (File file3 : file2) {
				 file3.delete();
			 }
		 }
		
		 file.delete();
		
    }
	 
	 public static void deleteChapter(String road) 
     {
   	   File file = new File(road);
   	   File[] file2 = file.listFiles();
   	   if (file2!=null) {
		 for (File file3 : file2) {
			 file3.delete();
		 }
   	   }
   	   file.delete();
    }

}
