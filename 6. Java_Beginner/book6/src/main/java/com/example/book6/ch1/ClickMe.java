package com.example.book6.ch1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickMe extends Application
{
    Button btn;

    public static void main(String[] args)
    {
        System.out.println("Launching JavaFX");
        launch(args);
        System.out.println("Closed JavaFX");
    }

    @Override
    public void start(Stage primaryStage)
    {
//      CREATING THE BUTTON
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

//      ADD THE BUTTON TO A LAYOUT PANE
        BorderPane pane = new BorderPane();
        pane.setCenter(btn);

//      ADD THE LAYOUT PANE TO A SCENE
        Scene scene = new Scene(pane, 300, 250);

//      FINALISE AND SHOW THE STAGE
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Click Me App");
        primaryStage.show();
    }

    public void buttonClick()
    {
        if (btn.getText() == "Click me please!")
        {
            btn.setText("You clicked me!");
        } else {
            btn.setText("Click me please!");
        }
    }
}
