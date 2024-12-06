package com.crud.service;

import java.util.List;

import com.crud.entities.User;

public interface UserService {
	
	User saveUser(User user);
	List<User> getAllUser();
	User getById(int id);
	User updateUser(int id, User user);
	String delete(int id);

}
