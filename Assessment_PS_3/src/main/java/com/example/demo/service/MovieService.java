package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;


@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	
	//create
	public Movie createNewMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	//read
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(int id) {
		if(!movieRepository.existsById(id)) {
			throw new RuntimeException("Movie does not exist by id : " + id);
		}
		return movieRepository.findById(id).orElse(null);
	}
	//update
	public Movie updateMovie(Movie movie, int id) {
		if(!movieRepository.existsById(id)) {
			throw new RuntimeException("Movie does not exist by id : " + id);
		}
		
		movie.setId(id);
		return movieRepository.save(movie);
	}
	
	//delete
	public void deleteMovie(int id) {
		if(!movieRepository.existsById(id)) {
			throw new RuntimeException("Movie does not exist by id : " + id);
		}
		movieRepository.deleteById(id);
	}
}
