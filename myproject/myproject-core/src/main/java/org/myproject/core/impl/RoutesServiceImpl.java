package org.myproject.core.impl;

import java.util.List;

import org.myproject.RouteDetailDao;
import org.myproject.RouteTypeDao;
import org.myproject.RoutesService;
import org.myproject.RutaDao;
import org.myproject.persistence.entities.Route;
import org.myproject.persistence.entities.RouteDetail;
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
	private RouteTypeDao routeTypeDao;

	@Autowired
	public RoutesServiceImpl(RutaDao rutaDao, RouteDetailDao routeDetailDao, RouteTypeDao routeTypeDao ) {
		this.rutaDao = rutaDao;
		this.rutaDetailDao = routeDetailDao;
		this.routeTypeDao = routeTypeDao;
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
	public RouteDetail getRoutesDetail(Long id) {
		return  this.rutaDetailDao.findOne(id);
	}

}
