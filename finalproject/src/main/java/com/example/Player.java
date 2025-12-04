package com.example;

public class Player {
    private String name;
    private Score[] scorecard;
    private int numRolls;

    public Player(String name) {
        this.name = name;     
        scorecard = new Score[]{new Score("Ones"), new Score("Twos"), new Score("Threes"), new Score("Fours"), new Score("Fives"), new Score("Sixes"), new Score("Bonus"), new Score("Three of a Kind"), new Score("Four of a Kind"), new Score("Full House"), new Score("Small Straight"), new Score("Large Straight"), new Score("Yahtzee"), new Score("Chance")};
        numRolls = 2;
    }

    public String getName() {
        return name;
    }

    public Score[] getScorecard() {
        return scorecard;
    }

    public int getNumRolls() {
        return numRolls;
    }

    public void setNumRolls(int numRolls) {
        this.numRolls = numRolls;
    }
}
