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
		 * 根据id查找记录
		 * @param pKey
		 * @return查找到的记录
		 */

/*
		public T getById(String pKey);
		*//**
		 * 根据id查找记录
		 * @param pKey
		 * @return查找到的记录
		 */


		
		public void save(T entity);
		
	/*	public void update(T entity);
		public void merge(T entity);
		
		public List<T> selectById(int id);*/
		
        public List<T> find(String pKey);
		public void delById(String pKey);

		public void update(T entity);

}
