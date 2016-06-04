package com.movieGo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movieGo.entity.User;
import com.movieGo.service.UserService;

@Controller

public class UserController {
	@Autowired
	private UserService userService;
	public UserController() {super();}
	
	
	@RequestMapping("/login")
    public String signin(Principal principal, RedirectAttributes ra) {
        return principal == null ? "index" : "index";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "index";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(User user) {
		user.setRole(User.ROLE_USER);
		userService.signup(user);
		return "index";
	}
	
	@RequestMapping(value = "/signup/{user}", method = RequestMethod.GET)
	public String signupGet(@PathVariable User user) {
		return "index";
	}
	
}
