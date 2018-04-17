package org.platesystem.operation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.platesystem.beans.*;
import org.platesystem.dao.BaseDaoImpl;
import org.platesystem.dao.plateDao;
import org.platesystem.dao.plateDaoImpl;

@Component
public class plateMainOperation {
	@Resource
	plateDao platedao;
	public void setplateDao(plateDao platedao) {
		this.platedao = platedao;
	}
	//@Resource
	//@Autowired
	//plateDaoImpl platedaodao;
public int plateMainOperation(String path) throws Exception{
	 Mat firstlocate = Highgui.imread(path,
             Highgui.CV_LOAD_IMAGE_COLOR);
	 int in = 0;
	 plateFirstLocate platefirstlocate = new plateFirstLocate();
	 Mat resultoffirst = platefirstlocate.plateFirstlocate(firstlocate);
	 plateSecondLocate secondlocate = new plateSecondLocate();
	 Mat resultofsecond = secondlocate.plateSecondLocate(resultoffirst);
	 plateRecognize recognize = new plateRecognize();
	 String platenumber = recognize.PlateNumber(resultofsecond);
	 platenumber = platenumber.replaceAll("[\\n]", "");
	 platenumber = platenumber.replaceAll("[¡¡]", "");
	 platenumber = platenumber.replaceAll("[ ]", "");
//	 plateInfo plateinfo= new plateInfo();
//	 plateinfo.setPlatenumber(platenumber);
//	 Date current = new Date();
//	 plateinfo.setIntime(current);
	 
	 /*plateDaoImpl platedaodao = new plateDaoImpl();
	 SessionFactory test = platedaodao.getSessionFactory();
	 HibernateTemplate yoyo =platedaodao.getHiberTemplate1();
	 platedaodao.setHibernateTemplate(yoyo);*/
//	 platedao.save(plateinfo);
	 List<plateInfo> platelist=this.platedao.find(platenumber);
	 
	 if(platelist.size()==0)
	 {
		 plateInfo plateinfo= new plateInfo();
		 plateinfo.setPlatenumber(platenumber);
		 Date current = new Date();
		 plateinfo.setIntime(current);;
		 platedao.save(plateinfo);
	 }
	 int count = 0;
	 for(int i=0;i<platelist.size();i++)
	 {
		 plateInfo plateinfo=platelist.get(i);
		 Date date = plateinfo.getOuttime();
		 if(date==null)
		 {
			 Date outtime = new Date();
			 plateinfo.setOuttime(outtime);
			 Date intime = plateinfo.getIntime();
			 long staytime = outtime.getTime() - intime.getTime();
			 double money =  staytime*0.003;
			 int moneyInt = (int) money;
			 plateinfo.setMoney(moneyInt);
			 this.platedao.update(plateinfo);
			 return moneyInt;
		 }
		 count += 1;
		 if(count == platelist.size())
		 {
			 plateInfo plateinfo2= new plateInfo();
			 plateinfo2.setPlatenumber(platenumber);
			 Date current = new Date();
			 plateinfo2.setIntime(current);;
			 platedao.save(plateinfo2);
		 }
	 }
	 
	 return in;
 }
 
	
}
