package org.platesystem.core;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class plateThresh {
    public static Mat plateThresh(Mat gray){
   	         
     Mat thresh = new Mat(gray.rows(),gray.cols(),gray.type());
     Imgproc.threshold(gray,thresh,127,255,Imgproc.THRESH_BINARY);//
     Highgui.imwrite("E:\\test\\ThreshOTSU.jpg", thresh);
     return thresh;
    }
    public static Mat plateThreshInv(Mat src){
    	Mat finalthresh = src;
   	         
     Mat finalthresh1 = new Mat(finalthresh.rows(),finalthresh.cols(),finalthresh.type());
     Imgproc.threshold(finalthresh,finalthresh1,127,255,Imgproc.THRESH_BINARY_INV);//
     Highgui.imwrite("E:\\test\\finalThreshOTSU.jpg", finalthresh1);
     return finalthresh1;
    }
}
