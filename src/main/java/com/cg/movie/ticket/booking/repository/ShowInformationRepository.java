package com.cg.movie.ticket.booking.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.movie.ticket.booking.entities.ShowInformation;


@Repository
public interface ShowInformationRepository extends JpaRepository<ShowInformation,Integer> {

	@Query(value = "select show from ShowInformation show where tet.theatreid=?1")
	List<ShowInformation> getshowByTetId(int theatreid);

	@Query(value = "select show from ShowInformation show where show.moviename=?1")
	List<ShowInformation> getShowByMovie(String moviename);

	@Query(value = "select show from ShowInformation show where show.date=?1")
	List<ShowInformation> getShowByTimings(Date date);

	@Query(value = "select show from ShowInformation show where show.showid=?1")
	ShowInformation getShowById(int showid);

	@Query(value = "select show.moviename from ShowInformation show where show.showid=?1")
	public String getNameId(int showid);
	
}
