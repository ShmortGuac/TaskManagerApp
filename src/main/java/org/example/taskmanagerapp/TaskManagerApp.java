package org.example.taskmanagerapp;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskManagerApp extends Application{

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Task task1 = new Task("Vacuum Floor", "Cleaning", LocalDate.of(2025, 10, 24) , "High");
        Task task2 = new Task("Watch Netflix", "Entertainment", LocalDate.of(2025, 5, 24), "Urgent");

        System.out.println(task1);
        System.out.println(TaskValidator.validateTask(task1));
        System.out.println();
        System.out.println(task2);
        System.out.println(TaskValidator.validateTask(task2));

        launch();
    }

}