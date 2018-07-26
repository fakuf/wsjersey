package com.ws.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ws.iservice.IPersonService;
import com.ws.model.Person;
import com.ws.serviceimp.PersonServiceImp;
@Path("/person")
public class PersonResource {

	@POST
	@Path("/add/{dni}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Person add(Person person) {
		IPersonService personService = new PersonServiceImp();
		person.setDni(33856518L);
		personService.add(person);
		return person;
	}
}
