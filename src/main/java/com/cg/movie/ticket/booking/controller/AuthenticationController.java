package com.cg.movie.ticket.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.cg.movie.ticket.booking.config.JwtTokenUtil;
import com.cg.movie.ticket.booking.entities.Users;
import com.cg.movie.ticket.booking.model.ApiResponse;
import com.cg.movie.ticket.booking.model.AuthToken;
import com.cg.movie.ticket.booking.model.LoginUser;
import com.cg.movie.ticket.booking.services.UserService;

//import com.cg.movie.ticket.booking.model.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		final Users user = userService.findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return new ApiResponse<AuthToken>(200, "success", new AuthToken(token, user.getUsername()));
	}

}