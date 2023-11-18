package com.lcwd.user.service.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.Exception.ResourceNotFoundException;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepo;
	
	// saving User
	public User saveUser(User user) {
		String randomId=UUID.randomUUID().toString();
		user.setUserid(randomId);
		return userRepo.save(user);
	}
	
	// getting all user
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	// get By id
	
	public User getById(String userId) {
		return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with this id not present"));
	}
	
	// delete by Id
	public void deleteUser(String userId) {
		userRepo.deleteById(userId);
	}
}
