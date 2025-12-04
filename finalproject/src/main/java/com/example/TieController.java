package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class TieController {
    @FXML
    private void toMainMenu() throws IOException {
        App.setRoot("primary");
    }
}