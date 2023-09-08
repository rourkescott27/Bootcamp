package com.example.book6.ch3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSwitcher extends Application
{
    //    INSTANCE VARIABLES FOR CLICK-COUNTER SCENE
    int iClickCount = 0;
    Label lblClicks;
    Button btnClickMe;
    Button btnSwitchToScene2;
    Scene scene1;

    //    INSTANCE VARIABLES FOR ADD-SUBTRACT SCENE
    int iCounter = 0;
    Label lblCounter;
    Button btnAdd;
    Button btnSubtract;
    Button btnSwitchToScene1;
    Scene scene2;

    //    INSTANCE VARIABLE FOR STAGE
    Stage stage;


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        stage = primaryStage;

//        BUILD THE CLICK-COUNTER SCENE
        lblClicks = new Label();
        lblClicks.setText("You have not clicked the button.");

        btnClickMe = new Button();
        btnClickMe.setText("Click me please!");
        btnClickMe.setOnAction(e -> btnClickMe_Click());

        btnSwitchToScene2 = new Button();
        btnSwitchToScene2.setText("Switch!");
        btnSwitchToScene2.setOnAction(e -> btnSwitchToScene2_Click());

        VBox pane1 = new VBox(10);
        pane1.getChildren().addAll(lblClicks, btnClickMe, btnSwitchToScene2);

        scene1 = new Scene(pane1, 250, 150);

//        BUILD THE ADD-SUBTRACT SCENE
        lblCounter = new Label();
        lblCounter.setText(Integer.toString(iCounter));

        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(e -> btnAdd_Click());

        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(e -> btnSubtract_Click());

        btnSwitchToScene2 = new Button();
        btnSwitchToScene2.setText("Switch!");
        btnSwitchToScene2.setOnAction(e -> btnSwitchToScene1_Click());

        HBox pane2 = new HBox(10);
        pane2.getChildren().addAll(lblCounter, btnAdd, btnSubtract, btnSwitchToScene2);

        scene2 = new Scene(pane2, 300, 75);

        // SET THE STAGE WITH SCENE1 AND SHOW THE STAGE
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene Switcher");
        primaryStage.show();

    }

    // EVENT HANDLERS FOR SCENE 1
    public void btnClickMe_Click()
    {
        iClickCount++;
        if (iClickCount == 1)

        {
            lblClicks.setText("You have clicked once.");
        } else
        {
            lblClicks.setText("You have clicked " + iClickCount + " times.");
        }
    }

    private void btnSwitchToScene2_Click()
    {
        stage.setScene(scene2);
    }

    // EVENT HANDLERS FOR SCENE 2
    private void btnAdd_Click()
    {
        iCounter++;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void btnSubtract_Click()
    {
        iCounter--;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void btnSwitchToScene1_Click()
    {
        stage.setScene(scene1);
    }

}
