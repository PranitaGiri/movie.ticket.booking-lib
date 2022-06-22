package com.cg.movie.ticket.booking.dto;

public class TheatreDto {
	private String theatrename;

	private String location;

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

	@Override
	public String toString() {
		return "TheatreDto [theatrename=" + theatrename + ", location=" + location + "]";
	}

}
