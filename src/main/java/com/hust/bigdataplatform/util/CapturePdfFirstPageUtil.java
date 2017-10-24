package com.hust.bigdataplatform.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;
public class CapturePdfFirstPageUtil {
  /** 
     * 生成一本书的缩略图
     * @param inputFile        需要生成缩略图的书籍的完整路径
     * @param outputFile    生成缩略图的放置路径
     */
    public static void generateBookIamge(String inputFile, String outputFile) {
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
        System.out.println( "to generate thumbnail of a book fail : " + inputFile );
        System.out.println( e );
        } 
    }
}