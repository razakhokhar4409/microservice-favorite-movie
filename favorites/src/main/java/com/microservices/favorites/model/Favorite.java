package com.microservices.favorites.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionType;

import java.util.List;

@Data
@Entity
@Table(name = "favorite")
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int fid;

    @ElementCollection
    List<Integer> favoriteMoviesIds;
}
