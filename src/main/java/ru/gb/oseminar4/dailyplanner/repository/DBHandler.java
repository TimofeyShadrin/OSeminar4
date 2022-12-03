package ru.gb.oseminar4.dailyplanner.repository;

import org.sqlite.JDBC;
import ru.gb.oseminar4.dailyplanner.data.Task;
import ru.gb.oseminar4.dailyplanner.data.TaskForTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class DBHandler {

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DBHandler instance = null;

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private final Connection connection;

    private DBHandler() throws SQLException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(PathSQLite.PATH_SQ_LITE.getPath());
    }

    public List<TaskForTable> getAllTasks() {

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {
            Logger.getAnonymousLogger().info("Making a request to DB...");
            // В данный список будем загружать наши задачи, полученные из БД
            List<TaskForTable> tasks = new ArrayList<>();
            // В resultSet будет храниться результат нашего запроса,
            // который выполняется командой statement.executeQuery()
            ResultSet resultSet = statement.executeQuery(
                    "SELECT id, date, time, deadline, fullname, priority, task FROM tasks");
            // Проходимся по нашему resultSet и заносим данные в tasks
            while (resultSet.next()) {
                tasks.add(new TaskForTable(resultSet.getInt("id"),
                        resultSet.getString("date"),
                        resultSet.getString("time"),
                        resultSet.getString("deadline"),
                        resultSet.getString("fullname"),
                        resultSet.getString("priority"),
                        resultSet.getString("task")
                        ));
            }
            // Возвращаем наш список
            Logger.getAnonymousLogger().info("DONE");
            return tasks;

        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }

    // Добавление в БД
    public void addTask(Task task) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO tasks ('date', 'time', 'deadline', 'fullname', 'priority', 'task') " +
                        "VALUES(?, ?, ?, ?, ?, ?)")) {
            statement.setObject(1, task.getDate());
            statement.setObject(2, task.getTime());
            statement.setObject(3, task.getDeadLine());
            statement.setObject(4, task.getFullName());
            statement.setObject(5, task.getPriority().toString());
            statement.setObject(6, task.getTask());
            Logger.getAnonymousLogger().info("Making a request to DB...");
            // Выполняем запрос
            statement.execute();
            Logger.getAnonymousLogger().info("DONE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удаление задачи по id
    public void deleteTask(Integer id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM tasks WHERE id = ?")) {
            statement.setObject(1, id);
            Logger.getAnonymousLogger().info("Making a request to DB...");
            // Выполняем запрос
            statement.execute();
            Logger.getAnonymousLogger().info("DONE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
