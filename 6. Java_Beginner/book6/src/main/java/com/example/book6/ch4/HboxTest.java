package com.example.book6.ch4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class HboxTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");

//        One way to create a HBox
//        Pane
//        HBox hbox = new HBox(10, btn1, btn2, btn3);

//        Another way
//        HBox hbox = new HBox(10);
//        hbox.getChildren().addAll(btn1, btn2, btn3);

//        Third way
//        HBox hbox = new HBox();
//        hbox.setSpacing(10);
//        hbox.getChildren().addAll(btn1, btn2, btn3);

//        Spacer
        Region spacer = new Region();

//        Setting Padding and Margins
        HBox hbox = new HBox(10, btn1,btn2, spacer,btn3);
        hbox.setMargin(btn1, new Insets(10));
        hbox.setMargin(btn2, new Insets(10));
        hbox.setMargin(btn3, new Insets(10));

        //      Set the Hgrow for the spacer
        hbox.setHgrow(spacer, Priority.ALWAYS);

//        hbox.setSpacing(10);
//        hbox.setPadding(new Insets(20));
//        hbox.setPadding(new Insets(20, 10,20,15));
//        hbox.getChildren().addAll(btn1, btn2, btn3);

//        Scene
        Scene scene = new Scene(hbox, 250, 250);


//        Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("HBox Test");
        primaryStage.show();
    }
}
