package com.movies.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Movie_Id")
    private Integer movieId;

    @Column(name = "Movie_Title")
    private String movieTitle;

    @Column(name = "Date_Released")
    private LocalDate dateReleased;

    @Column(name = "Movie_Running_Time")
    private String movieRunningTime;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "Movie_Director",
            joinColumns = @JoinColumn(name = "Movie_Id"),
            inverseJoinColumns = @JoinColumn(name = "Director_Id")
    )
    private Set<Director> directors = new HashSet<>();

    public Movie() {
    }

    public Movie(Integer movieId, String movieTitle,
                 LocalDate dateReleased,
                 String movieRunningTime) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.dateReleased = dateReleased;
        this.movieRunningTime = movieRunningTime;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public LocalDate getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(LocalDate dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getMovieRunningTime() {
        return movieRunningTime;
    }

    public void setMovieRunningTime(String movieRunningTime) {
        this.movieRunningTime = movieRunningTime;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @Override
    public String toString() {
        return "\nMovie ID      : " + movieId +
               "\nMovie Title   : " + movieTitle +
               "\nRelease Date  : " + dateReleased +
               "\nRunning Time  : " + movieRunningTime + " mins\n";
    }
}