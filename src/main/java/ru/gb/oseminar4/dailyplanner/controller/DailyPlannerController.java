package ru.gb.oseminar4.dailyplanner.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ru.gb.oseminar4.dailyplanner.data.Task;

import java.net.URL;
import java.util.ResourceBundle;

public class DailyPlannerController implements Initializable {

    @FXML
    private TableView<Task> low;
    @FXML
    private TableView<Task> middle;
    @FXML
    private TableView<Task> high;
    @FXML
    private Button addHigh;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}