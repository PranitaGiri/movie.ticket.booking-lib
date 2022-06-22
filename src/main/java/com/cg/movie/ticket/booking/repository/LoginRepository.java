package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.LoginDetails;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails, Integer> {

}
