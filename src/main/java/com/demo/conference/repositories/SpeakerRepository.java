package com.demo.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.conference.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{
	
}
