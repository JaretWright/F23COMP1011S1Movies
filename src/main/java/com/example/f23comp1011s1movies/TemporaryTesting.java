package com.example.f23comp1011s1movies;

public class TemporaryTesting {
    public static void main(String[] args) {
        try {
            APIUtility.callAPI("The dark knight");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
