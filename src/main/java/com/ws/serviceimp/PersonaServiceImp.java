package com.ws.serviceimp;

import java.util.List;

import com.ws.daoimp.FactoryDao;
import com.ws.excepciones.DAOException;
import com.ws.excepciones.ServiceException;
import com.ws.idao.IPersonaDao;
import com.ws.iservice.IPersonaService;
import com.ws.model.Persona;

public class PersonaServiceImp implements IPersonaService {

	public Persona add(Persona p) throws ServiceException {
		try {
			IPersonaDao personDao = FactoryDao.getPersonDAO();
			personDao.alta(p);
			return p;
		}catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Persona> recuperar() throws ServiceException {
		try {
			IPersonaDao personDao = FactoryDao.getPersonDAO();
			List<Persona> personas = personDao.recuperar();
			return personas;
		}catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

}
