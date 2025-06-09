package org.example.taskmanagerapp;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

public class HomePage extends VBox {

    // public Button so that the main app can manage on action events such as changing the page
    public Button newTaskBoard;
    public Button loadTaskBoard;
    public Button exit;

    private int buttonHeight = 50;
    private int buttonWidth = 343;

    public HomePage(TaskManagerApp app) {

        Image nexusLogo = new Image("file:src/main/images/Nexus.png");
        ImageView imageView = new ImageView(nexusLogo);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);

        Label appTitle = new Label("Nexus Task Manager App");

        newTaskBoard = new Button("New Task Board");
        loadTaskBoard = new Button("Load Task Board");
        exit = new Button("Exit");

        newTaskBoard.setPrefHeight(buttonHeight);
        newTaskBoard.setPrefWidth(buttonWidth);
        newTaskBoard.setOnAction(e->{
            app.showTaskBoardPage();
        });
        newTaskBoard.setOnMouseEntered(e->{
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), newTaskBoard);
            st.setFromX(1);
            st.setToX(1.05);
            st.setFromY(1);
            st.setToY(1.05);
            st.setInterpolator(Interpolator.EASE_OUT);
            st.play();
        });
        newTaskBoard.setOnMouseExited(e->{
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), newTaskBoard);
            st.setFromX(1.05);
            st.setToX(1);
            st.setFromY(1.05);
            st.setToY(1);
            st.setInterpolator(Interpolator.EASE_OUT);
            st.play();
        });


        loadTaskBoard.setPrefHeight(buttonHeight);
        loadTaskBoard.setPrefWidth(buttonWidth);
        loadTaskBoard.setOnMouseEntered(e->{
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), loadTaskBoard);
            st.setFromX(1);
            st.setToX(1.05);
            st.setFromY(1);
            st.setToY(1.05);
            st.setInterpolator(Interpolator.EASE_OUT);
            st.play();
        });
        loadTaskBoard.setOnMouseExited(e->{
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), loadTaskBoard);
            st.setFromX(1.05);
            st.setToX(1);
            st.setFromY(1.05);
            st.setToY(1);
            st.setInterpolator(Interpolator.EASE_OUT);
            st.play();
        });
        loadTaskBoard.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            fileChooser.setInitialDirectory(new File("src/main/savedBoards"));
            File selectedFile = fileChooser.showOpenDialog(app.getPrimaryStage());

            FileHandler fileHandler = new FileHandler(selectedFile);
            app.showTaskBoardPage(fileHandler.getLoadedTask());
        });



        exit.setPrefHeight(buttonHeight);
        exit.setPrefWidth(buttonWidth);
        exit.setOnMouseEntered(e->{
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), exit);
            st.setFromX(1);
            st.setToX(1.05);
            st.setFromY(1);
            st.setToY(1.05);
            st.setInterpolator(Interpolator.EASE_OUT);
            st.play();
        });
        exit.setOnMouseExited(e->{
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), exit);
            st.setFromX(1.05);
            st.setToX(1);
            st.setFromY(1.05);
            st.setToY(1);
            st.setInterpolator(Interpolator.EASE_OUT);
            st.play();
        });





        //HomePage constructors are put here
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(imageView, appTitle, newTaskBoard, loadTaskBoard, exit);

        //CSS styling

        String buttonClass = "-fx-font-size: 15; -fx-background-radius: 15; -fx-cursor: hand; -fx-focus-color: transparent; -fx-faint-focus-color: transparent;";

        this.setStyle("-fx-background-color: black");
        appTitle.setStyle("-fx-font-size: 20; -fx-text-fill: white;");
        newTaskBoard.setStyle(buttonClass);
        loadTaskBoard.setStyle(buttonClass);
        exit.setStyle(buttonClass);
    }
}
