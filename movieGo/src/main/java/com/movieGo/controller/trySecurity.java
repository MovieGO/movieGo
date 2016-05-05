package com.movieGo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movieGo.entity.User;
import com.movieGo.form.loginForm;
import com.movieGo.service.UserService;

@Controller
public class trySecurity {
	@Autowired
	private UserService userService;
	public trySecurity() {super();}
	
	@RequestMapping(value = "/")
	public @ResponseBody String mainPage() {
		return "hello";
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(loginForm loginform) {
		User user = new User(loginform.getMail(),loginform.getPw(),User.ROLE_USER);
		userService.signin(user);
		return "redirect:/";
	}*/
	
	@RequestMapping("/login")
    public String signin(Principal principal, RedirectAttributes ra) {
        return principal == null ? "/login" : "redirect:/";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(loginForm loginform) {
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
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public @ResponseBody String onlyAdmin() {
		return "hello, admin";
	}
}
