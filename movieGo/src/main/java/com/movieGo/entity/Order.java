package com.movieGo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="Orders")
@Entity

public class Order extends baseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3083641849975822426L;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private @Setter @Getter User user;
	
	
	public static final int maxOrderN = 4;
	
	public static enum Status {
		WAITPAY, PAID, CANCELED, SUCCEED;
	}
	
	@ManyToOne
	private @Setter @Getter Session session;
	
	
	@Column(nullable = false)
	private @Setter @Getter Double bill;
	
	@Column(nullable = false)
	private @Getter Date order_time = this.getCreatedAt();
	
	@Column(nullable = false)
	private @Setter @Getter int status;
	
	@Column(nullable = false)
	private @Getter int[][] seats;
	
	public void setSeats(int[][] s) {
		if (s.length <= maxOrderN) {
			for (int i = 0; i < s.length; i++) {
				seats[i][0] = s[i][0];
				seats[i][1] = s[i][1];
			}
		}
	}
	
}
