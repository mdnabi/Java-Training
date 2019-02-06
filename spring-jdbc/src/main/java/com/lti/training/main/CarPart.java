package com.lti.training.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carparts")
public class CarPart {
	
	@Id
	@GeneratedValue
	@Column(name="partno")
	private int partNo;
	
	@Column(name="name")
	private String partName;
	
	@Column(name="carmodel")
	private String carModel;
	
	@Column(name="price")
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	
	
	public int getPartNo() {
		return partNo;
	}
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CarPart [partNo=" + partNo + ", partName=" + partName + ", carModel=" + carModel + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
}
