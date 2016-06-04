package com.movieGo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.movieGo.service.*;
import com.movieGo.entity.Cinema;
import com.movieGo.entity.Movie;
import com.movieGo.form.*;
/*
 * handle movie and cinema search
 * (future:not in happy path) handle search by rating, location(cinema), tags  
 */
@Controller
@RequestMapping("/search")
public class SearchController {
	@RequestMapping(value = "/cinema/{cinemaName}", method = RequestMethod.GET)
	public String searchMovieByCinema(@PathVariable String cinemaName) {
		MovieService movieService = null;
		movieService.getMoviesByCinema(1, 10, cinemaName);
		return "movie-select-show";
	}
	
	@RequestMapping(value = "/movie/{movieName}", method = RequestMethod.GET)
	public String searchCinemaByMovie(@PathVariable String movieName) {
		CinemaService cinemaService = null;
		cinemaService.getCinemasByMovie(1, 10, movieName);
		return "movie-select-show";
	}
	
	@RequestMapping(value = "/session/{movie}/{date}/{cinema}", method = RequestMethod.GET)
	public String searchSession(@PathVariable Movie movie, @PathVariable String date, @PathVariable Cinema cinema) {
		SessionService sessionService = null;
		sessionQueryForm sf = null;
		sf.setCinema(cinema);
		sf.setDate(date);
		sf.setMovie(movie);
		sessionService.getAllSessions(1, 10, sf);
		return "movie-select-show";
	}
	
}
