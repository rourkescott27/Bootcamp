package com.example.book6.ch4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PizzaOrder extends Application
{
    Stage stage;
    TextField txtName;
    TextField txtPhone;
    TextField txtAddress;

    RadioButton rdoSmall;
    RadioButton rdoMedium;
    RadioButton rdoLarge;
    RadioButton rdoThin;
    RadioButton rdoThick;

    CheckBox chkPepperoni;
    CheckBox chkMushrooms;
    CheckBox chkAnchovies;


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        stage = primaryStage;

//        CREATE THE LABEL NAME AND TEXT FIELD
        Label lblName = new Label("Name:");
        txtName = new TextField();
        txtName.setMinWidth(100);
        txtName.setPrefWidth(200);
        txtName.setMaxWidth(300);
        txtName.setPromptText("Enter the name here");

//        CREATE THE PHONE NUMBER LABEL AND TEXT FIELD
        Label lblPhone = new Label("Phone Number:");
        txtPhone = new TextField();
        txtPhone.setMinWidth(60);
        txtPhone.setPrefWidth(120);
        txtPhone.setMaxWidth(180);
        txtPhone.setPromptText("Enter your phone number here");

//        CREATE THE ADDRESS LABEL AND TEXT FIELD
        Label lblAddress = new Label("Address:");
        txtAddress = new TextField();
        txtAddress.setMinWidth(100);
        txtAddress.setPrefWidth(200);
        txtAddress.setMaxWidth(300);
        txtAddress.setPromptText("Enter your address here");

//        CREATE THE SIZE PANE
        Label lblSize = new Label("Size");
        rdoSmall = new RadioButton("Small");
        rdoMedium = new RadioButton("Medium");
        rdoLarge = new RadioButton("Large");
        rdoMedium.setSelected(true);

        ToggleGroup groupSize = new ToggleGroup();
        rdoSmall.setToggleGroup(groupSize);
        rdoMedium.setToggleGroup(groupSize);
        rdoLarge.setToggleGroup(groupSize);

        VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
        paneSize.setSpacing(10);

//        CREATE THE CRUST PANE
        Label lblCrust = new Label("Crust");
        rdoThin = new RadioButton("Thin");
        rdoThick = new RadioButton("Thick");
        rdoThin.setSelected(true);

        ToggleGroup groupCrust = new ToggleGroup();
        rdoThin.setToggleGroup(groupCrust);
        rdoThick.setToggleGroup(groupCrust);

        VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
        paneCrust.setSpacing(10);

//        CREATE THE TOPPINGS PANE
        Label lblToppings = new Label("Toppings");
        chkPepperoni = new CheckBox("Pepperoni");
        chkMushrooms = new CheckBox("Mushrooms");
        chkAnchovies = new CheckBox("Anchovies");

        VBox paneToppings = new VBox(lblToppings, chkPepperoni, chkMushrooms, chkAnchovies);
        paneToppings.setSpacing(10);

//        CREATE THE BUTTONS
        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(e -> btnOk_Click());

        Button btnCancel = new Button("Cancel");
        btnCancel.setPrefWidth(80);
        btnCancel.setOnAction(e -> btnCancel_Click());

        HBox paneButtons = new HBox(10, btnOK, btnCancel);

//        CREATE A GRID PANE LAYOUT
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMinWidth(500);
        grid.setPrefWidth(500);
        grid.setMaxWidth(800);

//        ADD NODES TO THE PANE
        grid.addRow(0, lblName, txtName);
        grid.addRow(1, lblPhone, txtPhone);
        grid.addRow(2, lblAddress, txtAddress);
        grid.addRow(3, paneSize, paneCrust, paneToppings);
        grid.add(paneButtons, 2, 4);

//        SET ALIGNMENTS AND SPANNING
        GridPane.setHalignment(lblName, HPos.RIGHT);
        GridPane.setHalignment(lblPhone, HPos.RIGHT);
        GridPane.setHalignment(lblAddress, HPos.RIGHT);
        GridPane.setColumnSpan(txtName, 2);
        GridPane.setColumnSpan(txtPhone, 2);
        GridPane.setColumnSpan(txtAddress, 2);

//        SET COLUMN WIDTHS
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33);
        grid.getColumnConstraints().addAll(col1, col2, col3);

//        CREATE THE SCENE AND THE STAGE
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.setMinWidth(500);
        primaryStage.setMaxWidth(900);
        primaryStage.show();
    }

    public void btnOk_Click()
    {
//        MESSAGE STRING WITH CUSTOMER INFO
        String msg = "Customer: \n\n";
        msg += "\t" + txtName.getText() + "\n";
        msg += "\t" + txtPhone.getText() + "\n";
        msg += "\t" + txtAddress.getText() + "\n";
        msg += "You have ordered a ";

//        PIZZA SIZE
        if (rdoSmall.isSelected())
        {
            msg += "small ";
        }
        if (rdoMedium.isSelected())
        {
            msg += "medium ";
        }
        if (rdoLarge.isSelected())
        {
            msg += "large ";
        }

//        CRUST STYLE
        if (rdoThin.isSelected())
        {
            msg += "thin crust pizza with ";
        }
        if (rdoThick.isSelected())
        {
            msg += "thick crust pizza with";
        }

//        ADD THE TOPPINGS
        String toppings = "";

        toppings = buildToppings(chkPepperoni, toppings);
        toppings = buildToppings(chkMushrooms, toppings);
        toppings = buildToppings(chkAnchovies, toppings);
        if (toppings.equals(""))
        {
            msg += "no toppings.";
        } else
        {
            msg += " the following toppings:\n" + toppings;
        }

// DISPLAY THE MESSAGE
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
        a.setTitle("Order Details");
        a.showAndWait();

    }

    public String buildToppings(CheckBox chk, String msg)
    {
        if (chk.isSelected())
        {
            if (!msg.equals(""))
            {
                msg += ", ";
            }
            msg += chk.getText();
        }
        return msg;
    }

    public void btnCancel_Click()
    {
        stage.close();
    }
}
