package com.icl.epod.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.icl.epod.model.UserModel;

/**
 * @author Vijendra.y
 *
 */
@Repository
@EnableTransactionManagement
public class HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public <T> Serializable create(final T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	@Transactional
	public <T> T update(final T entity) {
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}

	@Transactional
	public <T> void delete(final T entity) {
		System.out.println("entity" + " " + entity);
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Transactional
	public int deleteAllUser() {

		Query qry = sessionFactory.getCurrentSession().createQuery("delete from UserEntity u");
		int res = qry.executeUpdate();
		System.out.println("Records deleted successfully...");
		return res;
	}

	@Transactional
	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T> List<UserModel> fetchAll(Class<T> entityClass) {
		return sessionFactory.getCurrentSession().createQuery(" FROM " + entityClass.getName()).list();

	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public <T> List fetchAll(String query) {
		return sessionFactory.getCurrentSession().createSQLQuery(query).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public <T> T fetchById(Serializable id, Class<T> entityClass) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}
	
	

	@SuppressWarnings("unchecked")
	@Transactional
	public  <T> boolean fetchUserById(Serializable id, Class<T> entityClass) {
		System.out.println("inside fetch user");
		return   (boolean) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@Transactional
	public <T> T updateFetch(Serializable id, Class<T> entityClass) {
		return fetchById(id, entityClass);
	}
}