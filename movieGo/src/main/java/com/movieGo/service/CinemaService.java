package com.movieGo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movieGo.entity.Cinema;
import com.movieGo.form.cinemaQueryForm;
import com.movieGo.repo.CinemaRepo;
import com.movieGo.support.querySupport.CinemaQuery;

@Service

public class CinemaService {
	@Autowired
	private CinemaRepo cinemaRepo;
	public Page<Cinema> getAllCinemas(int page, int pageSize, cinemaQueryForm cf) {
		return cinemaRepo.findAll(
				new CinemaQuery(cf),
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
	public Page<Cinema> getCinemasByMovie(int page, int pageSize, String movieName) {
		return cinemaRepo.findByMovie(
				movieName, 
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
}
