package com.movieGo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Table(name="User")
@Entity
@Getter @Setter
public class User extends baseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4811181582256823912L;
	
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
    public static final String ROLE_USER  = "ROLE_USER";
    
	public User(String mail, String pw, String role) {
		this.mail = mail;
        this.pw = pw;
        this.role = role;
	}
	
	@Column(nullable = false, unique = true)
	private @Setter @Getter String mail;
	
    @Column(nullable = false)
	private @Setter @Getter String pw;
    
    @Column(nullable = false)
	private @Setter @Getter String city;
    
    @Column(nullable = false)
	private @Setter @Getter String role = ROLE_USER;
    
    @Column
	private @Setter @Getter int gender;
    
    @Column
	private @Setter @Getter int age;
    
    @OneToMany(cascade = {  CascadeType.PERSIST,
            				CascadeType.MERGE,
            				CascadeType.REMOVE },
    		   mappedBy = "user")
  	private @Getter Set<Order> orders = new HashSet<>();
    
    public void addOrder(Order order) {
    	orders.add(order);
    }
}
