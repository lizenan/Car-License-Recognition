package org.platesystem.operation;

import org.opencv.core.Mat;
import org.platesystem.core.plateEnlarge;
import org.platesystem.core.plateFindContour;
import org.platesystem.core.plateGaussian;
import org.platesystem.core.plateGray;
import org.platesystem.core.plateMorphology;
import org.platesystem.core.plateSobel;
import org.platesystem.core.plateThresh;
import org.platesystem.core.plateToRect;
import org.platesystem.core.plateWipeOffFrame;

public class plateSecondLocate {
     public Mat plateSecondLocate(Mat src){
    	 Mat gray = plateGray.plateGray(src);
 		Mat gaussian = plateGaussian.plateGaussian(gray);
 		Mat sobel = plateSobel.Sobel(gaussian);
 		Mat thresh = plateThresh.plateThresh(sobel);
 		Mat morphology = plateMorphology.morphologySlightly(thresh);
 		morphology = plateMorphology.morphologySlightly(morphology);
 		morphology = plateMorphology.morphologySlightly(morphology);
 		Mat threshsecond = plateThresh.plateThresh(morphology);
 		Mat torect = plateToRect.plateToRect(threshsecond, src);
 		Mat wipeoff = plateWipeOffFrame.plateWipeOffFrame(torect);
 		Mat graysecond = plateGray.plateGray(wipeoff);
 		Mat gaussiansecond = plateGaussian.plateGaussianSlightly(graysecond);
 		Mat threshinv = plateThresh.plateThreshInv(gaussiansecond);
 		Mat enlarge = plateEnlarge.plateEnlarge(threshinv);
 		return enlarge;
     }
}
