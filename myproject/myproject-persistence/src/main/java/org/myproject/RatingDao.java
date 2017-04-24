package org.myproject;

import org.myproject.persistence.entities.Rating;
import org.myproject.persistence.entities.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.Integer;
import java.util.List;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @param <T>
 * @param <K>
 * @since 0.0.1
 */
@Repository
public interface RatingDao extends CrudRepository<Rating, Long> {
	@Query("Select d.route from Rating d left join d.route where stars=?1")
	List<Route> findByStars(Integer stars);
}
