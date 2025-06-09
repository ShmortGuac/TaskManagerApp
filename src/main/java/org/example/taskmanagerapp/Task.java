package org.example.taskmanagerapp;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

@SuppressWarnings("unused")
public abstract class Task {
 
    private String taskName;
    private String category;
    private LocalDate dueDate;
    private String priority;
    private boolean completed;

    public Task(){
        this.taskName = "Default Task";
        this.category = "General";
        this.dueDate = LocalDate.now();
        this.priority = "Low";
        this.completed = false;
    }

    public Task(String taskName, String category, LocalDate dueDate, String priority) {
        this.taskName = taskName;
        this.category = category;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public Task(String taskName, String category, LocalDate dueDate, String priority, boolean completed) {
        this.taskName = taskName;
        this.category = category;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
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

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public abstract VBox displayProperties();


    @Override
    public String toString(){
        if(isCompleted()) {
            return "✔ " + taskName;
        }else {
            return taskName;
        }
    }

}
