package com.example.book6.ch4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button btn1 = new Button("Button One");
        Button btn2 = new Button("Button Two");
        Button btn3 = new Button("Button Three");
        Button btn4 = new Button("Button Four");
        Button btn5 = new Button("Button Five");
        Button btn6 = new Button("Button Six");
        Button btn7 = new Button("Button Seven");
        Button btn8 = new Button("Button Eight");
        Button btn9 = new Button("Button Nine");
        Button btn10 = new Button("Button Ten");

        VBox vbox1 = new VBox(btn1, btn2);
        VBox vbox2 = new VBox(btn3, btn4);
        VBox vbox3 = new VBox(btn5, btn6);
        VBox vbox4 = new VBox(btn7, btn8);
        VBox vbox5 = new VBox(btn9, btn10);


        BorderPane bPane = new BorderPane(vbox1, vbox2, vbox3, vbox4, vbox5);
        vbox1.setAlignment(Pos.CENTER);
        vbox2.setAlignment(Pos.CENTER);
        vbox3.setAlignment(Pos.CENTER);
        vbox4.setAlignment(Pos.CENTER);
        vbox5.setAlignment(Pos.CENTER);
//        bPane.setCenter(vbox);

        Scene scene = new Scene(bPane, 200, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Border Pane Test");
        primaryStage.show();
    }
}
