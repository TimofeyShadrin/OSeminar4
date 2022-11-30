package ru.gb.oseminar4.dailyplanner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DailyPlannerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}