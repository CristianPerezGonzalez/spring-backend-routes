package org.myproject;

import org.myproject.persistence.entities.RouteType;
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
public interface RouteTypeDao extends CrudRepository<RouteType, Long> {

}
