package com.joao.dias.configs;

import com.joao.dias.App;
import com.joao.dias.controllers.PassGenerationController;
import com.joao.dias.utils.ClipBoardController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PassViewConfig {
    @FXML
    protected VBox nameVBox;

    @FXML
    protected VBox msgVBox;

    @FXML
    protected TextArea textArea;

    @FXML
    protected void generate(){
        PassGenerationController passGenerationController = new PassGenerationController();
        passGenerationController.populateNamesList(textArea.getText());
        passGenerationController.populateMessageList(textArea.getText());
        passGenerationController.populateNameToNumberMap(textArea.getText());
        passGenerationController.populateNameToMessageMap(textArea.getText());

        System.out.println("Working!!!");

        System.out.println(passGenerationController.getNameList());
        nameVBox.getChildren().addAll(createNamesButtons(passGenerationController.getNameList(), passGenerationController.getNameToNumberMap()));
        msgVBox.getChildren().addAll(createMessageButtons(passGenerationController.getNameList(), passGenerationController.getNameToMessageMap()));
    }

    private List<Button> createNamesButtons(List<String> names, Map<String, String> nameToNumberMap){
        List<Button> nameButtonsList = new ArrayList<>();
        for(String name : names){
            Button button = new Button();
            button.setPrefHeight(30f);
            button.setMaxHeight(30f);
            button.setMinHeight(30f);
            button.setText(name);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println(nameToNumberMap.get(button.getText()));
                    ClipBoardController.CopyToClipBoard(nameToNumberMap.get((button.getText())));
                }
            });
            nameButtonsList.add(button);
        }
        return nameButtonsList;
    }

    private List<Button> createMessageButtons(List<String> names, Map<String, String> nameToMessageMap){
        List<Button> messageButtonsList = new ArrayList<>();
        for(String name : names){
            Button button = new Button();
            button.setText("msg");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println(nameToMessageMap.get(name));
                    ClipBoardController.CopyToClipBoard(nameToMessageMap.get((name)));
                }
            });
            messageButtonsList.add(button);
        }
        return messageButtonsList;
    }



    @FXML
    protected void changeToNameView () {
        App.changeToNameView();
    }

    @FXML
    protected void changeToPassView() {
        App.changeToPassView();
    }

    @FXML
    protected void changeToTagView(){ App.changeToTagView(); }
}
