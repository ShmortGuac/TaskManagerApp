package org.example.taskmanagerapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;


public class TaskBoardPage extends VBox {

    public HBox backButton;

    public static ArrayList<Task> taskList = new ArrayList<>();
    public static ListView<Task> taskListView;

    public TaskBoardPage(TaskManagerApp app, ArrayList<Task> taskArrayList){

        // Page Header --------------------------------------------------------
        Label backLabel = new Label("Back");
        backLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16");

        Image nexusLogo = new Image("file:src/main/images/Nexus.png");
        ImageView nexusLogoView = new ImageView(nexusLogo);
        nexusLogoView.setFitHeight(48);
        nexusLogoView.setPreserveRatio(true);

        backButton = new HBox(5, new ImageView(Icon.BACK.show()), backLabel);
        backButton.setAlignment(Pos.CENTER_LEFT);
        backButton.setStyle("-fx-cursor: hand");

        backButton.setOnMouseEntered(e -> {
            backButton.setStyle("-fx-cursor: hand; -fx-scale-x: 1.1; -fx-scale-y: 1.1;");
        });
        backButton.setOnMouseExited(e -> {
            backButton.setStyle("-fx-cursor: hand; -fx-scale-x: 1.0; -fx-scale-y: 1.0;");
        });

        backButton.setOnMouseClicked(e->{
            app.showHomePage();
        });

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
        // Page Header --------------------------------------------------------


        // Page Body-----------------------------------------------------------

        // Task List Section -------------------------------
        Label taskBoardLabel = new Label("Task Board");
        taskBoardLabel.setMaxWidth(Double.MAX_VALUE);
        taskBoardLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px");


        ComboBox<String> taskFilter = new ComboBox<String>();
        taskFilter.setPrefWidth(128);
        taskFilter.getItems().addAll("None", "General", "Study", "Work");
        taskFilter.setValue("None");
        taskFilter.setOnAction(e->{
            taskListView.getItems().clear();
            if (!taskFilter.getValue().equalsIgnoreCase("None")) {
                for(Task task: taskList){
                    if(task.getCategory().equalsIgnoreCase(taskFilter.getValue())){
                        taskListView.getItems().add(task);
                    }
                }
            }else{
                for(Task task: taskList){
                    taskListView.getItems().add(task);
                }
            }
        });

        HBox filterContainer = new HBox(10, new ImageView(Icon.FILTER.show()), taskFilter);

        HBox taskBoardHeader = new HBox(taskBoardLabel, filterContainer);
        HBox.setHgrow(taskBoardLabel, Priority.ALWAYS);
        taskBoardHeader.setAlignment(Pos.CENTER_LEFT);
        taskBoardHeader.setPrefHeight(30);


        taskListView = new ListView<Task>();
        taskListView.setStyle("-fx-font-size: 20;");
        if(!taskArrayList.isEmpty()){
            for(Task task: taskArrayList){
                taskList.add(task);
                taskListView.getItems().add(task);
            }
        }


        VBox taskBoard = new VBox(10, taskBoardHeader, taskListView);
        VBox.setVgrow(taskListView, Priority.ALWAYS);
        taskBoard.setPadding(new Insets(10));
        // Task List Section -------------------------------


        // Task Details Section ----------------------------
        Label taskDetailsLabel = new Label("Task Details");
        taskDetailsLabel.setAlignment(Pos.CENTER_LEFT);
        taskDetailsLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px");
        taskDetailsLabel.setPrefHeight(30);

        VBox taskDetailsBox = new VBox(new TaskDetails());
        VBox.setVgrow(taskDetailsBox, Priority.ALWAYS);

        taskListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            taskDetailsBox.getChildren().clear();
            if (newVal != null) {
                taskDetailsBox.getChildren().add(newVal.displayProperties());
            }else{
                taskDetailsBox.getChildren().add(new TaskDetails());
            }
        });

        VBox taskDetails = new VBox(10, taskDetailsLabel, taskDetailsBox);
        VBox.setVgrow(taskDetailsBox, Priority.ALWAYS);
        taskDetails.setPrefWidth(450);
        taskDetails.setPadding(new Insets(10));


        HBox pageBody = new HBox(taskBoard, taskDetails);
        HBox.setHgrow(taskBoard, Priority.ALWAYS);
        VBox.setVgrow(pageBody, Priority.ALWAYS);
        // Task Details Section ----------------------------

        // Page Body-----------------------------------------------------------


        // Additional Buttons--------------------------------------------------
        Button addTask = new Button("Add Task", new ImageView(Icon.ADD.show()));
        addTask.setGraphicTextGap(10);
        addTask.setPadding(new Insets(10, 15, 10, 10));
        addTask.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 16; -fx-cursor: hand");

        addTask.setOnMouseEntered(e -> {
            addTask.setStyle("-fx-background-color: #00AA00; -fx-text-fill: white; -fx-font-size: 16; -fx-cursor: hand; ");
        });
        addTask.setOnMouseExited(e -> {
            addTask.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 16; -fx-cursor: hand;");
        });

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

        saveBoard.setOnMouseEntered(e -> {
            saveBoard.setStyle("-fx-background-color: #00AA00; -fx-text-fill: white; -fx-font-size: 16; -fx-cursor: hand;");
        });
        saveBoard.setOnMouseExited(e -> {
            saveBoard.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 16; -fx-cursor: hand;");
        });

        saveBoard.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("src/main/savedBoards"));
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Task Board Files (*.csv)", "*.csv")
            );

            File saveFile = fileChooser.showSaveDialog(app.getPrimaryStage());
            FileHandler fileHandler = new FileHandler();

            fileHandler.saveBoard(saveFile, taskList);

        });
        HBox saveBoardContainer = new HBox(saveBoard);
        HBox.setHgrow(saveBoardContainer, Priority.ALWAYS);
        saveBoardContainer.setAlignment(Pos.CENTER_RIGHT);

        HBox buttonSection = new HBox(addTaskContainer, saveBoardContainer);
        buttonSection.setPadding(new Insets(10));
        // Additional Buttons--------------------------------------------------

        // Remove Task Input section and moved it into a separate class for the input panel

        this.getChildren().addAll(pageHeader, pageBody, buttonSection);
        this.setSpacing(10);
        this.setPadding(new Insets(20, 10, 20, 10));

        this.setStyle("-fx-background-color: black;");
    }
}