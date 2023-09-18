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

public class ActorFilmInt extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    TextField intNoOfFilms;
    TextField txtActor;
    String errorMessage;


    @Override
    public void start(Stage primaryStage)
    {
        //create character label
        Label lblNoOfFilms = new Label("No of movies:");
        lblNoOfFilms.setMinWidth(200);
        lblNoOfFilms.setAlignment(Pos.BOTTOM_RIGHT);

        //create character input text field
        intNoOfFilms = new TextField();
        intNoOfFilms.setMinWidth(200);
        intNoOfFilms.setMaxWidth(200);
        intNoOfFilms.setPromptText("Enter number of films of actor:");

        //label for actor
        Label lblActor = new Label("Actor's Name:");
        lblActor.setMinWidth(100);
        lblActor.setAlignment(Pos.BOTTOM_RIGHT);

        //text input field for Actor
        txtActor = new TextField();
        txtActor.setMinWidth(200);
        txtActor.setMinWidth(200);
        txtActor.setPromptText("Enter the name of the actor");

        //ok button
        Button btnOK = new Button("OK");
        btnOK.setMinWidth(75);
        btnOK.setOnAction(e -> btnOK_Click());

        //Character pane
        HBox paneCharacter = new HBox(20, lblNoOfFilms, intNoOfFilms);
        paneCharacter.setPadding(new Insets(10));

        //Actor pane
        HBox paneActor = new HBox(20, lblActor, txtActor);
        paneActor.setPadding(new Insets(10));

        //create pane for the button
        HBox paneButton = new HBox(20, btnOK);

        //Add the above panes to a VBox
        VBox pane = new VBox(10, paneCharacter, paneActor, btnOK);

        //scene
        Scene scene = new Scene(pane);

        //stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Role Player");
        primaryStage.show();
    }

    public void btnOK_Click()
    {

        errorMessage = "";

        if (intNoOfFilms.getText().isEmpty())
        {
            errorMessage = "\nNo of films is a required field";
        }

        if (txtActor.getText().isEmpty())
        {
            errorMessage = "\nActor is a required field";
        }
        isInt(intNoOfFilms, "You must enter an integer.");
        if (errorMessage.isEmpty())
        {
            String message = txtActor.getText() + " has acted in " + intNoOfFilms.getText() + " movies"
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

    private void isInt(TextField f, String msg)
    {
        try
        {
            Integer.parseInt((f.getText()));

        } catch (NumberFormatException e)
        {
            errorMessage = msg;
        }
    }
}

