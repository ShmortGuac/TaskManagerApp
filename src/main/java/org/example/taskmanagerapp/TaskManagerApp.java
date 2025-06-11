package org.example.taskmanagerapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class TaskManagerApp extends Application{

    private Stage primaryStage;

    // Changed the TaskManagerApp from CLI application into a GUI application

    // Separated each page into its own separate class and each page is called from within this main class

    @Override
    public void start(Stage stage) throws IOException {

        // Separated the original GUI code into its own separate class
        primaryStage = stage;
        Image icon = new Image("file:src/main/images/nexus_logo_whitebg.png");
        stage.getIcons().add(icon);
        stage.setTitle("Task Manager App");
        showHomePage();

    }

    public void showHomePage(){
        HomePage homePage = new HomePage(this);
        Scene homePageScene = new Scene(homePage, 900, 700);
        primaryStage.setScene(homePageScene);
        primaryStage.show();

    }

    public void showTaskBoardPage(){
        TaskBoardPage taskBoardPage = new TaskBoardPage(this, new ArrayList<Task>());
        Scene taskBoardScene = new Scene(taskBoardPage, 900, 700);
        primaryStage.setScene(taskBoardScene);
        primaryStage.show();
    }

    public void showTaskBoardPage(ArrayList<Task> tasks){
        TaskBoardPage taskBoardPage = new TaskBoardPage(this, tasks);
        Scene taskBoardScene = new Scene(taskBoardPage, 900, 700);
        primaryStage.setScene(taskBoardScene);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }

}