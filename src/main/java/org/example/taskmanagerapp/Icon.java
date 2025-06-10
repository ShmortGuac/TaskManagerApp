package org.example.taskmanagerapp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum Icon {
    ADD("file:src/main/images/add.png"),
    EDIT("file:src/main/images/Edit.png"),
    FILTER("file:src/main/images/filter.png"),
    SAVE("file:src/main/images/Save.png"),
    DELETE("file:src/main/images/Trash.png"),
    BACK("file:src/main/images/arrow_back.png"),
    CONFIRM("file:src/main/images/Check.png");

    private Image image;

    Icon(String imageSrc){
        this.image = new Image(imageSrc);
    }

    public Image show(){
        return image;
    }
}
