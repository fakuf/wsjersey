package com.ws.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ws.daoimp.FactoryDao;
import com.ws.excepciones.DAOException;
import com.ws.idao.IPersonaDao;
import com.ws.model.Persona;

public class JUnitTest {
	public Persona persona1;
	public Persona persona2;
	public Persona persona3;
	public IPersonaDao personaDao;
	
	@Before
	public void init() {
		persona1 = new Persona(33856516L, "Falcone", "Facundo", 29);
		persona2 = new Persona(33856517L, "Falcone", "Fernando", 39);
		persona3 = new Persona(33856518L, "Falcone", "Agustina", 35);
		personaDao = FactoryDao.getPersonaDAO();
		try {
			personaDao.limpiarTabla();
		} catch (DAOException e) {
			fail("Ocurrio un error "+ e);
		}
	}
	
	@Test
	public void guardaPersona() {
		 try {
			Persona p = null;
			personaDao.alta(persona1);
			p = personaDao.recuperar(33856516L);
			assertNotNull(p);
			assertEquals(persona1, p);
		} catch (DAOException e) {
			fail("Ocurrio un error al dar de alta la persona "+e);
		}
	}
	
	@Test
	public void listarPersonas() {
		 IPersonaDao personaDao = FactoryDao.getPersonaDAO();
		 try {
			 personaDao.limpiarTabla();
			 personaDao.alta(persona1);
			 personaDao.alta(persona2);
			 personaDao.alta(persona3);
			 List<Persona> personas = personaDao.recuperar();
			 assertThat(personas, hasSize(equalTo(3)));
		} catch (DAOException e) {
			fail("Ocurrio un error al listar las personas "+e);
		}
	}

}
