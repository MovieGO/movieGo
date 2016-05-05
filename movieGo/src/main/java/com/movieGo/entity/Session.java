package com.movieGo.entity;

import java.util.Date;
import java.util.Set;

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
	private Cinema cinema;
	
	@ManyToOne
	private Movie movie;
	
	@Column(nullable = false)
	private @Setter @Getter String hall;
	
	@Column(nullable = false)
	private @Setter @Getter Double price;
	
	@Column(nullable = false)
	private @Setter @Getter seatStatus[][] seats;
	
	@Column(nullable = false)
	private @Setter @Getter Date showTime;
	
	@Column(nullable = false)
	private @Setter @Getter Date endTime;
	
	public void setSeatStatus(int x, int y, seatStatus s) {
		if (seats[x][y] != seatStatus.NOTASEAT) {
			seats[x][y] = s;
		}
	}
}
