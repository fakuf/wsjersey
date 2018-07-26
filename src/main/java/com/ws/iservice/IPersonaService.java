package com.ws.iservice;

import java.util.List;

import com.ws.excepciones.ServiceException;
import com.ws.model.Persona;

public interface IPersonaService {
	
	/**
	 * 
	 * @param p the person to store
	 * @return the person who was saved
	 */
	public Persona add(Persona p) throws ServiceException;
	
	/**
	 * Devuele el listado de todas las personas
	 * @return
	 */
	public List<Persona> recuperar() throws ServiceException;

}
