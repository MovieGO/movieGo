package com.movieGo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movieGo.entity.Cinema;
import com.movieGo.entity.Movie;
import com.movieGo.entity.Session;
import com.movieGo.form.cinemaQueryForm;
import com.movieGo.repo.CinemaRepo;
import com.movieGo.repo.MovieRepo;
import com.movieGo.repo.SessionRepo;
import com.movieGo.support.querySupport.CinemaQuery;

@Service

public class CinemaService {
	@Autowired
	private CinemaRepo cinemaRepo;
	@Autowired
	private MovieRepo movieRepo;
	@Autowired
	private SessionRepo sessionRepo;
	/**
	 * 根据cf中的条件查询影院
	 * @param pageSize 每页几个
	 * @param page 第几页
	 * @param cf 查询条件
	 * @return Page 查到的影院
	 * @see com.movieGo.form.cinemaQueryForm
	 */
	public Page<Cinema> getAllCinemas(int page, int pageSize, cinemaQueryForm cf) {
		return cinemaRepo.findAll(
				new CinemaQuery(cf),
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
	/**
	 * 按照电影名查询
	 * @param pageSize 每页几个
	 * @param page 第几页
	 * @param movieName 电影名
	 * @return Page 查到的影院
	 */
	public Page<Cinema> getCinemasByMovie(int page, int pageSize, String movieName) {
		return cinemaRepo.findByMovie(
				movieName, 
				new PageRequest(page, pageSize, Sort.Direction.DESC, "rating"));
	}
	/**
	 * 增加影院
	 * @param c 创建好的Cinema对象
	 * @return 保存的Cinema
	 */
	public Cinema addCinema(Cinema c) {
		return cinemaRepo.save(c);
	}
	/**
	 * 在影院中添加场次
	 * @param s List 要添加的场次
	 * @param cid Cinema id
	 * @return 添加后的Cinema
	 */
	public Cinema addSessions(List<Session> s, Long cid) {
		Cinema c = cinemaRepo.findOne(cid);
		if (c == null)
			return null;
		Cinema tmpc = cinemaRepo.fetchSessions(cid);
		if (tmpc == null) {
			c.setSessions(new ArrayList<Session>());
		} else {
			c = tmpc;
		}
		for (Session tmp : s) {
			Movie m = tmp.getMovie();
			Movie mv = movieRepo.findOne(m.getId());
			if (mv != null) {
				sessionRepo.save(tmp);
				c.getSessions().add(tmp);
			}
		}
		return cinemaRepo.save(c);
	}
}
