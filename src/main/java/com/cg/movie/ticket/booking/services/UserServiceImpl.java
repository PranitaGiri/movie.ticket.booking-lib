package com.cg.movie.ticket.booking.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.movie.ticket.booking.dto.BookDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.dto.ViewTicketDto;
import com.cg.movie.ticket.booking.entities.BookTicket;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Theatre;
import com.cg.movie.ticket.booking.entities.Users;
import com.cg.movie.ticket.booking.exceptions.InvalidBookingIdException;
import com.cg.movie.ticket.booking.exceptions.MovieNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.ShowNotFoundExceptions;
import com.cg.movie.ticket.booking.exceptions.TheraterNotFoundException;
import com.cg.movie.ticket.booking.exceptions.UserNotFoundException;
import com.cg.movie.ticket.booking.repository.BookTicketRepository;
import com.cg.movie.ticket.booking.repository.ShowInformationRepository;
import com.cg.movie.ticket.booking.repository.TheatreRepository;
import com.cg.movie.ticket.booking.repository.UserDao;
import com.cg.movie.ticket.booking.repository.UsersRepository;
import com.google.common.base.Optional;

@Service(value = "UserService")
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private UsersRepository userepo;
	@Autowired
	private TheatreRepository tetrepo;
	@Autowired
	private ShowInformationRepository showrepo;
	@Autowired
	private BookTicketRepository bookrepo;

	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	Users user;

	@Override
	public List<ShowInformation> searchShowByLocation(String location) {
		Theatre tet = tetrepo.getTetByLoc(location);
		if (tet == null)
			throw new TheraterNotFoundException();

		return showrepo.getshowByTetId(tet.getTheatreid());

	}

	@Override
	public List<ShowInformation> searchShowByTheaterName(String theatrename) {
		Theatre tet = tetrepo.getTetByName(theatrename);
		if (tet == null)
			throw new TheraterNotFoundException();

		return showrepo.getshowByTetId(tet.getTheatreid());

	}

	@Override
	public List<ShowInformation> searchShowByMoviename(String moviename) {
		List<ShowInformation> show = showrepo.getShowByMovie(moviename);
		if (show.isEmpty())
			throw new MovieNotFoundExceptions();
		return show;
	}

	@Override
	public List<ShowInformation> searchShowByDate(Date date) {
		List<ShowInformation> show = showrepo.getShowByTimings(date);
		if (show.isEmpty())
			throw new ShowNotFoundExceptions();
		return show;
	}

	@Override
	public ViewTicketDto viewBookedTickets(int bookingid) {
		BookTicket book = bookrepo.getById(bookingid);
		Users user = bookrepo.getUseById(bookingid);
		ShowInformation show = bookrepo.getshowById(bookingid);
		Theatre tet = show.getTet();
		if (book == null)
			throw new InvalidBookingIdException();

		ViewTicketDto vd = new ViewTicketDto();
		vd.setUserid(user.getUserid());
		vd.setUsername(user.getUsername());
		vd.setMoviename(show.getMoviename());
		vd.setNoofticketsbooked(book.getNoofticketsbooked());
		vd.setTheatrename(tet.getTheatrename());
		vd.setLocation(tet.getLocation());

		return vd;
	}

	@Override
	public int registrationUser(UserDto userdto) {
		Users user = new Users();
		user.setUsername(userdto.getUsername());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		user.setMobilenumber(userdto.getMobilenumber());
		user.setRole(userdto.getRole());
		userepo.save(user);
		return user.getUserid();
	}

	@Override
	public String login(int userid, String password) {

		if (userepo.existsById(userid)) {

			if (userepo.getByPassword(userid).equals(password)) {
				userepo.getId(userid);
				System.out.println("user logged in");
			} else {
				System.out.println("user password not matched");
			}
		} else
			throw new UserNotFoundException();

		return null;
	}

	@Override
	public int bookingTickets(BookDto bookdto) {

		ShowInformation show = showrepo.getShowById(bookdto.getShowid());
		Users user = userepo.getById(bookdto.getUserid());

		if (bookdto.getNoofticketsbooked() <= (show.getTotalnooftickets() - show.getBookingcount())) {
			BookTicket book = new BookTicket();
			book.setNoofticketsbooked(bookdto.getNoofticketsbooked());
			book.setShow(show);
			book.setUser(user);
			bookrepo.save(book);
			show.setBookingcount(show.getBookingcount() + book.getNoofticketsbooked());
			showrepo.save(show);
			return book.getBookingid();
		} else {

			int x = show.getTotalnooftickets() - show.getBookingcount();
			System.out.println(" only tickets avaiable are  " + "" + x);

			return 0;
		}
	}

	@Override
	public void cancelTickets(int bookingid) {
		BookTicket book=bookrepo.getById(bookingid);
		if(book==null)
			throw new InvalidBookingIdException();
		
		ShowInformation show=bookrepo.getshowById(bookingid);
		show.setBookingcount(show.getBookingcount()-book.getNoofticketsbooked());
		bookrepo.deleteById(bookingid);
		
	}
	  
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			 user=userDao.findByUsername(username);
			if(user == null){
				throw new UsernameNotFoundException("Invalid username or password.");
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
		}

		private List<SimpleGrantedAuthority> getAuthority() {
			return Arrays.asList(new SimpleGrantedAuthority(this.user.getRole()));
		}

		public List<Users> findAll() {
			List<Users> list = new ArrayList<>();
			userDao.findAll().iterator().forEachRemaining(list::add);
			return list;
		}

		@Override
		public void delete(int id) {
			userDao.deleteById(id);
		}

		@Override
		public Users findOne(String username) {
			return userDao.findByUsername(username);
		}

		@Override
		public Users findById(int id) {
			Optional<Users> optionalUser = userDao.findById(id);
			return optionalUser.isPresent() ? optionalUser.get() : null;
		}

	    @Override
	    public UserDto update(UserDto userDto) {
	        Users user = findById(userDto.getUserid());
	        if(user != null) {
	            BeanUtils.copyProperties(userDto, user, "password");
	        	
	            
	            userDao.save(user);
	        }
	        return userDto;
	    }


	    @Override
	    public Users save(UserDto user) {
		    Users newUser = new Users();
		    newUser.setUsername(user.getUsername());
		    newUser.setRole("USER");
		    newUser.setEmail(user.getEmail());
		    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			
	        return userDao.save(newUser);
	    }
}
