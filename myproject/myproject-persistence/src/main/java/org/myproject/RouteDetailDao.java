package org.myproject;

import java.util.List;

import org.myproject.persistence.entities.Routedetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.lang.Integer;
import java.lang.Long;

import org.myproject.persistence.entities.Route;
import org.myproject.persistence.entities.RouteType;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @param <T>
 * @param <K>
 * @since 0.0.1
 */
@Repository
public interface RouteDetailDao extends CrudRepository<Routedetail, Long> {

	Routedetail findByRoute_id(Long route_id);
	@Query("Select d.route from Routedetail d left join d.route where difficulty=?1")
	List<Route> findByDifficulty(Integer difficulty);
	@Query("Select d.route from Routedetail d left join d.route where coordinates=?1")
	List<Route> findByCoordinates(String coordinates);
	@Query("Select d.route from Routedetail d left join d.route where distance=?1")
	List<Route> findByDistance(double distance);
	@Query("Select d.route from Routedetail d left join d.route where duration=?1")
	List<Route> findByDuration(Integer duration);
	List<Route> findById(Long id);
	@Query("Select d.route from Routedetail d left join d.route where description=?1")
	List<Route> findByDescription(String description);
	@Query("Select d.route from Routedetail d left join d.route where routetype=?1")
	List<Route> findByRoutetype(RouteType routetype);
	
}
