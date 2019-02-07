package com.lti.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.entity.Movie;
import com.lti.training.service.MovieService;

@RestController
@CrossOrigin	//Set the headers for talking to the angular
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(path="/movie/add", method=RequestMethod.POST)
	public String add(@RequestBody Movie movie) {
		movieService.add(movie);
		return "Movie record added successfully";
	}
	
	@RequestMapping(path="/movie/{id}", method=RequestMethod.GET)
	public Movie fetch(@PathVariable("id") int id) {
		return movieService.fetch(id);
	}
}
