package org.example.taskmanagerapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class TaskBoardPage extends VBox {

    public HBox backButton;


    public TaskBoardPage(){

        Image editIcon = new Image("file:src/main/images/Edit.png");
        ImageView editIconView = new ImageView(editIcon);

        Image deleteIcon = new Image("file:src/main/images/Trash.png");
        ImageView deleteIconView = new ImageView(deleteIcon);

        // Page Header---------------------------------------------------------

        Image backLogo = new Image("file:src/main/images/arrow_back.png");
        ImageView backLogoView = new ImageView(backLogo);

        Label backLabel = new Label("Back");
        backLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16");

        Image nexusLogo = new Image("file:src/main/images/Nexus.png");
        ImageView nexusLogoView = new ImageView(nexusLogo);
        nexusLogoView.setFitHeight(48);
        nexusLogoView.setPreserveRatio(true);

        backButton = new HBox(5, backLogoView, backLabel);
        backButton.setAlignment(Pos.CENTER_LEFT);
        backButton.setStyle("-fx-cursor: hand");

        HBox backContainer = new HBox(backButton);
        HBox.setHgrow(backContainer, Priority.ALWAYS);
        backContainer.setAlignment(Pos.CENTER_LEFT);

        HBox logoContainer = new HBox(nexusLogoView);
        HBox.setHgrow(logoContainer, Priority.ALWAYS);
        logoContainer.setAlignment(Pos.CENTER);

        HBox emptyContainer = new HBox();
        HBox.setHgrow(emptyContainer, Priority.ALWAYS);


        HBox pageHeader = new HBox(10, backContainer, logoContainer, emptyContainer);
        pageHeader.setAlignment(Pos.CENTER);
        pageHeader.setStyle("-fx-border-color: white;");

        // Page Header---------------------------------------------------------

        // Page Body-----------------------------------------------------------

        // Task List Section--------------------------------
        Label taskBoardLabel = new Label("Task Board");
        taskBoardLabel.setMaxWidth(Double.MAX_VALUE);
        taskBoardLabel.setStyle("-fx-text-fill: white;");

        Image filterIcon = new Image("file:src/main/images/filter.png");
        ImageView filterIconView = new ImageView(filterIcon);

        ComboBox<String> taskFilter = new ComboBox<String>();
        taskFilter.setPrefWidth(128);

        HBox filterContainer = new HBox(10, filterIconView, taskFilter);

        HBox taskBoardHeader = new HBox(taskBoardLabel, filterContainer);
        HBox.setHgrow(taskBoardLabel, Priority.ALWAYS);
        taskBoardHeader.setAlignment(Pos.CENTER_LEFT);
        taskBoardHeader.setPrefHeight(30);

        ListView<String> taskList = new ListView<String>();

        VBox taskBoard = new VBox(10, taskBoardHeader, taskList);
        taskBoard.setPadding(new Insets(10));
        // Task List Section--------------------------------



        // Task Details Section-----------------------------

        Label taskDetailsLabel = new Label("Task Details");
        taskDetailsLabel.setAlignment(Pos.CENTER_LEFT);
        taskDetailsLabel.setStyle("-fx-text-fill: white");
        taskDetailsLabel.setPrefHeight(30);

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black;");
        taskName.setPrefHeight(50);
        taskName.setAlignment(Pos.CENTER);

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

        VBox taskAttributes = new VBox(20, category, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        Button editTask = new Button("Edit Task", editIconView);
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);

        Button deleteTask = new Button("Delete Task", deleteIconView);
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        VBox taskDetailsBox = new VBox(taskName, taskAttributes, taskButtons);
        taskDetailsBox.setPadding(new Insets(10));
        taskDetailsBox.setStyle("-fx-border-color: white; -fx-border-width: 3;");

        VBox taskDetails = new VBox(10, taskDetailsLabel, taskDetailsBox);
        VBox.setVgrow(taskDetailsBox, Priority.ALWAYS);
        taskDetails.setPrefWidth(350);
        taskDetails.setPadding(new Insets(10));


        HBox pageBody = new HBox(taskBoard, taskDetails);
        HBox.setHgrow(taskBoard, Priority.ALWAYS);
        pageBody.setStyle("-fx-border-color: white;");

        // Task Details Section-----------------------------

        // Page Body-----------------------------------------------------------


        // Remove Task Input section and moved it into a separate class for the input panel


        // Task display section ----------------------------------------------------------------

        this.getChildren().addAll(pageHeader, pageBody);
        this.setSpacing(10);
        this.setPadding(new Insets(20, 10, 20, 10));

        this.setStyle("-fx-background-color: black;");



    }

}
