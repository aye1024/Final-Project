package com.example;

public class Die
{
    private String name;
    private int value;
    private boolean kept;

    public Die(String name)
    {
        this.name = name;
        kept = false;
        rollDie();
    }

    public void rollDie()
    {
        value = (int)(Math.random() * 6 + 1);
    }

    public void setKept(boolean kept) {
        this.kept = kept;
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