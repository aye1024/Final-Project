package com.example;

public class Scorecard {
    private String name;
    private int[] scores = new int[14];

    public Scorecard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOnes() {
        return scores[0];
    }

    public void setOnes(int ones) {
        this.scores[0] = ones;
    }

    public int getTwos() {
        return scores[1];
    }

    public void setTwos(int twos) {
        this.scores[1] = twos;
    }

    public int getThrees() {
        return scores[2];
    }

    public void setThrees(int threes) {
        this.scores[2] = threes;
    }

    public int getFours() {
        return scores[3];
    }

    public void setFours(int fours) {
        this.scores[3] = fours;
    }

    public int getFives() {
        return scores[4];
    }

    public void setFives(int fives) {
        this.scores[4] = fives;
    }

    public int getSixes() {
        return scores[5];
    }

    public void setSixes(int sixes) {
        this.scores[5] = sixes;
    }

    public int getBonus() {
        return scores[6];
    }

    public void setBonus() {
        int total = 0;
        for (int i = 0; i < 6; i++) {
            total += scores[i];
        }
        if (total >= 63)
            scores[6] = 35;
        else
            scores[6] = 0;
    }

    public int getThreeOfAKind() {
        return scores[7];
    }

    public void setThreeOfAKind(int threeOfAKind) {
        this.scores[7] = threeOfAKind;
    }

    public int getFourOfAKind() {
        return scores[8];
    }

    public void setFourOfAKind(int fourofAKind) {
        this.scores[8] = fourofAKind;
    }

    public int getFullHouse() {
        return scores[9];
    }

    public void setFullHouse(int fullHouse) {
        this.scores[9] = fullHouse;
    }

    public int getSmallStraight() {
        return scores[10];
    }

    public void setSmallStraight(int smallStraight) {
        this.scores[10] = smallStraight;
    }

    public int getLargeStraight() {
        return scores[11];
    }

    public void setLargeStraight(int largeStraight) {
        this.scores[11] = largeStraight;
    }

    public int getYacht() {
        return scores[12];
    }

    public void setYacht(int yacht) {
        this.scores[12] = yacht;
    }
    
    public int getChance() {
        return scores[13];
    }

    public void setChance(int chance) {
        this.scores[13] = chance;
    }

    public int getTotalScore() {
        int total = 0;
        for (int i : scores) {
            total += i;
        }
        return total;
    }
}
