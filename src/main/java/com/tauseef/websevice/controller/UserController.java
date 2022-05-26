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

import com.tauseef.websevice.model.User;

@RestController
public class UserController {

	List<User> users = new ArrayList<User>();
	
		// get all User
	@GetMapping("/users")
	public List<User> getAll() {
		if (users.isEmpty()) {
		addDefaults();
		}
		return users;
	}
	// get one by id
	@GetMapping("/user/{id}")
	public User getOne(@PathVariable("id") int id) {
	// add a User list
		if (users.isEmpty()) {
			addDefaults();
		}
		// find a User
		for (User user : users) {
			if (user.getUserId() == id) {
				return user;
			}
		}
		return null;
		}
	// get one by name
	@GetMapping("/user")
	public User getOne(@RequestParam("name") String name) {
		// add a User list
		if (users.isEmpty()) 
			addDefaults();
		
	
	// find a user
	for (User user : users) {
		if (user.getName().equals(name)) {
			return user;
		}
	}
	return null;
	}
	


	// search one by name
	@GetMapping("/user/search")
	public User searchOne(@RequestParam("name") String name) {
		// add a User list
		if (users.isEmpty()) {
			addDefaults();
			
		}
		// find a users
		for (User user : users) {
			if (user.getName().contains(name)) {
				return user;
			}
		}
		return null;
		}

	// add one
	@PostMapping("/users")
	public User addOne(@RequestBody User user) {
		if (user != null) {
			users.add(user);
			return user;
		}
		return null;
	}
	// update one
	@PutMapping("/users")
	public User updateOne(@RequestBody User user) {
		if (user != null) {
			for (int index = 0; index < users.size(); index++) {
				if (users.get(index).getUserId() == user.getUserId()) {
					// replace /update on user list object
					users.set(index, user);
					return user;
				}
			}
		}
		return null;
	}
	// delete one
	@DeleteMapping("/users/{id}")
	public User deleteOne(@PathVariable("id") int id) {
		for (int index = 0; index < users.size(); index++) {
			if (users.get(index).getUserId() == id) {
				// delete from users list
				return users.remove(index);
			}
		}
		return null;
	}
	// add default users
	private void addDefaults() {
		users.add(new User(10001,"John Smith","john.smith@gmail.com","New York City",true));
		users.add(new User(10002,"Mike Smith","mike.smith@gmail.com","Maxico City",false));
		users.add(new User(10003,"Aria Smith","aria.smith@gmail.com","Belgium City",true));
		users.add(new User(10004,"David Will","david.will@gmail.com","Malysia City",true));
		users.add(new User(10005,"Ajay Atul","ajay.atul@gmail.com","Nagpur City",true));
	}

}
