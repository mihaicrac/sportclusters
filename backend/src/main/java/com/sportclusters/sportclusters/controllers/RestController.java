package com.sportclusters.sportclusters.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sportclusters.sportclusters.entity.User;
import com.sportclusters.sportclusters.repositories.UserRepository;
import com.sportclusters.sportclusters.repositories.UsersDao;

@org.springframework.web.bind.annotation.RestController

@Transactional
public class RestController {

	@Autowired
	UsersDao userDb;

	
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public void add(@RequestBody User user){
		userDb.create(user);
		System.out.println(userDb.getUserByName(user.getFirstName()).getId());
	}
	
}
