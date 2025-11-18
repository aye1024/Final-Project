package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SecondaryController {

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