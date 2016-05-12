package com.movieGo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movieGo.entity.Movie;
import com.movieGo.entity.User;
@Repository
@Transactional
public interface MovieRepo extends JpaRepository<Movie, Long> {
	Page<Movie> findAll(Specification<Movie> cond, Pageable pageRequest);
	@Query(
			"SELECT m from Movie m INNER JOIN m.cinemas c"+ 
			"WHERE c.name = :cinema"	
			)
	Page<Movie> findByCinema(@Param("cinema") String cinemaName, Pageable pageRequest);
}
