package com.ws.serviceimp;

import java.util.List;

import com.ws.daoimp.FactoryDao;
import com.ws.excepciones.DAOException;
import com.ws.excepciones.ServiceException;
import com.ws.idao.IPersonaDao;
import com.ws.iservice.IPersonaService;
import com.ws.model.Persona;

public class PersonaServiceImp implements IPersonaService {

	public Persona alta(Persona p) throws ServiceException {
		try {
			IPersonaDao personaDao = FactoryDao.getPersonaDAO();
			personaDao.alta(p);
			return p;
		}catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Persona> recuperar() throws ServiceException {
		try {
			IPersonaDao personaDao = FactoryDao.getPersonaDAO();
			List<Persona> personas = personaDao.recuperar();
			return personas;
		}catch(DAOException e) {
			throw new ServiceException(e);
		}
	}

}
