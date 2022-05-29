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

import com.tauseef.websevice.model.Order;

@RestController
public class OrderController {
	
	List<Order> orders = new ArrayList<Order>();
	
	// get all Orders
	@GetMapping("/orders")
	public List<Order> getAll() {
		if (orders.isEmpty()) {
			addDefaults();
		}
		return orders;
	}
	// get one by id
	@GetMapping("/orders/{id}")
	public Order getOne(@PathVariable("id") int id) {
		// add a products list
		if (orders.isEmpty()) {
			addDefaults();
		}
		// find a product
		for (Order order : orders) {
			if (order.getId() == id) {
				return order;
			}
		}
		return null;
	}
	// get one by name
	@GetMapping("/order")
	public Order getOne(@RequestParam("name") String name) {
		// add a orders list
		if (orders.isEmpty()) {
			addDefaults();
		}
		// find a orders
		for (Order order : orders) {
			if (order.getCustomerName().equals(name)) {
				return order;
			}
		}
			return null;
	
	}
	// search one by name
	@GetMapping("/order/search")
	public Order searchOne(@RequestParam("name") String name) {
		// add a products list
		if (orders.isEmpty()) {
			addDefaults();
		}
	// find a order
		for (Order order : orders) {
			if (order.getCustomerName().contains(name)) {
				return order;
			}
		}
		return null;
	}
	// add one
	@PostMapping("/orders")
	public Order addOne(@RequestBody Order order) {
		if (order != null) {
			orders.add(order);
			return order;
		}
		return null;
	}
	// update one
	@PutMapping("/products")
	public Order updateOne(@RequestBody Order order) {
		if (order != null) {
			for (int index = 0; index < orders.size(); index++) {
				if (orders.get(index).getId() == order.getId()) {
					// replace /update on products list object
					orders.set(index, order);
					return order;
				}
			}
		}
			return null;
	}

	// delete one
	@DeleteMapping("/orders/{id}")
	public Order deleteOne(@PathVariable("id") int id) {
			for (int index = 0; index < orders.size(); index++) {
				if (orders.get(index).getId() == id) {
					// delete from Orders list					
					return orders.remove(index);
				}
			}
	return null;
	}
// add default Orders
	private void addDefaults() {
		orders.add(new Order(10011, "John Smith", 99322001.2));
		orders.add(new Order(10022, "Mike Smith", 88322001.2));
		orders.add(new Order(10033, "David Smith", 88322001.2));
		orders.add(new Order(10044, "Aria Smith", 88322001.2));
	}
	
}
