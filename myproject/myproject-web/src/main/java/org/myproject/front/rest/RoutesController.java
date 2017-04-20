package org.myproject.front.rest;

import java.util.List;

import org.myproject.dto.RouteDTO;
import org.myproject.front.rest.exception.BadRequestException;
import org.myproject.front.rest.exception.NoContentException;
import org.myproject.front.rest.exception.NotFoundException;
import org.myproject.persistence.entities.Route;


public interface RoutesController {

	/**
	 * Obtiene todas las Routes
	 * 
	 * @return lista de Routes
	 * @throws NoContentException 
	 */
	public List<RouteDTO> getAllRoutes() throws NoContentException;

	/**
	 * Create route
	 * 
	 * @param Route
	 * @return
	 * @throws NotFoundException 
	 */
	
	public RouteDTO createRoute(Route Route) throws NotFoundException;

	/**
	 * Read route
	 * 
	 * @param id
	 *            - id de la Route
	 * @return Route
	 * @throws NotFoundException 
	 * @throws BadRequestException 
	 */
	
	public RouteDTO getRoute(String id) throws NotFoundException, BadRequestException;

	/**
	 * Update route
	 * 
	 * @param Route
	 * @return
	 * @throws NotFoundException 
	 */
	
	public RouteDTO updateRoute(Route Route) throws NotFoundException;

	/**
	 * Delete route
	 * 
	 * @param route
	 * @return
	 * @throws BadRequestException 
	 * @throws NotFoundException 
	 */
	
	public void deleteRoute(String id) throws BadRequestException, NotFoundException;

}
