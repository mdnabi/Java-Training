package com.lti.training.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="tbl_order")
public class Order {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="order_date")
	private Date date;
	
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
