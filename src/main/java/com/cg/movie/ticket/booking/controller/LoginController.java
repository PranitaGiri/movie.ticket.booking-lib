package com.cg.movie.ticket.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.ticket.booking.entities.LoginDetails;
import com.cg.movie.ticket.booking.services.LoginServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginServiceImpl loginimpl;

	@GetMapping("/logindetails")
	public List<LoginDetails> getalldetails() {
		return loginimpl.getAllDetails();
	}

}
