package com.ws.idao;

import java.util.List;

import com.ws.excepciones.DAOException;

public interface IGenericDao<T> {
	
	/**
	 * Guarda una entidad
	 * @param entidad
	 * @throws DAOException
	 */
	public void alta(T entidad) throws DAOException;
	
	
	/**
	 * Recupera una lista de entidades
	 * @return List<T>
	 * @throws DAOException
	 */
	public List<T> recuperar() throws DAOException;
	
}
