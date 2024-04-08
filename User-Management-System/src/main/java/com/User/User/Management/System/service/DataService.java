package com.User.User.Management.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User.User.Management.System.entity.userData;
import com.User.User.Management.System.repository.dataRepository;

@Service
public class DataService implements UserService{

	@Autowired
	private dataRepository dataRepository;
	@Override
	public userData createData(userData user) {
		return dataRepository.save(user);
		 
	}
	@Override
	public boolean checkEmail(String email) {
	
		return dataRepository.existsByEmail(email);
	}
	
	
}
