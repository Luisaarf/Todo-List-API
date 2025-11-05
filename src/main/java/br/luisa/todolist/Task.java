package br.luisa.todolist;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;

    public Task(String title, String description, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = false;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
}
