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
			return repo.findById(id).get();//orElseThrow(TarotNotFoundException::new);
		}

		// Get By number (get one tarot)
		public Tarot getByNumber(int number) {
			return repo.findByNumber(number).get();
		}
		
		// Create a new tarot card
		public Tarot create(Tarot tarot) {
			return repo.saveAndFlush(tarot);
		}
		
		// Update a tarot card
		public Tarot update(long id, Tarot tarot) {  
			Tarot existing = repo.findById(id).get(); 	// Get the EXISTING card
			existing.setNumber(tarot.getNumber());
			existing.setCard(tarot.getCard()); 			// Update existing card details
			existing.setUpright(tarot.getUpright()); 
			existing.setReversed(tarot.getReversed());
			return repo.saveAndFlush(existing); 
		}

		// Delete a tarot card
		public boolean delete(long id) {
			repo.deleteById(id);
			return !repo.existsById(id);
		}
	}
	
