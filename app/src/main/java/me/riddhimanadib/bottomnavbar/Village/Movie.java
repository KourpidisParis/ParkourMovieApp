package me.riddhimanadib.bottomnavbar.Village;

import java.util.ArrayList;

public class Movie {
    private String movie;
    public ArrayList<Theater> theater = new ArrayList<>();

    public Movie(String movie) {
        this.movie = movie;
    }

    public void addTheater(Theater t)
    {
        this.theater.add(t);
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public ArrayList<Theater> getTheater() {
        return theater;
    }

    public void setTheater(ArrayList<Theater> theater) {
        this.theater = theater;
    }




}
