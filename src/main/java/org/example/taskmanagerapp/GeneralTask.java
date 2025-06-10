package org.example.taskmanagerapp;

import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class GeneralTask extends Task {

    public GeneralTask(){
        super();
    }

    public GeneralTask(String taskName, String category, LocalDate dueDate, String priority){
        super(taskName, category, dueDate, priority);
    }

    public GeneralTask(String taskName, String category, LocalDate dueDate, String priority, boolean completed){
        super(taskName, category, dueDate, priority, completed);
    }

    @Override
    public VBox displayProperties(){
        return new TaskDetails(this);
    }
}