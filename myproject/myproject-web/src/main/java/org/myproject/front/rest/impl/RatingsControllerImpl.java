package org.myproject.front.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.myproject.RatingsService;
import org.myproject.dto.RatingDTO;
import org.myproject.front.rest.RatingsController;
import org.myproject.front.rest.exception.BadRequestException;
import org.myproject.front.rest.exception.NoContentException;
import org.myproject.front.rest.exception.NotFoundException;
import org.myproject.persistence.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class RatingsControllerImpl implements RatingsController {
	
	private RatingsService ratingsService;
	private Mapper mapper;
	@Autowired
	public RatingsControllerImpl(RatingsService ratingsService, Mapper mapper) {
		this.ratingsService = ratingsService;
		this.mapper = mapper;
	}


	@Override
	@RequestMapping(path = "/ratings", method = RequestMethod.GET)
	public List<RatingDTO> getAllRatings() throws NoContentException {
		List<Rating> ratings = ratingsService.getRatings();
		List<RatingDTO> result = new ArrayList<>();
		for (Rating rating : ratings) {
			result.add(mapper.map(rating, RatingDTO.class));
		}	
		if (ratings.isEmpty())
			throw new NoContentException("No hay valoraciones");

		return result;
	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.GET)
	public RatingDTO getRating(@RequestParam(value = "id", defaultValue = "1") String id) throws NotFoundException, BadRequestException {

		Long idAsLong;
		if (id == null)
			throw new NotFoundException("No existe la valoracion con id =" + id);

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new BadRequestException("El id introducido no es correcto");
		}

		Rating rating = ratingsService.getRating(idAsLong);
		RatingDTO ratingDTO = mapper.map(rating, RatingDTO.class);
		if (rating == null)
			throw new BadRequestException("La valoracion introucida está vacía");
		return ratingDTO;
	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.POST)
	public RatingDTO createRating(@RequestBody Rating rating) throws NotFoundException {
		if (rating == null)
			throw new NotFoundException("La valoracion introucida está vacía");
		Rating result = ratingsService.createRating(rating);
		RatingDTO ratingDTO = mapper.map(result, RatingDTO.class);
		return ratingDTO;
	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.PUT)
	public RatingDTO updateRating(@RequestBody Rating rating) throws NotFoundException {
		Rating result = null;
		if (rating != null) {
			try {
				result = ratingsService.updateRating(rating);
			} catch (Exception e) {
				throw new NotFoundException("No existe la valoracion");
			}
			RatingDTO ratingDTO = mapper.map(result, RatingDTO.class);

			return ratingDTO;
		}else
			throw new NotFoundException("No existe la valoracion " + rating);


	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.DELETE)
	public void deleteRating(@RequestParam(value = "id", defaultValue = "1") String id) throws BadRequestException, NotFoundException {
		Long idAsLong;
		if (id == null)
			throw new BadRequestException("La ruta valoracion está vacía");

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new BadRequestException("El id introducido no es correcto");
		}

		try {
			ratingsService.deleteRating(idAsLong);
		} catch (Exception e) {
			throw new NotFoundException("No existe la valoracion con id =" + id);
		}

		
	}

	
	

}
