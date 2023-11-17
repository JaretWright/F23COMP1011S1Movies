package com.example.f23comp1011s1movies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiResponse {
    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Search")
    private ArrayList<Movie> movies;

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
