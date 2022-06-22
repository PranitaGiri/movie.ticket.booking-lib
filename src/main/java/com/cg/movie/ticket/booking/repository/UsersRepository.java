package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.movie.ticket.booking.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	@Query(value="select u.password from Users u where u.userid=?1")
	public String getByPassword(int userid);
	@Query(value="select user from Users user where user.userid=?1")
     public Users getId(int userid);
	@Query(value="select user.username from Users user where user.userid=?1")
	public String getNameById(int userid );
	
	@Query(value = "select user from Users user where user.userid=?1")
	Users getUserById(int userId);
	
}