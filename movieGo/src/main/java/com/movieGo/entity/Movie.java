package com.movieGo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	public static enum Type {
		LOVE, ADVENTURE, ACTION, SEX, DOCUMENTARY
	}
	
	@ManyToMany
	@JoinTable(name = "cinema_movie",
		joinColumns = {@JoinColumn(name = "movie_id", nullable = false, updatable = false)},
		inverseJoinColumns = {@JoinColumn(name = "cinema_id", nullable = false, updatable = false)})
	public List<Cinema> cinemas = new ArrayList<Cinema>();
	
	public Movie() {super();}
	
	@Column(nullable = false)
	private @Getter @Setter String name;
	
	@Column
	private @Getter @Setter Double rating;
	
	@Column
	private @Getter @Setter Type type;
	
	@Column(nullable = false)
	private @Getter @Setter Double length;
	
	@Column
	private @Getter @Setter String director;
	
	@Column
	private @Getter String[] stars;
	
	@Column(nullable = false)
	private @Getter @Setter Date premiereTime;
}
