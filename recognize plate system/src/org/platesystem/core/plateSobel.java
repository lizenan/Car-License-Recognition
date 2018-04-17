package org.platesystem.core;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class plateSobel {
     public static Mat Canny(Mat gaussian){
    	 Mat canny = new Mat(gaussian.rows(),gaussian.cols(),CvType.CV_8UC1);
         Imgproc.Canny(gaussian, canny, 50, 200 );
          Highgui.imwrite("E:\\test\\testsobel.jpg", canny);
          return canny;
     }
     public static Mat Sobel(Mat gaussian){
    	 Mat sobel = new Mat(gaussian.rows(),gaussian.cols(),CvType.CV_8UC1);
          Imgproc.Sobel(gaussian, sobel, -1, 1 , 0);
          Highgui.imwrite("E:\\test\\testplatesobel.jpg", sobel);
          return sobel;
     }
}
