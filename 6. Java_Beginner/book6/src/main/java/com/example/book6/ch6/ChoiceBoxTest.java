package com.example.book6.ch6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxTest extends Application
{
    ChoiceBox<Astronaut> apollo13;

    ChoiceBox<String> dwarves;

    ChoiceBox<String> fruits;

    Label lblD;

    Label lblA;

    Label lblF;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        lblD = new Label("");
        dwarves = new ChoiceBox<>();
        dwarves.getItems().addAll("Bashful", "Doc", "Dopey", "Grumpy", "Happy", "Sleepy", "Sneezy");
        dwarves.setValue("Dopey");

        dwarves.setOnAction(e -> btnChoice_ClickDwarf());
        lblD.setText(dwarves.getValue());
//        dwarves.getSelectionModel().selectedItemProperty()
//                .addListener((v, oldValue, newValue) -> lblD.setText(newValue));


        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(lblD, dwarves);

//        ------------Astronaut------------
        apollo13 = new ChoiceBox<>();
        Astronaut lovell = new Astronaut("Jim", "Lovell");
        Astronaut swigert = new Astronaut("John", "Swigert");
        Astronaut haise = new Astronaut("Fred", "Haise");

        apollo13.getItems().addAll(lovell, swigert, haise);
        apollo13.setValue(lovell);
        apollo13.setOnAction(e -> btnChoice_ClickAstro());


        VBox vBox1 = new VBox(10);
        vBox1.getChildren().addAll(apollo13);

//        ------------Fruits-----------------
        fruits = new ChoiceBox<>();
        fruits.getItems().addAll("Apple", "Orange", "Banana", "Kiwi", "Grapefruit", "Lychee");
        fruits.setValue("Lychee");
        fruits.setOnAction(e -> btnChoice_ClickFruit());


        VBox vBox2 = new VBox(10);
        vBox2.getChildren().addAll(fruits);


        HBox mainPane = new HBox(10, vBox, vBox1, vBox2);

        Scene scene = new Scene(mainPane, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Choice Box Test");
        primaryStage.show();

    }

    public void btnChoice_ClickAstro()
    {
        String message = "You chose ";
        message += apollo13.getValue();
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setTitle("Your Favorite Astronaut");
        a.showAndWait();
    }

    public void btnChoice_ClickDwarf()
    {
        lblD.setText("Today is turn " + dwarves.getValue() + "'s to clean");
        String message = "Why is this your favorite dwarf ";
        message += dwarves.getValue();
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setTitle("Your Favorite Dwarf");
        a.showAndWait();
    }

    public void btnChoice_ClickFruit()
    {
        String message = "Is this your favorite fruit -> ";
        message += fruits.getValue();
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setTitle("Your Favorite Fruit");
        a.showAndWait();
    }

}

class Astronaut
{
    private final String firstName;
    private final String lastName;

    public Astronaut(String FirstName, String LastName)
    {
        firstName = FirstName;
        lastName = LastName;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}