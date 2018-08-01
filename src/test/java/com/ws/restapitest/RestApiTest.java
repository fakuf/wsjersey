package com.ws.restapitest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import com.ws.api.PersonaResource;
import com.ws.daoimp.FactoryDao;
import com.ws.excepciones.DAOException;
import com.ws.idao.IPersonaDao;
import com.ws.model.Persona;

public class RestApiTest extends JerseyTest {
	public Persona persona1;
	public Persona persona2;
	public Persona persona3;
	public IPersonaDao personaDao;
	
	protected Application configure() {
		return new ResourceConfig(PersonaResource.class);
	}
	
	@Before
	public void init() {
		persona1 = new Persona(33856516L, "Falcone", "Facundo", 29);
		persona2 = new Persona(33856517L, "Falcone", "Fernando", 39);
		persona3 = new Persona(33856518L, "Falcone", "Agustina", 35);
		personaDao = FactoryDao.getPersonaDAO();
		try {
			personaDao.limpiarTabla();
			personaDao.alta(persona1);
			personaDao.alta(persona2);
			personaDao.alta(persona3);
		} catch (DAOException e) {
			fail("Ocurrio un error "+ e);
		}
	}
	
	@Test
    public void testRecuperarTodos() {
        Response output = target("/personas").request().get();
        assertEquals("debe retornar 200", 200, output.getStatus());
        assertNotNull("debe retornar una lista", output.getEntity());
    }
	
	@Test
    public void testCrearPersona(){
        Persona persona = new Persona("Falcone", "Facundo", 29);
        Response output = target("/personas/33856515")
                .request()
                .post(Entity.entity(persona, MediaType.APPLICATION_JSON));

        assertEquals("Debe retornar 201", Status.CREATED.getStatusCode(), output.getStatus());
        
        persona = new Persona();
        output = target("/personas/33856516")
                .request()
                .post(Entity.entity(persona, MediaType.APPLICATION_JSON));
        assertEquals("Debe retornar 400", Status.BAD_REQUEST.getStatusCode(), output.getStatus());
        
        persona = new Persona("Falcone", "Facundo", 29);
        output = target("/personas/33856516")
                .request()
                .post(Entity.entity(persona, MediaType.APPLICATION_JSON));
        assertEquals("Debe retornar 500", Status.INTERNAL_SERVER_ERROR.getStatusCode(), output.getStatus());
        

        
    }

}
