package com.ws.idao;

import com.ws.excepciones.DAOException;
import com.ws.model.Persona;

public interface IPersonaDao extends IGenericDao<Persona> {
	
	/**
	 * @param dni
	 * @return Devuelve una persona
	 * @throws DAOException
	 */
	public Persona recuperar(Long dni) throws DAOException;
	
	/**
	 * Limpia la tabla persona
	 * @throws DAOException
	 */
	public void limpiarTabla() throws DAOException;
}
