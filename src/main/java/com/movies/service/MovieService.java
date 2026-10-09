package com.movies.service;

import java.time.LocalDate;
import java.util.List;

import com.movies.entity.Director;
import com.movies.entity.Movie;
import com.movies.exception.ExpressMoviesException;

public interface MovieService {

    // Add Movie
    Movie addMovie(Movie movie, Director director)
            throws ExpressMoviesException;

    // Search Movie by Title
    Movie getMovieByTitle(String movieTitle)
            throws ExpressMoviesException;

    // Search Movie by Director Name
    List<Movie> getMoviesByDirector(
            String firstName,
            String lastName)
            throws ExpressMoviesException;

    // Search Director by Movie Title
    List<Director> getDirectorByMovieTitle(
            String movieTitle)
            throws ExpressMoviesException;

    // View All Movies
    List<Movie> getAllMovies()
            throws ExpressMoviesException;

    // Update Release Date
    Movie updateMovieReleaseDate(
            String movieTitle,
            LocalDate newReleaseDate)
            throws ExpressMoviesException;

    // Update Director Details
    Director updateDirectorDetails(
            String firstName,
            String lastName,
            String address,
            Long contactNumber)
            throws ExpressMoviesException;

    // Delete Movie
    void deleteMovie(String movieTitle)
            throws ExpressMoviesException;
}