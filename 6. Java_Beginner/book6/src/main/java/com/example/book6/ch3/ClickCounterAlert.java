package com.example.book6.ch3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Optional;

public class ClickCounterAlert extends Application
{
    Button btn;
    Label lbl;
    int iClickCount = 0;

    //    Added
    Stage stage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
//        Added
        stage = primaryStage;

        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

        Button btnClose = new Button();
        btnClose.setText("Close");
        btnClose.setOnAction(e -> btnClose_Clicked());


        BorderPane pane = new BorderPane();
        pane.setTop(lbl);
        pane.setCenter(btn);
//        Close button exit confirmation
        pane.setBottom(btnClose);

        Scene scene = new Scene(pane, 250, 150);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter");
//        Exit confirmation
        primaryStage.setOnCloseRequest(
                e ->
                {
                    e.consume();
                    btnClose_Clicked();
                }
        );
        primaryStage.show();

    }

    public void buttonClick()
    {
        iClickCount++;
        if (iClickCount == 1)
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked once");
//            Alert a = new Alert(Alert.AlertType.INFORMATION, "Are you certain?", ButtonType.YES, ButtonType.NO);
            a.showAndWait();
        } else
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked " + iClickCount + " times.");
            a.showAndWait();
        }
    }

    //    Added
    private void btnClose_Clicked()
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Are you certain?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> r = a.showAndWait();
        if (r.isPresent() && r.get() == ButtonType.YES)
        {
            stage.close();
        }
    }


}
