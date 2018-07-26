package com.ws.idao;

import com.ws.excepciones.DAOException;
import com.ws.model.Persona;

public interface IPersonaDao extends IGenericDaoHibernateJpa<Persona> {
	/**
	 * 
	 * @param dni
	 * @return
	 * @throws Exception
	 */
	public Persona recuperar(Long dni) throws DAOException;
}
