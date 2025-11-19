package com.example;

public class Player {
    private String name;
    private Score[] scorecard;
    private int wins;
    private int losses;

    public Player(String name) {
        this.name = name;
        scorecard = {new Score("Ones"), new Score ()};
    }

    public String getName() {
        return name;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public int getWins() {
        return wins;
    }

    public void addWins() {
        wins++;
    }

    public int getLosses() {
        return losses;
    }

    public void addLosses() {
        losses++;
    }
}
