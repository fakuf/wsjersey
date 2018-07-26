package com.ws.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.ws.idao.IGenericDaoHibernateJpa;

public class GenericDaoHibernateJpa<T> implements IGenericDaoHibernateJpa<T>  {
	@PersistenceContext(unitName="ws") EntityManager em;

	public void alta(T entity) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
			em.close();
		} catch (Exception e) {
			throw e;
		}	
	}

	public List<T> recuperar() throws Exception {
		return null;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
