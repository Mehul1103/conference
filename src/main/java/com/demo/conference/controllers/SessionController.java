package com.demo.conference.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.conference.models.Session;
import com.demo.conference.repositories.SessionRepository;

@RestController // Act as ingoing and outgoing request as JSON Rest end-points
@RequestMapping("/api/v1/session") // tells the router mapping url look like
public class SessionController {

	@Autowired // create an instance of sessionRepository and put it on class
	private SessionRepository sessionRepository;

	@GetMapping // To use HTTP Get Methods
	public List<Session> list() {
		return sessionRepository.findAll();
	}

	@GetMapping
	@RequestMapping("{id}") // Addition to the URL
	public Session get(@PathVariable Long id) {
		return sessionRepository.getOne(id);
	}

	@PostMapping
	public Session create(@RequestBody final Session session) {
		return sessionRepository.saveAndFlush(session);
	}
}
