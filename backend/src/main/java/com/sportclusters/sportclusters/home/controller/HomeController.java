package com.sportclusters.sportclusters.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sportclusters.sportclusters.security.JwtTokenUtil;
import com.sportclusters.sportclusters.security.model.User;
import com.sportclusters.sportclusters.security.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	private UserRepository userRepo;
	
	@Value("${jwt.header}")
    private String tokenHeader;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	

	@RequestMapping(value = "/api/userDetails", method = RequestMethod.GET)
	public String userdetails(HttpServletRequest request) {

		String authToken = request.getHeader(this.tokenHeader);

		if (authToken != null && authToken.startsWith("Bearer ")) {
			authToken = authToken.substring(7);
		}

		String username = jwtTokenUtil.getUsernameFromToken(authToken);
		User u = userRepo.findByUsername(username);

		String id = jwtTokenUtil.getIdFromToken(authToken);
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("username", u.getUsername());
			obj.put("firstname", u.getFirstname());
			obj.put("lastname", u.getLastname());
			obj.put("email", u.getEmail());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj.toString();
	}
	
	
}
