package com.movieGo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Table(name="Cinema")
@Entity
public class Cinema  extends baseEntity{

	/**
	 * 
	 */
	public Cinema() {super();}
	
	private static final long serialVersionUID = 3678059644036355241L;
	
	@OneToMany(mappedBy = "cinema")
	private @Setter @Getter List<Session> sessions = new ArrayList<Session>();
	
	@ManyToMany(mappedBy="cinemas")
	public @Setter @Getter List<Movie> movies = new ArrayList<Movie>();
	
	public void addSession(Session session) {
		sessions.add(session);
	}
	
	@Column(nullable = false)
	private @Setter @Getter String name;
	
	@Column(nullable = false)
	private @Setter @Getter Integer city;
	
	@Column(nullable = false)
	private @Setter @Getter String address;
	
	private @Setter @Getter Integer rating;
}
