package com.movieGo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.movieGo.service.*;
import com.movieGo.form.*;
/*
 * handle movie and cinema search
 * (future:not in happy path) handle search by rating, location(cinema), tags  
 */
@Controller
@RequestMapping("/search:")
public class SearchController {
	public MovieService movieService;
	public CinemaService cinemaService;
	public SessionService sessionService;
	public movieQueryForm mf;
	public sessionQueryForm sf;
	
	@RequestMapping("/movie")
	public String searchByMovie(movieQueryForm mf) {
		movieService.getAllMovies(1, 10, mf);
		return "movie-select-show";
	}
	
	@RequestMapping("/cinema")
	public String searchByCinema(String movieName) {
		cinemaService.getCinemasByMovie(1, 10, movieName);
		return "movie-select-show";
	}
	
	@RequestMapping("/session")
	public String searchController(String date, String type, String Name) {
		cinemaService.getCinemasByMovie(1, 10, Name);
		sessionService.getAllSessions(1, 10, sf);
		return "movie-select-show";
	}
	
}
