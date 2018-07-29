package com.ws.api;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Digits;
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
import com.ws.serviceimp.FactoryService;
import com.ws.serviceimp.PersonaServiceImp;
@Path("/")
public class PersonaResource {

	@POST
	@Path("/personas/{dni}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response add(@PathParam( "dni" ) Long dni, @Valid Persona persona) {
		try {
			if (!validarDni(dni)) 
				throw new ValidationException("cantidad de digitos del dni distinto a ocho");
			IPersonaService personService = new PersonaServiceImp();
			persona.setDni(dni);
			personService.alta(persona);
			return Response.status(Status.CREATED).entity(persona).build();
		}catch(ServiceException se) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(se.getMessage()).build();
		}
	}
	
	@GET
	@Path("/personas")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response recuperar() {
		try {
			IPersonaService personService = FactoryService.getPersonaService();
			List<Persona> personas = personService.recuperar();
			return Response.status(Status.OK).entity(personas).build();
		}
		catch(ServiceException se) {
			return Response.status(Status.CONFLICT).entity(se.getMessage()).build();
		}
	}
	
	public Boolean validarDni(Long dni) {
		return (dni.toString().length()== 8);
	}
}
