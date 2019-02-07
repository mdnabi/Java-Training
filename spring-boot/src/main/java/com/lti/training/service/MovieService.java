package com.lti.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.dao.MovieRepository;
import com.lti.training.entity.Movie;




@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public void add(Movie movie) {
		movieRepository.add(movie);
	}
	
	public Movie fetch(int id) {
		return movieRepository.fetch(id);
	}
}
