package com.movieGo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieGo.entity.Order;
@Repository
@Transactional
public interface OrderRepo extends JpaRepository<Order, Long> {
	
}
