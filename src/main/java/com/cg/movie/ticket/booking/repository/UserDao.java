package com.cg.movie.ticket.booking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.Users;
import com.google.common.base.Optional;

@Repository
public interface UserDao extends CrudRepository<Users, Integer> {

	Users findByUsername(String username);
	Optional<Users> findById(int id );

}
