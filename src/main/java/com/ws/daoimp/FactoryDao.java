package com.ws.daoimp;

import com.ws.idao.IPersonaDao;

public class FactoryDao {
	
	public static IPersonaDao getPersonaDAO() {
		return new PersonaDaoHibernateJpa();
	}
}
