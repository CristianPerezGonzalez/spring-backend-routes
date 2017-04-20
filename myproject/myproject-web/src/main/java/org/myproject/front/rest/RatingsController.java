package org.myproject.front.rest;

import java.util.List;

import org.myproject.dto.RatingDTO;
import org.myproject.front.rest.exception.BadRequestException;
import org.myproject.front.rest.exception.NoContentException;
import org.myproject.front.rest.exception.NotFoundException;
import org.myproject.persistence.entities.Rating;


public interface RatingsController {

	/**
	 * Obtiene todas las Ratings
	 * 
	 * @return lista de Ratings
	 * @throws NoContentException 
	 */
	
	public List<RatingDTO> getAllRatings() throws NoContentException;

	/**
	 * Create Rating
	 * 
	 * @param Rating
	 * @return
	 * @throws NotFoundException 
	 */
	
	public RatingDTO createRating(Rating Rating) throws NotFoundException;

	/**
	 * Read Rating
	 * 
	 * @param id
	 *            - id de la Rating
	 * @return Rating
	 * @throws NotFoundException 
	 * @throws BadRequestException 
	 */
	
	public RatingDTO getRating(String id) throws NotFoundException, BadRequestException;

	/**
	 * Update Rating
	 * 
	 * @param Rating
	 * @return
	 * @throws NotFoundException 
	 */
	
	public RatingDTO updateRating(Rating Rating) throws NotFoundException;

	/**
	 * Delete Rating
	 * 
	 * @param Rating
	 * @return
	 * @throws BadRequestException 
	 * @throws NotFoundException 
	 */
	
	public void deleteRating(String id) throws BadRequestException, NotFoundException;

}
