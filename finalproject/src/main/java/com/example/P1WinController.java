package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class P1WinController {
    @FXML
    private void toMainMenu() throws IOException {
        App.setRoot("primary");
    }
}