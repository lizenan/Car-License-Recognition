package org.platesystem.core;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class plateGaussian {
     public static Mat plateGaussian(Mat gray){
    	 Mat gaussian = new Mat(gray.rows(),gray.cols(),gray.type());
         Imgproc.GaussianBlur(gray, gaussian,new Size(5,5), 0);
         Highgui.imwrite("E:\\test\\testtogaussian.jpg", gaussian);
         return gaussian;
     }
     public static Mat plateGaussianSlightly(Mat gray){
    	 Mat gaussian = new Mat(gray.rows(),gray.cols(),gray.type());
         Imgproc.GaussianBlur(gray, gaussian,new Size(3,3), 0);
         Highgui.imwrite("E:\\test\\testtogaussian.jpg", gaussian);
         return gaussian;
     }
}
