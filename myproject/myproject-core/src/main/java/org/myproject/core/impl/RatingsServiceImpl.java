package org.myproject.core.impl;

import java.util.List;

import org.myproject.RatingDao;
import org.myproject.RatingsService;
import org.myproject.persistence.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class RatingsServiceImpl implements RatingsService {
	
	
	private RatingDao dao;

	@Autowired
	public RatingsServiceImpl(RatingDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Rating> getRatings() {

		return Lists.newArrayList(dao.findAll());
	}

	@Override
	public Rating createRating(Rating Rating) {
		dao.save(Rating);
		return Rating;
	}

	@Override
	public Rating getRating(Long Id) {
		return dao.findOne(Id);
	}

	@Override
	public Rating updateRating(Rating Rating) throws Exception {
		return dao.save(Rating);
	}

	@Override
	public void deleteRating(Long id) throws Exception {
		 dao.delete(id);
	}

}
