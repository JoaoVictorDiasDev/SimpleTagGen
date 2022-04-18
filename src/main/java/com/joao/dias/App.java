package com.joao.dias;

import com.joao.dias.controllers.TagGenerationController;
import com.joao.dias.models.Sheet;
import com.joao.dias.models.Tag;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {
    static AnchorPane root;
    private static Scene scene;
    static List<HBox> grids = new ArrayList<HBox>();
    static int currentPaneId = 0;

    @Override
    public void start(Stage stage)  {
        try {
            root = (AnchorPane) FXMLLoader.load(getClass().getResource("anchor.fxml"));

            grids.add((HBox) FXMLLoader.load(getClass().getResource("tag-view.fxml")));
            grids.add((HBox) FXMLLoader.load(getClass().getResource("name-view.fxml")));

            root.getChildren().add(grids.get(currentPaneId));
            Scene scene = new Scene(root, 1200, 800);
            stage.setScene(scene);
            stage.setTitle("NutriNice TagGen");
            stage.show();
        } catch(Exception e){
            System.out.println("Exception in App.start: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

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
}