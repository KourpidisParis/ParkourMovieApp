package me.riddhimanadib.bottomnavbar;

public class Movie {
 private String  title;
 private String releaseDate;
    private String urlImage;
    private String overview;

    public Movie(String title, String releaseDate, String urlImage, String overview) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.urlImage = urlImage;
        this.overview = overview;
    }


    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getOverview() {
        return overview;
    }




}

