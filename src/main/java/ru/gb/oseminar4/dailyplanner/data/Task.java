package ru.gb.oseminar4.dailyplanner.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Task {

    private final Long id;
    private final String date;
    private final String time;
    private final String deadLine;
    private final String fullName;
    private final Priority priority;
    private static final AtomicLong idAtomic = new AtomicLong(0);

    public Task(Integer yearOfDeadLine,
                Integer monthOfDeadLine,
                Integer dayOfDeadLine,
                String name,
                String patronymic,
                String surname,
                Priority priority) {
        this.id = idAtomic.incrementAndGet();

        LocalDate localDate = LocalDate.now();
        this.date = localDate.getYear() + "-" +
                localDate.getMonthValue() + "-" +
                localDate.getDayOfMonth();

        LocalTime localTime = LocalTime.now();
        this.time = localTime.getHour() + ":" + localTime.getMinute();

        this.deadLine = yearOfDeadLine + "-" +
                monthOfDeadLine + "-" +
                dayOfDeadLine;

        this.fullName = name + " " + patronymic + " " + surname;
        this.priority = priority;
    }

    public Long getId() {
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
        return "Task{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", fullName='" + fullName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
