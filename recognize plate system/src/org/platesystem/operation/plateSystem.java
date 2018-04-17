package org.platesystem.operation;

import javax.annotation.Resource;

import org.opencv.core.Core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.swing.JFrame;

public class plateSystem {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        int kernelSize = 9;
       /* plateInterface   frame   =   new   plateInterface(); 
        frame.setSize(800,600); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            frame.setVisible(true);*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("root-context.xml");
        /*plateMainOperation platemainoperation = new plateMainOperation();///new plateMainOperation();
        platemainoperation.plateMainOperation();*/
        /*plateMainOperation platemainoperation = (plateMainOperation) ctx.getBean("plateMainOperation");
        platemainoperation.plateMainOperation();*/
        plateInterface plateinterface = (plateInterface) ctx.getBean("plateInterface");
        plateinterface.setVisible(true);

	}

}
