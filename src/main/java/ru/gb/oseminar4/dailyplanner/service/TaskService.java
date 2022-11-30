package ru.gb.oseminar4.dailyplanner.service;

import ru.gb.oseminar4.dailyplanner.data.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskService implements ITaskService{
    private final List<Task> taskList;

    public TaskService() {
        this.taskList = new LinkedList<>();
    }

    @Override
    public void createTask(Map<String, String> data) {
        data.forEach((key, value) -> {
        });
    }

    @Override
    public void deleteTask(Integer id) {
        if (!this.taskList.isEmpty()) {
            Task task = taskList.stream()
                    .filter(element -> element.getId().equals(id.longValue()))
                    .collect(Collectors.toList())
                    .get(0);
            this.taskList.remove(task);
        }
    }

    @Override
    public List<Task> getAll() {
        return this.taskList;
    }
}
