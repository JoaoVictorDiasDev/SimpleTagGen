package com.joao.dias;

import com.joao.dias.controllers.FileController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    static AnchorPane root;
    static final List<Pane> grids = new ArrayList<>();
    static int currentPaneId = 0;

    @SuppressWarnings("ConstantConditions")
    @Override
    public void start(Stage stage)  {
        try {
            root = FXMLLoader.load(getClass().getResource("anchor.fxml"));

            grids.add(FXMLLoader.load(getClass().getResource("tagView.fxml")));
            grids.add(FXMLLoader.load(getClass().getResource("nameView.fxml")));
            grids.add(FXMLLoader.load(getClass().getResource("passView.fxml")));

            root.getChildren().add(grids.get(currentPaneId));
            Scene scene = new Scene(root, 1400, 900);
            stage.setScene(scene);
            stage.setTitle("NutriNice SimpleTagGen");
            stage.show();

        } catch(Exception e){
            System.out.println("Exception in App.start: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileController fc = new FileController();
        fc.loadFont();
        launch();
    }


    public static void changeToNameView(){
        root.getChildren().remove(grids.get(currentPaneId));
        root.getChildren().add(grids.get(1));
        currentPaneId = 1;
    }

    public static void changeToTagView(){
        root.getChildren().remove(grids.get(currentPaneId));
        root.getChildren().add(grids.get(0));
        currentPaneId = 0;
    }

    public static void changeToPassView(){
        root.getChildren().remove(grids.get(currentPaneId));
        root.getChildren().add(grids.get(2));
        currentPaneId = 2;
    }
}