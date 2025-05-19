module org.example.taskmanagerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.taskmanagerapp to javafx.fxml;
    exports org.example.taskmanagerapp;
}