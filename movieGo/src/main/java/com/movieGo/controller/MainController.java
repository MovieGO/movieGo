package com.movieGo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(value = "/")
	public @ResponseBody String mainPage() {
		return "index";
	}
}
