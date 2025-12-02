package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;

public class SecondaryController implements Initializable{
    @FXML private TableView<Score> scoreTable;
    @FXML private TableColumn<Score, String> scoreTypes;
    @FXML private TableColumn<Score, String> scores;
    @FXML private ImageView d1;
    @FXML private ImageView d2;
    @FXML private ImageView d3;
    @FXML private ImageView d4;
    @FXML private ImageView d5;
    @FXML private CheckBox c1;
    @FXML private CheckBox c2;
    @FXML private CheckBox c3;
    @FXML private CheckBox c4;
    @FXML private CheckBox c5;
    private Image pip1 = new Image(getClass().getResource("img/pip1.png").toExternalForm());
    private Image pip2 = new Image(getClass().getResource("img/pip2.png").toExternalForm());
    private Image pip3 = new Image(getClass().getResource("img/pip3.png").toExternalForm());
    private Image pip4 = new Image(getClass().getResource("img/pip4.png").toExternalForm());
    private Image pip5 = new Image(getClass().getResource("img/pip5.png").toExternalForm());
    private Image pip6 = new Image(getClass().getResource("img/pip6.png").toExternalForm());
    private Player p1 = new Player("Player 1");
    private Die[] dice = {new Die("d1"), new Die("d2"), new Die("d3"), new Die("d4"), new Die("d5")};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScorecard();
    }

    private void updateScorecard() {
        scoreTable.getItems().clear();
        for (int i = 0; i < p1.getScorecard().length; i++)
            scoreTable.getItems().add(p1.getScorecard()[i]);
        scoreTypes.setCellValueFactory(new PropertyValueFactory<Score, String>("name"));
        scores.setCellValueFactory(new PropertyValueFactory<Score, String>("score"));
    }

    @FXML
    private void toMainMenu() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void options() throws IOException {
        App.setRoot("tertiary");
    }

    @FXML
    private void rollDice() throws IOException {
        dice[0].rollDie();
        switch(dice[0].getValue()) {
            case (1):
                d1.setImage(pip1);
                break;
            case (2):
                d1.setImage(pip2);
                break;
            case (3):
                d1.setImage(pip3);
                break;
            case (4):
                d1.setImage(pip4);
                break;
            case (5):
                d1.setImage(pip5);
                break;
            case (6):
                d1.setImage(pip6);
                break;
            default:
                break;
            }
        dice[1].rollDie();
        switch(dice[1].getValue()) {
            case (1):
                d2.setImage(pip1);
                break;
            case (2):
                d2.setImage(pip2);
                break;
            case (3):
                d2.setImage(pip3);
                break;
            case (4):
                d2.setImage(pip4);
                break;
            case (5):
                d2.setImage(pip5);
                break;
            case (6):
                d2.setImage(pip6);
                break;
            default:
                break;
        }
        dice[2].rollDie();
        switch(dice[0].getValue()) {
            case (1):
                d3.setImage(pip1);
                break;
            case (2):
                d3.setImage(pip2);
                break;
            case (3):
                d3.setImage(pip3);
                break;
            case (4):
                d3.setImage(pip4);
                break;
            case (5):
                d3.setImage(pip5);
                break;
            case (6):
                d3.setImage(pip6);
                break;
            default:
                break;
        }
        dice[3].rollDie();
        switch(dice[3].getValue()) {
            case (1):
                d4.setImage(pip1);
                break;
            case (2):
                d4.setImage(pip2);
                break;
            case (3):
                d4.setImage(pip3);
                break;
            case (4):
                d4.setImage(pip4);
                break;
            case (5):
                d4.setImage(pip5);
                break;
            case (6):
                d4.setImage(pip6);
                break;
            default:
                break;
        }
        dice[4].rollDie();
        switch(dice[4].getValue()) {
            case (1):
                d5.setImage(pip1);
                break;
            case (2):
                d5.setImage(pip2);
                break;
            case (3):
                d5.setImage(pip3);
                break;
            case (4):
                d5.setImage(pip4);
                break;
            case (5):
                d5.setImage(pip5);
                break;
            case (6):
                d5.setImage(pip6);
                break;
            default:
                break;
        }
        int[] calculatedScores = checkCombos(this.dice);
        for (int i = 0; i < 14; i++) {
            p1.getScorecard()[i].setScore(calculatedScores[i]);
        }
        updateScorecard();
    }

    
    private int[] checkCombos(Die[] dice) {
        int[] calculatedScores = new int[14];
        int[] diceValues = new int[5];
        int[] numOccurences = new int[6];

        for (int i = 0; i < 5; i++) {
            int currentNumber = dice[i].getValue();
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

    @FXML
    private void quit(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}