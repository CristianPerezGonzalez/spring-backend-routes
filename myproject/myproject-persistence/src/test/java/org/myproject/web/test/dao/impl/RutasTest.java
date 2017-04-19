package org.myproject.web.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.myproject.RutaDao;
import org.myproject.persistence.entities.Route;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import junit.framework.TestCase;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@SuppressWarnings("javadoc")
public class RutasTest extends TestCase {

	@Autowired
	RutaDao dao;

	@Override
	@BeforeClass
	public void setUp() throws Exception {

		

		List<Route> rutas = new ArrayList<Route>();

		for (int i = 0; i < 100; i++) {
			rutas.add(new Route( "ruta" + i));
		}

		// when(rutaDao.save(ruta)).then(new Long(rutas.size()+1));
	}

	@Test
	public void testSave() throws Exception {

		List<Route> rutas = Lists.newArrayList(  this.dao.findAll());

		int sizeAntes = rutas.size();
		for (int i = 100; i < 200; i++) {
			this.dao.save(new Route( "ruta" + i));
		}

		rutas = Lists.newArrayList(this.dao.findAll());

		int sizeDespues = rutas.size();

		Assert.assertEquals(sizeAntes + 100, sizeDespues);
	}

	@Test
	public void testUpdate() throws Exception {

		List<Route> rutasAntes = Lists.newArrayList(this.dao.findAll());
		List<Route> rutasActualizadas = new ArrayList<Route>();

		for (Route ruta : rutasAntes) {
			rutasActualizadas.add(ruta);
			this.dao.save(ruta);
		}

		List<Route> rutasDespues = Lists.newArrayList(this.dao.findAll());
		Assert.assertEquals(rutasActualizadas, rutasDespues);
	}

	@Test
	public void testDelete() throws Exception {

		List<Route> rutasAntes = Lists.newArrayList(this.dao.findAll());
		for (Route ruta : rutasAntes) {
			this.dao.delete(ruta.getId());
		}
		List<Route> rutasDespues = Lists.newArrayList(this.dao.findAll());
		assertEquals(0, rutasDespues.size());
	}

	@Test
	public void testFindById() throws Exception {

		List<Route> rutas = Lists.newArrayList(this.dao.findAll());

		int sizeAntes = rutas.size();

		for (int i = 1; i <= sizeAntes; i++) {
			assertEquals(rutas.get(i - 1), this.dao.findOne((long) i));
		}

	}

	@Test
	public void testFindAll() throws Exception {

		List<Route> rutas = Lists.newArrayList(this.dao.findAll());
		int size = rutas.size();
		assertEquals(100, size);
	}
}
