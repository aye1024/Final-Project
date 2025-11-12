import java.util;
public class Dice
{
private String name;
private int value;

public Dice(String name, int value)
{
    this.name=name;
    this.value=value;
}

public int getValue()
{
    this.value=(int)(Math.random() * ((6 - 1) + 1) + 1);
}

}