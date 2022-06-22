package com.cg.movie.ticket.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShowExceptionHandler {
	@ExceptionHandler(value=ShowNotFoundExceptions.class)
	public ResponseEntity<Object> exception(ShowNotFoundExceptions exception) {
		return new ResponseEntity<Object>("Show not found ....", HttpStatus.NOT_FOUND);
	}

}
