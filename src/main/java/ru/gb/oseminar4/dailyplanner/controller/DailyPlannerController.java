package ru.gb.oseminar4.dailyplanner.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.gb.oseminar4.dailyplanner.data.Priority;
import ru.gb.oseminar4.dailyplanner.data.TaskForTable;
import ru.gb.oseminar4.dailyplanner.repository.DBHandler;
import ru.gb.oseminar4.dailyplanner.service.TaskForTableService;
import ru.gb.oseminar4.dailyplanner.service.TaskService;
import ru.gb.oseminar4.dailyplanner.utils.ChildWindow;
import ru.gb.oseminar4.dailyplanner.view.ViewTable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DailyPlannerController implements Initializable {
    @FXML
    private TableView<TaskForTable> low;
    @FXML
    private TableColumn<TaskForTable, String> dateLow;
    @FXML
    private TableColumn<TaskForTable, String> timeLow;
    @FXML
    private TableColumn<TaskForTable, String> deadlineLow;
    @FXML
    private TableColumn<TaskForTable, String> fullnessLow;
    @FXML
    private TableView<TaskForTable> middle;
    @FXML
    private TableColumn<TaskForTable, String> dateMiddle;
    @FXML
    private TableColumn<TaskForTable, String> timeMiddle;
    @FXML
    private TableColumn<TaskForTable, String> deadLineMiddle;
    @FXML
    private TableColumn<TaskForTable, String> fullnessMiddle;
    @FXML
    private TableView<TaskForTable> high;
    @FXML
    private TableColumn<TaskForTable, String> dateHigh;
    @FXML
    private TableColumn<TaskForTable, String> timeHigh;
    @FXML
    private TableColumn<TaskForTable, String> deadlineHigh;
    @FXML
    private TableColumn<TaskForTable, String> fullnessHigh;
    @FXML
    private Button addHigh;

    private final TaskService taskService = new TaskService();
    private final TaskForTableService taskForTableService = new TaskForTableService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }

    @FXML
    public void createTask() throws SQLException {
        ChildWindow childWindow = new ChildWindow();
        childWindow.start();
        if (!(childWindow.getResult()).isEmpty()) {
            taskService.createTask(childWindow.getResult());
            DBHandler dbHandler = DBHandler.getInstance();
            taskService.getAll().forEach(dbHandler::addTask);
            taskService.clearAll();
            taskForTableService.clearAll();
            refreshTable();
        }
    }

    private void initTable() {
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            dbHandler.getAllTasks().forEach(taskForTableService::addTaskForTable);
            ViewTable<TaskForTable> tableLow = new ViewTable<>(low, dateLow, timeLow, deadlineLow,
                    fullnessLow, taskForTableService.sortAll().get(Priority.LOW));
            tableLow.sendOnTable();
            ViewTable<TaskForTable> tableMiddle = new ViewTable<>(middle, dateMiddle, timeMiddle, deadLineMiddle,
                    fullnessMiddle, taskForTableService.sortAll().get(Priority.MIDDLE));
            tableMiddle.sendOnTable();
            ViewTable<TaskForTable> tableHigh = new ViewTable<>(high, dateHigh, timeHigh, deadlineHigh,
                    fullnessHigh, taskForTableService.sortAll().get(Priority.HIGH));
            tableHigh.sendOnTable();
        } catch (SQLException e) {
            throw new IllegalStateException("DB not found!");
        }
    }

    private void refreshTable() {
        Platform.runLater(() -> {
            low.getItems().clear();
            high.getItems().clear();
            middle.getItems().clear();
        });
        Platform.runLater(this::initTable);
    }
}