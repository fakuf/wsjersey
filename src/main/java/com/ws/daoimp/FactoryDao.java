package com.ws.daoimp;

import com.ws.idao.IPersonDao;

public class FactoryDao {
	
	public static IPersonDao getPersonDAO() {
		return new PersonaDaoHibernateJpa();
	}
}
