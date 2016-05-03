package com.movieGo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieGo.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findUserByMail(String mail);
}
