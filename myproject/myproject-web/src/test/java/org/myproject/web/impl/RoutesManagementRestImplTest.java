package org.myproject.web.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.myproject.RoutesService;
import org.myproject.dto.RouteDTO;
import org.myproject.front.rest.impl.RoutesControllerImpl;
import org.myproject.persistence.entities.Route;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

public class RoutesManagementRestImplTest {

	private RoutesService routesService;
	private Mapper mapper;

	private MockMvc mockMvc;

	Gson gson;
	String json;

	Route route;
	private List<Route> routes;

	@Before
	public void setUp() {
		routes = new ArrayList<Route>();

		for (int i = 0; i < 100; i++) {
			routes.add((new Route( "camino" + i)));
		}

		route = new Route( "camino0");
		

		gson = new Gson();
		json = gson.toJson(route);

		routesService = mock(RoutesService.class);
		mapper = mock(Mapper.class);
		
		
		mockMvc = MockMvcBuilders.standaloneSetup(new RoutesControllerImpl(routesService,mapper)).build();
		
		//when
		when(routesService.getRoutes()).thenReturn(routes);
		when(routesService.getRoute(new Long(1))).thenReturn(route);
		
		
		
	}

	@Test
	public void testGetRoute() throws Exception {
		//given
		Route route = new Route( "camino0");
		RouteDTO  dto = new RouteDTO();
		dto.setId(route.getId());
		dto.setName(route.getNameroute());
		
		//when
		when(mapper.map(route, RouteDTO.class)).thenReturn(dto);
		
		//then			
		mockMvc.perform(get("/route").param("id", "1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("camino0"));
	}

	@Test
	public void testGetRoutes() throws Exception {
		
		//given y when
		RouteDTO  dto;
		for (Route route : routes) {
			dto = new RouteDTO();
			dto.setId(route.getId());
			dto.setName(route.getNameroute());
			when(mapper.map(route, RouteDTO.class)).thenReturn(dto);
		}
		
		//then
		
		MockHttpServletRequestBuilder requestBuilder = get("/routes");
		mockMvc.perform(requestBuilder.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				
				.andExpect(jsonPath("$.[0].name").value("camino0"));
	}

	@Test
	public void testCreateRoute() throws Exception {
		mockMvc.perform(post("/route").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void testUpdateRoute() throws Exception {
		mockMvc.perform(put("/route").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json)).andExpect(status().isOk());
	}

	@Test
	public void testDeleteRoute() throws Exception {
		mockMvc.perform(delete("/route").param("id", "1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				;
	}

}
