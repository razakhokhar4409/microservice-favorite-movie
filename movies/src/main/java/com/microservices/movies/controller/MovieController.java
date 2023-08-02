package com.microservices.movies.controller;

import com.microservices.movies.model.Movie;
import com.microservices.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/allMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return  movieService.getAllMovies();
    }

    @GetMapping("genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre){
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("IdsFromGenre/{genre}")
    public ResponseEntity<List<Integer>> getMoviesIdByGenre(@PathVariable String genre){
        return movieService.getMoviesIdByGenre(genre);
    }

    @PostMapping("genreFromId")
    public ResponseEntity<List<Movie>> getMoviesById(@RequestBody List<Integer> genreIdList){
        return movieService.getMoviesById(genreIdList);
    }

}
