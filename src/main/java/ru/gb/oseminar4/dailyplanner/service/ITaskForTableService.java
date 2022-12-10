package ru.gb.oseminar4.dailyplanner.service;

import javafx.collections.ObservableList;
import ru.gb.oseminar4.dailyplanner.data.Priority;
import ru.gb.oseminar4.dailyplanner.data.TaskForTable;

import java.util.Map;

public interface ITaskForTableService{
    ObservableList<TaskForTable> getAll();
    void addTaskForTable(TaskForTable taskForTable);
    Map<Priority, ObservableList<TaskForTable>> sortAll();
}
