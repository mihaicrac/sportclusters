package com.sportclusters.sportclusters.org.zerhusen.security.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sportclusters.sportclusters.org.zerhusen.model.security.Authority;
import com.sportclusters.sportclusters.org.zerhusen.model.security.AuthorityName;
import com.sportclusters.sportclusters.org.zerhusen.model.security.User;
import com.sportclusters.sportclusters.org.zerhusen.security.JwtAuthenticationRequest;
import com.sportclusters.sportclusters.org.zerhusen.security.JwtRegisterRequest;
import com.sportclusters.sportclusters.org.zerhusen.security.JwtTokenUtil;
import com.sportclusters.sportclusters.org.zerhusen.security.JwtUser;
import com.sportclusters.sportclusters.org.zerhusen.security.repository.AuthorityRepository;
import com.sportclusters.sportclusters.org.zerhusen.security.repository.UserRepository;
import com.sportclusters.sportclusters.org.zerhusen.security.service.JwtAuthenticationResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthorityRepository authRepo;
    
    
    @Autowired
    private UserRepository userRepo;
    
    

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody JwtRegisterRequest regReq, Device device){
    	
    	User u = new User();
    	u.setFirstname(regReq.getFirstName());
    	u.setLastname(regReq.getLastName());
    	u.setEmail(regReq.getEmail());
    	u.setPassword(regReq.getPassword());
    	
    	Authority a = authRepo.findByName(AuthorityName.ROLE_USER);
    	List<Authority> l = new ArrayList<Authority>();
    	l.add(a);
    	
    	u.setAuthorities(l);
    	u.setEnabled(true);
    	u.setLastPasswordResetDate(new Date());
    	userRepo.save(u);
    	
    	
    	final UserDetails userDetails = userDetailsService.loadUserByUsername(u.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
}
