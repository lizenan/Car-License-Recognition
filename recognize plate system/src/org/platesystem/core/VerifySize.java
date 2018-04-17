package org.platesystem.core;

import org.opencv.core.Rect;

public class VerifySize {
	   public static boolean verifySizes(Rect mr, double contourarea){
		   float error = 0.6f;
		   double areaError = 0.7;

		   // China car plate size: 440mm*140mm£¬aspect 3.142857
		 
		   float aspect = 3.75f;
		   
		   double min = 44 * 14 * 10; // minimum area

		   double max = 44 * 14 * 150; // maximum area
		   
		   
		   // Get only patchs that match to a respect ratio.

		   float rmin = aspect - aspect * error;

		   float rmax = aspect + aspect * error;


		   double area = (int) mr.area();

		   float r = mr.width / mr.height;
		   

		   
		   return area >= min && area <= max && contourarea >= areaError*area && r>=1.8;// && r >= rmin && r <= rmax

		}
		   public static boolean verifySizesForPlate(Rect mr){
			   double area = (int) mr.area();
			   double min = 44 * 14 * 5; // minimum area

			   double max = 44 * 14 * 150; // maximum area
			   return area >= min && area <= max;
		   }
		
}
