package com.movies.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.entity.Director;
import com.movies.entity.Movie;
import com.movies.exception.ExpressMoviesException;
import com.movies.repository.DirectorRepository;
import com.movies.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Movie addMovie(Movie movie, Director director)
            throws ExpressMoviesException {

        movie.getDirectors().add(director);

        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieByTitle(String movieTitle)
            throws ExpressMoviesException {

        return movieRepository
                .findByMovieTitleIgnoreCase(movieTitle)
                .orElseThrow(() ->
                        new ExpressMoviesException(
                                "Invalid Movie title"));
    }

    @Override
    public List<Movie> getMoviesByDirector(
            String firstName,
            String lastName)
            throws ExpressMoviesException {

        Director director = directorRepository
                .findByFirstNameIgnoreCaseAndLastNameIgnoreCase(
                        firstName,
                        lastName)
                .orElseThrow(() ->
                        new ExpressMoviesException(
                                "Invalid Director name"));

        return new ArrayList<>(director.getMovies());
    }

    @Override
    public List<Director> getDirectorByMovieTitle(
            String movieTitle)
            throws ExpressMoviesException {

        Movie movie = movieRepository
                .findByMovieTitleIgnoreCase(movieTitle)
                .orElseThrow(() ->
                        new ExpressMoviesException(
                                "Invalid Movie title"));

        return new ArrayList<>(movie.getDirectors());
    }

    @Override
    public List<Movie> getAllMovies()
            throws ExpressMoviesException {

        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovieReleaseDate(
            String movieTitle,
            LocalDate newReleaseDate)
            throws ExpressMoviesException {

        Movie movie = movieRepository
                .findByMovieTitleIgnoreCase(movieTitle)
                .orElseThrow(() ->
                        new ExpressMoviesException(
                                "Invalid Movie title"));

        movie.setDateReleased(newReleaseDate);

        return movieRepository.save(movie);
    }

    @Override
    public Director updateDirectorDetails(
            String firstName,
            String lastName,
            String address,
            Long contactNumber)
            throws ExpressMoviesException {

        Director director = directorRepository
                .findByFirstNameIgnoreCaseAndLastNameIgnoreCase(
                        firstName,
                        lastName)
                .orElseThrow(() ->
                        new ExpressMoviesException(
                                "Invalid Director name"));

        director.setAddress(address);
        director.setContactNumber(contactNumber);

        return directorRepository.save(director);
    }

    @Override
    public void deleteMovie(String movieTitle)
            throws ExpressMoviesException {

        Movie movie = movieRepository
                .findByMovieTitleIgnoreCase(movieTitle)
                .orElseThrow(() ->
                        new ExpressMoviesException(
                                "Movie with the given title is not present"));

        movieRepository.delete(movie);
    }
}