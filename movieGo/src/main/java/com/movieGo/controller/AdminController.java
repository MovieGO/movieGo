package com.movieGo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 管理员权限：
 * ？有哪些
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public @ResponseBody String onlyAdmin() {
		return "hello, admin";
	}
}
