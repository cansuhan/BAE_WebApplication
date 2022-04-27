package com.qa.baewebapp.controller;

import java.util.List;
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
import com.qa.baewebapp.domain.Tarot;
//import com.qa.baewebapp.exceptions.UserNotFoundException;
//import com.qa.baewebapp.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/tarot")
public class TarotController {
	
	// Get
	@GetMapping("/hello") // localhost:8080/hello
	public String helloWorld( ) {
		return "Hello World";
	}
	
	// Post
	
	// Put/Patch
	
	// Delete

}
