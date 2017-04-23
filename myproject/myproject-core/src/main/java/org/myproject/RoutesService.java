package org.myproject;

import java.util.List;

import org.myproject.persistence.entities.Route;
import org.myproject.persistence.entities.Routedetail;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */

public interface RoutesService {
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
