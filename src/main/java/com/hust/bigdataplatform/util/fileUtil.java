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
	
	public static List<String> getFileName(String road, String type){
		File file = new File(road);
		File files[] = file.listFiles();
		List<String> files2 = new ArrayList<String>();
		if (files==null) {
			return null;
		}
		for(File f : files){
			String suffix = f.getName().substring(f.getName().lastIndexOf(".") + 1);
			if(type.equals(suffix)){
				files2.add(f.getName());
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
		 for (File file3 : file2) {
			 file3.delete();
		 }
		 file.delete();
		
    }
	 
	 public static void deleteChapter(String road) 
     {
   	   File file = new File(road);
   	   File[] file2 = file.listFiles();
   	   for (File file3 : file2) {
		   	 deleteSection(file3.getPath());
		  }
   	   file.delete();
    }

}
