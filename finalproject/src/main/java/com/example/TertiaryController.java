package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class TertiaryController {

    @FXML
    private void toMainMenu() throws IOException {
        App.setRoot("primary");
    }
}