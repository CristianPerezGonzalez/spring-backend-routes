package org.myproject.front.rest.impl;

import org.dozer.Mapper;
import org.myproject.RoutesService;
import org.myproject.dto.RouteDetailDTO;
import org.myproject.front.rest.RoutesDetailController;
import org.myproject.front.rest.exception.BadRequestException;
import org.myproject.front.rest.exception.NotFoundException;
import org.myproject.persistence.entities.RouteDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class RoutesDetailControllerImpl implements RoutesDetailController {
	
	private RoutesService routesService;
	private Mapper mapper;
	
	
	@Autowired
	public RoutesDetailControllerImpl(RoutesService routesService, Mapper mapper) {
		this.routesService = routesService;
		this.mapper = mapper;
	}


	

	@Override
	@RequestMapping(path = "/routedetail", method = RequestMethod.GET)
	public RouteDetailDTO getRouteDetail(@RequestParam(value = "id", defaultValue = "1") String id) throws BadRequestException, NotFoundException {

		Long idAsLong;
		if (id == null)
			throw new BadRequestException("El detalle de la ruta introucido está vacío");

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new BadRequestException("El id introducido no es correcto");
		}

		RouteDetail routeDetail = routesService.getRoutesDetail(idAsLong);

		
		RouteDetailDTO routeDTO = mapper.map(routeDetail, RouteDetailDTO.class);
		
		if (routeDetail == null)
			throw new NotFoundException("No existe el detalle de la ruta " + routeDetail);
		return routeDTO;
	}

	

	
	

}
