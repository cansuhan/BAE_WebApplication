package com.qa.baewebapp.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
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
import com.qa.baewebapp.service.TarotService;
//import com.qa.baewebapp.exceptions.UserNotFoundException;
//import com.qa.baewebapp.service.UserService;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping //("/tarot")
public class TarotController {
	
	private TarotService service;
	
	public TarotController(TarotService service) {
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Tarot>> getAll() {
		return new ResponseEntity<List<Tarot>>(service.getAll(), HttpStatus.OK);
	}
	
	// Get by ID (get one tarot)
	@GetMapping("/getById/{id}")
	public ResponseEntity<Tarot> getById(@PathVariable long id) {
		return new ResponseEntity<Tarot>(service.getById(id), HttpStatus.OK);
	
	
//	// Get
//	@GetMapping("/hello") // localhost:8080/hello
//	public String helloWorld( ) {
//		return "Hello World";
//	}
	
	
	// Get by Tarot Card Number (get one tarot card)
		@GetMapping("/getByNumber/{number}")
		public ResponseEntity<Tarot> getByNumber(@PathVariable String number) {
			return new ResponseEntity<Tarot>(service.getByNumber(number), HttpStatus.OK);
		}
		
		
		// Post
		@PostMapping("/create") 		// localhost:8080/create
		public ResponseEntity<Tarot> create(@RequestBody Tarot tarot) {
			return new ResponseEntity<Tarot>(service.create(tarot), HttpStatus.CREATED);
		}
		
		// Put
		@PutMapping("/update/{id}") 	// localhost:8080/update/id
		public ResponseEntity<Tarot> update(@PathVariable long id, @RequestBody Tarot tarot) {
			return new ResponseEntity<Tarot>(service.update(tarot), HttpStatus.ACCEPTED);
		}
		
		
		// Delete
		@DeleteMapping("/delete/{id}") 	//localhost:8080/delete/id
		public ResponseEntity<?> delete(@PathVariable long id) {
			return (service.delete(id))? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
