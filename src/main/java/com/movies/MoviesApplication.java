package com.movies;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movies.entity.Director;
import com.movies.entity.Movie;
import com.movies.exception.ExpressMoviesException;
import com.movies.service.MovieService;

@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EXPRESS MOVIES =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie By Title");
            System.out.println("3. Search Movies By Director");
            System.out.println("4. Search Director By Movie");
            System.out.println("5. View All Movies");
            System.out.println("6. Update Movie Release Date");
            System.out.println("7. Update Director Details");
            System.out.println("8. Delete Movie");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {

                switch (choice) {

                case 1:

                    Movie movie = new Movie();

                    System.out.print("Movie Title: ");
                    movie.setMovieTitle(sc.nextLine());

                    System.out.print("Release Date (yyyy-mm-dd): ");
                    movie.setDateReleased(
                            LocalDate.parse(sc.nextLine()));

                    System.out.print("Running Time: ");
                    movie.setMovieRunningTime(sc.nextLine());

                    Director director = new Director();

                    System.out.print("Director First Name: ");
                    director.setFirstName(sc.nextLine());

                    System.out.print("Director Last Name: ");
                    director.setLastName(sc.nextLine());

                    System.out.print("Address: ");
                    director.setAddress(sc.nextLine());

                    System.out.print("Contact Number: ");
                    director.setContactNumber(
                            Long.parseLong(sc.nextLine()));

                    System.out.print("Email: ");
                    director.setEmail(sc.nextLine());

                    movieService.addMovie(movie, director);

                    System.out.println("Movie Added Successfully");

                    break;

                case 2:

                    System.out.print("Enter Movie Title: ");

                    String movieTitle = sc.nextLine();

                    Movie foundMovie =
                            movieService.getMovieByTitle(movieTitle);

                    System.out.println(foundMovie);

                    break;

                case 3:

                    System.out.print("Director First Name: ");
                    String firstName = sc.nextLine();

                    System.out.print("Director Last Name: ");
                    String lastName = sc.nextLine();

                    List<Movie> movies =
                            movieService.getMoviesByDirector(
                                    firstName,
                                    lastName);

                    movies.forEach(System.out::println);

                    break;

                case 4:

                    System.out.print("Movie Title: ");

                    String title = sc.nextLine();

                    List<Director> directors =
                            movieService
                                    .getDirectorByMovieTitle(title);

                    directors.forEach(System.out::println);

                    break;

                case 5:

                    List<Movie> allMovies =
                            movieService.getAllMovies();

                    allMovies.forEach(System.out::println);

                    break;

                case 6:

                    System.out.print("Movie Title: ");

                    String updateTitle = sc.nextLine();

                    System.out.print(
                            "New Release Date (yyyy-mm-dd): ");

                    LocalDate newDate =
                            LocalDate.parse(sc.nextLine());

                    movieService.updateMovieReleaseDate(
                            updateTitle,
                            newDate);

                    System.out.println(
                            "Release Date Updated Successfully");

                    break;

                case 7:

                    System.out.print("Director First Name: ");
                    String fName = sc.nextLine();

                    System.out.print("Director Last Name: ");
                    String lName = sc.nextLine();

                    System.out.print("New Address: ");
                    String address = sc.nextLine();

                    System.out.print("New Contact Number: ");
                    Long contact =
                            Long.parseLong(sc.nextLine());

                    movieService.updateDirectorDetails(
                            fName,
                            lName,
                            address,
                            contact);

                    System.out.println(
                            "Director Updated Successfully");

                    break;

                case 8:

                    System.out.print("Movie Title: ");

                    String deleteTitle = sc.nextLine();

                    movieService.deleteMovie(deleteTitle);

                    System.out.println(
                            "Movie Deleted Successfully");

                    break;

                case 9:

                    System.out.println("Thank You");

                    sc.close();

                    System.exit(0);

                    break;

                default:

                    System.out.println(
                            "Invalid Choice");
                }

            } catch (ExpressMoviesException e) {

                System.out.println(e.getMessage());

            } catch (Exception e) {

                System.out.println(
                        "Error : " + e.getMessage());
            }
        }
    }
}