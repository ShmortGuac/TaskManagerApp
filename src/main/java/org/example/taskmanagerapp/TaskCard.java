package org.example.taskmanagerapp;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

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



}
