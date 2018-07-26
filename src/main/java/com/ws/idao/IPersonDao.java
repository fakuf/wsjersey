package com.ws.idao;

import com.ws.model.Person;

public interface IPersonDao extends IGenericDaoHibernateJpa<Person> {
	/**
	 * 
	 * @param dni
	 * @return
	 * @throws Exception
	 */
	public Person find(Long dni) throws Exception;
}
