package com.example;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Die
{
    private String name;
    private int value;
    private ImageView img;
    private Image pip1 = new Image(getClass().getResource("img/pip1.png").toExternalForm());
    private Image pip2 = new Image(getClass().getResource("img/pip2.png").toExternalForm());
    private Image pip3 = new Image(getClass().getResource("img/pip3.png").toExternalForm());
    private Image pip4 = new Image(getClass().getResource("img/pip4.png").toExternalForm());
    private Image pip5 = new Image(getClass().getResource("img/pip5.png").toExternalForm());
    private Image pip6 = new Image(getClass().getResource("img/pip6.png").toExternalForm());

    public Die(String name, ImageView img)
    {
        this.name = name;
        this.img = img;
        rollDie();
    }

    public void rollDie()
    {
        value = (int)(Math.random() * 6 + 1);
        switch (value) {
            case 1:
                img.setImage(pip1);
                break;
            case 2:
                img.setImage(pip2);
                break;
            case 3:
                img.setImage(pip3);
                break;
            case 4:
                img.setImage(pip4);
                break;
            case 5:
                img.setImage(pip5);
                break;
            case 6:
                img.setImage(pip6);
                break;
            default:
                break;
        }

    }

    public int getValue()
    {
        return value;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getName()
    {
        return name;
    }
}