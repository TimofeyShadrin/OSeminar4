package ru.gb.oseminar4.dailyplanner.utils;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ChildWindow {

    private final Map<String, String> result;
    private final RadioButton low;
    private final RadioButton middle;
    private final RadioButton high;
    private final Label selectedLabel;
    private final Label priority;
    private final Label dateOfDeadLine;
    private final Label nameLabel;
    private final Label patronymicLabel;
    private final Label surnameLabel;
    private final TextField name;
    private final TextField patronymic;
    private final TextField surname;
    private final ToggleGroup group;
    private final DatePicker datePicker;
    private final Button button;
    private final Label taskLabel;
    private final TextArea task;
    private final Label message;

    public ChildWindow() {
        this.priority = new Label("Выберите приоритет:");
        this.dateOfDeadLine = new Label("Установите дату дедлайна:");
        this.group = new ToggleGroup();
        this.low = new RadioButton("Низкий приоритет");
        this.middle = new RadioButton("Средний приоритет");
        this.high = new RadioButton("Высокий приоритет");
        this.selectedLabel = new Label();
        this.nameLabel = new Label("Введите свое имя:");
        this.patronymicLabel = new Label("Введите свое отчество:");
        this.surnameLabel = new Label("Введите свою фамилию:");
        this.name = new TextField();
        this.patronymic = new TextField();
        this.surname = new TextField();
        this.datePicker = new DatePicker(LocalDate.now());
        this.button = new Button("Записать");
        this.task = new TextArea();
        this.taskLabel = new Label("Введите описание задачи:");
        this.message = new Label();
        this.result = new HashMap<>();
    }

    public void start() {
        low.setToggleGroup(group);
        middle.setToggleGroup(group);
        high.setToggleGroup(group);
        low.setOnAction(event -> selectedLabel.setText("LOW"));
        middle.setOnAction(event -> selectedLabel.setText("MIDDLE"));
        high.setOnAction(event -> selectedLabel.setText("HIGH"));
        task.setPrefColumnCount(20);
        task.setPrefRowCount(5);
        button.setOnAction(event -> {
            if (selectedLabel.getText().isEmpty() || String.valueOf(datePicker.getValue()).isEmpty() ||
                    name.getText().isEmpty() || patronymic.getText().isEmpty() || surname.getText().isEmpty() ||
                    task.getText().isEmpty()) message.setText("Вы ввели не все данные!");
            else {
                this.result.put(Keys.PRIORITY.toString(), selectedLabel.getText());
                this.result.put(Keys.DEADLINESS.toString(), datePicker.getValue().toString());
                this.result.put(Keys.NAME.toString(), name.getText());
                this.result.put(Keys.PATRONYMIC.toString(), patronymic.getText());
                this.result.put(Keys.SURNAME.toString(), surname.getText());
                this.result.put(Keys.TASK.toString(), task.getText());
                Stage stage = (Stage) button.getScene().getWindow();
                stage.close();
            }
        });
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(priority, low, middle, high, selectedLabel, dateOfDeadLine,
                datePicker, nameLabel, name, patronymicLabel, patronymic, surnameLabel, surname,
                taskLabel, task, button, message);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 320, 580);
        Stage stage = new Stage();
        stage.setTitle("Новая задача");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public Map<String, String> getResult() {
        return result;
    }
}
