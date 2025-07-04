package org.example.taskmanagerapp;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class TaskValidator {

    // Modified validateTask logic to output an Alert Signal rather than a simple text

    private static final Alert alert = new Alert(Alert.AlertType.ERROR);

    // Changed parameters for validate Task to accept individual attribute rather than a Task object
    // Allows for validating input before creating a Task object
    public static boolean validateTask(String taskName, String category, LocalDate dueDate, String priority) {

        alert.setTitle("Input Error!");

        if (taskName == null || taskName.isEmpty()) {
            alert.setHeaderText("Invalid Name");
            alert.setContentText("Task Name cannot be empty");
            alert.showAndWait();
            return false;
        } else if (category == null || category.isEmpty()) {
            alert.setHeaderText("Invalid Category");
            alert.setContentText("Category cannot be empty");
            alert.showAndWait();
            return false;
        } else if (dueDate == null) {
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Due Date cannot be empty");
            alert.showAndWait();
            return false;
        } else if (dueDate.isBefore(LocalDate.now())) {
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Due Date cannot be in the past");
            alert.showAndWait();
            return false;
        } else if (priority.isEmpty()) {
            alert.setHeaderText("Invalid Priority");
            alert.setContentText("Priority cannot be empty");
            alert.showAndWait();
            return false;
        } else if (!priority.equalsIgnoreCase("LOW") && !priority.equalsIgnoreCase("MEDIUM") && !priority.equalsIgnoreCase("HIGH")) {
            alert.setHeaderText("Invalid Priority");
            alert.setContentText("Priority must either be LOW, MEDIUM OR HIGH");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

    // Overloaded Validate Task to also accept subject parameter

    public static boolean validateTask(String taskName, String category, LocalDate dueDate, String priority, String subject) {

        alert.setTitle("Input Error!");

        if (taskName == null || taskName.isEmpty()) {
            alert.setHeaderText("Invalid Name");
            alert.setContentText("Task Name cannot be empty");
            alert.showAndWait();
            return false;
        } else if (category == null || category.isEmpty()) {
            alert.setHeaderText("Invalid Category");
            alert.setContentText("Category cannot be empty");
            alert.showAndWait();
            return false;
        } else if (dueDate == null) {
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Due Date cannot be empty");
            alert.showAndWait();
            return false;
        } else if (dueDate.isBefore(LocalDate.now())) {
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Due Date cannot be in the past");
            alert.showAndWait();
            return false;
        } else if (priority.isEmpty()) {
            alert.setHeaderText("Invalid Priority");
            alert.setContentText("Priority cannot be empty");
            alert.showAndWait();
            return false;
        } else if (!priority.equalsIgnoreCase("LOW") && !priority.equalsIgnoreCase("MEDIUM") && !priority.equalsIgnoreCase("HIGH")) {
            alert.setHeaderText("Invalid Priority");
            alert.setContentText("Priority must either be LOW, MEDIUM OR HIGH");
            alert.showAndWait();
            return false;
        }else if (subject == null || subject.isEmpty()) {
            alert.setHeaderText("Invalid Subject");
            alert.setContentText("Subject cannot be empty");
            alert.showAndWait();
            return false;}
        else {
            return true;
        }
    }
}