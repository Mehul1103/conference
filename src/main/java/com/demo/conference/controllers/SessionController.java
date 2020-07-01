package com.demo.conference.controllers;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		sessionRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		Session currentSession = sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, currentSession, "session_id");
		return sessionRepository.saveAndFlush(currentSession);
	}
}
