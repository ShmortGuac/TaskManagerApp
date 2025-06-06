package org.example.taskmanagerapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskManagerApp extends Application{

    // Changed the TaskManagerApp from CLI application into a GUI application

    @Override
    public void start(Stage stage) throws IOException {


        // Separated the original GUI code into its own separate class

        HomePage homePage = new HomePage();
        homePage.setVisible(true);

        TaskBoardPage taskBoardPage = new TaskBoardPage();
        taskBoardPage.setVisible(false);


        homePage.newTaskBoard.setOnAction(e->{
            homePage.setVisible(false);
            taskBoardPage.setVisible(true);
        });

        taskBoardPage.backButton.setOnMouseClicked(e->{
            homePage.setVisible(true);
            taskBoardPage.setVisible(false);
        });

        StackPane root = new StackPane(homePage, taskBoardPage);

        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Task Manager App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}