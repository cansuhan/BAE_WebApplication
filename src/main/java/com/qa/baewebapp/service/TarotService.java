package com.qa.baewebapp.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.qa.baewebapp.domain.Tarot;
import com.qa.baewebapp.repo.TarotRepo;

@Service
public class TarotService {
	
	private TarotRepo repo;

	public TarotService(TarotRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	// Get ALL tarots
		public List<Tarot> getAll() {
			return repo.findAll();
		}
		
		// Get By ID (get one tarot) 
		public Tarot getById(long id) {
			return repo.findById(id).orElseThrow(TarotNotFoundException::new);
		}

		// Get By number (get one tarot)
		public Tarot getByNumber(String number) {
			return repo.findByNumber(number).get();
		}
		
		// Create a new user
		public Tarot create(Tarot tarot) {
			return repo.saveAndFlush(tarot);
		}
		
		// Update a tarot card
		public Tarot update(long id, Tarot tarot) {  
			Tarot existing = repo.findById(id).get(); 	// Get the EXISTING user
			existing.setCard(tarot.getCard()); 			// Update existing card details
			existing.setUpright(tarot.getUpright()); 
			existing.setReversed(tarot.getReversed());
			return existing; 
		}

		// Delete a user
		public boolean delete(long id) {
			repo.deleteById(id);
			return !repo.existsById(id);
		}
	}
	
