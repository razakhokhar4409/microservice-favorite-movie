package com.microservices.favorites.repository;

import com.microservices.favorites.model.Favorite;
import com.microservices.favorites.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Integer> {
}
