package org.platesystem.dao;

	import java.io.Serializable;
	import java.util.Collection;
	import java.util.Date;
	import java.util.List;
	import java.util.Map;

	import org.hibernate.Session;
	import org.hibernate.criterion.Criterion;
	import org.springframework.transaction.annotation.Propagation;
	import org.springframework.transaction.annotation.Transactional;



	public interface BaseDao<T> {

		/**
		 * ����id���Ҽ�¼
		 * @param pKey
		 * @return���ҵ��ļ�¼
		 */

/*
		public T getById(String pKey);
		*//**
		 * ����id���Ҽ�¼
		 * @param pKey
		 * @return���ҵ��ļ�¼
		 */


		
		public void save(T entity);
		
	/*	public void update(T entity);
		public void merge(T entity);
		
		public List<T> selectById(int id);*/
		
        public List<T> find(String pKey);
		public void delById(String pKey);

		public void update(T entity);

}
