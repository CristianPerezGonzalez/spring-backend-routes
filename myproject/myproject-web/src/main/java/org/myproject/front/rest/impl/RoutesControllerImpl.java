package org.myproject.front.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.myproject.RoutesService;
import org.myproject.dto.RouteDTO;
import org.myproject.front.rest.RoutesController;
import org.myproject.front.rest.exception.BadRequestException;
import org.myproject.front.rest.exception.NoContentException;
import org.myproject.front.rest.exception.NotFoundException;
import org.myproject.persistence.entities.Route;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<RouteDTO> getAllRoutes() throws NoContentException {
		List<Route> routes = routesService.getRoutes();
		List<RouteDTO> result = new ArrayList<>();
		for (Route route : routes) {
			result.add(mapper.map(route, RouteDTO.class));
		}		
		
		
		if (result.isEmpty())
			throw new NoContentException("No hay rutas");

		return result;
	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.GET)
	public RouteDTO getRoute(@RequestParam(value = "id", defaultValue = "1") String id) throws NotFoundException, BadRequestException {


		
		Long idAsLong;
		if (id == null)
			throw new NotFoundException("No existe la ruta con id =" + id);

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new BadRequestException("El id introducido no es correcto");
		}

		Route route = routesService.getRoute(idAsLong);

		
		RouteDTO routeDTO = mapper.map(route, RouteDTO.class);
		
		if (route == null)
			throw new BadRequestException("La ruta introucida está vacía");
		return routeDTO;
	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.POST)
	public RouteDTO createRoute(@RequestBody Route route) throws NotFoundException {
		if (route == null)
			throw new NotFoundException("La ruta introucida está vacía");
		Route result = routesService.createRoute(route);
		
		RouteDTO routeDTO = mapper.map(result, RouteDTO.class);

		
		return routeDTO;
	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.PUT)
	public RouteDTO updateRoute(@RequestBody Route route) throws NotFoundException {
		Route result = null;
		if (route != null) {
				try {
					result = routesService.updateRoute(route);
				} catch (Exception e) {
					throw new NotFoundException("No existe la ruta");
				}
				RouteDTO routeDTO = mapper.map(result, RouteDTO.class);

			return routeDTO;
		}else
			throw new NotFoundException("No existe la ruta " + route);


	}

	@Override
	@RequestMapping(path = "/route", method = RequestMethod.DELETE)
	public void deleteRoute(@RequestParam(value = "id", defaultValue = "1") String id) throws BadRequestException, NotFoundException {
		Long idAsLong;
		if (id == null)
			throw new BadRequestException("La ruta introucida está vacía");

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new BadRequestException("El id introducido no es correcto");
		}

		try {
			routesService.deleteRoute(idAsLong);
		} catch (Exception e) {
			throw new NotFoundException("No existe la ruta con id =" + id);
		}

		
	}

	
	

}
