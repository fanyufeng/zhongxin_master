package com.dongfang.client.zhongxin.commons.constants;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

public class Constants {
	public final static String _SESSION_USER_ID_KEYPREFIX="SESSION_USER_ID_KEYPREFIX";
	//存储session的值
	public static Map<String, String> mapSession=new HashMap<String, String>();
	public static String testfuntion() throws IOException{
		
		try {
			
			FFmpegFrameGrabber g =new FFmpegFrameGrabber("/usr/local/dreameclipse/apache-tomcat-7.0.70/webapps/videoLibrary/991d2231-b41d-4159-800c-3ecdeebcbc0e.mp4");
			
			
			g.start();
			for (int i = 0 ; i < 1 ; i++) {
		 		   Java2DFrameConverter converter = new Java2DFrameConverter();
		 		   BufferedImage bi = converter.getBufferedImage(g.grabImage());
		 		  
		 		   String imagePath="/usr/local/dreameclipse/apache-tomcat-7.0.70/webapps/videoLibrary/images/"+System.currentTimeMillis() + ".png";
		 		   ImageIO.write(bi, "png", new File(imagePath));   
			}
		 	g.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	   
		return "success";
		
	}
	 
	
}
