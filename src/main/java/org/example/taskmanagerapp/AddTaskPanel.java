package org.example.taskmanagerapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

public class AddTaskPanel extends Stage {


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
        VBox taskNameInput = new VBox(10, taskNameLabel, taskNameField);

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
        VBox categoryInput = new VBox(10, categoryLabel, categoryButtons);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setStyle("-fx-font-size: 14");
        dueDateField.setPrefWidth(Double.MAX_VALUE);
        dueDateField.setValue(LocalDate.now());
        VBox dueDateInput = new VBox(10, dueDateLabel, dueDateField);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        ComboBox<String> priorityField = new ComboBox<>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefWidth(Double.MAX_VALUE);
        priorityField.setStyle("-fx-font-size: 14");
        priorityField.setValue("LOW");
        VBox priorityInput = new VBox(10, priorityLabel, priorityField);

        Label subjectLabel = new Label("Subject");
        subjectLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        TextField subjectField = new TextField();
        subjectField.setStyle("-fx-font-size: 14");
        VBox subjectInput = new VBox(10, subjectLabel, subjectField);
        subjectInput.setVisible(false);

        Label descriptionLabel = new Label("Work Description");
        descriptionLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-underline: true");
        TextArea descriptionArea = new TextArea();
        descriptionArea.setStyle("-fx-font-size: 14");
        VBox descriptionInput = new VBox(10, descriptionLabel, descriptionArea);
        descriptionInput.setVisible(false);

        StackPane additionalFields = new StackPane(subjectInput, descriptionInput);

        categoryGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        RadioButton selected = (RadioButton) newValue;
                        switch (selected.getText()){
                            case "General":
                                subjectInput.setVisible(false);
                                descriptionInput.setVisible(false);
                                break;
                            case "Study":
                                subjectInput.setVisible(true);
                                descriptionInput.setVisible(false);
                                subjectField.setText("");
                                break;
                            case "Work":
                                subjectInput.setVisible(false);
                                descriptionInput.setVisible(true);
                                descriptionArea.setText("");
                        }
                    }
                });

        VBox inputSection = new VBox(15, taskNameInput, categoryInput, dueDateInput, priorityInput, additionalFields);
        inputSection.setPadding(new Insets(10));

        Button addButton = new Button("Add Task", new ImageView(Icon.ADD.show()));
        addButton.setPadding(new Insets(10, 15, 10, 15));
        addButton.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-cursor: hand");
        addButton.setOnAction(e->{
            RadioButton selectedRadio = (RadioButton) categoryGroup.getSelectedToggle();

            String taskName = taskNameField.getText();
            String taskCategory = selectedRadio.getText();
            LocalDate dueDate = dueDateField.getValue();
            String priority = priorityField.getValue();
            String subject = subjectField.getText();
            String description = descriptionArea.getText();

            boolean isValid;

            if(Objects.equals(taskCategory, "Study")){
                isValid = TaskValidator.validateTask(taskName, taskCategory, dueDate, priority, subject);
            }else{
                isValid = TaskValidator.validateTask(taskName, taskCategory, dueDate,priority);
            }

            if(isValid){
                TaskBoardPage.taskListView.getItems().add(createTask(taskName, taskCategory, dueDate, priority, subject, description));
                TaskBoardPage.taskList.add(createTask(taskName, taskCategory, dueDate, priority, subject, description));
                this.close();
            }

        });
        VBox buttonSection = new VBox(addButton);
        buttonSection.setAlignment(Pos.CENTER);


        VBox root = new VBox(10, titleSection, inputSection, buttonSection);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: black");

        Scene scene = new Scene(root, 530, 600);

        this.setScene(scene);
        this.showAndWait();
    }

    private static Task createTask(String taskName, String category, LocalDate dueDate, String priority, String subject, String description){
        return switch (category) {
            case "General" -> new GeneralTask(taskName, category, dueDate, priority);
            case "Study" -> new StudyTask(taskName, category, dueDate, priority, subject);
            case "Work" -> new WorkTask(taskName, category, dueDate, priority, description);
            default -> new GeneralTask();
        };
    }

}
