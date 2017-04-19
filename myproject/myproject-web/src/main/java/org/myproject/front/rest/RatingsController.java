package org.myproject.front.rest;

import java.util.List;

import org.myproject.persistence.entities.Rating;
import org.springframework.http.ResponseEntity;


public interface RatingsController {

	/**
	 * Obtiene todas las Ratings
	 * 
	 * @return lista de Ratings
	 */
	
	public ResponseEntity<List<Rating>> getAllRatings();

	/**
	 * Create Rating
	 * 
	 * @param Rating
	 * @return
	 */
	
	public ResponseEntity<Rating> createRating(Rating Rating);

	/**
	 * Read Rating
	 * 
	 * @param id
	 *            - id de la Rating
	 * @return Rating
	 */
	
	public ResponseEntity<Rating> getRating(String id);

	/**
	 * Update Rating
	 * 
	 * @param Rating
	 * @return
	 */
	
	public ResponseEntity<Rating> updateRating(Rating Rating);

	/**
	 * Delete Rating
	 * 
	 * @param Rating
	 * @return
	 */
	
	public ResponseEntity<Void> deleteRating(String id);

}
