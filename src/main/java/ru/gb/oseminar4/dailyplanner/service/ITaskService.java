package ru.gb.oseminar4.dailyplanner.service;

import ru.gb.oseminar4.dailyplanner.data.Priority;
import ru.gb.oseminar4.dailyplanner.data.Task;

import java.util.List;

public interface ITaskService {
    void createTask(Integer yearOfDeadLine,
                    Integer monthOfDeadLine,
                    Integer dayOfDeadLine,
                    String name,
                    String patronymic,
                    String surname,
                    Priority priority);
    void deleteTask(Integer id);
    List<Task> getAll();
}
