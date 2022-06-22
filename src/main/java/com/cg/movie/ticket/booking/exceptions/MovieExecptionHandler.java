package com.cg.movie.ticket.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExecptionHandler {
	@ExceptionHandler(value = InvalidBookingIdException.class)
	public ResponseEntity<Object> exception(InvalidBookingIdException exception) {
		return new ResponseEntity<Object>("invalid booking id ....", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		return new ResponseEntity<Object>("user not found....", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = TheraterNotFoundException.class)
	public ResponseEntity<Object> exception(TheraterNotFoundException exception) {
		return new ResponseEntity<Object>("therater not found....", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ShowNotFoundExceptions.class)
	public ResponseEntity<Object> exception(ShowNotFoundExceptions exception) {
		return new ResponseEntity<Object>("show not found....", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MovieNotFoundExceptions.class)
	public ResponseEntity<Object> exception(MovieNotFoundExceptions exception) {
		return new ResponseEntity<Object>("movie not found....", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidUserNameException.class)
	public ResponseEntity<String> exception(InvalidUserNameException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidPasswordException.class)
	public ResponseEntity<String> exception(InvalidPasswordException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
