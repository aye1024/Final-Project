package com.example;

public class Score {
    private String name;
    private int score;

    public Score(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return Integer.toString(score);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
