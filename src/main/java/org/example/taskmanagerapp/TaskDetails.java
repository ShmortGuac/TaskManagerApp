package org.example.taskmanagerapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class TaskDetails extends VBox {

    public TaskDetails(){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black;");
        taskName.setPrefHeight(50);
        taskName.setAlignment(Pos.CENTER);

        VBox taskAttributes = new VBox();
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);

        Button editTask = new Button("Edit Task", new ImageView(Icon.EDIT.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.DELETE.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);
        deleteTask.setOnAction(e-> deleteTask());

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskName, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");


    }

    public TaskDetails(GeneralTask task){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black;");
        taskName.setPrefHeight(30);
        taskName.setAlignment(Pos.CENTER);
        taskName.setText(task.getTaskName());

        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefHeight(35);
        categoryField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(categoryField, Priority.ALWAYS);
        categoryField.setEditable(false);
        categoryField.setText(task.getCategory());
        categoryField.setStyle("-fx-background-radius: 0");
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER_LEFT);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setPrefHeight(35);
        dueDateField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(dueDateField, Priority.ALWAYS);
        dueDateField.setStyle("-fx-background-radius: 0");
        dueDateField.setValue(task.getDueDate());
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER_LEFT);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        ComboBox<String> priorityField = new ComboBox<>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefHeight(35);
        priorityField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(priorityField, Priority.ALWAYS);
        priorityField.setStyle("-fx-background-radius: 0");
        priorityField.setValue(task.getPriority());
        HBox priority = new HBox(10, priorityLabel, priorityField);
        priority.setAlignment(Pos.CENTER_LEFT);

        Label statusLabel = new Label("Completed");
        statusLabel.setPrefWidth(140);
        statusLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        CheckBox statusBox = new CheckBox();
        statusBox.setScaleX(1.2);
        statusBox.setScaleY(1.2);
        statusBox.setSelected(task.isCompleted());
        statusBox.setOnAction(e-> task.setCompleted(!task.isCompleted()));
        HBox status = new HBox(10, statusLabel,statusBox);
        status.setAlignment(Pos.CENTER_LEFT);

        VBox taskAttributes = new VBox(20, category, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        Button editTask = new Button("Edit Task", new ImageView(Icon.EDIT.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);
        editTask.setOnAction(e-> editTask(taskName.getText(), categoryField.getText(), dueDateField.getValue(), priorityField.getValue()));

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.DELETE.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);
        deleteTask.setOnAction(e-> deleteTask());

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskName, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");


    }

    public TaskDetails(StudyTask task){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black;");
        taskName.setPrefHeight(30);
        taskName.setAlignment(Pos.CENTER);
        taskName.setText(task.getTaskName());

        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefHeight(35);
        categoryField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(categoryField, Priority.ALWAYS);
        categoryField.setEditable(false);
        categoryField.setText(task.getCategory());
        categoryField.setStyle("-fx-background-radius: 0");
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER_LEFT);

        Label subjectLabel = new Label("Subject");
        subjectLabel.setPrefWidth(140);
        subjectLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField subjectField = new TextField();
        subjectField.setPrefHeight(35);
        subjectField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(subjectField, Priority.ALWAYS);
        subjectField.setText(task.getSubject());
        subjectField.setStyle("-fx-background-radius: 0");
        HBox subject = new HBox(10, subjectLabel, subjectField);
        subject.setAlignment(Pos.CENTER_LEFT);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setPrefHeight(35);
        dueDateField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(dueDateField, Priority.ALWAYS);
        dueDateField.setStyle("-fx-background-radius: 0");
        dueDateField.setValue(task.getDueDate());
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER_LEFT);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        ComboBox<String> priorityField = new ComboBox<>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefHeight(35);
        priorityField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(priorityField, Priority.ALWAYS);
        priorityField.setStyle("-fx-background-radius: 0");
        priorityField.setValue(task.getPriority());
        HBox priority = new HBox(10, priorityLabel, priorityField);
        priority.setAlignment(Pos.CENTER_LEFT);

        Label statusLabel = new Label("Completed");
        statusLabel.setPrefWidth(140);
        statusLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        CheckBox statusBox = new CheckBox();
        statusBox.setScaleX(1.2);
        statusBox.setScaleY(1.2);
        statusBox.setSelected(task.isCompleted());
        statusBox.setOnAction(e-> task.setCompleted(!task.isCompleted()));
        HBox status = new HBox(10, statusLabel,statusBox);
        status.setAlignment(Pos.CENTER_LEFT);

        VBox taskAttributes = new VBox(20, category, subject, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        Button editTask = new Button("Edit Task", new ImageView(Icon.EDIT.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);
        editTask.setOnAction(e->{
            StudyTask selectedTask = (StudyTask) TaskBoardPage.taskListView.getSelectionModel().getSelectedItem();
            editTask(selectedTask, taskName.getText(), categoryField.getText(), dueDateField.getValue(), priorityField.getValue(), subjectField.getText());
        });

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.DELETE.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);
        deleteTask.setOnAction(e-> deleteTask());

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskName, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");


    }

    public TaskDetails(WorkTask task){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black;");
        taskName.setPrefHeight(30);
        taskName.setAlignment(Pos.CENTER);
        taskName.setText(task.getTaskName());

        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefHeight(35);
        categoryField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(categoryField, Priority.ALWAYS);
        categoryField.setEditable(false);
        categoryField.setText(task.getCategory());
        categoryField.setStyle("-fx-background-radius: 0");
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER_LEFT);

        Label descriptionLabel = new Label("Description");
        descriptionLabel.setMinWidth(140);
        descriptionLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextArea descriptionArea = new TextArea();
        descriptionArea.setPrefHeight(80);
        descriptionArea.setText(task.getDescription());
        descriptionArea.setWrapText(true);
        descriptionArea.setStyle("-fx-background-radius: 0");
        HBox description = new HBox(10, descriptionLabel, descriptionArea);
        description.setAlignment(Pos.CENTER_LEFT);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setPrefHeight(35);
        dueDateField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(dueDateField, Priority.ALWAYS);
        dueDateField.setStyle("-fx-background-radius: 0");
        dueDateField.setValue(task.getDueDate());
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER_LEFT);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        ComboBox<String> priorityField = new ComboBox<>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefHeight(35);
        priorityField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(priorityField, Priority.ALWAYS);
        priorityField.setStyle("-fx-background-radius: 0");
        priorityField.setValue(task.getPriority());
        HBox priority = new HBox(10, priorityLabel, priorityField);
        priority.setAlignment(Pos.CENTER_LEFT);

        Label statusLabel = new Label("Completed");
        statusLabel.setPrefWidth(140);
        statusLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        CheckBox statusBox = new CheckBox();
        statusBox.setScaleX(1.2);
        statusBox.setScaleY(1.2);
        statusBox.setSelected(task.isCompleted());
        statusBox.setOnAction(e-> task.setCompleted(!task.isCompleted()));
        HBox status = new HBox(10, statusLabel,statusBox);
        status.setAlignment(Pos.CENTER_LEFT);

        VBox taskAttributes = new VBox(20, category, description, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        Button editTask = new Button("Edit Task", new ImageView(Icon.EDIT.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);
        editTask.setOnAction(e->{
            WorkTask selectedTask = (WorkTask) TaskBoardPage.taskListView.getSelectionModel().getSelectedItem();
            editTask(selectedTask, taskName.getText(), categoryField.getText(), dueDateField.getValue(), priorityField.getValue(), descriptionArea.getText());
        });

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.DELETE.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);
        deleteTask.setOnAction(e-> deleteTask());

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskName, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");


    }


    private static void deleteTask(){
        int selectedIdx = TaskBoardPage.taskListView.getSelectionModel().getSelectedIndex();
        if(selectedIdx != -1){
            TaskBoardPage.taskListView.getItems().remove(selectedIdx);
        }
    }

    private static void editTask(String taskName, String category, LocalDate dueDate, String priority){
        Task selectedTask = TaskBoardPage.taskListView.getSelectionModel().getSelectedItem();
        if(selectedTask != null){
            if(TaskValidator.validateTask(taskName, category, dueDate, priority)){
                selectedTask.setTaskName(taskName);
                selectedTask.setCategory(category);
                selectedTask.setDueDate(dueDate);
                selectedTask.setPriority(priority);
            }
        }
    }

    private static void editTask(StudyTask task, String taskName, String category, LocalDate dueDate, String priority, String subject){
        if(task != null){
            if(TaskValidator.validateTask(taskName, category, dueDate, priority, subject)){
                task.setTaskName(taskName);
                task.setCategory(category);
                task.setDueDate(dueDate);
                task.setPriority(priority);
                task.setSubject(subject);
            }
        }
    }

    private static void editTask(WorkTask task, String taskName, String category, LocalDate dueDate, String priority, String subject){
        if(task != null){
            if(TaskValidator.validateTask(taskName, category, dueDate, priority)){
                task.setTaskName(taskName);
                task.setCategory(category);
                task.setDueDate(dueDate);
                task.setPriority(priority);
                task.setDescription(subject);
            }
        }
    }

}
