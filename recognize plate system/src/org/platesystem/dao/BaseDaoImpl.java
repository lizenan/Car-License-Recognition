package org.platesystem.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.platesystem.dao.BaseDao;

@Component
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    
	//private SessionFactory sessionFactory;
	//@Resource
	//@Transactional 
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
		//this.sessionFactory = sessionFacotry;
	}
	/*public SessionFactory getSessionFacotry(){
		return this.sessionFactory;
	}*/
	
	private HibernateTemplate getHiberTemplate() {
		return this.getHibernateTemplate();
	}
	
/*	public HibernateTemplate getHiberTemplate1() {
		return this.getHibernateTemplate();
	}*/
	@Override  
    public void save(T entity) {  
        this.getHibernateTemplate().save(entity);  
		
    }  
  
    // 删除记录（按照实体删除）  
    @Override  
    public void delById(String entity) {  
        // TODO Auto-generated method stub  
        this.getHibernateTemplate().delete(entity);  
  
    }  
  
    // 删除记录（按id删除）,不成功  
  
  
//  按照id查找记录  
    @Override  
    public List<T> find(String platenumber) {  
        // TODO Auto-generated method stub  
        /*this.getHibernateTemplate().find("from bean.User u where u.name=?","test");  
        List<T> entities =new ArrayList();
        return entities;  */
    	//Session session = getSession();
    	String sql = "from plateInfo where platenumber='"+platenumber+"'";
    	Query query = getSession().createQuery(sql);
    	List list = query.list();
    	return list;
    }  
  
//  更新的方法  
    @Override  
    public void update(T entity) {  
        // TODO Auto-generated method stub  
        this.getHibernateTemplate().update(entity);  
    }  
  
    
}
/*@Repository  
public class BaseDaoImpl<T> implements BaseDao<T> {  
  
    protected Class<T> entityClazz;  
  
    protected SessionFactory sessionFactory;  
  
    @SuppressWarnings("unchecked")  
    public BaseDaoImpl() {  
        Type type = getClass().getGenericSuperclass();  
        if (type instanceof ParameterizedType) {  
            this.entityClazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];  
        } else {  
            this.entityClazz = null;  
        }  
    }  
  
    @Resource  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
  
    protected Session getSession() {  
        return sessionFactory.getCurrentSession();  
    }  
  
  
	@Override
	public void save(T entity) {
		getSession().save(entity);// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> find(String pKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delById(String pKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}  
}*/
/*public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    
	//private SessionFactory sessionFactory;
	//@Resource
	//@Transactional 
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
		//this.sessionFactory = sessionFacotry;
	}
	public SessionFactory getSessionFacotry(){
		return this.sessionFactory;
	}
	
	private HibernateTemplate getHiberTemplate() {
		return this.getHibernateTemplate();
	}
	
	public HibernateTemplate getHiberTemplate1() {
		return this.getHibernateTemplate();
	}
	@Override  
    public void save(T entity) {  
        this.getHibernateTemplate().save(entity);  
		
    }  
  
    // 删除记录（按照实体删除）  
    @Override  
    public void delById(String entity) {  
        // TODO Auto-generated method stub  
        this.getHibernateTemplate().delete(entity);  
  
    }  
  
    // 删除记录（按id删除）,不成功  
  
  
//  按照id查找记录  
    @Override  
    public List<T> find(String id) {  
        // TODO Auto-generated method stub  
        this.getHibernateTemplate().find("from bean.User u where u.name=?","test");  
        List<T> entities =new ArrayList();
        return entities;  
    }  
  
//  更新的方法  
    @Override  
    public void update(T entity) {  
        // TODO Auto-generated method stub  
        this.getHibernateTemplate().update(entity);  
    }  
  
    
}*/

