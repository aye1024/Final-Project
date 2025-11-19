package com.example;

public class Score {
    private String name;
    private int score;

    public Score(String name) {
        this.name = name;
    }

    public String nameProperty() {
        return name;
    }

    public String scoreProperty() {
        return Integer.toString(score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
