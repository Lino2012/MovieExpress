package com.movies.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Director_Id")
    private Integer directorId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Contact_Number")
    private Long contactNumber;

    @Column(name = "Email")
    private String email;

    @ManyToMany(
            mappedBy = "directors",
            fetch = FetchType.EAGER
    )
    private Set<Movie> movies = new HashSet<>();

    public Director() {
    }

    public Director(Integer directorId, String firstName,
                    String lastName, String address,
                    Long contactNumber, String email) {
        this.directorId = directorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "\nDirector ID    : " + directorId +
               "\nFirst Name     : " + firstName +
               "\nLast Name      : " + lastName +
               "\nAddress        : " + address +
               "\nContact Number : " + contactNumber +
               "\nEmail          : " + email + "\n";
    }
}