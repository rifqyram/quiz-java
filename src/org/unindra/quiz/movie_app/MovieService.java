package org.unindra.quiz.movie_app;

import org.unindra.quiz.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService {

    private final List<Movie> movies;

    public MovieService() {
        this.movies = new ArrayList<>(Arrays.asList(
                new Movie(Utils.generateId(), "Wakanda", "Action", 8),
                new Movie(Utils.generateId(), "Dr. Strange", "Action", 8)
        ));
    }

    public void createNewMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> movieListSorted() {
        if (movies.size() != 0) {
            return movies.stream().sorted(Comparator.comparing(Movie::getTitle)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public List<Movie> movieList() {
        if (movies.size() != 0) {
            return movies;
        }
        return Collections.emptyList();
    }

    public Movie getMovieByIdx(Integer idx) {
        try {
            return movies.get(idx - 1);
        } catch (Exception e) {
            return null;
        }
    }

    public void rentMovie(Movie movie) {
        movies.remove(movie);
    }


}
