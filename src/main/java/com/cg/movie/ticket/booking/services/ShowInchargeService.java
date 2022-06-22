package com.cg.movie.ticket.booking.services;

import java.util.List;
import java.util.Optional;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.exceptions.ShowNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.UserNotFoundException;

public interface ShowInchargeService {
	
	int registerShowIncharge(UserDto s);
	 int addShowTimings(ShowDto show);
	 List<ShowInformation> viewAllShows();
	// void updateShowTimings(ShowInformation show);
	 int updateShowTimings(ShowDto show);
	 void deleteShowTimings(int showid);
	 Optional<ShowInformation> getShowById(int showid)throws ShowNotFoundExceptions;
	 String login(int userid,String password)throws UserNotFoundException;
}
