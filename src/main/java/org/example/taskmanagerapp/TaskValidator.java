package org.example.taskmanagerapp;

import java.time.LocalDate;

public class TaskValidator {

    public static String validateTask(Task task) {

        String taskName = task.getTaskName();
        String category = task.getCategory();
        LocalDate dueDate = task.getDueDate();
        String priority = task.getPriority().toLowerCase();


        if (task.getTaskName() == null || task.getTaskName().isEmpty()) {
            return "Task name cannot be empty.";
        } else if (task.getCategory() == null || task.getCategory().isEmpty()) {
            return "Category cannot be empty.";
        } else if (task.getDueDate() == null) {
            return "Due date cannot be empty.";
        } else if (task.getDueDate().isBefore(LocalDate.now())) {
            return "Due date cannot be in the past.";
        } else if (task.getPriority() == null || task.getPriority().isEmpty()) {
            return "Priority cannot be empty.";
        } else if (!priority.equals("low") && !priority.equals("medium") && !priority.equals("high")) {
            return "Priority must be either 'Low', 'Medium' or 'High'.";
        } else {
            return "Task is valid.";
        }
    }
}
