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
import java.net.URL;

public class SecondaryController {
    @FXML private TableView<Score> scoreTable;
    @FXML private TableColumn<Score, String> scoreTypes;
    @FXML private TableColumn<Score, String> scores;

    Score s = new Score("Ones");

    public void initialize(URL location, ResourceBundle resources) {
        scoreTable.getItems().add(s);
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
    private void quit(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}