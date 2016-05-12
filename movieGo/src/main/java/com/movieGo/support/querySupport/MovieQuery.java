package com.movieGo.support.querySupport;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.movieGo.entity.Movie;
import com.movieGo.form.movieQueryForm;

import lombok.Getter;
import lombok.Setter;

public class MovieQuery implements Specification<Movie>{
	private @Getter @Setter movieQueryForm cond;
	public MovieQuery(movieQueryForm cond) {
		this.cond = cond;
	}
	
	
	@Override
	public Predicate toPredicate(Root<Movie> root, javax.persistence.criteria.CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		List<Predicate> list = new ArrayList<Predicate>();
		if (cond.getName() != null && cond.getName().trim().length() > 0) {
			list.add(cb.like(root.get("name").as(String.class), "%"+cond.getName()+"%"));
		}
		if (cond.getType() != null) {
			list.add(cb.equal(root.get("type").as(Movie.Type.class), cond.getType()));
		}
		Predicate[] p = new Predicate[list.size()];  
	    return cb.and(list.toArray(p));
	}
}
