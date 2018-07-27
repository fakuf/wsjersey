package com.ws.api;

import java.util.List;

import javax.validation.Valid;
//import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ws.excepciones.ServiceException;
import com.ws.iservice.IPersonaService;
import com.ws.model.Persona;
import com.ws.serviceimp.PersonaServiceImp;
@Path("/persona")
public class PersonaResource {

	@POST
	@Path("/personas/{dni}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response add(@PathParam( "dni" ) Long dni, @Valid Persona person) {
		try {
			IPersonaService personService = new PersonaServiceImp();
			person.setDni(dni);
			personService.add(person);
			return Response.status(Status.OK).entity(person).build();
		}catch(ServiceException se) {
			return Response.status(Status.CONFLICT).entity(se.getMessage()).build();
		}
		catch(Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/personas")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response recuperar() {
		try {
			IPersonaService personService = new PersonaServiceImp();
			List<Persona> personas = personService.recuperar();
			return Response.status(Status.OK).entity(personas).build();
		}
		catch(ServiceException se) {
			return Response.status(Status.CONFLICT).entity(se.getMessage()).build();
		}
	}
}
