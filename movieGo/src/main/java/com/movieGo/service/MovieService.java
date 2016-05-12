package com.movieGo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movieGo.entity.Movie;
import com.movieGo.form.movieQueryForm;
import com.movieGo.repo.MovieRepo;
import com.movieGo.support.querySupport.MovieQuery;

@Service

public class MovieService {
	@Autowired
	private MovieRepo movieRepo;
	public Page<Movie> getAllMovies(int page, int pageSize, movieQueryForm mf) {
		return movieRepo.findAll(
				new MovieQuery(mf),
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
	public Page<Movie> getMoviesByCinema(int page, int pageSize, String cinemaName) {
		return movieRepo.findByCinema(
				cinemaName,
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
}
