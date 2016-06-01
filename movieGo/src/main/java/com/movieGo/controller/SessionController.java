package com.movieGo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.movieGo.service.SessionService;;
/*
 * main page of one session, triggered by "选座购票" button
 * the page ONLY contains seats status and(maybe) brief session info
 * 
 */
@Controller
@RequestMapping("/seats")
public class SessionController {
	private final SessionService sessionService;
	
	public SessionController(final SessionService sessionService) {
		this.sessionService = sessionService;
	}
	@RequestMapping
	public String showSeats(long movieId) {
		return "movie-payment";
	}

}
