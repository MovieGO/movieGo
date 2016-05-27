package com.movieGo.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Session")
public class Session extends baseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6946813268358433426L;
	public static int maxSize = 20;
	
	public static enum seatStatus {
		AVAILABLE, LOCKED, UNAVAILABLE, NOTASEAT
	}
	
	public Session() {super();}
	
	@ManyToOne
	private @Setter @Getter Cinema cinema;
	
	@ManyToOne
	private @Setter @Getter Movie movie;
	
	@OneToMany
	private @Setter @Getter Set<Order> orders = new HashSet<Order>();
	
	@Column(nullable = false)
	private @Setter @Getter String hall;
	
	@Column(nullable = false)
	private @Setter @Getter Double price;
	
	@Column(nullable = false)
	private @Setter @Getter seatStatus[][] seats;
	
	@Column(nullable = false)
	private @Getter Date showTime;
	
	@Column(nullable = false)
	private @Setter @Getter Date endTime;
	
	@Column(nullable = false)
	private @Setter @Getter String date;
	
	public void setSeatStatus(int x, int y, seatStatus s) {
		if (seats[x][y] != seatStatus.NOTASEAT) {
			seats[x][y] = s;
		}
	}
	
	private void setDate() {
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		this.date = f.format(showTime);
	}
	
	public void setShowTime(Date t) {
		this.showTime = t;
		setDate();
	}
}
