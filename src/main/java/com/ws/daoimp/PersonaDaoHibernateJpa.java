package com.ws.daoimp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ws.entitymanager.EMF;
import com.ws.idao.IPersonDao;
import com.ws.model.Person;

public class PersonaDaoHibernateJpa extends GenericDaoHibernateJpa<Person> implements IPersonDao {
	
	public Person find(Long dni) throws Exception {
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			Query consulta = em.
			createQuery("select p from Person p where p.Dni = :dni");
			consulta.setParameter("dni", dni);
			Person resultado = (Person)consulta.getSingleResult();
			return resultado;
		}catch(Exception e) {
			return null;
		}
	}

}
