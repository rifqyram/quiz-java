package org.unindra.quiz.movie_app;

public class Movie {
    private String id;
    private String title;
    private String genre;
    private Integer rating;
    private Integer price;

    public Movie(String id, String title, String genre, Integer rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.price = setAdditionalPrice();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer setAdditionalPrice() {
        int additionalPrice = 0;
        switch (genre) {
            case "Comedy":
                additionalPrice = 3000;
                break;
            case "Action":
                additionalPrice = 4000;
                break;
            case "Horror":
                additionalPrice = 5000;
                break;
        }
        return (title.length() * 500) + additionalPrice;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
