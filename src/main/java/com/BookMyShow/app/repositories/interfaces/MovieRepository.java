package com.BookMyShow.app.repositories;

import com.BookMyShow.app.models.Movie;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MovieRepository extends AbstractRepository <Movie , Long> {
    Optional<Movie> findByName(String movieName);


}
