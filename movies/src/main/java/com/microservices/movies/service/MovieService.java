package com.microservices.movies.service;

import com.microservices.movies.model.Movie;
import com.microservices.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public ResponseEntity<List<Movie>> getAllMovies(){
        try {
            return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Movie>> getMoviesByGenre(String genre) {
        try {
            return new ResponseEntity<>(movieRepository.findByGenres(genre), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> getMoviesIdByGenre(String genre) {
        try {
            return new ResponseEntity<>(movieRepository.findIdByGenres(genre), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Movie>> getMoviesById(List<Integer> genreIdList) {
        try {
            List<Movie> listOfMovies = genreIdList
                    .stream()
                    .map(id -> movieRepository.findById(id).isPresent() ? movieRepository.findById(id).get() : new Movie())
                    .toList();
            System.out.println("Movies are : "+ listOfMovies);
            return new ResponseEntity<>(listOfMovies, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
