package com.example.gaurav.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gaurav.watchlist.entity.movie;
import com.example.gaurav.watchlist.repository.MovieRepo;

@Service
public class DatabaseService {

	@Autowired
	MovieRepo movierepo;
	
	@Autowired
	RatingService ratingService; 
	public void create (movie movie) {
		String rating = ratingService.getMovieRating(movie.getTitle());
		if(rating !=null) {
			movie.setRating(Float.parseFloat(rating));
		}
		movierepo.save(movie);
	}
	
	public List<movie> getAllMovies(){
		return movierepo.findAll();
	}
	
	public movie getMovieById(Integer id) {
		return movierepo.findById(id).get();
	}

	public void update(movie movie, Integer id) {
		// TODO Auto-generated method stub
		movie toBeUpdated = getMovieById(id);
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setComment(movie.getComment());
		toBeUpdated.setPriority(movie.getPriority());
		movierepo.save(toBeUpdated);
	}
}
