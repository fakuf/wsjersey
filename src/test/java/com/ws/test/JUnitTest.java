package com.ws.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.ws.daoimp.FactoryDao;
import com.ws.excepciones.DAOException;
import com.ws.idao.IPersonaDao;
import com.ws.model.Persona;

public class JUnitTest {
	
	@Test
	public void guardaPersona() {
		 IPersonaDao personaDao = FactoryDao.getPersonDAO();
		 Persona persona1 = new Persona(33856516L, "Falcone", "Facundo", "29");
		 try {
			Persona p = null;
			personaDao.alta(persona1);
			p = personaDao.recuperar(33856516L);
			assertNotNull(p);
			assertEquals(new Long(33856516), p.getDni());
		} catch (DAOException e) {
			fail("Ocurrio un error al dar de alta la persona "+e);
		}
	}
	
	@Test
	public void listarPersonas() {
		 IPersonaDao personaDao = FactoryDao.getPersonDAO();
		 try {
			List<Persona> personas = personaDao.recuperar();
			assertThat(personas, hasSize(equalTo(1)));
		} catch (DAOException e) {
			fail("Ocurrio un error al listar las personas "+e);
		}
	}

}
