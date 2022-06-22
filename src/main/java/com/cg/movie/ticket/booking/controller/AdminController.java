package com.cg.movie.ticket.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.ticket.booking.dto.ShowDto;
import com.cg.movie.ticket.booking.dto.TheatreDto;
import com.cg.movie.ticket.booking.dto.UserDto;
import com.cg.movie.ticket.booking.entities.ShowInformation;
import com.cg.movie.ticket.booking.services.AdminServiceImpl;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminServiceImpl adminservice;

	@GetMapping("/login/{userid}/{password}")
	public String login(@PathVariable int userid, @PathVariable String password) {
		return adminservice.login(userid, password);
	}

	@PostMapping()
	public ResponseEntity<String> registerUser(@RequestBody UserDto userdto) {
		int user = adminservice.registerUser(userdto);
		return new ResponseEntity<String>("get userid =" + user, HttpStatus.OK);
	}

	@PostMapping("/admin")
	public ResponseEntity<String> addMovies(@RequestBody ShowDto showdto) {
		int showid = adminservice.addMovies(showdto);
		return new ResponseEntity<String>("inserted movie = " + showid, HttpStatus.OK);
	}

	@PostMapping("/admin/{theatre}")
	public ResponseEntity<String> addTheatre(@RequestBody TheatreDto theatredto) {
		int theatreid = adminservice.addTheatre(theatredto);
		return new ResponseEntity<String>("inserted theatre = " + theatreid, HttpStatus.OK);

	}

	@GetMapping("/movie/{show}")
	public ResponseEntity<List<ShowInformation>> getShowDetails() {
		List<ShowInformation> adminList = adminservice.viewAllMovies();
		return new ResponseEntity<List<ShowInformation>>(adminList, HttpStatus.OK);
	}

	@GetMapping("/movie")
	public ResponseEntity<List<ShowInformation>> getAllMovies() {
		List<ShowInformation> adminList = adminservice.viewAllMovies();
		return new ResponseEntity<List<ShowInformation>>(adminList, HttpStatus.OK);
	}

	@PutMapping("/movie")
	public ResponseEntity<String> editMovies(@RequestBody ShowInformation admin) {
		adminservice.updateMovies(admin);
		return new ResponseEntity<String>("updated", HttpStatus.OK);
	}

	@DeleteMapping("/movie{showid}")
	public ResponseEntity<String> deleteMovies(@PathVariable int showid) {
		adminservice.deleteMovies(showid);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}