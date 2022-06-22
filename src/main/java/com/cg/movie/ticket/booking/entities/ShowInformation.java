package com.cg.movie.ticket.booking.entities;

import java.util.Date;


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
@Table(name="ShowInformation")
public class ShowInformation {
@Id@SequenceGenerator(name = "show_seq",initialValue=92022,sequenceName="show_code_seq",allocationSize=1)
@GeneratedValue(generator="show_seq",strategy = GenerationType.SEQUENCE)
	private int showid;
@Column(name="moviename",length=300)
	private String moviename;
@Column(name="totalnooftickets",length=300)
	private int totalnooftickets;
@Column(name="date",length=300)
	private Date date;
@Column(name="bookingcount",length=300)
    private int bookingcount;

public int getBookingcount() {
	return bookingcount;
}

public void setBookingcount(int bookingcount) {
	this.bookingcount = bookingcount;
}

@OneToOne
@JoinColumn(name = "theatreid")
	private Theatre tet;

public int getShowid() {
	return showid;
}

public void setShowid(int showid) {
	this.showid = showid;
}

public String getMoviename() {
	return moviename;
}

public void setMoviename(String moviename) {
	this.moviename = moviename;
}



public int getTotalnooftickets() {
	return totalnooftickets;
}

public void setTotalnooftickets(int totalnooftickets) {
	this.totalnooftickets = totalnooftickets;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Theatre getTet() {
	return tet;
}

public void setTet(Theatre tet) {
	this.tet = tet;
}


}






