package com.example.book6.ch2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddSubtract5 extends Application
{

    Button btnAdd;
    Button btnSubtract;
    Label lbl;
    int iCounter = 0;


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

//        CREATE THE ADD BUTTON
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(e -> btnAdd_Click());

//        CREATE THE SUBTRACT BUTTON
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(e -> btnSubtract_Click());

//        CREATE THE LABEL
        lbl = new Label();
        lbl.setText(Integer.toString(iCounter));

//        ADD THE BUTTONS AND LABEL TO N HBOX PANE
        HBox pane = new HBox(10);
        pane.getChildren().addAll(lbl, btnAdd, btnSubtract);

//        ADD THE LAYOUT PANE TO A SCENE
        Scene scene = new Scene(pane, 200, 75);

//        ADD THE SCENE TO THE STAGE, SET THE TITLE AND SHOW THE STAGE
        primaryStage.setScene(scene);
        primaryStage.setTitle("ADD/SUB");
        primaryStage.show();
    }

    private void btnAdd_Click()
    {
        iCounter++;
        lbl.setText(Integer.toString(iCounter));
    }

    private void btnSubtract_Click()
    {
        iCounter--;
        lbl.setText(Integer.toString(iCounter));
    }

}
