package com.example.book6.ch4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VboxTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
//        Button btn1 = new Button("Button 1");
//        Button btn2 = new Button("Button 2");
//        Button btn3 = new Button("Button 3");

        Button btn1 = new Button("Number One");
        Button btn2 = new Button("Two");
        Button btn3 = new Button("The Third Button");

        System.out.println(Double.MAX_VALUE);

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);

//        VBox vbox = new VBox(10, btn1, btn2, btn3);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(btn1, btn2, btn3);
        Scene scene = new Scene(vbox, 750, 750);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);

        primaryStage.setScene(scene);
        primaryStage.setTitle("VBox Test");
        primaryStage.show();
    }
}
