package org.platesystem.core;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class plateMorphology {
      public static Mat morphology(Mat thresh){
    	  Mat morphology1 = new Mat(thresh.rows(),thresh.cols(),thresh.type());
          Mat morphology2 = new Mat(morphology1.rows(),morphology1.cols(),morphology1.type());
          int g_nStructElementSize = Imgproc.CHAIN_APPROX_TC89_KCOS;
          Mat element =Imgproc.getStructuringElement(Imgproc.MORPH_RECT,
        	       new Size(12,3)
        	       );
          
          Mat element1 =Imgproc.getStructuringElement(Imgproc.MORPH_RECT,
       	       new Size(3,12));
          //(2*g_nStructElementSize+1,2*g_nStructElementSize+1)
          Imgproc.morphologyEx(thresh,morphology1, Imgproc.MORPH_DILATE, element);
          /*Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);*/
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          /*Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);*/
          //Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element1);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element1);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element1);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element1);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element1);


          Highgui.imwrite("E:\\test\\morphology.jpg", morphology1);
          return morphology1;
      }
      
      public static Mat morphologySlightly(Mat thresh){
    	  Mat platemorphology1 = new Mat(thresh.rows(),thresh.cols(),thresh.type());
          Mat platemorphology2 = new Mat(platemorphology1.rows(),platemorphology1.cols(),platemorphology1.type());
          //int g_nStructElementSize = Imgproc.CHAIN_APPROX_TC89_KCOS;
          Mat plateelement =Imgproc.getStructuringElement(Imgproc.MORPH_RECT,
        	       new Size(4,2)
        	       );
          
          Mat plateelement1 =Imgproc.getStructuringElement(Imgproc.MORPH_RECT,
       	       new Size(1,3));
          //(2*g_nStructElementSize+1,2*g_nStructElementSize+1)
          //Imgproc.morphologyEx(platemorphology,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          //Imgproc.morphologyEx(platemorphology,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          /*Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);*/
          /*Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);*/
          /*Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_ERODE, element);*/
          //Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_ERODE, plateelement);
          /*Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);*/
          //Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          //Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          //Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          /*Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element);*/
          //Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element1);
          //Imgproc.morphologyEx(platemorphology,platemorphology1, Imgproc.MORPH_ERODE, plateelement1);
          //Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_ERODE, plateelement1);
          //Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_ERODE, plateelement1);
         /* Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element1);
          Imgproc.morphologyEx(morphology1,morphology1, Imgproc.MORPH_DILATE, element1);*/
          //Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_DILATE, plateelement1);
          Imgproc.morphologyEx(thresh,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          /*Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_DILATE, plateelement);
          Imgproc.morphologyEx(platemorphology1,platemorphology1, Imgproc.MORPH_DILATE, plateelement);*/
          Highgui.imwrite("E:\\test\\platemorphology.jpg", platemorphology1);
          return platemorphology1;
      }
}
