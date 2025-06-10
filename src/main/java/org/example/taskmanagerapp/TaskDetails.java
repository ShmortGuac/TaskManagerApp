package org.example.taskmanagerapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.Optional;

public class TaskDetails extends VBox {

    public TaskDetails(){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setEditable(false);
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black; -fx-border-color: white");
        taskName.setPrefHeight(50);
        taskName.setAlignment(Pos.CENTER);

        VBox taskAttributes = new VBox();
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);

        Button editTask = new Button("Edit Task", new ImageView(Icon.EDIT.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);

        editTask.setOnMouseEntered(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #0066FF; -fx-background-radius:10; -fx-cursor: hand;");
        });
        editTask.setOnMouseExited(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand;");
        });

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.DELETE.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);
        deleteTask.setOnAction(e-> deleteTask());

        deleteTask.setOnMouseEntered(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #FF6666; -fx-background-radius:10; -fx-cursor: hand;");
        });
        deleteTask.setOnMouseExited(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand;");
        });

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskName, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");
    }

    public TaskDetails(GeneralTask task){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: black;");
        taskName.setPrefHeight(30);
        taskName.setAlignment(Pos.CENTER);
        taskName.setText(task.getTaskName());

        HBox taskNameBox = new HBox(taskName, new ImageView(Icon.EDIT.show()));

        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefHeight(35);
        categoryField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(categoryField, Priority.ALWAYS);
        categoryField.setEditable(false);
        categoryField.setText(task.getCategory());
        categoryField.setStyle("-fx-background-radius: 0");
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER_LEFT);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setPrefHeight(35);
        dueDateField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(dueDateField, Priority.ALWAYS);
        dueDateField.setStyle("-fx-background-radius: 0");
        dueDateField.setValue(task.getDueDate());
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER_LEFT);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        ComboBox<String> priorityField = new ComboBox<>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefHeight(35);
        priorityField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(priorityField, Priority.ALWAYS);
        priorityField.setStyle("-fx-background-radius: 0");
        priorityField.setValue(task.getPriority());
        HBox priority = new HBox(10, priorityLabel, priorityField);
        priority.setAlignment(Pos.CENTER_LEFT);

        Label statusLabel = new Label("Completed");
        statusLabel.setPrefWidth(140);
        statusLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        CheckBox statusBox = new CheckBox();
        statusBox.setScaleX(1.2);
        statusBox.setScaleY(1.2);
        statusBox.setSelected(task.isCompleted());
        statusBox.setOnAction(e-> {
            task.setCompleted(!task.isCompleted());
            TaskBoardPage.taskListView.getSelectionModel().clearSelection();
        });
        HBox status = new HBox(10, statusLabel,statusBox);
        status.setAlignment(Pos.CENTER_LEFT);

        VBox taskAttributes = new VBox(20, category, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        Button editTask = new Button("Edit Task", new ImageView(Icon.EDIT.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);

        editTask.setOnMouseEntered(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #0066FF; -fx-background-radius:10; -fx-cursor: hand;");
        });
        editTask.setOnMouseExited(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand;");
        });
        editTask.setOnAction(e-> {
            enableEditMode(taskName, categoryField, dueDateField, priorityField, task);
        });

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.DELETE.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);

        deleteTask.setOnMouseEntered(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #FF6666; -fx-background-radius:10; -fx-cursor: hand;");
        });
        deleteTask.setOnMouseExited(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand;");
        });
        deleteTask.setOnAction(e-> deleteTask());

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskNameBox, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");
    }

    public TaskDetails(StudyTask task){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black; -fx-border-color: white");
        taskName.setPrefHeight(30);
        taskName.setAlignment(Pos.CENTER);
        taskName.setText(task.getTaskName());

        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefHeight(35);
        categoryField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(categoryField, Priority.ALWAYS);
        categoryField.setEditable(false);
        categoryField.setText(task.getCategory());
        categoryField.setStyle("-fx-background-radius: 0");
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER_LEFT);

        Label subjectLabel = new Label("Subject");
        subjectLabel.setPrefWidth(140);
        subjectLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField subjectField = new TextField();
        subjectField.setPrefHeight(35);
        subjectField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(subjectField, Priority.ALWAYS);
        subjectField.setText(task.getSubject());
        subjectField.setStyle("-fx-background-radius: 0");
        HBox subject = new HBox(10, subjectLabel, subjectField);
        subject.setAlignment(Pos.CENTER_LEFT);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setPrefHeight(35);
        dueDateField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(dueDateField, Priority.ALWAYS);
        dueDateField.setStyle("-fx-background-radius: 0");
        dueDateField.setValue(task.getDueDate());
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER_LEFT);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        ComboBox<String> priorityField = new ComboBox<>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefHeight(35);
        priorityField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(priorityField, Priority.ALWAYS);
        priorityField.setStyle("-fx-background-radius: 0");
        priorityField.setValue(task.getPriority());
        HBox priority = new HBox(10, priorityLabel, priorityField);
        priority.setAlignment(Pos.CENTER_LEFT);

        Label statusLabel = new Label("Completed");
        statusLabel.setPrefWidth(140);
        statusLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        CheckBox statusBox = new CheckBox();
        statusBox.setScaleX(1.2);
        statusBox.setScaleY(1.2);
        statusBox.setSelected(task.isCompleted());
        statusBox.setOnAction(e-> {
            task.setCompleted(!task.isCompleted());
            TaskBoardPage.taskListView.getSelectionModel().clearSelection();
        });
        HBox status = new HBox(10, statusLabel,statusBox);
        status.setAlignment(Pos.CENTER_LEFT);

        VBox taskAttributes = new VBox(20, category, subject, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        Button editTask = new Button("Edit Task", new ImageView(Icon.DELETE.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);

        editTask.setOnMouseEntered(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #0066FF; -fx-background-radius:10; -fx-cursor: hand;");
        });
        editTask.setOnMouseExited(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand;");
        });
        editTask.setOnAction(e->{
            enableEditModeStudy(taskName, categoryField, subjectField, dueDateField, priorityField, task);
        });

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.DELETE.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);

        deleteTask.setOnMouseEntered(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #FF6666; -fx-background-radius:10; -fx-cursor: hand;");
        });
        deleteTask.setOnMouseExited(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand;");
        });
        deleteTask.setOnAction(e-> deleteTask());

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskName, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");
    }

    public TaskDetails(WorkTask task){
        super();

        TextField taskName = new TextField("Task Name");
        taskName.setStyle("-fx-font-size: 20; -fx-text-fill: white; -fx-background-color: black; -fx-border-color: white");
        taskName.setPrefHeight(30);
        taskName.setAlignment(Pos.CENTER);
        taskName.setText(task.getTaskName());

        Label categoryLabel = new Label("Category");
        categoryLabel.setPrefWidth(140);
        categoryLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextField categoryField = new TextField();
        categoryField.setPrefHeight(35);
        categoryField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(categoryField, Priority.ALWAYS);
        categoryField.setEditable(false);
        categoryField.setText(task.getCategory());
        categoryField.setStyle("-fx-background-radius: 0");
        HBox category = new HBox(10, categoryLabel, categoryField);
        category.setAlignment(Pos.CENTER_LEFT);

        Label descriptionLabel = new Label("Description");
        descriptionLabel.setMinWidth(140);
        descriptionLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        TextArea descriptionArea = new TextArea();
        descriptionArea.setPrefHeight(80);
        descriptionArea.setText(task.getDescription());
        descriptionArea.setWrapText(true);
        descriptionArea.setStyle("-fx-background-radius: 0");
        HBox description = new HBox(10, descriptionLabel, descriptionArea);
        description.setAlignment(Pos.CENTER_LEFT);

        Label dueDateLabel = new Label("Due Date");
        dueDateLabel.setPrefWidth(140);
        dueDateLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        DatePicker dueDateField = new DatePicker();
        dueDateField.setPrefHeight(35);
        dueDateField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(dueDateField, Priority.ALWAYS);
        dueDateField.setStyle("-fx-background-radius: 0");
        dueDateField.setValue(task.getDueDate());
        HBox dueDate = new HBox(10, dueDateLabel, dueDateField);
        dueDate.setAlignment(Pos.CENTER_LEFT);

        Label priorityLabel = new Label("Priority");
        priorityLabel.setPrefWidth(140);
        priorityLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        ComboBox<String> priorityField = new ComboBox<>();
        priorityField.getItems().addAll("LOW", "MEDIUM", "HIGH");
        priorityField.setPrefHeight(35);
        priorityField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(priorityField, Priority.ALWAYS);
        priorityField.setStyle("-fx-background-radius: 0");
        priorityField.setValue(task.getPriority());
        HBox priority = new HBox(10, priorityLabel, priorityField);
        priority.setAlignment(Pos.CENTER_LEFT);

        Label statusLabel = new Label("Completed");
        statusLabel.setPrefWidth(140);
        statusLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        CheckBox statusBox = new CheckBox();
        statusBox.setScaleX(1.2);
        statusBox.setScaleY(1.2);
        statusBox.setSelected(task.isCompleted());
        statusBox.setOnAction(e-> {
            task.setCompleted(!task.isCompleted());
            TaskBoardPage.taskListView.getSelectionModel().clearSelection();
        });
        HBox status = new HBox(10, statusLabel,statusBox);
        status.setAlignment(Pos.CENTER_LEFT);

        VBox taskAttributes = new VBox(20, category, description, dueDate, priority, status);
        VBox.setVgrow(taskAttributes, Priority.ALWAYS);
        taskAttributes.setAlignment(Pos.CENTER_LEFT);
        taskAttributes.setMaxHeight(Double.MAX_VALUE);

        Button editTask = new Button("Edit Task", new ImageView(Icon.EDIT.show()));
        editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(editTask, Priority.ALWAYS);
        editTask.setMaxWidth(Double.MAX_VALUE);
        editTask.setPrefHeight(45);
        editTask.setGraphicTextGap(10);

        editTask.setOnMouseEntered(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #0066FF; -fx-background-radius:10; -fx-cursor: hand;");
        });
        editTask.setOnMouseExited(e -> {
            editTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: blue; -fx-background-radius:10; -fx-cursor: hand;");
        });
        editTask.setOnAction(e->{
            enableEditModeWork(taskName, categoryField, descriptionArea, dueDateField, priorityField, task);
        });

        Button deleteTask = new Button("Delete Task", new ImageView(Icon.EDIT.show()));
        deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand");
        HBox.setHgrow(deleteTask, Priority.ALWAYS);
        deleteTask.setMaxWidth(Double.MAX_VALUE);
        deleteTask.setPrefHeight(45);
        deleteTask.setGraphicTextGap(10);

        deleteTask.setOnMouseEntered(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: #FF6666; -fx-background-radius:10; -fx-cursor: hand;");
        });
        deleteTask.setOnMouseExited(e -> {
            deleteTask.setStyle("-fx-font-size: 16; -fx-text-fill: white; -fx-background-color: red; -fx-background-radius:10; -fx-cursor: hand;");
        });
        deleteTask.setOnAction(e-> deleteTask());

        HBox taskButtons = new HBox(10, editTask, deleteTask);

        this.getChildren().addAll(taskName, taskAttributes, taskButtons);
        this.setPadding(new Insets(10));
        VBox.setVgrow(this, Priority.ALWAYS);
        this.setStyle("-fx-border-color: white; -fx-border-width: 3;");
    }

    private void enableEditMode(TextField taskName, TextField categoryField, DatePicker dueDateField, ComboBox<String> priorityField, GeneralTask task) {
        boolean isChanged = false;

        if (!taskName.getText().equals(task.getTaskName())) {
            task.setTaskName(taskName.getText());
            isChanged = true;
        }
        if (!dueDateField.getValue().equals(task.getDueDate())) {
            task.setDueDate(dueDateField.getValue());
            isChanged = true;
        }
        if (!priorityField.getValue().equals(task.getPriority())) {
            task.setPriority(priorityField.getValue());
            isChanged = true;
        }
        if (isChanged) {
            showSaveDialog(taskName, categoryField, dueDateField, priorityField, task);
        }
    }

    private void enableEditModeStudy(TextField taskName, TextField categoryField, TextField subjectField, DatePicker dueDateField, ComboBox<String> priorityField, StudyTask task) {
        boolean isChanged = false;

        if (!taskName.getText().equals(task.getTaskName())) {
            task.setTaskName(taskName.getText());
            isChanged = true;
        }
        if(!subjectField.getText().equals(task.getSubject())){
            task.setSubject(subjectField.getText());
            isChanged = true;
        }
        if (!dueDateField.getValue().equals(task.getDueDate())) {
            task.setDueDate(dueDateField.getValue());
            isChanged = true;
        }
        if (!priorityField.getValue().equals(task.getPriority())) {
            task.setPriority(priorityField.getValue());
            isChanged = true;
        }
        if (isChanged) {
            showSaveDialogStudy(taskName, categoryField, subjectField, dueDateField, priorityField, task);
        }
    }

    private void enableEditModeWork(TextField taskName, TextField categoryField, TextArea descriptionArea, DatePicker dueDateField, ComboBox<String> priorityField, WorkTask task) {
        boolean isChanged = false;

        if (!taskName.getText().equals(task.getTaskName())) {
            task.setTaskName(taskName.getText());
            isChanged = true;
        }
        if (!descriptionArea.getText().equals(task.getDescription())){
            task.setDescription(descriptionArea.getText());
            isChanged = true;
        }
        if (!dueDateField.getValue().equals(task.getDueDate())) {
            task.setDueDate(dueDateField.getValue());
            isChanged = true;
        }
        if (!priorityField.getValue().equals(task.getPriority())) {
            task.setPriority(priorityField.getValue());
            isChanged = true;
        }
        if (isChanged) {
            showSaveDialogWork(taskName, categoryField, descriptionArea, dueDateField, priorityField, task);
        }
    }

    private void showSaveDialog(TextField taskName, TextField categoryField, DatePicker dueDateField, ComboBox<String> priorityField, GeneralTask task) {
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Save Changes");
        confirmDialog.setHeaderText("Do you want to save your changes?");
        confirmDialog.setContentText("Click OK to save the changes or Cancel to discard them.");

        ButtonType saveButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirmDialog.getButtonTypes().setAll(saveButton, cancelButton);

        Optional<ButtonType> result = confirmDialog.showAndWait();
        if (result.isPresent() && result.get() == saveButton) {
            // Only validate when user clicks Save
            editTask(task, taskName.getText(), categoryField.getText(), dueDateField.getValue(), priorityField.getValue());
        }

        categoryField.setEditable(false);
        dueDateField.setDisable(true);
        priorityField.setDisable(true);
        TaskBoardPage.taskListView.getSelectionModel().clearSelection();
    }

    private void showSaveDialogStudy(TextField taskName, TextField categoryField, TextField subjectField, DatePicker dueDateField, ComboBox<String> priorityField, StudyTask task) {
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Save Changes");
        confirmDialog.setHeaderText("Do you want to save your changes?");
        confirmDialog.setContentText("Click OK to save the changes or Cancel to discard them.");

        ButtonType saveButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirmDialog.getButtonTypes().setAll(saveButton, cancelButton);

        Optional<ButtonType> result = confirmDialog.showAndWait();
        if (result.isPresent() && result.get() == saveButton) {
            // Only validate when user clicks Save
            editTask(task, taskName.getText(), categoryField.getText(), dueDateField.getValue(), priorityField.getValue(), subjectField.getText());
        }

        categoryField.setEditable(false);
        subjectField.setEditable(false);
        dueDateField.setDisable(true);
        priorityField.setDisable(true);
        TaskBoardPage.taskListView.getSelectionModel().clearSelection();
    }

    private void showSaveDialogWork(TextField taskName, TextField categoryField, TextArea descriptionArea, DatePicker dueDateField, ComboBox<String> priorityField, WorkTask task) {
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Save Changes");
        confirmDialog.setHeaderText("Do you want to save your changes?");
        confirmDialog.setContentText("Click OK to save the changes or Cancel to discard them.");

        ButtonType saveButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        confirmDialog.getButtonTypes().setAll(saveButton, cancelButton);

        Optional<ButtonType> result = confirmDialog.showAndWait();
        if (result.isPresent() && result.get() == saveButton) {
            // Only validate when user clicks Save
            editTask(task, taskName.getText(), categoryField.getText(), dueDateField.getValue(), priorityField.getValue(), descriptionArea.getText());
        }

        categoryField.setEditable(false);
        descriptionArea.setEditable(false);
        dueDateField.setDisable(true);
        priorityField.setDisable(true);
        TaskBoardPage.taskListView.getSelectionModel().clearSelection();
    }

    private static void deleteTask(){
        Task selectedTask = TaskBoardPage.taskListView.getSelectionModel().getSelectedItem();
        int selectedIdx = TaskBoardPage.taskListView.getSelectionModel().getSelectedIndex();
        if(selectedIdx != -1 && selectedTask != null){

            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Delete Task");
            confirmationAlert.setHeaderText("Are you sure you want to delete this task?");
            confirmationAlert.setContentText("Task: " + selectedTask.getTaskName() + "\n" +
                    "Category: " + selectedTask.getCategory() + "\n" +
                    "This action cannot be undone.");

            ButtonType deleteButton = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirmationAlert.getButtonTypes().setAll(deleteButton, cancelButton);

            confirmationAlert.getDialogPane().lookupButton(deleteButton).setStyle(
                    "-fx-background-color: #d32f2f; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand"
            );
            confirmationAlert.getDialogPane().lookupButton(cancelButton).setStyle(
                    "-fx-background-color: #424242; -fx-text-fill: white; -fx-cursor: hand"
            );

            Optional<ButtonType> result = confirmationAlert.showAndWait();

            if (result.isPresent() && result.get() == deleteButton) {
                TaskBoardPage.taskList.remove(selectedTask);
                TaskBoardPage.taskListView.getItems().remove(selectedIdx);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Task Deleted");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Task \"" + selectedTask.getTaskName() + "\" has been deleted successfully.");
                successAlert.showAndWait();
            }
        }
    }

    private static void editTask(GeneralTask task, String taskName, String category, LocalDate dueDate, String priority){
        if(task != null){
            if(TaskValidator.validateTask(taskName, category, dueDate, priority)){
                task.setTaskName(taskName);
                task.setCategory(category);
                task.setDueDate(dueDate);
                task.setPriority(priority);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Task Updated");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Task has been updated successfully!");
                successAlert.showAndWait();
            }
        }
    }

    private static void editTask(StudyTask task, String taskName, String category, LocalDate dueDate, String priority, String subject){
        if(task != null){
            if(TaskValidator.validateTask(taskName, category, dueDate, priority, subject)){
                task.setTaskName(taskName);
                task.setCategory(category);
                task.setDueDate(dueDate);
                task.setPriority(priority);
                task.setSubject(subject);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Task Updated");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Study task has been updated successfully!");
                successAlert.showAndWait();
            }
        }
    }

    private static void editTask(WorkTask task, String taskName, String category, LocalDate dueDate, String priority, String description){
        if(task != null){
            if(TaskValidator.validateTask(taskName, category, dueDate, priority)){
                task.setTaskName(taskName);
                task.setCategory(category);
                task.setDueDate(dueDate);
                task.setPriority(priority);
                task.setDescription(description);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Task Updated");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Work task has been updated successfully!");
                successAlert.showAndWait();
            }
        }
    }
}