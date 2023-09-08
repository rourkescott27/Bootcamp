package com.example.book6.ch1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickCounter extends Application
{

    Button btn;
    Label lbl;
    int iClickCount = 0;

    public static void main(String[] args)
    {
        System.out.println("How many times can you click the button in 10 seconds");
        launch(args);
        System.out.println("That was a valiant effort, well done !");
    }

    @Override
    public void start(Stage primaryStage)
    {
//        CREATE THE BUTTON
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

//        CREATE THE LABEL
        lbl = new Label();
        lbl.setText("You have not clicked the button.");

//        ADD THE LABEL AND THE BUTTON TO A LAYOUT PANE
        BorderPane pane = new BorderPane();
        pane.setTop(lbl);
        pane.setCenter(btn);

//        ADD THE LAYOUT PANE TO A SCENE
        Scene scene = new Scene(pane, 250, 300);

//        ADD THE SCENE TO THE STAGE, SET THE TITLE AND SHOW THE STAGE
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter");
        primaryStage.show();
    }

    public void buttonClick()
    {
        iClickCount++;
        if (iClickCount == 1)
        {
            lbl.setText("You have clicked once.");
        }else {
            lbl.setText("You have clicked " + iClickCount + " times.");
        }
    }
}
