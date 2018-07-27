package com.ws.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import com.ws.entitymanager.EMF;
import com.ws.excepciones.DAOException;
import com.ws.idao.IGenericDaoHibernateJpa;
import com.ws.model.Persona;

public class GenericDaoHibernateJpa<T> implements IGenericDaoHibernateJpa<T>  {
//	@PersistenceContext(unitName="ws") EntityManager em;
	protected Class<T> persistentClass;
	
	public GenericDaoHibernateJpa(Class<T> persistentClass){
		this.setPersistentClass(persistentClass);
	}
	
	public void alta(T entity) throws DAOException {
		EntityTransaction tx = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			throw new DAOException("Se produjo un error al persistir la entidad "+e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> recuperar() throws DAOException {
		List<T> resultado = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			Query consulta = em.createQuery("SELECT e FROM " + this.getPersistentClass().getSimpleName() + " e");
			resultado = consulta.getResultList();
			return resultado;
		}catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}
