package com.example;

public class Player {
    private String name;
    private Score[] scorecard;
    private int wins;
    private int losses;

    public Player(String name) {
        this.name = name;     
        scorecard = new Score[]{new Score("Ones"), new Score("Twos"), new Score("Threes"), new Score("Fours"), new Score("Fives"), new Score("Sixes"), new Score("Bonus"), new Score("Three of a Kind"), new Score("Four of a Kind"), new Score("Full House"), new Score("Small Straight"), new Score("Large Straight"), new Score("Yahtzee"), new Score("Chance")};
    }

    public String getName() {
        return name;
    }

    public Score[] getScorecard() {
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
