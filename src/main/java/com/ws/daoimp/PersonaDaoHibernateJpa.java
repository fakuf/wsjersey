package com.ws.daoimp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ws.entitymanager.EMF;
import com.ws.excepciones.DAOException;
import com.ws.idao.IPersonaDao;
import com.ws.model.Persona;

public class PersonaDaoHibernateJpa extends GenericDaoHibernateJpa<Persona> implements IPersonaDao {
	
	public PersonaDaoHibernateJpa() {
		super(Persona.class);
	}

	public Persona recuperar(Long dni) throws DAOException {
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			Query consulta = em.
			createQuery("select p from Persona p where p.Dni = :dni");
			consulta.setParameter("dni", dni);
			Persona resultado = (Persona)consulta.getSingleResult();
			return resultado;
		}catch(Exception e) {
			return null;
		}
	}

}
