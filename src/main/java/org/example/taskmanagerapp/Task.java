package org.example.taskmanagerapp;

import java.time.LocalDate;

public class Task {
 
    private String taskName;
    private String category;
    private LocalDate dueDate;
    private String priority;

    public Task(){
        this.taskName = "Default Task";
        this.category = "General";
        this.dueDate = LocalDate.now();
        this.priority = "Low";
    }

    public Task(String taskName, String category, LocalDate dueDate, String priority) {
        this.taskName = taskName;
        this.category = category;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        return "Task : " + taskName + ", Category : " + category + ", Due Date : " + dueDate + ", Priority : " + priority;
    }

}
