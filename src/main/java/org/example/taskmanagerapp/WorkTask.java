package org.example.taskmanagerapp;

import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class WorkTask extends Task{

    private String description;

    public WorkTask(){
        super();
        description = "General Studies";
    }

    public WorkTask(String taskName, String category, LocalDate dueDate, String priority, String description){
        super(taskName, category, dueDate, priority);
        this.description = description;
    }

    public WorkTask(String taskName, String category, LocalDate dueDate, String priority, String description, boolean completed){
        super(taskName, category, dueDate, priority, completed);
        this.description = description;
    }

    public String getDescription(){
        return description;
    }


    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public VBox displayProperties(){
        return new TaskDetails(this);
    }

}
