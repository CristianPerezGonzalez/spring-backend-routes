package org.myproject.front.rest;

import org.myproject.dto.RouteDetailDTO;
import org.springframework.http.ResponseEntity;


public interface RoutesDetailController {

	

	
	/**
	 * Read route
	 * 
	 * @param id
	 *            - id de la Route
	 * @return Route
	 */
	
	public ResponseEntity<RouteDetailDTO> getRouteDetail(String id);

	

}
