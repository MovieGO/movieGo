package com.movieGo.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private @Setter @Getter User user;
	
	
	public static final int maxOrderN = 4;
	
	public static enum Status {
		WAITPAY, PAID, CANCELED, SUCCEED;
	}
	
	public Order() {super();}
	
	@ManyToOne
	private @Setter @Getter Session session;
	
	
	@Column(nullable = false)
	private @Setter @Getter Double bill;
	
	@Column(nullable = false)
	private @Getter Date order_time = this.getCreatedAt();
	
	@Column(nullable = false)
	private @Setter @Getter Status status;
	
	@Column(nullable = false)
	private @Setter @Getter Integer[] seatsx;
	
	@Column(nullable = false)
	private @Setter @Getter Integer[] seatsy;
	
	public void setSeats(ArrayList<Integer> sx, ArrayList<Integer> sy) {
		if (sx.size() <= maxOrderN) {
			for (int i = 0; i < sx.size(); i++) {
				seatsx[i] = sx.get(i);
				seatsy[i] = sy.get(i);
			}
		}
	}
	
}
