package com.example;

public class Score {
    private String name;
    private int score;
    private boolean scoreKept;

    public Score(String name) {
        this.name = name;
        scoreKept = false;
    }

    public String getName() {
        return name;
    }

    public void keepScore() {
        scoreKept = true;
    }

    public String getScore() {
        return Integer.toString(score);
    }

    public void setScore(int score) {
        if (!scoreKept)
            this.score = score;
    }
}
