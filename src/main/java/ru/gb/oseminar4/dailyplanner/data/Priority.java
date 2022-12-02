package ru.gb.oseminar4.dailyplanner.data;

public enum Priority {
    LOW("LOW"),
    MIDDLE("MIDDLE"),
    HIGH("HIGH");

    private final String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
