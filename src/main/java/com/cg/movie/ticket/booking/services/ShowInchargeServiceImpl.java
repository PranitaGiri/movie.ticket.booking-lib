package com.cg.movie.ticket.booking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Theatre;
import com.cg.movie.ticket.booking.entities.Users;
import com.cg.movie.ticket.booking.exceptions.ShowNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.UserNotFoundException;
import com.cg.movie.ticket.booking.repository.ShowInformationRepository;
import com.cg.movie.ticket.booking.repository.TheatreRepository;
import com.cg.movie.ticket.booking.repository.UsersRepository;

@Service
public class ShowInchargeServiceImpl implements ShowInchargeService{
	@Autowired
	private ShowInformationRepository showrepo;
	@Autowired
	private UsersRepository userrepo;
	@Autowired
	private TheatreRepository theatrerepo;
	
	@Override
	public int registerShowIncharge(UserDto s) {
		Users showinc = new Users();
		showinc.setUsername(s.getUsername());
		showinc.setPassword(s.getPassword());
		showinc.setEmail(s.getEmail());
		showinc.setRole(s.getRole());
		userrepo.save(showinc);
		return showinc.getUserid();
	}
	
	@Override
	public int addShowTimings(ShowDto showdto) {
		Theatre tet = theatrerepo.getTetById(showdto.getTheatreid());
	    ShowInformation admin = new ShowInformation();
	    admin.setTet(tet);;
	    admin.setMoviename(showdto.getMoviename());
	    admin.setDate(showdto.getDate());
	    admin.setTotalnooftickets(showdto.getTotalnooftickets());
	    admin.setBookingcount(showdto.getBookingcount());
	    showrepo.save(admin);
		return admin.getShowid();
	}
	@Override
	public String login(int userid, String password) {
		
	if(userrepo.existsById(userid)) {

		
		if(userrepo.getByPassword(userid).equals(password)) {
			userrepo.getId(userid);
		System.out.println("user logged in");
		}
		else {
			System.out.println("user password not matched");
			}}
		else
			throw new UserNotFoundException();
		
return null;
	}

	@Override
	public List<ShowInformation> viewAllShows() {
		return showrepo.findAll();
	}

	@Override
	public int updateShowTimings(ShowDto show) {
		ShowInformation addshow = new ShowInformation();
	    addshow.setDate(show.getDate());
	    showrepo.save(addshow);
		return addshow.getShowid();
	}

	@Override
	public void deleteShowTimings(int showid) {
		showrepo.deleteById(showid);
	}
	
	@Override 
	public Optional<ShowInformation> getShowById(int showid) {
		Optional<ShowInformation> show = showrepo.findById(showid); 
		if(show==null)
			throw new ShowNotFoundExceptions();
		return show;
	}
}
