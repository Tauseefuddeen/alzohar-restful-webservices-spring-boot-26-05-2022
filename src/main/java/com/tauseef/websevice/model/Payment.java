package com.tauseef.websevice.model;

import java.util.Date;

public class Payment {

	public int paymentId;
	public String paymentName;
	public String customerName;
	public String email;
	private Date paymentDate;
	
	public Payment() {}
	public Payment(int paymentId, String paymentName, String customerName, String email) {
		super();
		this.paymentId = paymentId;
		this.paymentName = paymentName;
		this.customerName = customerName;
		this.email = email;
		this.paymentDate = paymentDate;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
