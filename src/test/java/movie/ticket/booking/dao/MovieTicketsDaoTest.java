package movie.ticket.booking.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.movie.ticket.booking.entities.BookTicket;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.entities.Theatre;
import com.cg.movie.ticket.booking.repository.BookTicketRepository;
import com.cg.movie.ticket.booking.repository.ShowInformationRepository;
import com.cg.movie.ticket.booking.repository.TheatreRepository;
import com.cg.movie.ticket.booking.repository.UsersRepository;

@SpringBootTest
public class MovieTicketsDaoTest {
	@Autowired
	UsersRepository userepo;
	@Autowired
	TheatreRepository tetrepo;
	@Autowired
	ShowInformationRepository showrepo;
	@Autowired
	BookTicketRepository bookrepo;
@Test
public void TestgetTetByLoc() {
	Theatre tet= tetrepo.getTetByLoc("hyderabad");
	System.out.println(tet.getLocation());
	assertEquals(tet.getLocation(),"hyderabad");
}
@Test
public void TestgetTetByName() {
	Theatre tet= tetrepo.getTetByName("pvr");
	System.out.println(tet.getTheatrename());
	assertEquals(tet.getTheatrename(),"pvr");
	
	
}
@Test
public void TestgetShowByMovie() {
	List<ShowInformation> show=showrepo.getShowByMovie("kgf");
	assertNull(show);
}
@Test
public void TestgetById() {
	BookTicket book=bookrepo.getById(2);
	System.out.println(book.getBookingid());
	assertEquals(book.getBookingid(),2);
}
@Test
public void testGetAllMoviesNotNull() {
	List<ShowInformation> showlist = showrepo.findAll();
	assertNotNull(showlist);
}
@Test
public void testGetAllShowInformationNotNull() {
	List<ShowInformation> showlist = showrepo.findAll();
	assertNotNull(showlist);
}
@Test
public void testDeleteAllMoviesNull() {
	List<ShowInformation> showlist = showrepo.findAll();
	assertNotNull(showlist);
}

}
