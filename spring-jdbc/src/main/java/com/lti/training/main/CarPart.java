package com.lti.training.main;

public class CarPart {
	
	private int partNo;
	private String partName;
	private String carModel;
	private double price;
	private int quantity;
	
	public CarPart(int partNo, String partName, String carModel, double price, int quantity) {
		super();
		this.partNo = partNo;
		this.partName = partName;
		this.carModel = carModel;
		this.price = price;
		this.quantity = quantity;
	}
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
	
	
}
