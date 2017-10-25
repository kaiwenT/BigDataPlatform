package com.hust.bigdataplatform.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;
public class ImageUtil {
  /** 
     * 生成一个PDF文件的缩略图，jpg格式
     * @param inputFile	需要生成缩略图的PDF的完整路径
     * @param outputFile 生成缩略图的放置路径
     */
    public static void generatePDFImage(String inputFile, String outputFile) {
        Document document = null;
        
        try {
            float rotation = 0f;
            //缩略图显示倍数，1表示不缩放，0.5表示缩小到50%
            float zoom = 0.8f;
            
            document = new Document();
            document.setFile(inputFile);
             // maxPages = document.getPageTree().getNumberOfPages();
            
            BufferedImage image = (BufferedImage)document.getPageImage(0, GraphicsRenderingHints.SCREEN, 
                        Page.BOUNDARY_CROPBOX, rotation, zoom);
            
            Iterator iter = ImageIO.getImageWritersBySuffix("jpg");
            ImageWriter writer = (ImageWriter)iter.next();
            
            FileOutputStream out = new FileOutputStream(new File(outputFile));
            
            ImageOutputStream outImage = ImageIO.createImageOutputStream(out);
            
            writer.setOutput(outImage);
            writer.write(new IIOImage(image, null, null));
        
        } catch(Exception e) {
        System.out.println( "to generate image of a pdf fail : " + inputFile );
        System.out.println( e );
        } 
    }
    /**
     * 获取一个.mp4视频文件的第一帧图像，jpg格式
     * @param ffmpegPath
     * @param upFilePath
     * @param mediaPicPath
     * //ffmpeg -i xxx.mp4 -y -f image2 -t 0.001 -s 1366*768 xxx.jpg  
     */
    public static void generateVideoImage(String ffmpegPath, String upFilePath, String mediaPicPath) {
    	List<String> cutpic = new ArrayList<String>();  
        cutpic.add(ffmpegPath);  
        cutpic.add("-i");
        cutpic.add(upFilePath); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）  
        cutpic.add("-y");  
        cutpic.add("-f");  
        cutpic.add("image2");  
//        cutpic.add("-s"); // 添加参数＂-ss＂，该参数指定截取的起始时间  
//        cutpic.add("0"); // 添加起始时间为第17秒  
        cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间  
        cutpic.add("0.001"); // 添加持续时间为1毫秒  
        cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小  
        cutpic.add("1366*768"); // 添加截取的图片大小为350*240  
        cutpic.add(mediaPicPath); // 添加截取的图片的保存路径        
        
        try {  
        	ProcessBuilder builder = new ProcessBuilder();  
            builder.command(cutpic);
            builder.redirectErrorStream(true);  
            // 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，  
            // 因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易  
            builder.start();
            
        } catch (Exception e) {  
            System.out.println(e);  
            e.printStackTrace();  
        }  
    }  
    
   public static void main(String[] args) {
//    	ImageUtil.generateBookIamge("D:\\workspace\\bigdataplatform_file\\courseware\\12\\23.pdf", "D:\\workspace\\bigdataplatform_file\\courseware\\12\\23.jpg");
//    	ImageUtil.generateBookIamge("D:\\workspace\\bigdataplatform_file\\courseware\\12\\23.pdf", "D:\\workspace\\bigdataplatform_file\\courseware\\12\\23.jpg");
//	   ImageUtil.generateVideoImage("F:\\工具\\ffmpeg-20171022-72c3d9a-win64-static\\ffmpeg-20171022-72c3d9a-win64-static\\bin\\ffmpeg", "D:\\workspace\\bigdataplatform_file\\course_video\\12\\23.mp4", "D:\\workspace\\bigdataplatform_file\\course_video\\12\\23.jpg");
	 
   }
}

