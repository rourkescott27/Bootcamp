package com.example.book6.ch5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RolePlayer extends Application
{
    TextField txtCharacter;

    TextField txtActor;


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
//        CREATE THE CHARACTER LABEL
        Label lblCharacter = new Label("Character's Name:");
        lblCharacter.setMinWidth(100);
        lblCharacter.setAlignment(Pos.BOTTOM_RIGHT);

//        CREATE THE CHARACTER INPUT TEXT FIELD
        txtCharacter = new TextField();
        txtCharacter.setMinWidth(200);
        txtCharacter.setMaxWidth(200);
        txtCharacter.setPromptText("Enter the name of the character here.");

//        CREATE THE ACTOR LABEL
        Label lblActor = new Label("Actor's Name:");
        lblActor.setMinWidth(100);
        lblActor.setAlignment(Pos.BOTTOM_RIGHT);

//        CREATE THE ACTOR INPUT TEXT FIELD
        txtActor = new TextField();
        txtActor.setMinWidth(200);
        txtActor.setMaxWidth(200);
        txtActor.setPromptText("Enter the name of the actor here.");

//        CREATE THE OK BUTTON
        Button btnOK = new Button("OK");
        btnOK.setMinWidth(75);
        btnOK.setOnAction(e -> btnOK_Click());

//        CREATE THE CHARACTER PANE
        HBox paneCharacter = new HBox(20, lblCharacter, txtCharacter);
        paneCharacter.setPadding(new Insets(10));

//        CREATE THE ACTOR PANE
        HBox paneActor = new HBox(20, lblActor, txtActor);
        paneActor.setPadding(new Insets(10));

//        CREATE THE BUTTON PANE
        HBox paneButton = new HBox(20, btnOK);
        paneButton.setPadding(new Insets(10));
        paneButton.setAlignment(Pos.BOTTOM_RIGHT);

//        ADD THE CHARACTER, ACTOR AND THE BUTTON PANES TO A VBOX
        VBox pane = new VBox(10, paneCharacter, paneActor, paneButton);

//        SET THE STAGE
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Role Player");
        primaryStage.show();

    }

    public void btnOK_Click()
    {
        String errorMessage = "";
        if (txtCharacter.getText().isEmpty())
        {
            errorMessage += "\nCharacter is a required field.";
        }
        if (txtActor.getText().isEmpty())
        {
            errorMessage += "\nActor is a required field.";
        }
        if (errorMessage.isEmpty())
        {
            String message = "The role of "
                    + txtCharacter.getText()
                    + " will be played by "
                    + txtActor.getText()
                    + ".";
            Alert a = new Alert(Alert.AlertType.INFORMATION, message);
            a.setTitle("Cast");
            a.showAndWait();
        } else
        {
            Alert a = new Alert(Alert.AlertType.WARNING, errorMessage);
            a.setTitle("Missing Data");
            a.showAndWait();
        }
    }
}
