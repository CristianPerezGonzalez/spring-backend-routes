package org.myproject.front.rest.impl;

import org.dozer.Mapper;
import org.myproject.RoutesService;
import org.myproject.dto.RouteDetailDTO;
import org.myproject.front.rest.RoutesDetailController;
import org.myproject.persistence.entities.RouteDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<RouteDetailDTO> getRouteDetail(@RequestParam(value = "id", defaultValue = "1") String id) {

		Long idAsLong;
		if (id == null)
			return new ResponseEntity<RouteDetailDTO>(HttpStatus.NOT_FOUND);

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return new ResponseEntity<RouteDetailDTO>(HttpStatus.BAD_REQUEST);
		}

		RouteDetail route = routesService.getRoutesDetail(idAsLong);

		
		RouteDetailDTO routeDTO = mapper.map(route, RouteDetailDTO.class);
		
		if (route == null)
			return new ResponseEntity<RouteDetailDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<RouteDetailDTO>(routeDTO, HttpStatus.OK);
	}

	

	
	

}
