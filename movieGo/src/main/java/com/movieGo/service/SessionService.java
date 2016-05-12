package com.movieGo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movieGo.entity.Session;
import com.movieGo.form.sessionQueryForm;
import com.movieGo.repo.SessionRepo;
import com.movieGo.support.querySupport.SessionQuery;

@Service
public class SessionService {
	@Autowired
	private SessionRepo sessionRepo;
	public Page<Session> getAllSessions(int page, int pageSize, sessionQueryForm sf) {
		return sessionRepo.findAll(
				new SessionQuery(sf),
				new PageRequest(page, pageSize, Sort.Direction.DESC, "showTime"));
	}
	
}
