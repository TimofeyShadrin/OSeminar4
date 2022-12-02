package ru.gb.oseminar4.dailyplanner.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {

    private final Integer id;
    private final String date;
    private final String time;
    private String deadLine;
    private String fullName;
    private Priority priority;
    private String task;
    private static final AtomicInteger idAtomic = new AtomicInteger(0);

    public Task(String dateOfDeadLine,
                String name,
                String patronymic,
                String surname,
                Priority priority,
                String task) {
        this.id = idAtomic.incrementAndGet();

        LocalDate localDate = LocalDate.now();
        this.date = localDate.getYear() + "-" +
                localDate.getMonthValue() + "-" +
                localDate.getDayOfMonth();

        LocalTime localTime = LocalTime.now();
        this.time = localTime.getHour() + ":" + localTime.getMinute();

        this.deadLine = dateOfDeadLine;

        this.fullName = name + " " + patronymic + " " + surname;
        this.priority = priority;
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public String getFullName() {
        return fullName;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(date, task.date) &&
                Objects.equals(time, task.time) && Objects.equals(deadLine, task.deadLine) &&
                Objects.equals(fullName, task.fullName) && priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, deadLine, fullName, priority);
    }

    @Override
    public String toString() {
        return ("Task No "+ id +
                ", date=" + date +
                ", time=" + time +
                ", deadLine=" + deadLine +
                ", fullName=" + fullName +
                ", priority=" + priority +
                ", task=" + task + "\n")
                .replace("[", "")
                .replace("]", "");
    }
}
