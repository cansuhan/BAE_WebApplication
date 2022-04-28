package com.qa.baewebapp.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TarotNotFoundExceptionWithID extends EntityNotFoundException {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public TarotNotFoundExceptionWithID(long id) {
			super("User does not exist with ID: " + id);
		}
		
	}