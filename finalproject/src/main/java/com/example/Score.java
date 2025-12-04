package com.example;

public class Score {
    private String name;
    private int score;
    private boolean scoreKept;

    public Score(String name) {
        this.name = name;
        if (name.equals("Bonus"))
            scoreKept = true;
        else
            scoreKept = false;
    }

    public String getName() {
        return name;
    }

    public void keepScore() {
        scoreKept = true;
    }

    public boolean getScoreKept() {
        return scoreKept;
    }

    public int getIntScore() {
        return score;
    }

    public String getScore() {
        if (scoreKept)
            return Integer.toString(score);
        else
            return "Keep " + Integer.toString(score) + "?";
    }

    public void setScore(int score) {
        if (!scoreKept || name.equals("Bonus"))
            this.score = score;
    }
}
