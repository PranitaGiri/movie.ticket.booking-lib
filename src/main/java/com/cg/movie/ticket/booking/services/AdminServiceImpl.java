package com.cg.movie.ticket.booking.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.dto.TheatreDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Theatre;
import com.cg.movie.ticket.booking.entities.Users;
import com.cg.movie.ticket.booking.exceptions.UserNotFoundException;
import com.cg.movie.ticket.booking.repository.ShowInformationRepository;
import com.cg.movie.ticket.booking.repository.TheatreRepository;

import com.cg.movie.ticket.booking.repository.UsersRepository;



@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
   private ShowInformationRepository showrepo;
    @Autowired
   private UsersRepository userrepo;
    @Autowired
   private TheatreRepository theatrerepo;
    
	@Override
	public int addMovies(ShowDto showdto) {  
		    Theatre tet = theatrerepo.getTetById(showdto.getTheatreid());
		    ShowInformation admin = new ShowInformation();
		    admin.setTet(tet);
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
	public int registerUser(UserDto userdto) {
		 Users admin = new Users();
		 
		 admin.setMobilenumber(userdto.getMobilenumber());
		 admin.setEmail(userdto.getEmail());
		 admin.setPassword(userdto.getPassword());
		 admin.setRole(userdto.getRole());
		 userrepo.save(admin);
	     return admin.getUserid();
	}
	
	@Override
	public List<ShowInformation> viewAllMovies() {
		return showrepo.findAll();
	}

	@Override
	public void updateMovies(ShowInformation show) {
		 showrepo.save(show);
		
	}

	@Override
	public void deleteMovies(int showid) {
		 showrepo.deleteById(showid);	
		
	}

	@Override
	public List<ShowInformation> viewShowDetails() {
		return showrepo.findAll();
	}

	

	@Override
	public int addTheatre(TheatreDto theatredto) {
		Theatre tet= new Theatre();
		tet.setTheatrename(theatredto.getTheatrename());
		tet.setLocation(theatredto.getLocation());
		theatrerepo.save(tet);
		return tet.getTheatreid();
	}
	
	}	
   
    
    