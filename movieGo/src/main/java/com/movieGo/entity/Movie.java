package com.movieGo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Movie")
public class Movie extends baseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7237540471162355519L;
	
	@ManyToMany(mappedBy = "movies")
	private List<Cinema> cinemas = new ArrayList<Cinema>();
	
	public Movie() {super();}
	
	@Column(nullable = false)
	private @Getter @Setter String name;
	
	@Column
	private @Getter @Setter String rating;
	
	@Column(nullable = false)
	private @Getter @Setter String length;
	
	@Column
	private @Getter @Setter String director;
	
	@Column
	private @Getter String[] stars;
	
	@Column(nullable = false)
	private @Getter @Setter Date premiereTime;
}
