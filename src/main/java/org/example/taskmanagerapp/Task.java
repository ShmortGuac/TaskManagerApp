package org.example.taskmanagerapp;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Task {
 
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

    public VBox displayProperties(){
        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefWidth(150);
        categoryField.setPrefHeight(35);
        categoryField.setEditable(false);
        categoryField.setStyle("-fx-background-radius: 0");
        categoryField.setText(category);
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setPrefWidth(150);
        dueDateField.setPrefHeight(35);
        dueDateField.setValue(dueDate);
        dueDateField.setStyle("-fx-background-radius: 0");
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        ComboBox<String> priorityField = new ComboBox<String>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefWidth(150);
        priorityField.setPrefHeight(35);
        priorityField.setEditable(false);
        priorityField.setValue(priority);
        priorityField.setStyle("-fx-background-radius: 0");
        HBox priority = new HBox(10, priorityLabel, priorityField);
        priority.setAlignment(Pos.CENTER);

        Label statusLabel = new Label("Completed");
        statusLabel.setPrefWidth(140);
        statusLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        CheckBox statusBox = new CheckBox();
        statusBox.setScaleX(1.2);
        statusBox.setScaleY(1.2);
        HBox status = new HBox(10, statusLabel,statusBox);
        status.setAlignment(Pos.CENTER_LEFT);

        VBox taskAttributes = new VBox(20, category, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        return  taskAttributes;
    }


    @Override
    public String toString(){
        return taskName;
    }

}
