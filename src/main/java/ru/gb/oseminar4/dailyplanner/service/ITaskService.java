package ru.gb.oseminar4.dailyplanner.service;

import ru.gb.oseminar4.dailyplanner.data.Task;
import java.util.List;
import java.util.Map;

public interface ITaskService {
    void createTask(Map<String, String> data);
    void deleteTask(Integer id);
    List<Task> getAll();
    void clearAll();
}
