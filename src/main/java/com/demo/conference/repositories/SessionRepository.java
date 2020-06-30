package com.demo.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.conference.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
