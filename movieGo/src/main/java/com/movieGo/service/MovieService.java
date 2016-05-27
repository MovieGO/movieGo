package com.movieGo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movieGo.entity.Movie;
import com.movieGo.form.movieQueryForm;
import com.movieGo.repo.CinemaRepo;
import com.movieGo.repo.MovieRepo;
import com.movieGo.support.querySupport.MovieQuery;

@Service

public class MovieService {
	@Autowired
	private MovieRepo movieRepo;
	/**
	 * 按照条件查找电影
	 * @param pageSize 每页几个
	 * @param page 第几页
	 * @param mf 查询条件
	 * @return Page 查到的电影
	 * @see com.movieGo.form.movieQueryForm
	 */
	public Page<Movie> getAllMovies(int page, int pageSize, movieQueryForm mf) {
		return movieRepo.findAll(
				new MovieQuery(mf),
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
	/**
	 * 按照影院名查询
	 * @param pageSize 每页几个
	 * @param page 第几页
	 * @param cinemaName 影院名
	 * @return Page 查到的电影
	 */
	public Page<Movie> getMoviesByCinema(int page, int pageSize, String cinemaName) {
		return movieRepo.findByCinema(
				cinemaName,
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
	/**
	 * 添加电影
	 * @param m 电影
	 * @return 保存后的电影
	 */
	public Movie addMovie(Movie m) {
		if (movieRepo.findByName(m.getName()) != null) {
			return null;
		}
		return movieRepo.save(m);
	}
}
