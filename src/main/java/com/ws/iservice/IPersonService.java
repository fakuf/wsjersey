package com.ws.iservice;

import com.ws.model.Person;

public interface IPersonService {
	
	/**
	 * 
	 * @param p the person to store
	 * @return the person who was saved
	 */
	public Person add(Person p);

}
