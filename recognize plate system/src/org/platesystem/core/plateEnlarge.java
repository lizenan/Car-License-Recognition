package org.platesystem.core;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class plateEnlarge {
       public static Mat plateEnlarge(Mat thresh){
    	   Mat enlargeImage = thresh;
            Mat enlargedImage = new Mat();
            Size sz = new Size(enlargeImage.width()*4,enlargeImage.height()*4);
            Imgproc.resize(enlargeImage,enlargedImage,sz);
            Highgui.imwrite("E:\\test\\enlargePicture.jpg", enlargedImage);
            return enlargedImage;
       }
}
