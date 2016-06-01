package com.movieGo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        return principal == null ? "/login" : "redirect:/";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "login";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(User user) {
		user.setRole(User.ROLE_USER);
		userService.signup(user);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(User user) {
		return "signup";
	}
}
