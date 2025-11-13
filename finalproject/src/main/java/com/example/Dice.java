package com.example;

public class Dice
{
    private String name;
    private int value;

    public Dice(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    public void rollDice()
    {
        value = (int)(Math.random() * 6 + 1);
    }

    public int getValue()
    {
        return value;
    }

    public String getName()
    {
        return name;
    }
}