package com.example.gaurav.watchlist.controller;

import java.util.HashMap;
import java.util.Map;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.gaurav.watchlist.entity.movie;
import com.example.gaurav.watchlist.service.DatabaseService;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseservice;

	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
	
		String viewName = "watchlistItemForm";
		Map<String,Object> model = new HashMap<>();
		if(id==null) {
			model.put("watchlistItem", new movie());
		} else {
			model.put("watchlistItem",databaseservice.getMovieById(id) );
		}
//		movie dummyMovie = new movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(0);
//		dummyMovie.setPriority("Low");
//		dummyMovie.setComment("awesome");
//		model.put("watchlistItem", dummyMovie);
		
		
		return new ModelAndView(viewName,model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm (@Validated @ModelAttribute("watchlistItem") movie movie, BindingResult bindingresult) {
		if(bindingresult.hasErrors()) {
			// if errors are there, redisplay the form and let user enter again
			return new ModelAndView("watchlistItemForm");
		}
		
		RedirectView rd = new RedirectView();
		
		Integer id = movie.getId();
		if(id==null) {
			databaseservice.create(movie);
		} else {
			databaseservice.update(movie,id);
		}
		rd.setUrl("/watchlist");
		return new ModelAndView(rd);
		
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		String viewName = "watchlist";
		Map<String,Object> model = new HashMap<>();
		List<movie> movielist = databaseservice.getAllMovies();
		
		model.put("watchlistrows",movielist);
		model.put("noofmovies",movielist.size());
		return new ModelAndView(viewName,model);
	}
	
	
}
