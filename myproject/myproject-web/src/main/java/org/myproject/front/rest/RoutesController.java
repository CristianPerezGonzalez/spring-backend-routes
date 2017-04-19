package org.myproject.front.rest;

import java.util.List;

import org.myproject.dto.RouteDTO;
import org.myproject.persistence.entities.Route;
import org.springframework.http.ResponseEntity;


public interface RoutesController {

	/**
	 * Obtiene todas las Routes
	 * 
	 * @return lista de Routes
	 */
	public ResponseEntity<List<RouteDTO>> getAllRoutes();

	/**
	 * Create route
	 * 
	 * @param Route
	 * @return
	 */
	
	public ResponseEntity<Route> createRoute(Route Route);

	/**
	 * Read route
	 * 
	 * @param id
	 *            - id de la Route
	 * @return Route
	 */
	
	public ResponseEntity<RouteDTO> getRoute(String id);

	/**
	 * Update route
	 * 
	 * @param Route
	 * @return
	 */
	
	public ResponseEntity<Route> updateRoute(Route Route);

	/**
	 * Delete route
	 * 
	 * @param route
	 * @return
	 */
	
	public ResponseEntity<Void> deleteRoute(String id);

}
