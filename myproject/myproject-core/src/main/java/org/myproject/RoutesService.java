package org.myproject;

import java.util.List;

import org.myproject.persistence.entities.Marker;
import org.myproject.persistence.entities.Route;
import org.myproject.persistence.entities.RouteType;
import org.myproject.persistence.entities.Routedetail;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */

public interface RoutesService {
	
	/**Lista de markers por ruta
	 * @param id
	 * @return
	 */
	public List<Marker> getMarkersByRoute(Long route_id);
	
	/**Crea markers
	 * @param marker
	 * @return marker
	 */
	public Marker createMarker(Marker marker);
	
	/**Obtiene lista de rutas por valoracion
	 * @param stars
	 * @return
	 */
	public List<Route> getRoutesByRouteType(RouteType routetype);
	
	/**Obtiene lista de rutas por valoracion
	 * @param stars
	 * @return
	 */
	public List<Route> getRoutesByStars(Integer stars);
	
	
	/**Obtiene lista de rutas por dificultad
	 * @param stars
	 * @return
	 */
	public List<Route> getRoutesByDifficulty(Integer difficulty);
	
	/**Obtiene lista de rutas por distancia
	 * @param stars
	 * @return
	 */
	public List<Route> getRoutesByDistance(double distance);
	
	/**Obtiene lista de rutas por duracion
	 * @param stars
	 * @return
	 */
	public List<Route> getRoutesByDuration(Integer duration);
	/**
	 * Obtiene las Routes
	 * 
	 * @return lista de Routes @
	 */
	public List<Route> getRoutes();
	
	
	/**
	 * @return
	 */
	public Routedetail getRoutesDetail(Long id);

	/**
	 * Crea una Route
	 * 
	 * @param Route
	 * @return el Id de la Route creada @
	 */
	public Route createRoute(Route Route);

	/**
	 * Actualiza una Route
	 * 
	 * @param Route
	 * @return el Id de la Route actualizada @
	 * @throws Exception 
	 */
	public Route updateRoute(Route Route) throws Exception;

	/**
	 * Elimina una Route
	 * 
	 * @param Route
	 * @return el Id de la Route actualizada @
	 * @throws Exception 
	 */
	public void deleteRoute(Long id) throws Exception;

	/**
	 * Obtiene una Route
	 * 
	 * @param Id
	 *            - id de la Route a obtener
	 * @return la Route @
	 */
	public Route getRoute(Long Id);

}
