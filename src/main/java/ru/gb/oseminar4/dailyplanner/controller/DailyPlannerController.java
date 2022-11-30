package ru.gb.oseminar4.dailyplanner.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import ru.gb.oseminar4.dailyplanner.data.Task;
import ru.gb.oseminar4.dailyplanner.service.TaskService;
import ru.gb.oseminar4.dailyplanner.utils.ChildWindow;

import java.io.IOException;
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

    private TaskService taskService = new TaskService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addHigh.setDisable(false);
    }

    public void createTask(MouseEvent mouseEvent) throws IOException {
        ChildWindow childWindow = new ChildWindow();
        childWindow.start();
    }
}