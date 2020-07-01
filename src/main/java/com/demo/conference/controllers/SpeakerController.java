package com.demo.conference.controllers;

import java.util.List;

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

import com.demo.conference.models.Speaker;
import com.demo.conference.repositories.SpeakerRepository;

@RestController
@RequestMapping("api/v1/speaker")
public class SpeakerController {
	
	@Autowired
	private SpeakerRepository speakerRepository;
	
	@GetMapping
	public List<Speaker> list(){
		return speakerRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(@PathVariable Long id) {
		return speakerRepository.getOne(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		speakerRepository.deleteById(id);
	}
	
	@PostMapping
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker currentSpeaker = speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, currentSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(currentSpeaker);
	}
	
}