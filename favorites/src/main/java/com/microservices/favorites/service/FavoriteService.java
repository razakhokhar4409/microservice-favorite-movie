package com.microservices.favorites.service;

import com.microservices.favorites.feign.FavoriteFeign;
import com.microservices.favorites.model.Favorite;
import com.microservices.favorites.model.Movie;
import com.microservices.favorites.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    FavoriteFeign favoriteFeign;

    public ResponseEntity<String> createFavorites(String genre){
        try {
            List<Integer> favoriteMoviesId = favoriteFeign.getMoviesIdByGenre(genre).getBody();
            Favorite favorite = new Favorite();
            favorite.setFavoriteMoviesIds(favoriteMoviesId);
            favoriteRepository.save(favorite);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Movie>> fetchFavoriteMovie(int id){
        try {
            Favorite favorite = favoriteRepository.findById(id).get();
            List<Integer> moviesIds = new ArrayList<>();

            for(int fid : favorite.getFavoriteMoviesIds()){
                moviesIds.add(fid);
            }
            List<Movie> favoriteMoviesId = favoriteFeign.getMoviesById(moviesIds).getBody();

            return new ResponseEntity<>(favoriteMoviesId, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
