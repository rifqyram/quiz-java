package org.unindra.quiz.movie_app;

import org.unindra.quiz.Utils;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private final MovieService movieService;

    public Menu(MovieService movieService) {
        this.movieService = movieService;
    }

    public void showMenu() {
        while (true) {
            printMainMenu();
            String option = Utils.inputUtils("Choose");

            switch (option) {
                case "1":
                    addNewMovie();
                    break;
                case "2":
                    viewMovie();
                    break;
                case "3":
                    rentMovie();
                    break;
                case "4":
                    System.out.println("Good bye~");
                    System.exit(0);
                    break;
            }
        }
    }

    private void printMainMenu() {
        System.out.println(Utils.repeat("=", 30));
        System.out.println("Movie Rental");
        System.out.println(Utils.repeat("=", 30));
        System.out.println("1. Add new Movie");
        System.out.println("2. View Movie");
        System.out.println("3. Rent Movie");
        System.out.println("4. EXIT");
    }

    private void addNewMovie() {
        Function<String, Boolean> titleValidation = input -> !input.isEmpty() && (input.length() >= 3 && input.length() <= 20);
        Function<String, Boolean> genreValidation = input -> input.equals("Horror") || input.equals("Comedy") || input.equals("Action");
        Function<Integer, Boolean> ratingValidation = input -> input >= 1 && input <= 10;
        Function<String, Boolean> idValidation = input -> {
            boolean matches = Pattern.matches("[A-Z]{2}\\d{3}", input);
            return matches && !input.isEmpty();
        };

        String title = Utils.inputUtils("Input Movie Title [Length Must be 3 - 20 chars]", titleValidation);
        String genre = Utils.inputUtils("Input Movie Genre [Horror | Comedy | Action]", genreValidation);
        Integer rating = Utils.inputUtilsInt("Input Movie Rating [1-10]", ratingValidation);
        String id = Utils.inputUtils("Generated MovieID", idValidation);

        Movie movie = new Movie(id, title, genre, rating);
        movieService.createNewMovie(movie);
    }

    private void viewMovie() {
        List<Movie> movies = movieService.movieListSorted();
        printMovies(movies);
    }

    private void rentMovie() {
        List<Movie> movies = movieService.movieList();
        printMovies(movies);

        Function<Integer, Boolean> movieOptValidation = input -> input != 0 && input <= movies.size();
        Integer chooseMovie = Utils.inputUtilsInt(String.format("Choose Movie index [%d-%d]", 1, movies.size()), movieOptValidation);
        Movie movie = movieService.getMovieByIdx(chooseMovie);

        Function<Integer, Boolean> balanceValidation = input -> input > movie.getPrice();
        Integer balance = Utils.inputUtilsInt(String.format("Input Money to Rent [MIN %d]", movie.getPrice()), balanceValidation);

        movieService.rentMovie(movie);

        if (balance > movie.getPrice()) {
            System.out.printf("Pay Rent Successfully with %d Change \n", balance - movie.getPrice());
            return;
        }

        System.out.println("Pay Rent Successfully");
    }

    private void printMovies(List<Movie> movies) {
        if (!movies.isEmpty()) {
            System.out.println(Utils.repeat("=", 104));
            System.out.printf("| %-10s | %-10s | %-20s | %-15s | %-15s | %-15s | \n", "NO", "ID", "Title", "Genre", "Rating", "Price");
            System.out.println(Utils.repeat("=", 104));

            for (int i = 0; i < movies.size(); i++) {
                Movie movie = movies.get(i);
                System.out.printf("| %-10d | %-10s | %-20s | %-15s | %-15s | %-15s | \n", (i + 1), movie.getId(), movie.getTitle(), movie.getGenre(), movie.getRating(), movie.getPrice());
            }
            System.out.println(Utils.repeat("=", 104));
            return;
        }
        System.out.println("NO MOVIE FOUND");
    }

}
