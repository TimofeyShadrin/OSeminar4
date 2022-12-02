package ru.gb.oseminar4.dailyplanner.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void createTask() {
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