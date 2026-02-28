package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;


@Controller
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	//get all movies
	@GetMapping("/all")
	public String getAllMovies(Model model){
		model.addAttribute("movies", movieService.getAllMovies());
		return "movies.html";
	}
	
	//create
	@GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "addNewMovies";
    }
	
	@PostMapping("/add")
	public String addNewMovie(@ModelAttribute Movie movie) {
		movieService.createNewMovie(movie);
		return "redirect:/movies/all";
	}
	
	//update 
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable int id, Model model) {
	    model.addAttribute("movie", movieService.getMovieById(id));
	    return "updateMovie";
	}
	
	@PutMapping("/edit/{id}")
	public String updatemovie(@PathVariable int id, @ModelAttribute Movie movie) {
		movieService.updateMovie(movie, id);
	    return "redirect:/movies/all";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMovie(@PathVariable int id) {
	    movieService.deleteMovie(id);
	    return "redirect:/movies/all";
	}
}
