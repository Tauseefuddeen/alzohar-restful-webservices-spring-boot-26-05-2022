package com.tauseef.websevice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tauseef.websevice.model.Payment;

@RestController
public class PaymentController {
	List<Payment> payments = new ArrayList<Payment>();

	// get all Payments
	@GetMapping("/payments")
	public List<Payment> getAll(){
		if (payments.isEmpty()) {
			addDefaults();
		}
		return payments;
	}
	// get one by id

	@GetMapping("/payments/{id}")
	public Payment getOne(@PathVariable("id") int id) {
		// add a Payments list
		if (payments.isEmpty()) {
			addDefaults();
		}
		// find a payment
		for (Payment payment : payments) {
			if (payment.getPaymentId() == id) {
				return payment;
			}
			
		}
		return null;
		}
		// get one by name
		@GetMapping("/payment")
		public Payment getOne(@RequestParam("name") String name) {
			// add a Payment list
			if (payments.isEmpty()) {
				addDefaults();
			}
			// find a payment
			for (Payment payment : payments) {
				if (payment.getPaymentName().equals(name)) {
					return payment;
				}
			}
			return null;
			
		}
		// search one by name
		@GetMapping("/payment/search")
		public Payment searchOne(@RequestParam("name") String name) {
			// add a payment list
			if (payments.isEmpty()) {
				addDefaults();
			}
			// find a payment
			for (Payment payment : payments) {
				if (payment.getPaymentName().contains(name)) {
					return payment;
				}
			}
			return null;
		}
		// add one
		@PostMapping("/payments")
		public Payment addOne(@RequestBody Payment payment) {
			if (payment !=null) {
				payments.add(payment);
				return payment;
			}
			return null;
		}
		// update one
		@PutMapping("/payments")
		public Payment updateOne(@RequestBody Payment payment) {
			if (payment != null) {
				for (int index = 0; index < payments.size(); index++) {
					if (payments.get(index).getPaymentId() == payment.getPaymentId()) {
						// replace /update on payments list object
						payments.set(index, payment);
						return payment;
					}
				}
			}
			return null;
		}
		// delete one
		@DeleteMapping("/payments/{id}")
		public Payment deleteOne(@PathVariable("id") int id) {
			for (int index = 0; index < payments.size(); index++) {
				if (payments.get(index).getPaymentId() == id) {
					// delete from payments list
					return payments.remove(index);
				}
			}
			return null;
			
		}
		// add default payment

		private void addDefaults() {
	
			payments.add(new Payment(10011,"Debt Payment","John Smith","john.smith@gmail.com"));
			payments.add(new Payment(10012,"Online Payment","Mike Smith","mike.smith@gmail.com"));
			payments.add(new Payment(10013,"Shopping Payment","Aria Smith","aria.smith@gmail.com"));
			payments.add(new Payment(10014,"Salary Payment","Little Smith","little.smith@gmail.com"));
			payments.add(new Payment(10015,"Account Payment","David Will","david.will@gmail.com"));
		
	}
	

}
