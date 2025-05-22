package org.example.taskmanagerapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskManagerApp extends Application{
    @Override
    public void start(Stage stage) throws IOException {

        Image nexusLogo = new Image("file:src/main/java/org/example/taskmanagerapp/Nexus.png");
        ImageView imageView = new ImageView(nexusLogo);
        imageView.setFitHeight(48);
        imageView.setPreserveRatio(true);

        HBox titleSection = new HBox(imageView);
        titleSection.setAlignment(Pos.CENTER);

        // Task Input section --------------------------------------------------------------

        // Task Name
        Label taskNameLabel = new Label("Task Name");
        taskNameLabel.setPrefHeight(25);
        taskNameLabel.setTextFill(Color.WHITE);

        TextField taskNameTField = new TextField();

        // Task Category
        Label taskCategoryLabel = new Label("Category");
        taskCategoryLabel.setPrefHeight(25);
        taskCategoryLabel.setTextFill(Color.WHITE);

        TextField taskCategoryTField = new TextField();

        // Task Due Date
        Label taskDueLabel = new Label("Due Date");
        taskDueLabel.setPrefHeight(25);
        taskDueLabel.setTextFill(Color.WHITE);

        //TextField taskDueTField = new TextField();
        DatePicker taskDueDatePicker = new DatePicker();
        taskDueDatePicker.setPrefWidth(227);


        // Task Priority
        Label taskPriorityLabel = new Label("Priority");
        taskPriorityLabel.setPrefHeight(25);
        taskPriorityLabel.setTextFill(Color.WHITE);

        TextField taskPriorityTField = new TextField();

        // Error Label
        Label errorMsg = new Label();
        errorMsg.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 11));
        errorMsg.setTextFill(Color.RED);

        // Add Task Button
        Button addTaskButton = new Button("ADD");
        addTaskButton.setPrefWidth(Double.MAX_VALUE);
        addTaskButton.setTextFill(Color.WHITE);
        addTaskButton.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        addTaskButton.setBackground(Background.fill(Color.web("0F7D12")));

        VBox taskName = new VBox(taskNameLabel, taskNameTField);
        VBox taskCategory = new VBox(taskCategoryLabel, taskCategoryTField);
        VBox taskDueDate = new VBox(taskDueLabel, taskDueDatePicker);
        VBox taskPriority = new VBox(taskPriorityLabel, taskPriorityTField);

        VBox inputs = new VBox(10, taskName, taskCategory, taskDueDate, taskPriority);
        VBox btnAndError = new VBox(10, addTaskButton, errorMsg);

        VBox inputSection = new VBox(40, inputs, btnAndError);
        inputSection.setMinWidth(227);
        inputSection.setPrefWidth(227);

        // Task Input section end --------------------------------------------------------------

        // Task display section ----------------------------------------------------------------

        Label outputLabel = new Label("Your To-Do List");
        outputLabel.setTextFill(Color.WHITE);
        outputLabel.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));

        TaskCard taskExample1 = new TaskCard("Vacuum Floor", "Cleaning", "Medium", "24/10/2025");
        TaskCard taskExample2 = new TaskCard("Watching Netflix", "Entertainment", "Low", "24/5/2025");

        VBox displaySection = new VBox(10, outputLabel, taskExample1, taskExample2);
        displaySection.setPadding(new Insets(22, 10, 22, 10));

        //Adding New Task
        addTaskButton.setOnAction(e->{
                String tName = taskNameTField.getText();
                String tCategory = taskCategoryTField.getText();
                //LocalDate tDate = LocalDate.parse(taskDueTField.getText(), DateTimeFormatter.ofPattern("d/M/yyyy"));
                LocalDate tDate = taskDueDatePicker.getValue();
                String tPriority =  taskPriorityTField.getText();

                Task taskObj = new Task(tName, tCategory, tDate, tPriority);

                if(TaskValidator.validateTask(taskObj).equals("Task is valid.")){
                    displaySection.getChildren().add(new TaskCard(taskObj));
                    taskNameTField.setText("");
                    taskCategoryTField.setText("");
                    //taskDueTField.setText("");
                    taskPriorityTField.setText("");
                }else{
                    errorMsg.setText(TaskValidator.validateTask(taskObj));
                }

        });

        HBox contentSection = new HBox(74, inputSection, displaySection);
        contentSection.setPadding(new Insets(10));

        //Root ----------------------------------------------------------------
        VBox root = new VBox(10, titleSection, contentSection);
        root.setBackground(Background.EMPTY);
        root.setPadding(new Insets(20, 10, 20, 10));

        Scene scene = new Scene(root, 800, 450);
        scene.setFill(Color.BLACK);
        stage.setTitle("Task Manager App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}