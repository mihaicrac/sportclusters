package com.sportclusters.sportclusters.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sportclusters.sportclusters.entity.Event;
import com.sportclusters.sportclusters.errors.EntityNotFoundException;
import com.sportclusters.sportclusters.security.UserAddRequest;
import com.sportclusters.sportclusters.security.JwtUser;
import com.sportclusters.sportclusters.repositories.AuthorityRepository;
import com.sportclusters.sportclusters.security.service.JwtAuthenticationResponse;
import com.sportclusters.sportclusters.services.eventService.model.EventAddReq;
import com.sportclusters.sportclusters.services.eventService.EventServiceImpl;
import com.sportclusters.sportclusters.services.userService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.sportclusters.sportclusters.userUpdateReq;
import com.sportclusters.sportclusters.security.JwtTokenUtil;
import com.sportclusters.sportclusters.entity.User;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private EventServiceImpl eventService;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;



	@RequestMapping(method = RequestMethod.POST)
	public JwtAuthenticationResponse addUser(@RequestBody UserAddRequest regReq){

		User u = userService.addUser(regReq);

		final UserDetails userDetails = userService.loadUserByUsername(u.getUsername());
		final String token = jwtTokenUtil.generateToken((JwtUser)userDetails);

		// Return the token
		return new JwtAuthenticationResponse(token);
	}


	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@Valid @RequestBody userUpdateReq user){
		return userService.updateUser(user);
	}


	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") UUID id) {

		return userService.findUser(id);
	}


	@RequestMapping(value = "/api/events", method = RequestMethod.POST)
	public Event addEvent(@Valid @RequestBody EventAddReq event) throws EntityNotFoundException {

		return eventService.addEvent(event);
	}


	//TODO modify this when you make filtering, also good is a good ideea to find out how you can bypass security check
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public Boolean existsEmail(@NotNull @PathVariable("email") String email) {
		return userService.existsEmail(email);
	}


	//TODO modify this when you make filtering, also good is a good ideea to find out how you can bypass security check
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public Boolean existsUsername(@NotNull @PathVariable("username") String username) {
		return userService.existsUsername(username);
	}

}
