package com.qa.baewebapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.baewebapp.domain.Tarot;
import com.qa.baewebapp.repo.TarotRepo;


@SpringBootTest
@ActiveProfiles("test")
public class TarotServiceUnitTest {

	@Autowired 
	private TarotService service;

	@MockBean 
	private TarotRepo repo;

	@Test
	void testCreate() {
		
		Tarot tarot = new Tarot(20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		Tarot savedTarot = new Tarot(1L, 20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		
		Mockito.when(this.repo.save(tarot)).thenReturn(savedTarot);
		assertThat(this.service.create(tarot)).isEqualTo(savedTarot);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(tarot); //checks that the mock was used exactly once
		
	}
	
	@Test
	void testUpdate() {
		long id = 1L;
		Tarot existingTarot = new Tarot(1L, 22, "Judgement", "Rites of Passage", "Forcing an Outcome");
		Tarot updatedTarot = new Tarot(1L, 19, "The Sun", "Happiness", "Delays");
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existingTarot));
		Mockito.when(this.repo.save(updatedTarot)).thenReturn(updatedTarot);
		
		assertThat(this.service.update(id, new Tarot(19, "The Sun", "Happiness", "Delays"))).isEqualTo(updatedTarot);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedTarot);
		
	}
}