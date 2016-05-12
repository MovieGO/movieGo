package com.movieGo.support.querySupport;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.movieGo.entity.Cinema;
import com.movieGo.form.cinemaQueryForm;

import lombok.Getter;
import lombok.Setter;

public class CinemaQuery implements Specification<Cinema>{
	private @Getter @Setter cinemaQueryForm cond;
	public CinemaQuery(cinemaQueryForm cond) {
		this.cond = cond;
	}
	
	
	@Override
	public Predicate toPredicate(Root<Cinema> root, javax.persistence.criteria.CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		List<Predicate> list = new ArrayList<Predicate>();
		if (cond.getName() != null && cond.getName().trim().length() > 0) {
			list.add(cb.like(root.get("name").as(String.class), "%"+cond.getName()+"%"));
		}
		if (cond.getRating() != null) {
			list.add(cb.equal(root.get("rating").as(Integer.class), cond.getRating()));
		}
		if (cond.getAddress() != null && cond.getCity() != null) {
			list.add(cb.equal(root.get("address").as(String.class), cond.getAddress()));
			list.add(cb.equal(root.get("city").as(Integer.class), cond.getCity()));
		}
		Predicate[] p = new Predicate[list.size()];  
	    return cb.and(list.toArray(p));
	}
}
