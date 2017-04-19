package org.myproject.persistence.config;

import org.myproject.RatingDao;
import org.myproject.RouteDetailDao;
import org.myproject.RutaDao;
import org.myproject.UserDao;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses =
	{RatingDao.class,
	RutaDao.class,
	RouteDetailDao.class,
	RouteDetailDao.class,
	UserDao.class})
public class PersistenceConfiguration {

}
