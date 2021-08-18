package com.BookMyShow.app.repositories.interfaces;

import com.BookMyShow.app.models.Cinema;
import com.BookMyShow.app.models.Movie;

import java.util.Optional;


public interface MovieRepository extends AbstractRepository <Movie, Long> {
    Optional<Movie> findByName(String movieName);


    QuerySet<Movie> getMovieByCinema(Cinema cinema);
}
