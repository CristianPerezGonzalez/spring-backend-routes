package org.myproject.front.rest.impl;

import java.util.List;

import org.myproject.RatingsService;
import org.myproject.front.rest.RatingsController;
import org.myproject.persistence.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@Autowired
	public RatingsControllerImpl(RatingsService ratingsService) {
		this.ratingsService = ratingsService;
	}


	@Override
	@RequestMapping(path = "/ratings", method = RequestMethod.GET)
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> Ratings = ratingsService.getRatings();

		if (Ratings.isEmpty())
			return new ResponseEntity<List<Rating>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Rating>>(Ratings, HttpStatus.OK);
	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.GET)
	public ResponseEntity<Rating> getRating(@RequestParam(value = "id", defaultValue = "1") String id) {

		Long idAsLong;
		if (id == null)
			return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return new ResponseEntity<Rating>(HttpStatus.BAD_REQUEST);
		}

		Rating Rating = ratingsService.getRating(idAsLong);

		if (Rating == null)
			return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Rating>(Rating, HttpStatus.OK);
	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.POST)
	public ResponseEntity<Rating> createRating(@RequestBody Rating Rating) {
		if (Rating == null)
			return new ResponseEntity<Rating>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Rating>(ratingsService.createRating(Rating), HttpStatus.CREATED);
	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.PUT)
	public ResponseEntity<Rating> updateRating(@RequestBody Rating Rating) {
		Rating result = null;
		if (Rating != null) {
			try {
				result = ratingsService.updateRating(Rating);
			} catch (Exception e) {
				return new ResponseEntity<Rating>(result, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Rating>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Rating>(result, HttpStatus.NOT_FOUND);

	}

	@Override
	@RequestMapping(path = "/rating", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRating(@RequestParam(value = "id", defaultValue = "1") String id) {
		Long idAsLong;
		if (id == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		try {
			idAsLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}

		try {
			ratingsService.deleteRating(idAsLong);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Void>( HttpStatus.OK);
	}

	
	

}
