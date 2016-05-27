package com.movieGo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movieGo.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findUserByMail(String mail);
	@Query(
			"SELECT DISTINCT u FROM User u JOIN FETCH u.orders "
			+ "WHERE u.id = :uid")
	public User fetchOrders(@Param("uid") Long uid);
}
