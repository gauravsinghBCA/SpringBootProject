package com.example.packageOf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.packageOf.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
