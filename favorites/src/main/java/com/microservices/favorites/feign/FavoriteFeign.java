package com.microservices.favorites.feign;

import com.microservices.favorites.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("MOVIE")
public interface FavoriteFeign {

    @GetMapping("movies/IdsFromGenre/{genre}")
    public ResponseEntity<List<Integer>> getMoviesIdByGenre(@PathVariable String genre);

    @PostMapping("movies/genreFromId")
    public ResponseEntity<List<Movie>> getMoviesById(@RequestBody List<Integer> genreIdList);
}
