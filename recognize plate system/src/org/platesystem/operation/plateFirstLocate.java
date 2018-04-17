package org.platesystem.operation;

import org.opencv.core.Mat;
import org.platesystem.core.plateFindContour;
import org.platesystem.core.plateGaussian;
import org.platesystem.core.plateGray;
import org.platesystem.core.plateMorphology;
import org.platesystem.core.plateSobel;
import org.platesystem.core.plateThresh;

public class plateFirstLocate {
	public Mat plateFirstlocate(Mat src){
		Mat gray = plateGray.plateGray(src);
		Mat gaussian = plateGaussian.plateGaussian(gray);
		Mat canny = plateSobel.Canny(gaussian);
		Mat thresh = plateThresh.plateThresh(canny);
		Mat morphology = plateMorphology.morphology(thresh);
		Mat threshsecond = plateThresh.plateThresh(morphology);
		Mat findcontour = plateFindContour.plateFindContour(threshsecond, src);
		return findcontour;
		
	}

}
