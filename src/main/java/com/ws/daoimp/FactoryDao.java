package com.ws.daoimp;

import com.ws.idao.IPersonaDao;

public class FactoryDao {
	
	/**
	 * 
	 * @return PersonaDaoHibernateJpa
	 */
	public static IPersonaDao getPersonaDAO() {
		return new PersonaDaoHibernateJpa();
	}
}
