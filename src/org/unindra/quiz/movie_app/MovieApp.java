package org.unindra.quiz.movie_app;

public class MovieApp {

    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        Menu menu = new Menu(movieService);
        menu.showMenu();
    }

}
