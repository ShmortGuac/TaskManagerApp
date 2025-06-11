package org.example.taskmanagerapp;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class StudyTask extends Task{

    private String subject;

    public StudyTask(){
        super();
        subject = "General Studies";
    }

    public StudyTask(String taskName, String category, LocalDate dueDate, String priority, String subject){
        super(taskName, category, dueDate, priority);
        this.subject = subject;
    }

    public StudyTask(String taskName, String category, LocalDate dueDate, String priority, String subject, boolean completed){
        super(taskName, category, dueDate, priority, completed);
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    public VBox displayProperties(){
       return new TaskDetails(this);
    }


}

