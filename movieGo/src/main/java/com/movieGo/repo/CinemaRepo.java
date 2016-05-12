package com.movieGo.repo;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movieGo.entity.Cinema;
import com.movieGo.entity.Movie;
@Repository
@Transactional
public interface CinemaRepo extends JpaRepository<Cinema, Long> {
	Page<Cinema> findAll(Specification<Cinema> cond, Pageable pageRequest);
	@Query(
			"SELECT c from Cinema c INNER JOIN c.movies m"+ 
			"WHERE m.name = :movie"	
					)
	Page<Cinema> findByMovie(@Param("movie") String movieName, Pageable pageRequest);
}


