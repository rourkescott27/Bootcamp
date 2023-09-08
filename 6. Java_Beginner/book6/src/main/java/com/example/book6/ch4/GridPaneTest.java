package com.example.book6.ch4;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button btn1 = new Button("Click for no reason");
        Button btn2 = new Button("This one doesn't do anything either");
        Button btn3 = new Button("Nothing happening here");

        TextField txt1 = new TextField("Put anything in here!");
        TextField txt2 = new TextField("HELLO");
        TextField txt3 = new TextField("FUN");

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);

        Label lbl1 = new Label("Name");
        Label lbl2 = new Label("WOW");
        Label lbl3 = new Label("LOREM IPSUM");

        GridPane grid = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints(200);
        ColumnConstraints col2 = new ColumnConstraints(200);
        ColumnConstraints col3 = new ColumnConstraints(200);
        ColumnConstraints col4 = new ColumnConstraints(200);

        col1.setPercentWidth(33);
        col2.setPercentWidth(33);
        col3.setPercentWidth(33);

        grid.getColumnConstraints().addAll(col1, col2, col3, col4);

//        grid.add(lbl1, 0, 0,1,1);
//        grid.add(lbl2, 1,0,1,1);
//        grid.add(lbl3, 2,0,1,1);
//
//        grid.add(btn1, 0,1,1,1);
//        grid.add(btn2, 1,1,1,1);
//        grid.add(btn3, 2,1,1,1);

        grid.add(txt1, 0,0,1,1);
        grid.add(txt2, 1,0,1,1);
        grid.add(txt3, 2,0,1,1);

        grid.setHgap(10);
        grid.setVgap(10);

        Scene scene = new Scene(grid,750,750);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Grid Pane Test");
        primaryStage.show();


    }
}
