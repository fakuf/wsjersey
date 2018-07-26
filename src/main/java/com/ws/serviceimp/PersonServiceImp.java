package com.ws.serviceimp;

import com.ws.daoimp.FactoryDao;
import com.ws.idao.IPersonDao;
import com.ws.iservice.IPersonService;
import com.ws.model.Person;

public class PersonServiceImp implements IPersonService {

	public Person add(Person p) {
		try {
			IPersonDao personDao = FactoryDao.getPersonDAO();
			personDao.alta(p);
			return p;
		}catch(Exception e) {
			return null;
		}
	}

}
