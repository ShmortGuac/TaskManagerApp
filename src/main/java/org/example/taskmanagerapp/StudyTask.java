package org.example.taskmanagerapp;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class StudyTask extends Task{

    private String subject;

    public StudyTask(){
        super();
        subject = "General Studies";
    }

    public StudyTask(String taskName, String category, LocalDate dueDate, String priority, String subject){
        super(taskName, category, dueDate, priority);
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    public VBox displayProperties(){
        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefWidth(150);
        categoryField.setPrefHeight(35);
        categoryField.setEditable(false);
        categoryField.setStyle("-fx-background-radius: 0");
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER);

        Label subjectLabel = new Label("Subject");
        subjectLabel.setPrefWidth(140);
        subjectLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField subjectField = new TextField();
        subjectField.setPrefWidth(150);
        subjectField.setPrefHeight(35);
        subjectField.setEditable(false);
        subjectField.setStyle("-fx-background-radius: 0");
        HBox subject = new HBox(10, subjectLabel, subjectField);
        subject.setAlignment(Pos.CENTER);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField dueDateField = new TextField();
        dueDateField.setPrefWidth(150);
        dueDateField.setPrefHeight(35);
        dueDateField.setEditable(false);
        dueDateField.setStyle("-fx-background-radius: 0");
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField priorityField = new TextField();
        priorityField.setPrefWidth(150);
        priorityField.setPrefHeight(35);
        priorityField.setEditable(false);
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

        VBox taskAttributes = new VBox(20, category, subject, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        return  taskAttributes;
    }


}
