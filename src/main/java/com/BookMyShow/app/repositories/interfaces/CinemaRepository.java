package com.BookMyShow.app.repositories.interfaces;

import com.BookMyShow.app.models.Cinema;
import com.BookMyShow.app.models.Movie;

public interface CinemaRepository {
    QuerySet<Cinema> getCinemaByMovie(Movie movie);
}
