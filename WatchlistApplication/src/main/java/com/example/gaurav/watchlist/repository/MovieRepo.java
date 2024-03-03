package com.example.gaurav.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gaurav.watchlist.entity.movie;

@Repository
public interface MovieRepo extends JpaRepository<movie,Integer> {
	

}
