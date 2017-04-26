package org.myproject.core.impl;

import java.util.List;

import org.myproject.MarkerDao;
import org.myproject.RatingDao;
import org.myproject.RouteDetailDao;
import org.myproject.RoutesService;
import org.myproject.RutaDao;
import org.myproject.persistence.entities.Marker;
import org.myproject.persistence.entities.Route;
import org.myproject.persistence.entities.RouteType;
import org.myproject.persistence.entities.Routedetail;
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
public class RoutesServiceImpl implements RoutesService {
	
	
	private RutaDao rutaDao;
	private RouteDetailDao rutaDetailDao;
	private RatingDao ratingDao;
	private MarkerDao markerDao;

	@Autowired
	public RoutesServiceImpl(RutaDao rutaDao, RouteDetailDao routeDetailDao, RatingDao ratingdao, MarkerDao markerDao ) {
		this.rutaDao = rutaDao;
		this.rutaDetailDao = routeDetailDao;
		this.ratingDao = ratingdao;
		this.markerDao = markerDao;
	}

	@Override
	public List<Route> getRoutes() {

		return Lists.newArrayList(rutaDao.findAll());
	}

	@Override
	public Route createRoute(Route Route) {
		rutaDao.save(Route);
		return Route;
	}

	@Override
	public Route getRoute(Long Id) {
		return rutaDao.findOne(Id);
	}

	@Override
	public Route updateRoute(Route Route) throws Exception {
		return rutaDao.save(Route);
	}

	@Override
	public void deleteRoute(Long id) throws Exception {
		 rutaDao.delete(id);
	}

	@Override
	public Routedetail getRoutesDetail(Long id) {
		return  this.rutaDetailDao.findOne(id);
	}

	@Override
	public List<Route> getRoutesByStars(Integer stars) {
		return this.ratingDao.findByStars(stars);
	}

	@Override
	public List<Route> getRoutesByDifficulty(Integer difficulty) {
		return this.rutaDetailDao.findByDifficulty(difficulty);
	}

	@Override
	public List<Route> getRoutesByDistance(double distance) {
		return this.rutaDetailDao.findByDistance(distance);
	}

	@Override
	public List<Route> getRoutesByDuration(Integer duration) {
		return this.rutaDetailDao.findByDuration(duration);
	}

	@Override
	public List<Route> getRoutesByRouteType(RouteType routetype) {
		return this.rutaDetailDao.findByRoutetype(routetype);
	}

	@Override
	public List<Marker> getMarkersByRoute(Long route_id) {
		return this.markerDao.findByRoute_id(route_id);
	}

	@Override
	public Marker createMarker(Marker marker) {
		return this.markerDao.save(marker);
	}

}
