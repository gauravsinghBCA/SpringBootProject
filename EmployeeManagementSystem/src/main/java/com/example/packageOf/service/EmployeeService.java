package com.example.packageOf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.packageOf.model.Employee;
import com.example.packageOf.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	public void saveEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}

	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee=optional.get();
		} else {
			throw new RuntimeException("Employee not found by id:: "+id);
		}
		
		return employee;
	}

	public void deleteById(long id) {
		
	   employeeRepository.deleteById(id);
	}

	
}

