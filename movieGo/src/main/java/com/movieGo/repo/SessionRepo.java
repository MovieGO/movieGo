package com.movieGo.repo;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movieGo.entity.Movie;
import com.movieGo.entity.Session;
@Repository
@Transactional
public interface SessionRepo extends JpaRepository<Session, Long> {
	Page<Session> findAll(Specification<Session> cond, Pageable pageRequest);
	
	@Query(
			"SELECT DISTINCT s FROM Session s JOIN FETCH s.orders "
			+ "WHERE s.id = :sid")
	Session fetchOrders(@Param("sid") Long sid);
}


