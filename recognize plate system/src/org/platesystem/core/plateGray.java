package org.platesystem.core;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class plateGray {
	public static Mat plateGray(Mat src){
		Mat gray = new Mat(src.rows(),src.cols(),CvType.CV_8UC1);
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_RGB2GRAY);
        Highgui.imwrite("E:\\test\\testtogray.jpg", gray);
        return gray;
	}

}
