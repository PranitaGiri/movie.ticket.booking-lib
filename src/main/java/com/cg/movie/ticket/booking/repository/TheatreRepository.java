package com.cg.movie.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.movie.ticket.booking.entities.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

	@Query(value = "select tet from Theatre tet where tet.location=?1")
	Theatre getTetByLoc(String location);

	@Query(value = "select tet from Theatre tet where tet.theatrename=?1")
	Theatre getTetByName(String theatrename);

	@Query(value = "select tet from Theatre tet where tet.theatreid=?1")
	Theatre getTetById(int theatreid);


	@Query(value = "select tet.theatrename from Theatre tet where tet.theatreid=?1")
	public String getNameById(int theatreid);

	@Query(value = "select tet.location from Theatre tet where tet.theatreid=?1")
	public String getLocById(int theatreid);
}
