package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.UserRepository;
import com.crud.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		User save = userRepository.save(user);
		return save;
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	@Override
	public User getById(int id) {
		User orElseThrow = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"+id));
		return orElseThrow;
	}

	@Override
	public User updateUser(int id, User user) {
		User orElseThrow = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
		orElseThrow.setName(user.getName());
		orElseThrow.setPassword(user.getPassword());
		User save = userRepository.save(user);
		
		return save;
	}

	@Override
	public String delete(int id) {
		User orElseThrow = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
		userRepository.delete(orElseThrow);
		return "Deleted successfully";
	}

	

}
