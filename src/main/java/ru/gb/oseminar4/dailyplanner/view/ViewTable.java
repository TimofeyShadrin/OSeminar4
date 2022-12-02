package ru.gb.oseminar4.dailyplanner.view;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.gb.oseminar4.dailyplanner.data.TaskForTable;
import ru.gb.oseminar4.dailyplanner.repository.DBHandler;

import java.sql.SQLException;

public class ViewTable<T extends TaskForTable> {
    @FXML
    private final TableView<T> tableView;
    @FXML
    private final TableColumn<T, String> date;
    @FXML
    private final TableColumn<T, String> time;
    @FXML
    private final TableColumn<T, String> deadline;
    @FXML
    private final TableColumn<T, String> fullness;
    @FXML
    private final ObservableList<T> observableList;

    public ViewTable(TableView<T> tableView, TableColumn<T, String> date,
                     TableColumn<T, String> time, TableColumn<T, String> deadline,
                     TableColumn<T, String> fullness, ObservableList<T> observableList) {
        this.tableView = tableView;
        this.date = date;
        this.time = time;
        this.deadline = deadline;
        this.fullness = fullness;
        this.observableList = observableList;
    }

    public void sendOnTable() {
        date.setCellValueFactory(date -> date.getValue().dateProperty());
        time.setCellValueFactory(time -> time.getValue().timeProperty());
        deadline.setCellValueFactory(deadline -> deadline.getValue().deadlineProperty());
        fullness.setCellValueFactory(fullness -> fullness.getValue().fullnessProperty());
        tableView.setItems(observableList);
        TableView.TableViewSelectionModel<T> selectionModel = tableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((val, oldVal, newVal) -> {
            if(newVal != null) {
                Alert alert = new Alert(
                        Alert.AlertType.CONFIRMATION, newVal + "\n\nДело сделано, удалить его?",
                        ButtonType.YES, ButtonType.NO);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    try {
                        DBHandler dbHandler = DBHandler.getInstance();
                        dbHandler.deleteTask(newVal.getId());
                        Platform.runLater(() -> observableList.remove(newVal));
                        alert.close();
                        tableView.refresh();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
