package com.cg.movie.ticket.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.ticket.booking.entities.LoginDetails;
import com.cg.movie.ticket.booking.repository.LoginRepository;

@Service
public class LoginServiceImpl  implements LoginService{

	@Autowired
	LoginRepository loginrepo;
	@Override
	public List<LoginDetails> getAllDetails() {
		List<LoginDetails> list=loginrepo.findAll();
		return list;
	}

}


