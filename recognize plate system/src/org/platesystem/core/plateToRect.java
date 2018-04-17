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

public class plateToRect {
	public static Mat plateToRect(Mat thresh,Mat src){
	/*提取轮廓*/
		int g_nStructElementSize = Imgproc.CHAIN_APPROX_TC89_KCOS;
    List<MatOfPoint> platecontours = new ArrayList<>();
    Mat plateplates = thresh;
    Mat platehierarchy = new Mat(plateplates.rows(),plateplates.cols(),plateplates.type());
    Imgproc.findContours(plateplates, platecontours,platehierarchy // a vector of contours

  		              // 提取外部轮廓

  		  ,Imgproc.RETR_EXTERNAL, g_nStructElementSize );       // all pixels of each contours

    
    Mat plateresult = new Mat(plateplates.rows(),plateplates.cols(),plateplates.type());
    src.copyTo(plateresult);

    Imgproc.drawContours(plateresult, platecontours, -1, new Scalar(0, 0, 255, 255));
    Highgui.imwrite("E:\\test\\debug_plateContours.jpg", plateresult);
    
    /*初步筛选*/
    //Vector<Rect> rects = new Vector<Rect>();
    List<Rect> platerects = new ArrayList<>();
    Mat plateresult1 = new Mat();
    src.copyTo(plateresult1);
    for (int i = 0; i < platecontours.size(); ++i) {
//  	  MatOfPoint2f contour2f = new MatOfPoint2f( contours.get(i).toArray() );
        Rect mr = Imgproc.boundingRect(platecontours.get(i));
        double contourArea = Imgproc.contourArea(platecontours.get(i));
        if (VerifySize.verifySizesForPlate(mr))
         {Core.rectangle(plateresult1,mr.tl(),mr.br(),new Scalar(0, 0, 255, 255));
            platerects.add(mr);
            System.out.println(mr.width+"||"+mr.height);
         }
    }
   
    //Imgproc.drawContours(result, rects, -1, new Scalar(0, 0, 255, 255));
    Highgui.imwrite("E:\\test\\debug_platerectangle.jpg", plateresult1);
    
    /*提取框内图像*/
    //for(int i = 0;i < platerects.size();i++){
  	  Rect rectangle = platerects.get(0);
  	  Mat image = src;
  	  Mat image_roi = image.submat(rectangle);
  	  Highgui.imwrite("E:\\test\\"+"platesplateyo0.jpg", image_roi);
   // }
  	  return image_roi;
	}
}
