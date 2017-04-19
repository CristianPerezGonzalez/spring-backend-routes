package org.myproject.core.impl;

import org.myproject.UserDao;
import org.myproject.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersServiceImpl implements UsersService {

	private UserDao userDao;

	@Autowired
	public UsersServiceImpl(UserDao userDao) {
		this.userDao = userDao;
		
	}

	
}
