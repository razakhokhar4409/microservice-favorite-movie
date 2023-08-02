package com.microservices.favorites.controller;

import com.microservices.favorites.model.Movie;
import com.microservices.favorites.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favorite")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;
    @PostMapping("create/{genre}")
    public ResponseEntity<String> createFavorites(@PathVariable String genre){
        return favoriteService.createFavorites(genre);
    }

    @GetMapping("getMovies/{id}")
    public ResponseEntity<List<Movie>> fetchFavoriteMovie(@PathVariable int id){
        return  favoriteService.fetchFavoriteMovie(id);
    }


}
