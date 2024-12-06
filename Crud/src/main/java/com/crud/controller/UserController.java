package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entities.User;
import com.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		return saveUser;
	}
	
	@GetMapping
	public List<User> getAll(){
		List<User> allUser = userService.getAllUser();
		return allUser;
	}
	
	@GetMapping("/{id}")
	public User getId(@PathVariable("id") int id) {
		User byId = userService.getById(id);
		return byId;
		
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		User updateUser = userService.updateUser(id, user);
		return updateUser;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		String delete = userService.delete(id);
		return delete;
	}
}
