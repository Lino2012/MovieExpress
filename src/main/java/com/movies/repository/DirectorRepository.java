package com.movies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

    Optional<Director> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(
            String firstName,
            String lastName);

}