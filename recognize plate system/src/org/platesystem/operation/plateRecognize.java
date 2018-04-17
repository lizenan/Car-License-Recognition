package org.platesystem.operation;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.platesystem.beans.*;

@Controller
public class plateRecognize {

       
       public String PlateNumber(Mat src) throws Exception{
    	    
    	   Highgui.imwrite("E:\\platenumber.tif", src);
    	   File imageFile = new File("E:\\platenumber.tif");
           /* File imageFile1 = new File("E:\\18.jpg");
            File imageFile2 = new File("E:\\17.jpg");
            File imageFile3 = new File("E:\\16.jpg");
            File imageFile4 = new File("E:\\15.jpg");
            File imageFile5 = new File("E:\\14.jpg");
            File imageFile6 = new File("E:\\13.jpg");*/
            ITesseract instance = new Tesseract();  
            ITesseract instance1 = new Tesseract();  // JNA Interface Mapping
            instance.setPageSegMode(7);
            instance1.setPageSegMode(7);
            // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
            instance.setDatapath("F:\\plate reconition util\\T4J\\Tess4J");
            instance1.setDatapath("F:\\plate reconition util\\T4J\\Tess4J");
            instance.setLanguage("plate");
            instance1.setLanguage("plate");
          
            
                String result = instance1.doOCR(imageFile);
                /*String result1 = instance.doOCR(imageFile1);
                String result2 = instance.doOCR(imageFile2);
                String result3 = instance.doOCR(imageFile3);
                String result4 = instance.doOCR(imageFile4);
                String result5 = instance.doOCR(imageFile5);
                String result6 = instance.doOCR(imageFile6);*/
                //String test=result+result1+result2+result3+result4+result5+result6;
                
                //String test=result1+result2;
                //String test=result+result1+result2;
                System.out.println(result);
           
    	  
    	  return result;
       }
       
}
