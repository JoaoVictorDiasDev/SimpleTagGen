package com.joao.dias.configs;

import com.joao.dias.App;
import com.joao.dias.controllers.AlertController;
import com.joao.dias.controllers.NameGenerationController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class NameViewConfig {
    @FXML
    protected TextArea startPositionTxt;

    @FXML
    public TextArea namesTextArea;

    @FXML
    protected void print(){
        NameGenerationController nameGenerationController;
        if(!startPositionTxt.getText().isEmpty() && !namesTextArea.getText().isEmpty()) {
            nameGenerationController = new NameGenerationController(Integer.parseInt(startPositionTxt.getText()));
            nameGenerationController.printNames(namesTextArea.getText());
        } else{
            AlertController.createErrorDialog("Posição Inicial ou Nomes está vazio", "");
        }
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
