package com.qa.baewebapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.baewebapp.domain.Tarot;


@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class TarotControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Tarot entry = new Tarot(1L, 20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Tarot result = new Tarot(2L, 20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/tarot/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));

	}

	@Test
	public void getAllTest() throws Exception {
		Tarot tarot = new Tarot(1L, 20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		List<Tarot> output = new ArrayList<>();
		output.add(tarot);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/tarot/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByIdTest() throws Exception {
		Tarot entry = new Tarot(1L, 20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/tarot/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Tarot entry = new Tarot(20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		Tarot result = new Tarot(1L, 20, "Judgement", "Rites of Passage", "Forcing an Outcome");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/tarot/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/tarot/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
}
