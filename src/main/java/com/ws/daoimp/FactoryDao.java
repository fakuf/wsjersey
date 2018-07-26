package com.ws.daoimp;

import com.ws.idao.IPersonaDao;

public class FactoryDao {
	
	public static IPersonaDao getPersonDAO() {
		return new PersonaDaoHibernateJpa();
	}
}
