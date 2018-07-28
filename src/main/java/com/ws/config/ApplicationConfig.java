package com.ws.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.ws.model.Persona;

public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		register(Persona.class);
		register(ConstraintViolationMapper.class);
	}
}
