package com.example.f23comp1011s1movies;

import com.google.gson.annotations.SerializedName;

public class MovieRatings {
    @SerializedName("Source")
    private String source;

    @SerializedName("Value")
    private String value;

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    public String toString()
    {
        return String.format("%s-%s", source, value);
    }
}
