package com.movieGo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.movieGo.service.*;
import com.movieGo.support.querySupport.*;
import com.movieGo.form.*;
import com.movieGo.entity.*;
/*
 * main page of one session, triggered by "选座购票" button
 * the page ONLY contains seats status and(maybe) brief session info
 * 
 */
@Controller
@RequestMapping("/seats")
public class SessionController {
	
	@RequestMapping("/{movie}/{date}/{cinema}")
	public String showSeats(@PathVariable Movie movie, @PathVariable String date, @PathVariable Cinema cinema) {
		SessionService sessionService = null;
		sessionQueryForm sf = null;
		sf.setCinema(cinema);
		sf.setDate(date);
		sf.setMovie(movie);
		sessionService.getAllSessions(1, 10, sf);
		return "movie-payment";
	}
//非常奇怪，没有找到showSeats对应的函数，不知道是不是漏看了，这里写的其实是showSession的操作
}
