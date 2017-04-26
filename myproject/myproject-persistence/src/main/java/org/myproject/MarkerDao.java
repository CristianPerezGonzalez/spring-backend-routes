package org.myproject;

import java.util.List;

import org.myproject.persistence.entities.Marker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @param <T>
 * @param <K>
 * @since 0.0.1
 */
@Repository
public interface MarkerDao extends CrudRepository<Marker, Long> {

	List<Marker> findByRoute_id(Long route_id);
	
	
}
