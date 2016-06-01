package com.movieGo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.movieGo.service.*;
import com.movieGo.form.*;
import com.movieGo.entity.*;
/*
 * 1.seats has been selected, order has been confirmed, 
 *   create an order and set 15 minutes to wait
 * 2.cancel order
 */
@Controller
@RequestMapping("/order")

public class OrderController {
	public OrderService orderService;
	@RequestMapping("/new")
	public String makeOrder(Session s, seatsForm sf, User u) {
		orderService.createOrder(sf, s, u);
		return "movie-payment";
	}
	
	@RequestMapping("/delete")
	public String deleteOrder(Long oid) {
		orderService.cancelOrder(oid);
		return "movie-payment";
	}
}
