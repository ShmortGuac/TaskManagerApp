package org.example.taskmanagerapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private ArrayList<Task> taskArrayList = new ArrayList<>();

    public FileHandler(){

    }

    public FileHandler(File filePath){
        try(Scanner fileReader = new Scanner(filePath)){
            while(fileReader.hasNextLine()){
                String task = fileReader.nextLine();
                String[] taskData = task.split(",");
                String taskName = taskData[1];
                String category = taskData[2];
                String dueDate = taskData[3];
                String priority = taskData[4];
                String subject = taskData[5];
                String description = taskData[6];
                String completed = taskData[7];

                switch(taskData[0].toLowerCase()){
                    case "general":
                        taskArrayList.add(new GeneralTask(taskName, category, LocalDate.parse(dueDate), priority, Boolean.parseBoolean(completed)));
                        break;
                    case "study":
                        taskArrayList.add(new StudyTask(taskName, category, LocalDate.parse(dueDate), priority, subject, Boolean.parseBoolean(completed)));
                        break;
                    case "work":
                        taskArrayList.add(new WorkTask(taskName, category, LocalDate.parse(dueDate), priority, description, Boolean.parseBoolean(completed)));
                        break;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }

    public void saveBoard(File saveFile, ArrayList<Task> savedTasks){
        if(saveFile != null){
            try(FileWriter writer = new FileWriter(saveFile, true)){
                for(Task task : savedTasks){
                    String taskType = task.getType();
                    String taskName = task.getTaskName();
                    String category = task.getCategory();
                    String dueDate = task.getDueDate().format(DateTimeFormatter.ISO_DATE);
                    String priority = task.getPriority();
                    String subject = "None";
                    String description = "None";
                    String completed = String.valueOf(task.isCompleted());

                    switch (taskType.toLowerCase()) {
                        case "study":
                            subject = ((StudyTask) task).getSubject();
                            break;
                        case "work":
                            description = ((WorkTask) task).getDescription();
                    }
                    writer.write(taskType + "," +taskName + "," + category + "," + dueDate + "," + priority + "," + subject + "," + description + "," + completed + ";");

                }
            } catch (IOException e) {
                System.out.println("Error in saving file");
            }
        }
    }

    public ArrayList<Task> getLoadedTask(){
        return taskArrayList;
    }

}
