package com.cg.movie.ticket.booking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BookingTicket")
public class BookTicket {
@Id
@SequenceGenerator(name = "book_seq",initialValue=1,sequenceName="book_code_seq",allocationSize=1)
@GeneratedValue(generator="book_seq",strategy = GenerationType.SEQUENCE)
private int bookingid;

@Column(name="noofticketsbooked",length=300)
private int noofticketsbooked;

@OneToOne
@JoinColumn(name = "userid")
private Users user;

@OneToOne
@JoinColumn(name = "showid")
private ShowInformation show;

public int getBookingid() {
	return bookingid;
}

public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}

public int getNoofticketsbooked() {
	return noofticketsbooked;
}

public void setNoofticketsbooked(int noofticketsbooked) {
	this.noofticketsbooked = noofticketsbooked;
}

public Users getUser() {
	return user;
}

public void setUser(Users user) {
	this.user = user;
}

public ShowInformation getShow() {
	return show;
}

public void setShow(ShowInformation show) {
	this.show = show;
}
}

