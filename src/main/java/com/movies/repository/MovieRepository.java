package com.movies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByMovieTitleIgnoreCase(String movieTitle);

    List<Movie> findByMovieTitleContainingIgnoreCase(String movieTitle);

}