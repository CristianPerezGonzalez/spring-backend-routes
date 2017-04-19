package org.myproject.web.test.core.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.myproject.RoutesService;
import org.myproject.persistence.entities.Route;

import junit.framework.TestCase;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
public class RoutesBusinessTest extends TestCase {

	private static final String NAME = "camino0";
	private RoutesService service;
	private Route Route;

	@Override
	protected void setUp() throws Exception {

		// this.service = Services.getRoutesService();

		List<Route> Routes = new ArrayList<Route>();

		for (int i = 0; i < 100; i++) {
			Routes.add((new Route("camino" + i)));
		}

		Route = new Route( "camino0");
		service = mock(RoutesService.class);
		when(service.getRoutes()).thenReturn(Routes);
		when(service.getRoute(new Long(1))).thenReturn(Route);

	}

	@Test
	public void testGetRoutes() throws Exception {

		List<Route> Routes = this.service.getRoutes();

		assertNotNull(Routes);

		assertTrue(Routes.size() > 0);

		assertEquals(Routes.get(0).getNameroute(), NAME);
		assertEquals(100, Routes.size());
	}

	@Test
	public void testGetRoute() throws Exception {

		Route Route = service.getRoute(new Long(1));

		assertNotNull(Route);
		assertEquals(NAME, Route.getNameroute());
	}

}
