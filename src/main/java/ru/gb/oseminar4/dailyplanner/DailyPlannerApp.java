package ru.gb.oseminar4.dailyplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DailyPlannerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DailyPlannerApp.class.getResource("dailyPlanner.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 580);
        stage.setTitle("Мой еженедельник");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}