package com.lti.training.entity;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="tbl_payment")
public class Payment {

	@Id
	@GeneratedValue
	private int id;
	private String paymentMode;
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMode() {
		return paymentMode;
	}
	public void setMode(String mode) {
		this.paymentMode = mode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
