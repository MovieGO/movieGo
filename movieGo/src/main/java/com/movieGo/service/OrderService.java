package com.movieGo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieGo.entity.Order;
import com.movieGo.entity.Session;
import com.movieGo.entity.User;
import com.movieGo.form.seatsForm;
import com.movieGo.repo.OrderRepo;
import com.movieGo.repo.SessionRepo;
import com.movieGo.repo.UserRepo;

@Service

public class OrderService {
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SessionRepo sessionRepo;
	/**
	 * 创建订单后调用的方法,15min未付款取消订单
	 * @param o 订单
	 */
	public void waitForPay(Order o) {
		class waitPayThread extends Thread {
			private Long oid = null;
			public waitPayThread(Long oid) {
				this.oid = oid;
			}
			public void run() {
				waitPay(oid);
			}
			private synchronized void waitPay(Long oid) {
				try {
					sleep(15*60*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Order o = orderRepo.findOne(oid);
				if (o.getStatus() != Order.Status.PAID) {
					o.setStatus(Order.Status.CANCELED);
					orderRepo.save(o);
				}
			}
		}
		waitPayThread t = new waitPayThread(o.getId());
		t.start();
	}
	/**
	 * 取消订单
	 * @param oid 订单id
	 */
	public void cancelOrder(Long oid) {
		Order o = orderRepo.findOne(oid);
		o.setStatus(Order.Status.CANCELED);
		orderRepo.save(o);
	}
	/**
	 * 创建订单
	 * @param sf 座位表
	 * @param s 关联的场次(已经有id)
	 * @param u 用户
	 * @return 创建好的订单
	 */
	public Order createOrder(seatsForm sf, Session s, User u) {
		Order o = null;
		if (s != null && sf.getNseats() <= Order.maxOrderN) {
			o = new Order();
				o.setBill(sf.getNseats()*s.getPrice());
				o.setSeats(sf.getXList(), sf.getYlist());
				o.setStatus(Order.Status.WAITPAY);
				o.setUser(u);
			User utmp = userRepo.fetchOrders(u.getId());
			if (utmp != null) {
				u = utmp;
			} else {
				u.setOrders(new HashSet<Order>());
			}
			Session stmp = sessionRepo.fetchOrders(s.getId());
			if (stmp != null) {
				s = stmp;
			} else {
				s.setOrders(new HashSet<Order>());
			}
			orderRepo.save(o);
			u.addOrder(o);
			userRepo.save(u);	
			s.getOrders().add(o);
			sessionRepo.save(s);
		}
		return o;
	}
}


