package com.example;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
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


    private Player p1 = new Player("Player 1");
    private Die[] dice = {new Die("d1", d1), new Die("d2", d2), new Die("d3", d3), new Die("d4", d4), new Die("d5", d5)};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        for (int i = 0; i < dice.length; i++) {
            dice[i].rollDie();
        }
        
        System.out.println("Dice rolled");
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}