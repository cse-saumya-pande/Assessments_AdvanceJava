package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private final Map<Long, Movie> movieStore = new HashMap<>();
    private long idCounter = 1;

    public Movie save(Movie movie) {
        movie.setId(idCounter);
        movieStore.put(idCounter, movie);
        idCounter++;
        return movie;
    }

    public List<Movie> findAll() {
        return new ArrayList<>(movieStore.values());
    }

    public Optional<Movie> findById(long id) {
        return Optional.ofNullable(movieStore.get(id));
    }

    public boolean existsById(long id) {
        return movieStore.containsKey(id);
    }
}