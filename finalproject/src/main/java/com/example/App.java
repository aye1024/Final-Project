package com.example;

import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Yacht");
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static int[] checkCombos(ArrayList<Dice> dice) {
        int[] calculatedScores = new int[14];
        int[] diceValues = new int[5];
        int[] numOccurences = new int[6];

        for (int i = 0; i < 5; i++) {
            int currentNumber = dice.get(i).getValue();
            diceValues[i] = currentNumber;
            switch (currentNumber) {
                case 1:
                    numOccurences[0]++;
                    break;
                case 2:
                    numOccurences[1]++;
                    break;
                case 3:
                    numOccurences[2]++;
                    break;
                case 4:
                    numOccurences[3]++;
                    break;
                case 5:
                    numOccurences[4]++;
                    break;
                case 6:
                    numOccurences[5]++;
                    break;
                default:
                    break;
            }
        }

        calculatedScores[0] = 1 * numOccurences[0];
        calculatedScores[1] = 2 * numOccurences[1];
        calculatedScores[2] = 3 * numOccurences[2];
        calculatedScores[3] = 4 * numOccurences[3];
        calculatedScores[4] = 5 * numOccurences[4];
        calculatedScores[5] = 6 * numOccurences[5];

        int maxOccurences = 0;
        for (int i : numOccurences) {
            if (i > maxOccurences)
            maxOccurences = i;
        }

        int diceValueSum = 0;
        for (int i : diceValues) {
            diceValueSum += i;
        }

        //three of a kind
        if(maxOccurences >= 3)
        {
            calculatedScores[7] = diceValueSum;
        }
        
        //four of a kind
        if(maxOccurences >= 4)
        {
            calculatedScores[8] = diceValueSum;
        }
       
        //fullHouse
        boolean threeOfAKind = false;
        boolean twoOfAKind = false;
        for (int i : numOccurences) {
            if (i == 3)
                threeOfAKind = true;
            if (i == 2) 
                twoOfAKind = true;
        }
        
        if (threeOfAKind && twoOfAKind) 
            calculatedScores[9] = 25;

        //smallStraight & large straight
        int count = 0 ;
        boolean isSmallStraight = false;
        boolean isLargeStraight = false;
        for (int i : numOccurences) {
            if (i > 0)
                count ++;
            else 
                count = 0;
            if (count >= 4) 
                isSmallStraight = true;
            if (count >= 5)
                isLargeStraight = true;
        }

        if (isSmallStraight)
            calculatedScores[10] = 30;
        if (isLargeStraight)
            calculatedScores[11] = 40;

        //yacht
        if (maxOccurences >= 5) 
            calculatedScores[12] = 50;
        
        //chance
        calculatedScores[13] = diceValueSum;

        return calculatedScores;
    }
}