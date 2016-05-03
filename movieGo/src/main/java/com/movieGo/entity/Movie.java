package com.movieGo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
public class Movie extends baseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7237540471162355519L;
	
	@ManyToMany(mappedBy = "movies")
	private List<Cinema> cinemas = new ArrayList<Cinema>();
	
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String rating;
	
	@Column(nullable = false)
	private String length;
	
	@Column
	private String director;
	
	@Column
	private String[] stars;
	
	@Column(nullable = false)
	private Date premiereTime;
}
