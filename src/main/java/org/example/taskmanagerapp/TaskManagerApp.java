package org.example.taskmanagerapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskManagerApp extends Application{

    @Override
    public void start(Stage stage) throws IOException {

        Image nexusLogo = new Image("file:src/main/java/org/example/taskmanagerapp/Nexus.png");
        ImageView imageView = new ImageView(nexusLogo);
        imageView.setFitHeight(48);
        imageView.setPreserveRatio(true);

        Border inputBorder = new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                new CornerRadii(50),
                new BorderWidths(0)
        ));

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

        TextField taskDueTField = new TextField();

        // Task Priority
        Label taskPriorityLabel = new Label("Priority");
        taskPriorityLabel.setPrefHeight(25);
        taskPriorityLabel.setTextFill(Color.WHITE);

        TextField taskPriorityTField = new TextField();

        VBox taskName = new VBox(taskNameLabel, taskNameTField);
        VBox taskCategory = new VBox(taskCategoryLabel, taskCategoryTField);
        VBox taskDueDate = new VBox(taskDueLabel, taskDueTField);
        VBox taskPriority = new VBox(taskPriorityLabel, taskPriorityTField);

        VBox inputs = new VBox(10, taskName, taskCategory, taskDueDate, taskPriority);


        // Add Task Button
        Button addTaskButton = new Button("ADD");
        addTaskButton.setPrefWidth(Double.MAX_VALUE);
        addTaskButton.setTextFill(Color.WHITE);
        addTaskButton.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 13));
        addTaskButton.setBackground(Background.fill(Color.web("0F7D12")));

        VBox inputSection = new VBox(50, inputs, addTaskButton);
        inputSection.setPrefWidth(227);


        Label outputLabel = new Label("Your To-Do List");
        outputLabel.setTextFill(Color.WHITE);
        outputLabel.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 16));

        VBox displaySection = new VBox(10, outputLabel);
        displaySection.setPadding(new Insets(22, 10, 22, 10));


        HBox titleSection = new HBox(imageView);
        titleSection.setAlignment(Pos.CENTER);

        HBox contentSection = new HBox(74, inputSection, displaySection);
        contentSection.setPadding(new Insets(10));

        VBox root = new VBox(10, titleSection, contentSection);
        root.setBackground(Background.EMPTY);
        root.setPadding(new Insets(20, 10, 20, 10));

        Scene scene = new Scene(root, 770, 500);
        scene.setFill(Color.BLACK);
        stage.setTitle("Task Manager App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}