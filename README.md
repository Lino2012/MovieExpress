# ExpressMovies – Movie Management System

A Java-based movie management application developed using **Spring Boot, Spring Data JPA, Hibernate, and MySQL**. ExpressMovies manages movie and director information through CRUD operations and custom search functionality.

## Features

- **Add Movie:** Save movie and director details in the database.
- **Search Movie by Title:** Retrieve movie details using the movie title.
- **Search Movies by Director:** Find movies associated with a director's first and last name.
- **Search Director by Movie:** Retrieve director details for a given movie.
- **View All Movies:** Display all available movies.
- **Update Movie Release Date:** Modify the release date of an existing movie.
- **Update Director Details:** Update a director's address and contact number.
- **Delete Movie:** Remove a movie and its associated movie-director relationship.
- **Exception Handling:** Handle invalid movie titles, director names, and other errors.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL 8
- Maven
- Spring Tool Suite (STS) / Eclipse

## Project Architecture

The application follows a layered architecture:

```text
ExpressMovies
│
├── src/main/java/com/movies
│   ├── entity
│   │   ├── Movie.java
│   │   └── Director.java
│   ├── repository
│   ├── service
│   ├── exception
│   └── MoviesApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── src/test
├── pom.xml
├── .gitignore
└── README.md
```

*Note: Adjust the package names and file list above if your actual project structure differs.*

## Prerequisites

Install the following before running the application:

- JDK 17 or compatible Java version
- Maven 3.x
- MySQL Server 8.x
- STS or Eclipse IDE

## Database Setup

1. Start the MySQL server.
2. Open MySQL Workbench or the MySQL command-line client.
3. Create the database:

```sql
CREATE DATABASE MovieDetails;
```

4. Configure your database connection in `src/main/resources/application.properties`.

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/MovieDetails
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Set the `DB_PASSWORD` environment variable to your local MySQL password before running the application. Alternatively, configure your local password directly in your untracked local configuration file. **Never commit database passwords or other secrets to GitHub.**

If your project already has working database properties, retain those settings.

## Run the Application

### Using Spring Tool Suite

1. Import the project as an Existing Maven Project.
2. Wait for Maven dependencies to download.
3. Ensure MySQL is running and the database configuration is correct.
4. Open `MoviesApplication.java`.
5. Right-click and select **Run As → Spring Boot App**.

### Using Maven

From the project root, run:

```bash
mvn clean install
mvn spring-boot:run
```

## Application Functionalities

The application provides a menu-driven console interface for movie and director management.

| Option | Functionality |
|---|---|
| 1 | Add Movie |
| 2 | Search Movie by Title |
| 3 | Search Movies by Director |
| 4 | Search Director by Movie |
| 5 | View All Movies |
| 6 | Update Movie Release Date |
| 7 | Update Director Details |
| 8 | Delete Movie |
| 9 | Exit |

## Database Design

The application uses three related tables:

- **Movie:** Stores movie title, release date, running time, and movie ID.
- **Director:** Stores director ID, name, address, and contact details as defined in the entity.
- **Movie_Director:** Maps movies to directors using foreign keys.

The exact table names and columns are determined by the JPA entity mappings.

## Learning Outcomes

This project demonstrates:

- Spring Boot application configuration
- Entity mapping using JPA annotations
- Database persistence with Spring Data JPA
- Hibernate ORM
- CRUD operations
- Custom repository queries
- Entity relationships
- Exception handling
- MySQL integration

## Future Enhancements

- Build a web interface using Spring MVC or React.
- Add REST APIs for movie management.
- Add pagination and sorting.
- Add movie genre, language, cast, and rating.
- Implement automated unit and integration tests.

## Author

Developed as a Java and Spring Data JPA capstone project.

## License

This project is intended for educational and learning purposes. Add a license if you plan to distribute it publicly.
