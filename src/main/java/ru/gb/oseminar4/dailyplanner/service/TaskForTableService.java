package ru.gb.oseminar4.dailyplanner.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.gb.oseminar4.dailyplanner.data.Priority;
import ru.gb.oseminar4.dailyplanner.data.TaskForTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskForTableService implements ITaskForTableService{

    ObservableList<TaskForTable> observableList;

    public TaskForTableService() {
        this.observableList = FXCollections.observableArrayList();
    }

    @Override
    public ObservableList<TaskForTable> getAll() {
        return this.observableList;
    }

    @Override
    public void addTaskForTable(TaskForTable taskForTable) {
        this.observableList.add(taskForTable);
    }

    @Override
    public Map<String, ObservableList<TaskForTable>> sortAll() {
        Map<String, ObservableList<TaskForTable>> result = new HashMap<>();
        for (Priority priority : Priority.values()) {
            result.put(priority.getPriority(), (this.observableList.stream()
                    .filter(taskForTable -> (taskForTable.getPriority()).equalsIgnoreCase(priority.getPriority()))
                    .collect(FXCollections::observableArrayList,
                            List::add,
                            List::addAll)
            ));
        }
        return result;
    }

    public void clearAll() {
        this.observableList.clear();
    }
}
