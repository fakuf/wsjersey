package com.ws.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

	public Response toResponse(ConstraintViolationException e) {
		// There can be multiple constraint Violations
	    Set<ConstraintViolation<?>> errores = e.getConstraintViolations();
	    List<String> messages = new ArrayList<String>();
	    for (ConstraintViolation<?> error : errores) {
	        messages.add(error.getMessage());

	    }
	    return Response.status(Status.BAD_REQUEST).entity(messages).build();
	}

}
