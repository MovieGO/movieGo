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
	private static final long serialVersionUID = 3678059644036355241L;
	
	@OneToMany(cascade = {  CascadeType.PERSIST,
							CascadeType.MERGE,
							CascadeType.REMOVE },
			   mappedBy = "cinema")
	private @Getter Set<Session> sessions;
	
	public Cinema() {super();}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "cinema_movie",
    			joinColumns = {@JoinColumn(name = "cinema_id", nullable = false, updatable = false)},
    			inverseJoinColumns = {@JoinColumn(name = "movie_id", nullable = false, updatable = false)})
	private @Getter List<Movie> movies = new ArrayList<Movie>();
	
	public void addSession(Session session) {
		sessions.add(session);
	}
	
	@Column(nullable = false)
	private @Setter @Getter String city;
	
	@Column(nullable = false)
	private @Setter @Getter String address;
	
	private @Setter @Getter String rating;
	
	
}
