package com.microservices.movies.repository;

import com.microservices.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByGenres(String genre);

    @Query(value = "select m.mid from Movie m where m.genres = :genre")
    List<Integer> findIdByGenres(String genre);

}
