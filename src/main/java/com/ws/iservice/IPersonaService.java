package com.ws.iservice;

import java.util.List;

import com.ws.excepciones.ServiceException;
import com.ws.model.Persona;

public interface IPersonaService {
	
	/**
	 * @param p la persona a guardar
	 * @return Persona
	 */
	public Persona alta(Persona p) throws ServiceException;
	
	/**
	 * @return List<Persona>
	 */
	public List<Persona> recuperar() throws ServiceException;

}
