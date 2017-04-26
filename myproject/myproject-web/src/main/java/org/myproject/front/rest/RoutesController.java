package org.myproject.front.rest;

import java.util.List;

import org.myproject.dto.MarkerDTO;
import org.myproject.dto.RouteDTO;
import org.myproject.front.rest.exception.BadRequestException;
import org.myproject.front.rest.exception.NoContentException;
import org.myproject.front.rest.exception.NotFoundException;
import org.myproject.persistence.entities.Route;
import org.myproject.persistence.entities.RouteType;


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
	
	/**Obtiene markers por ruta
	 * @param route_id
	 * @return
	 * @throws BadRequestException 
	 * @throws NoContentException 
	 */
	public List<MarkerDTO> getMarkersByRoute(String route_id) throws BadRequestException, NoContentException;
	
	/**Obtiene lista de rutas por valoracion
	 * @param stars
	 * @return
	 * @throws NoContentException 
	 */
	public List<RouteDTO> getRoutesByRouteType(RouteType routetype) throws NoContentException;
	
	/**Obtiene lista de rutas por valoracion
	 * @param stars
	 * @return
	 * @throws NoContentException 
	 * @throws BadRequestException 
	 */
	public List<RouteDTO> getRoutesByStars(String stars) throws NoContentException, BadRequestException;
	
	
	/**Obtiene lista de rutas por dificultad
	 * @param stars
	 * @return
	 * @throws NoContentException 
	 * @throws BadRequestException 
	 */
	public List<RouteDTO> getRoutesByDifficulty(String difficulty) throws NoContentException, BadRequestException;
	
	/**Obtiene lista de rutas por distancia
	 * @param stars
	 * @return
	 * @throws NoContentException 
	 * @throws BadRequestException 
	 */
	public List<RouteDTO> getRoutesByDistance(String distance) throws NoContentException, BadRequestException;
	
	/**Obtiene lista de rutas por duracion
	 * @param stars
	 * @return
	 * @throws NoContentException 
	 * @throws BadRequestException 
	 */
	public List<RouteDTO> getRoutesByDuration(String duration) throws NoContentException, BadRequestException;

}
