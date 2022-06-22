package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.BookTicket;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Users;
@Repository
public interface BookTicketRepository extends JpaRepository<BookTicket, Integer>{
	@Query(value = "select book.user from BookTicket book where book.bookingid=?1")
	Users getUseById(int bookingid );
	@Query(value = "select book.show from BookTicket book where book.bookingid=?1")
	ShowInformation getshowById(int bookingid );
	
	
	
}
