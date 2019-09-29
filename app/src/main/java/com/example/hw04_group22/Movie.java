package com.example.hw04_group22;

import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable {
    String name, description, imdb, genreList;
    //String[] genreList = {"Action", "Animation", "Comedy", "Documentry", "Family", "Horror", "Crime", "Others"};
    int rating, year;

    public Movie(String name, String description, String genreList, int rating, int year, String imdb) {
        this.name = name;
        this.description = description;
        this.imdb = imdb;
        this.genreList = genreList;
        this.rating = rating;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getGenreList() {
        return genreList;
    }

    public void setGenreList(String genreList) {
        this.genreList = genreList;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imdb='" + imdb + '\'' +
                ", genreList=" + genreList +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
