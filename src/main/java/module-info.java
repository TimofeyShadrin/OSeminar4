module ru.gb.oseminar.dailyplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;


    opens ru.gb.oseminar4.dailyplanner to javafx.fxml;
    exports ru.gb.oseminar4.dailyplanner;
    exports ru.gb.oseminar4.dailyplanner.controller;
    opens ru.gb.oseminar4.dailyplanner.controller to javafx.fxml;
    exports ru.gb.oseminar4.dailyplanner.utils;
    opens ru.gb.oseminar4.dailyplanner.utils to javafx.fxml;
}