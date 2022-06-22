package com.cg.movie.ticket.booking.dto;

public class BookDto {
	private int noofticketsbooked;
	private int userid;
	private int showid;
	public int getNoofticketsbooked() {
		return noofticketsbooked;
	}
	public void setNoofticketsbooked(int noofticketsbooked) {
		this.noofticketsbooked = noofticketsbooked;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
	@Override
	public String toString() {
		return "BookDto [noofticketsbooked=" + noofticketsbooked + ", userid=" + userid + ", showid=" + showid + "]";
	}
	
}
