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
        resetGUI();
        PassGenerationController passGenerationController = new PassGenerationController();
        passGenerationController.populateNamesList(textArea.getText());
        passGenerationController.populateMessageList(textArea.getText());
        passGenerationController.populateNameToNumberMap(textArea.getText());
        passGenerationController.populateNameToMessageMap(textArea.getText());


        nameVBox.getChildren().addAll(createNamesButtons(passGenerationController.getNameList(), passGenerationController.getNameToNumberMap()));
        msgVBox.getChildren().addAll(createMessageButtons(passGenerationController.getNameList(), passGenerationController.getNameToMessageMap()));
    }

    private List<Button> createNamesButtons(List<String> names, Map<String, String> nameToNumberMap){
        List<Button> nameButtonsList = new ArrayList<>();
        for(int i = 0; i < names.size(); i++){
            String name = names.get(i);
            Button button = new Button();
            button.setPrefHeight(40f);
            button.setMaxHeight(40f);
            button.setMinHeight(40f);
            button.setText(String.format("%2d - %s", i, name));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ClipBoardController.CopyToClipBoard(nameToNumberMap.get((name)));
                }
            });
            nameButtonsList.add(button);
        }
        return nameButtonsList;
    }

    private List<Button> createMessageButtons(List<String> names, Map<String, String> nameToMessageMap){
        List<Button> messageButtonsList = new ArrayList<>();
        for(int i = 0; i < names.size(); i++){
            String name = names.get(i);
            Button button = new Button();
            button.setPrefHeight(40f);
            button.setMaxHeight(40f);
            button.setMinHeight(40f);
            button.setText(String.format("%2d - msg", i));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ClipBoardController.CopyToClipBoard(nameToMessageMap.get((name)));
                }
            });
            messageButtonsList.add(button);
        }
        return messageButtonsList;
    }

    private void resetGUI () {
        nameVBox.getChildren().clear();
        msgVBox.getChildren().clear();

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
