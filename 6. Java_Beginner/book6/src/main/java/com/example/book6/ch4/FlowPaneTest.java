package com.example.book6.ch4;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button btn1 = new Button("Button one");
        Button btn2 = new Button("Button two");
        Button btn3 = new Button("Button three");
        Button btn4 = new Button("Button four");
        Button btn5 = new Button("Button five");

        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 10, 10, btn1, btn2, btn3, btn4, btn5);
        pane.setPrefWrapLength(300);

        Scene scene = new Scene(pane, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Flow Pane Test");
        primaryStage.show();


    }
}
