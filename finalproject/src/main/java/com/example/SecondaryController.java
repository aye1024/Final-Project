package com.example;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import javafx.scene.control.TableCell;

public class SecondaryController implements Initializable{
    @FXML private Label whoTurn;
    @FXML private Label turnNumber;
    @FXML private TableView<Score> p1ScoreTable;
    @FXML private TableColumn<Score, String> p1ScoreTypes;
    @FXML private TableColumn<Score, String> p1Scores;
    @FXML private TableView<Score> p2ScoreTable;
    @FXML private TableColumn<Score, String> p2ScoreTypes;
    @FXML private TableColumn<Score, String> p2Scores;
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
    @FXML private Label rollsRemaining;
    private int turnNum = 0;
    private boolean isP1Turn;
    private Image pip1 = new Image(getClass().getResource("img/pip1.png").toExternalForm());
    private Image pip2 = new Image(getClass().getResource("img/pip2.png").toExternalForm());
    private Image pip3 = new Image(getClass().getResource("img/pip3.png").toExternalForm());
    private Image pip4 = new Image(getClass().getResource("img/pip4.png").toExternalForm());
    private Image pip5 = new Image(getClass().getResource("img/pip5.png").toExternalForm());
    private Image pip6 = new Image(getClass().getResource("img/pip6.png").toExternalForm());
    private Player p1 = new Player("Player 1");
    private Player p2 = new Player("Player 2");
    private Die[] dice = {new Die("d1"), new Die("d2"), new Die("d3"), new Die("d4"), new Die("d5")};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScorecards();
        p1Turn();
    }

    // private void checkWin() {
    //     if (turnNum > 13)
    //         FXMLSceneSwitcher.loadScene("tertiary.fxml");
    // }

    private void updateTurnNumber() {
        turnNumber.setText(String.format("Turn #%d", turnNum));
    }

    private void updateWhoTurn() {
        if (isP1Turn)
            whoTurn.setText("Player 1's Turn");
        else   
            whoTurn.setText("Player 2's Turn");
    }

    private void updateScorecards() {
        updateP1Scorecard();
        updateP2Scorecard();
    }

    private void updateP1Scorecard() {
        p1ScoreTable.getItems().clear();
        for (int i = 0; i < p1.getScorecard().length; i++)
            p1ScoreTable.getItems().add(p1.getScorecard()[i]);
        p1ScoreTypes.setCellValueFactory(new PropertyValueFactory<Score, String>("name"));
        p1Scores.setCellValueFactory(new PropertyValueFactory<Score, String>("score"));
        p1Scores.setCellFactory(tc -> {
            TableCell<Score, String> cell = new TableCell<Score, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };

            cell.setOnMouseClicked(event -> {
                if (isP1Turn) {
                    if (!p1.getScorecard()[cell.getIndex()].getScoreKept()) {
                        p1.getScorecard()[cell.getIndex()].keepScore();
                        p2Turn();
                    }
                }
            });
            return cell ;
        });
    }

    private void updateP2Scorecard() {
        p2ScoreTable.getItems().clear();
        for (int i = 0; i < p1.getScorecard().length; i++)
            p2ScoreTable.getItems().add(p2.getScorecard()[i]);
        p2ScoreTypes.setCellValueFactory(new PropertyValueFactory<Score, String>("name"));
        p2Scores.setCellValueFactory(new PropertyValueFactory<Score, String>("score"));
        p2Scores.setCellFactory(tc -> {
            TableCell<Score, String> cell = new TableCell<Score, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.setOnMouseClicked(event -> {
                if (!isP1Turn) {
                    if (!p2.getScorecard()[cell.getIndex()].getScoreKept()) {
                        p2.getScorecard()[cell.getIndex()].keepScore();
                        p1Turn();
                    }
                }
            });
            return cell ;
        });
    }

    private void p1Turn() {
        isP1Turn = true;
        turnNum++;
        updateTurnNumber();
        updateWhoTurn();
        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c4.setSelected(false);
        c5.setSelected(false);
        for (Die d : dice) {
            d.setKept(false);
        }
        shuffleDice();
        updateScorecards();
        p1.setNumRolls(2);
        rollsRemaining.setText(String.format("Player 1 has %s rolls left.", p1.getNumRolls()));
    }

    private void p2Turn() {
        isP1Turn = false;
        updateWhoTurn();
        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c4.setSelected(false);
        c5.setSelected(false);
        for (Die d : dice) {
            d.setKept(false);
        }
        shuffleDice();
        updateScorecards();
        p2.setNumRolls(2);
        rollsRemaining.setText(String.format("Player 2 has %s rolls left.", p1.getNumRolls()));
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
    private void setD1() throws IOException {
        if (c1.isSelected())
            dice[0].setKept(true);
        else   
            dice[0].setKept(false);
    }

    @FXML
    private void setD2() throws IOException {
        if (c2.isSelected())
            dice[1].setKept(true);
        else   
            dice[1].setKept(false);
    }

    @FXML
    private void setD3() throws IOException {
        if (c3.isSelected())
            dice[2].setKept(true);
        else   
            dice[2].setKept(false);
    }

    @FXML
    private void setD4() throws IOException {
        if (c4.isSelected())
            dice[3].setKept(true);
        else   
            dice[3].setKept(false);
    }

    @FXML
    private void setD5() throws IOException {
        if (c5.isSelected())
            dice[4].setKept(true);
        else   
            dice[4].setKept(false);
    }

    private void shuffleDice() {
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
        switch(dice[2].getValue()) {
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
        
        if (isP1Turn) {
            for (int i = 0; i < 14; i++) {
                p1.getScorecard()[i].setScore(calculatedScores[i]);
            }
        }
        else {
            for (int i = 0; i < 14; i++) {
                p2.getScorecard()[i].setScore(calculatedScores[i]);
            }
        }
    }

    @FXML
    private void rollDice() throws IOException {
        if (isP1Turn) {
            if (p1.getNumRolls() > 0) {
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
                switch(dice[2].getValue()) {
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

                updateScorecards();
                p1.setNumRolls(p1.getNumRolls()-1);
                rollsRemaining.setText(String.format("Player 1 has %s rolls left.", p1.getNumRolls()));
            }

            else
                System.out.println("No rolls left! Choose a score to keep!");
        }
        
        else {
            if (p2.getNumRolls() > 0) {
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
                switch(dice[2].getValue()) {
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
                    p2.getScorecard()[i].setScore(calculatedScores[i]);
                }

                updateScorecards();
                p2.setNumRolls(p2.getNumRolls()-1);
                rollsRemaining.setText(String.format("Player 2 has %s rolls left.", p2.getNumRolls()));
            }

            else
                System.out.println("No rolls left! Choose a score to keep!");
        }
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

        //bonus
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += calculatedScores[i];
        }
        if (sum >= 63) 
            calculatedScores[6] = 35;

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