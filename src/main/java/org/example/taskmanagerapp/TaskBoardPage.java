package org.example.taskmanagerapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;


public class TaskBoardPage extends VBox {

    public HBox backButton;

    public static ListView<Task> taskList;

    public TaskBoardPage(){

        // Page Header---------------------------------------------------------

        Image backLogo = new Image("file:src/main/images/arrow_back.png");
        ImageView backLogoView = new ImageView(backLogo);

        Label backLabel = new Label("Back");
        backLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16");

        Image nexusLogo = new Image("file:src/main/images/Nexus.png");
        ImageView nexusLogoView = new ImageView(nexusLogo);
        nexusLogoView.setFitHeight(48);
        nexusLogoView.setPreserveRatio(true);

        backButton = new HBox(5, new ImageView(Icon.BACK.show()), backLabel);
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

        // Page Header---------------------------------------------------------

        // Page Body-----------------------------------------------------------

        // Task List Section--------------------------------
        Label taskBoardLabel = new Label("Task Board");
        taskBoardLabel.setMaxWidth(Double.MAX_VALUE);
        taskBoardLabel.setStyle("-fx-text-fill: white;");


        ComboBox<String> taskFilter = new ComboBox<String>();
        taskFilter.setPrefWidth(128);
        taskFilter.getItems().addAll("General", "Study", "Work");

        HBox filterContainer = new HBox(10, new ImageView(Icon.FILTER.show()), taskFilter);

        HBox taskBoardHeader = new HBox(taskBoardLabel, filterContainer);
        HBox.setHgrow(taskBoardLabel, Priority.ALWAYS);
        taskBoardHeader.setAlignment(Pos.CENTER_LEFT);
        taskBoardHeader.setPrefHeight(30);

        taskList = new ListView<Task>();

        VBox taskBoard = new VBox(10, taskBoardHeader, taskList);
        VBox.setVgrow(taskList, Priority.ALWAYS);
        taskBoard.setPadding(new Insets(10));
        // Task List Section--------------------------------



        // Task Details Section-----------------------------

        Label taskDetailsLabel = new Label("Task Details");
        taskDetailsLabel.setAlignment(Pos.CENTER_LEFT);
        taskDetailsLabel.setStyle("-fx-text-fill: white");
        taskDetailsLabel.setPrefHeight(30);

        VBox taskDetailsBox = new VBox();
        taskDetailsBox.getChildren().add(new TaskDetails());

        taskList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            taskDetailsBox.getChildren().clear();
            taskDetailsBox.getChildren().add(new TaskDetails((GeneralTask) newVal));
        });

        VBox taskDetails = new VBox(10, taskDetailsLabel, taskDetailsBox);
        VBox.setVgrow(taskDetailsBox, Priority.ALWAYS);
        taskDetails.setPrefWidth(350);
        taskDetails.setPadding(new Insets(10));


        HBox pageBody = new HBox(taskBoard, taskDetails);
        HBox.setHgrow(taskBoard, Priority.ALWAYS);
        VBox.setVgrow(pageBody, Priority.ALWAYS);

        // Task Details Section-----------------------------

        // Page Body-----------------------------------------------------------

        // Additional Buttons--------------------------------------------------

        Button addTask = new Button("Add Task", new ImageView(Icon.ADD.show()));
        addTask.setGraphicTextGap(10);
        addTask.setPadding(new Insets(10, 15, 10, 10));
        addTask.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 16; -fx-cursor: hand");
        addTask.setOnAction(e->{
            new AddTaskPanel();
        });

        HBox addTaskContainer = new HBox(addTask);
        HBox.setHgrow(addTaskContainer, Priority.ALWAYS);
        addTaskContainer.setAlignment(Pos.CENTER_LEFT);


        Button saveBoard = new Button("SAVE BOARD", new ImageView(Icon.SAVE.show()));
        saveBoard.setGraphicTextGap(10);
        saveBoard.setPadding(new Insets(10, 15, 10, 10));
        saveBoard.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 16; -fx-cursor: hand");
        HBox saveBoardContainer = new HBox(saveBoard);
        HBox.setHgrow(saveBoardContainer, Priority.ALWAYS);
        saveBoardContainer.setAlignment(Pos.CENTER_RIGHT);

        HBox buttonSection = new HBox(addTaskContainer, saveBoardContainer);
        buttonSection.setPadding(new Insets(10));


        // Remove Task Input section and moved it into a separate class for the input panel



        this.getChildren().addAll(pageHeader, pageBody, buttonSection);
        this.setSpacing(10);
        this.setPadding(new Insets(20, 10, 20, 10));

        this.setStyle("-fx-background-color: black;");



    }





}
