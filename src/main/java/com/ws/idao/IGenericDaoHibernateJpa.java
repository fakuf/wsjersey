package com.ws.idao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDaoHibernateJpa<T> {
	/**
	 * store an entity
	 * @param entity
	 * @throws Exception
	 */
	void alta(T entity) throws Exception;
	
	/**
	 * get a list of entities
	 * @return
	 * @throws Exception
	 */
	List<T> recuperar() throws Exception;
	
}
