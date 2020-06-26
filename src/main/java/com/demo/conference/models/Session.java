package com.demo.conference.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // specifies how the primary key value populated on every new
														// entry.
	private Long session_id;
	private String session_name;
	private String session_description;
	private Integer session_length;
	// Keeping the variable name(instead of Java specified camel-case) same as
	// database column as jpa will autobinds the column(Don't need to annotate each
	// variable)

	@ManyToMany		//setting many-to-many relationship, have join query in database
	@JoinTable(		//specifying the table with foreign-key, jpa will do join automatically
			name = "session_speakers",
			joinColumns = @JoinColumn(name = "session_id"),
			inverseJoinColumns = @JoinColumn(name = "speaker_id"))
	private List<Speaker> speakers;
	
	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

	public Session() {

	}

	public Long getSession_id() {
		return session_id;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getSession_name() {
		return session_name;
	}

	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}

	public String getSession_description() {
		return session_description;
	}

	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}

	public Integer getSession_length() {
		return session_length;
	}

	public void setSession_length(Integer session_length) {
		this.session_length = session_length;
	}

}
