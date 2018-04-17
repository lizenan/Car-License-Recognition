package org.platesystem.core;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;

public class plateWipeOffFrame {
      public static Mat plateWipeOffFrame(Mat src){
    	  /*È¥³ýÃ­¶¤±ß¿ò*/
          Mat plateresult2 = new Mat();
          Mat image = src;
          image.copyTo(plateresult2);
          Integer imgheight = image.height();
          Integer imgwidth = image.width();
          double without = imgwidth*0.045;
          double without2 = imgwidth*(1-0.09);
          int withoutInt = (int) without;
          double withoutHeight = imgheight*0.15;
          double withoutHeight2 = imgheight*(1-0.15);
          int withoutHeightInt = (int)withoutHeight;
          Point topleft = new Point(without,withoutHeight);
          Point rightbot = new Point(without2,withoutHeight2);
          Core.rectangle(plateresult2,topleft,rightbot,new Scalar(0, 0, 255, 255));
          Highgui.imwrite("E:\\test\\"+"idontgetafuck.jpg", plateresult2);
          Rect mr = new Rect(topleft,rightbot);
          Mat lastimage = plateresult2;
    	  Mat image_roi = lastimage.submat(mr);
    	  Highgui.imwrite("E:\\test\\"+"finalplateman.jpg", image_roi);
    	  return image_roi;
      }
}
