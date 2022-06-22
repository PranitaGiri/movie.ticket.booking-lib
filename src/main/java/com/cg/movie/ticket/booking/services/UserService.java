package com.cg.movie.ticket.booking.services;

import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.cg.movie.ticket.booking.dto.BookDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.dto.ViewTicketDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Users;
import com.cg.movie.ticket.booking.exceptions.InvalidBookingIdException;
import com.cg.movie.ticket.booking.exceptions.MovieNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.ShowNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.TheraterNotFoundException;
import com.cg.movie.ticket.booking.exceptions.UserNotFoundException;

public interface UserService {
	int registrationUser(UserDto userdto);

	List<ShowInformation> searchShowByLocation(String location) throws TheraterNotFoundException;

	List<ShowInformation> searchShowByTheaterName(String theatrename) throws TheraterNotFoundException;

	List<ShowInformation> searchShowByMoviename(String moviename) throws MovieNotFoundExceptions;

	List<ShowInformation> searchShowByDate(Date date) throws ShowNotFoundExceptions;

	String login(int userid, String password) throws UserNotFoundException;

	ViewTicketDto viewBookedTickets(int bookingid) throws InvalidBookingIdException;

	int bookingTickets(BookDto bookdto) throws InvalidBookingIdException;

	void cancelTickets(int bookingid) throws InvalidBookingIdException;

	Users save(UserDto user);

	List<Users> findAll();

	void delete(int id);

	Users findOne(String username);

	Users findById(int id);

	UserDto update(UserDto userDto);
}
