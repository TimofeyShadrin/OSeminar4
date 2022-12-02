package ru.gb.oseminar4.dailyplanner.service;

import ru.gb.oseminar4.dailyplanner.data.Priority;
import ru.gb.oseminar4.dailyplanner.data.Task;
import ru.gb.oseminar4.dailyplanner.utils.Keys;

import java.util.*;
import java.util.stream.Collectors;

public class TaskService implements ITaskService{
    private List<Task> taskList;

    public TaskService() {
        this.taskList = new ArrayList<>();
    }

    @Override
    public void createTask(Map<String, String> data) {
        String[] list = new String[6];
        data.forEach((key, value) -> {
            if ((Keys.PRIORITY.toString()).equals(key)) list[0] = value;
            else if ((Keys.DEADLINESS.toString()).equalsIgnoreCase(key)) {
                list[1] = value;
            } else if ((Keys.NAME.toString()).equalsIgnoreCase(key)) {
                list[2] = value;
            } else if ((Keys.PATRONYMIC.toString()).equalsIgnoreCase(key)) {
                list[3] = value;
            } else if ((Keys.SURNAME.toString()).equalsIgnoreCase(key)) {
                list[4] = value;
            } else if ((Keys.TASK.toString()).equalsIgnoreCase(key)) {
                list[5] = value;
            }
        });
        if (Arrays.stream(list).allMatch(Objects::nonNull)) {
            this.taskList.add(new Task(list[1], list[2], list[3], list[4],
                    Priority.valueOf(list[0].toUpperCase()), list[5]));
        }
    }

    @Override
    public void deleteTask(Integer id) {
        if (!this.taskList.isEmpty()) {
            Task task = taskList.stream()
                    .filter(element -> element.getId().equals(id))
                    .collect(Collectors.toList())
                    .get(0);
            this.taskList.remove(task);
        }
    }

    @Override
    public List<Task> getAll() {
        return this.taskList;
    }

    @Override
    public void clearAll() {
        this.taskList.clear();
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
