package ru.gb.oseminar4.dailyplanner.service;

import ru.gb.oseminar4.dailyplanner.data.Priority;
import ru.gb.oseminar4.dailyplanner.data.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService implements ITaskService{
    private final List<Task> taskList;

    public TaskService() {
        this.taskList = new ArrayList<>();
    }

    @Override
    public void createTask(Integer yearOfDeadLine,
                           Integer monthOfDeadLine,
                           Integer dayOfDeadLine,
                           String name,
                           String patronymic,
                           String surname,
                           Priority priority) {
        this.taskList.add(new Task(yearOfDeadLine,
                monthOfDeadLine,
                dayOfDeadLine,
                name,
                patronymic,
                surname,
                priority));
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
