package ru.gb.oseminar4.dailyplanner.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.oseminar4.dailyplanner.data.Priority;

class TaskServiceTest {
    TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void createTask() {
        taskService.createTask(2022, 11, 30,
                "Ivan", "Ivanica", "Petrov", Priority.LOW);
        taskService.createTask(2022, 11, 30,
                "Ivan", "Jovanovich", "Petrov", Priority.LOW);
        System.out.println(taskService.getAll());
    }

    @Test
    void deleteTask() {
        taskService.deleteTask(1);
        System.out.println(taskService.getAll());
    }

    @Test
    void getAll() {
        System.out.println(taskService.getAll());
    }
}