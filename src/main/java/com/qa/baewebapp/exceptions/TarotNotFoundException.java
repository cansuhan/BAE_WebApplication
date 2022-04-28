package com.qa.baewebapp.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason= "User does not exist with that ID")
public class TarotNotFoundException extends EntityNotFoundException{

		private static final long serialVersionUID = -4159324449523862724L;

	}