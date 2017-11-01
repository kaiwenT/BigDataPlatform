package com.hust.bigdataplatform.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtils {
	
	   
		/**
		 * 单文件上传
		 * @param file 上传的文件
		 * @param dir 待存放的目录（文件夹）
		 * @return
		 */
		public boolean upload(MultipartFile file,String dir)
		{
				
			//设置上传文件位置
    		String uploadpath = file.getOriginalFilename();  //获取文件名
            //创建文件夹
    	    File uploadtargetFile = new File(dir,uploadpath);
			//判断文件是否存在
    	    isExists(new File(dir));
			//保存文件
			if (saveFile(file, uploadtargetFile)) {	
				return true;
			}

			return false;
		}
		//判断该路径下文件是否存在,若不存在则新建
		private boolean isExists(File uploadtargetFile)
		{
			if (!uploadtargetFile.exists())
		    {
		    	uploadtargetFile.mkdirs(); 
		    	return true;
			}
		    else{
		    	System.out.println("文件已存在");
		    	return false;
		    }
		}
		
		//保存文件
		private boolean saveFile(MultipartFile file, File uploadtargetFile)
		{  
	        // 判断文件是否为空  
	        if (!file.isEmpty()) {  
	            try {  
	        	    file.transferTo(uploadtargetFile);  //写入文件
	                return true;  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return false;  
	    }

}


