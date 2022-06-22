package com.cg.movie.ticket.booking.dto;

import java.util.Date;

public class ViewTicketDto {
	private int  userid;
	private String username;
	private String moviename;
	private Date date;
    private String time;
	private int noofticketsbooked;
	private String theatrename;
	private String location;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public int getNoofticketsbooked() {
		return noofticketsbooked;
	}
	public void setNoofticketsbooked(int noofticketsbooked) {
		this.noofticketsbooked = noofticketsbooked;
	}
	public String getTheatrename() {
		return theatrename;
	}
	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
