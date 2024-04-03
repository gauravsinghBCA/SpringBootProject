package com.example.packageOf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.packageOf.entity.bodyBuilder;
import com.example.packageOf.repository.dataRepository;

@Service
public class dataService {

	@Autowired
	private dataRepository dataRepository;

	public void saveData(bodyBuilder joiner) {
		// TODO Auto-generated method stub
		dataRepository.save(joiner);
	}
	
}
