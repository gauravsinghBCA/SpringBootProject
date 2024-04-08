package com.User.User.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.User.User.Management.System.entity.userData;

@Repository
public interface dataRepository extends JpaRepository<userData, Integer>{

	boolean existsByEmail(String email);

}
