package org.myproject;

import java.util.List;

import org.myproject.persistence.entities.Rating;
import org.myproject.persistence.entities.Route;
import org.springframework.data.jpa.repository.Query;
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
public interface RutaDao extends CrudRepository<Route, Long> {

	
	
	
}
