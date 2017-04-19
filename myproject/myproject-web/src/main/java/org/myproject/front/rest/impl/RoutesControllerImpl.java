package org.myproject.front.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.myproject.RoutesService;
import org.myproject.dto.RouteDTO;
import org.myproject.front.rest.RoutesController;
import org.myproject.persistence.entities.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class RoutesControllerImpl implements RoutesController {
	
	private RoutesService routesService;
	private Mapper mapper;
	
	
	@Autowired
	public RoutesControllerImpl(RoutesService routesService, Mapper mapper) {
		this.routesService = routesService;
		this.mapper = mapper;
	}


	@Override
	@RequestMapping(path = "/routes", method = RequestMethod.GET )
	public ResponseEntity<List<RouteDTO>> getAllRoutes() {
		List<Route> routes = routesService.getRoutes();
		List<RouteDTO> result = new ArrayList<>();
		for (Route route : routes) {
			result.add(mapper.map(route, RouteDTO.class));
		}
		
		//result = Arrays.asList(routes.stream().map(a -> mapper.map(a, RouteDTO.class)).toArray(RouteDTO[]::new));			

		
		
		if (result.isEmpty())
			return new ResponseEntity<List<RouteDTO>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<RouteDTO>>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.GET)
	public ResponseEntity<RouteDTO> getRoute(@RequestParam(value = "id", defaultValue = "1") String id) {

		Long idAsLong;
		if (id == null)
			return new ResponseEntity<RouteDTO>(HttpStatus.NOT_FOUND);

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return new ResponseEntity<RouteDTO>(HttpStatus.BAD_REQUEST);
		}

		Route route = routesService.getRoute(idAsLong);

		
		RouteDTO routeDTO = mapper.map(route, RouteDTO.class);
		
		if (route == null)
			return new ResponseEntity<RouteDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<RouteDTO>(routeDTO, HttpStatus.OK);
	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.POST)
	public ResponseEntity<Route> createRoute(@RequestBody Route Route) {
		if (Route == null)
			return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Route>(routesService.createRoute(Route), HttpStatus.CREATED);
	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.PUT)
	public ResponseEntity<Route> updateRoute(@RequestBody Route Route) {
		Route result = null;
		if (Route != null) {
			try {
				result = routesService.updateRoute(Route);
			} catch (Exception e) {
				return new ResponseEntity<Route>(result, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Route>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Route>(result, HttpStatus.NOT_FOUND);

	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRoute(@RequestParam(value = "id", defaultValue = "1") String id) {
		Long idAsLong;
		if (id == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}

		try {
			routesService.deleteRoute(idAsLong);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>( HttpStatus.OK);
	}

	
	

}
