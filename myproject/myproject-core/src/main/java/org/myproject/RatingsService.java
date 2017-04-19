package org.myproject;

import java.util.List;

import org.myproject.persistence.entities.Rating;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */

public interface RatingsService {
	/**
	 * Obtiene las Ratings
	 * 
	 * @return lista de Ratings @
	 */
	public List<Rating> getRatings();

	/**
	 * Crea una Rating
	 * 
	 * @param Rating
	 * @return el Id de la Rating creada @
	 */
	public Rating createRating(Rating Rating);

	/**
	 * Actualiza una Rating
	 * 
	 * @param Rating
	 * @return el Id de la Rating actualizada @
	 * @throws Exception 
	 */
	public Rating updateRating(Rating Rating) throws Exception;

	/**
	 * Elimina una Rating
	 * 
	 * @param Rating
	 * @return el Id de la Rating actualizada @
	 * @throws Exception 
	 */
	public void deleteRating(Long id) throws Exception;

	/**
	 * Obtiene una Rating
	 * 
	 * @param Id
	 *            - id de la Rating a obtener
	 * @return la Rating @
	 */
	public Rating getRating(Long Id);

}
