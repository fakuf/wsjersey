package com.ws.idao;

import java.util.List;

import com.ws.excepciones.DAOException;

public interface IGenericDaoHibernateJpa<T> {
	/**
	 * store an entity
	 * @param entity
	 * @throws Exception
	 */
	void alta(T entity) throws DAOException;
	
	/**
	 * get a list of entities
	 * @return
	 * @throws Exception
	 */
	List<T> recuperar() throws DAOException;
	
}
