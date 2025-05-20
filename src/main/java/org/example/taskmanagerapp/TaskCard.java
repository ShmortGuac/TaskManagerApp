package org.example.taskmanagerapp;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskCard extends TitledPane {


    public TaskCard(String taskName, String taskCategory, String taskPriority, String taskDueDate){

        super();

        Label taskLabel = new Label("Task: " + taskName);
        Label categoryLabel = new Label("Category: " + taskCategory);
        Label priorityLabel = new Label("Priority: " + taskPriority);
        Label dueLabel = new Label("Due Date:" + taskDueDate);

        VBox task = new VBox(7, taskLabel, categoryLabel, priorityLabel, dueLabel);
        task.setPrefSize(560, 45);

        this.setText(taskName);
        this.setContent(task);
        this.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        this.setExpanded(false);

    }

    public TaskCard(Task task){
        super();

        String taskName = task.getTaskName();
        String taskCategory = task.getCategory();
        String taskPriority = task.getPriority();
        String taskDueDate = task.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Label taskLabel = new Label("Task: " + taskName);
        Label categoryLabel = new Label("Category: " + taskCategory);
        Label priorityLabel = new Label("Priority: " + taskPriority);
        Label dueLabel = new Label("Due Date:" + taskDueDate);

        VBox taskBox = new VBox(7, taskLabel, categoryLabel, priorityLabel, dueLabel);
        taskBox.setPrefSize(560, 45);

        this.setText(taskName);
        this.setContent(taskBox);
        this.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        this.setExpanded(false);
    }



}
