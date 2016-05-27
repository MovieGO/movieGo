package com.movieGo.support.querySupport;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.movieGo.entity.Session;
import com.movieGo.form.sessionQueryForm;

import lombok.Getter;
import lombok.Setter;

public class SessionQuery implements Specification<Session>{
	private @Getter @Setter sessionQueryForm cond;
	public SessionQuery(sessionQueryForm cond) {
		this.cond = cond;
	}
	
	
	@Override
	public Predicate toPredicate(Root<Session> root, javax.persistence.criteria.CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		List<Predicate> list = new ArrayList<Predicate>();
		if (cond.getCinema() != null) {
			list.add(cb.equal(root.get("cinema"), cond.getCinema()));
		}
		if (cond.getDate() != null) {
			list.add(cb.equal(root.get("date"),cond.getDate()));
		}
		if (cond.getMovie() != null) {
			list.add(cb.equal(root.get("movie"), cond.getMovie()));
		}
		Predicate[] p = new Predicate[list.size()];  
	    return cb.and(list.toArray(p));
	}
}
