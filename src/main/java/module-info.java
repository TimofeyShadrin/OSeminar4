module ru.gb.oseminar4.dailyplanner {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.oseminar4.dailyplanner to javafx.fxml;
    exports ru.gb.oseminar4.dailyplanner;
    exports ru.gb.oseminar4.dailyplanner.controller;
    opens ru.gb.oseminar4.dailyplanner.controller to javafx.fxml;
}