package com.example.packageOf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.packageOf.entity.bodyBuilder;

@Repository
public interface dataRepository extends JpaRepository<bodyBuilder, Integer>{

}
