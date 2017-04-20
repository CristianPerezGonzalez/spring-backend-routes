package org.myproject.front.rest;

import org.myproject.dto.RouteDetailDTO;
import org.myproject.front.rest.exception.BadRequestException;
import org.myproject.front.rest.exception.NotFoundException;


public interface RoutesDetailController {

	

	
	/**
	 * Read route
	 * 
	 * @param id
	 *            - id de la Route
	 * @return Route
	 * @throws BadRequestException 
	 * @throws NotFoundException 
	 */
	
	public RouteDetailDTO getRouteDetail(String id) throws BadRequestException, NotFoundException;

	

}
