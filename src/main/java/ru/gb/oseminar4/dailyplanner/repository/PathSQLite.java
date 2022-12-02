package ru.gb.oseminar4.dailyplanner.repository;

public enum PathSQLite {
    PATH_SQ_LITE("jdbc:sqlite:/home/timofei/Homework/DailyPlanner/src/main/resources/ru/gb/oseminar4/dailyplanner/planner.db");

    private final String path;

    PathSQLite(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
