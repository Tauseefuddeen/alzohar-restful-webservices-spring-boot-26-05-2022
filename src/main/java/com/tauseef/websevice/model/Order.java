package com.tauseef.websevice.model;

import java.util.Date;

public class Order {

	public int Id;
	public String customerName;
	public double orderNumber; 
	public Date generatedAt;
	
	public Order() {}
	public Order(int id, String customerName, double orderNumber) {
		Id = id;
		this.customerName = customerName;
		this.orderNumber = orderNumber;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(double orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	
}
