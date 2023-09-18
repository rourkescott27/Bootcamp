package com.example.book6.ch6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpinOffs extends Application
{
    TreeView<String> tree;
    Label lblShowName;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        TreeItem<String> root, andy, archie, happy, george, maude;
        root = new TreeItem<>("Spin Offs");
        root.setExpanded(true);

        andy = makeShow("The Andy Griffith Show", root);
        makeShow("Gomer Pyle, U.S.M.C.", andy);
        makeShow("Mayberry R.F.D", andy);

        archie = makeShow("All in the Family", root);
        george = makeShow("The Jeffersons", archie);
        makeShow("Checking In", george);

        maude = makeShow("Maude", archie);
        makeShow("Good Times", maude);
        makeShow("Gloria", archie);
        makeShow("Archie Bunker's Place", archie);

        happy = makeShow("Happy Days", root);
        makeShow("Mork and Mindy", happy);
        makeShow("Laverne and Shirley", happy);
        makeShow("Joanie Loves Chachi", happy);

        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) ->
                        tree_SelectionChanged(newValue));

        lblShowName = new Label();
        VBox pane = new VBox(10);

        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.getChildren().addAll(tree, lblShowName);

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("My Favorite Spin Offs");
        primaryStage.show();
    }

    public TreeItem<String> makeShow(String title, TreeItem<String> parent)
    {
        TreeItem<String> show = new TreeItem<>(title);
        show.setExpanded(true);
        parent.getChildren().add(show);
        return show;
    }

    public void tree_SelectionChanged(TreeItem<String> item)
    {
        if (item != null)
        {
            lblShowName.setText(item.getValue());
        }
    }
}
