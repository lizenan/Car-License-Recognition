package org.platesystem.core;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class plateFindContour {
     public static Mat plateFindContour(Mat thresh,Mat src){
    	 List<MatOfPoint> contours = new ArrayList<>();
    	 int g_nStructElementSize = Imgproc.CHAIN_APPROX_TC89_KCOS;
        /* Mat plates = Highgui.imread("E:\\morphologyandthresh.jpg",
     	         Highgui.CV_LOAD_IMAGE_GRAYSCALE);*/
         Mat hierarchy = new Mat(thresh.rows(),thresh.cols(),thresh.type());
         Imgproc.findContours(thresh, contours,hierarchy // a vector of contours

       		              // 提取外部轮廓

       		  ,Imgproc.RETR_EXTERNAL, g_nStructElementSize );       // all pixels of each contours

         
         Mat result = new Mat(thresh.rows(),thresh.cols(),thresh.type());
         src.copyTo(result);

         Imgproc.drawContours(result, contours, -1, new Scalar(0, 0, 255, 255));
         Highgui.imwrite("E:\\test\\debug_Contours.jpg", result);
         
         
         /*初步筛选*/
         //Vector<Rect> rects = new Vector<Rect>();
         List<Rect> rects = new ArrayList<>();
         Mat result1 = new Mat();
         src.copyTo(result1);
         for (int i = 0; i < contours.size(); ++i) {
//       	  MatOfPoint2f contour2f = new MatOfPoint2f( contours.get(i).toArray() );
             Rect mr = Imgproc.boundingRect(contours.get(i));
             double contourArea = Imgproc.contourArea(contours.get(i));
             if (VerifySize.verifySizes(mr,contourArea))
             { Core.rectangle(result1,mr.tl(),mr.br(),new Scalar(0, 0, 255, 255));
                 rects.add(mr);
                 System.out.println(mr.width+"||"+mr.height);
             }
         }
        
         //Imgproc.drawContours(result, rects, -1, new Scalar(0, 0, 255, 255));
         Highgui.imwrite("E:\\test\\debug_rectangle.jpg", result1);
         
         /*提取框内图像*/
         //for(int i = 0;i < rects.size();i++){
       	  Rect rectangle = rects.get(0);
       	  Mat image = src;
       	  Mat image_roi = image.submat(rectangle);
       	  Highgui.imwrite("E:\\test\\"+"platesyo0.jpg", image_roi);
         //}
         return image_roi;
     }
}
