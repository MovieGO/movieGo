package com.movieGo.repo;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieGo.entity.Session;
@Repository
@Transactional
public interface SessionRepo extends JpaRepository<Session, Long> {
	Page<Session> findAll(Specification<Session> cond, Pageable pageRequest);
}


