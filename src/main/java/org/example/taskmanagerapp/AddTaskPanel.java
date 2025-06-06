package org.example.taskmanagerapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddTaskPanel extends Stage {

    Image addIcon = new Image("file:src/main/images/add.png");
    ImageView addIconView = new ImageView(addIcon);

    public AddTaskPanel(){
        super();
        this.setTitle("Add Task");

        Label addTaskLabel = new Label("Add New Task");
        addTaskLabel.setStyle("-fx-font-size: 26; -fx-text-fill: white");

        VBox titleSection = new VBox(addTaskLabel);


        Label taskNameLabel = new Label("Task Name");
        taskNameLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        TextField taskNameField = new TextField();
        taskNameField.setStyle("-fx-font-size: 14");
        VBox taskName = new VBox(10, taskNameLabel, taskNameField);

        Label categoryLabel = new Label("Task Category");
        categoryLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");

        ToggleGroup categoryGroup = new ToggleGroup();

        RadioButton generalTask = new RadioButton("General");
        generalTask.setStyle("-fx-text-fill: white; -fx-font-size: 14");
        generalTask.setToggleGroup(categoryGroup);
        generalTask.setSelected(true);
        RadioButton studyTask = new RadioButton("Study");
        studyTask.setStyle("-fx-text-fill:white; -fx-font-size: 14");
        studyTask.setToggleGroup(categoryGroup);
        RadioButton workTask = new RadioButton("Work");
        workTask.setStyle("-fx-text-fill:white; -fx-font-size: 14");
        workTask.setToggleGroup(categoryGroup);

        BorderPane categoryButtons = new BorderPane();
        categoryButtons.setLeft(generalTask);
        categoryButtons.setCenter(studyTask);
        categoryButtons.setRight(workTask);
        VBox category = new VBox(10, categoryLabel, categoryButtons);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setStyle("-fx-font-size: 14");
        dueDateField.setPrefWidth(Double.MAX_VALUE);
        VBox dueDate = new VBox(10, dueDateLabel, dueDateField);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        ComboBox<TaskPriority> priorityField = new ComboBox<>();
        priorityField.getItems().addAll(TaskPriority.values());
        priorityField.setPrefWidth(Double.MAX_VALUE);
        priorityField.setStyle("-fx-font-size: 14");
        VBox priority = new VBox(10, priorityLabel, priorityField);

        Label subjectLabel = new Label("Subject");
        subjectLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        TextField subjectField = new TextField();
        subjectField.setStyle("-fx-font-size: 14");
        VBox subject = new VBox(10, subjectLabel, subjectField);
        subject.setVisible(false);

        Label descriptionLabel = new Label("Work Description");
        descriptionLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        TextArea descriptionArea = new TextArea();
        descriptionArea.setStyle("-fx-font-size: 14");
        VBox description = new VBox(10, descriptionLabel, descriptionArea);
        description.setVisible(false);

        StackPane additionalFields = new StackPane(subject, description);

        categoryGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        RadioButton selected = (RadioButton) newValue;
                        switch (selected.getText()){
                            case "General":
                                subject.setVisible(false);
                                description.setVisible(false);
                                break;
                            case "Study":
                                subject.setVisible(true);
                                description.setVisible(false);
                                break;
                            case "Work":
                                subject.setVisible(false);
                                description.setVisible(true);
                        }
                    }
                });

        VBox inputSection = new VBox(15, taskName, category, dueDate, priority, additionalFields);
        inputSection.setPadding(new Insets(10));

        Button addButton = new Button("Add Task", new ImageView(Icon.ADD.show()));
        addButton.setPadding(new Insets(10, 15, 10, 15));
        addButton.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-cursor: hand");
        addButton.setOnAction(e->{
            this.close();
        });
        VBox buttonSection = new VBox(addButton);
        buttonSection.setAlignment(Pos.CENTER);


        VBox root = new VBox(10, titleSection, inputSection, buttonSection);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: black");

        Scene scene = new Scene(root, 530, 600);

        this.setScene(scene);
        this.show();
    }

}
