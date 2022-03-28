package com.joao.dias.configs;

import com.joao.dias.App;
import com.joao.dias.controllers.NameGenerationController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class NameViewConfig {
    @FXML
    public TextArea namesTextArea;

    @FXML
    protected void printNames(){
        NameGenerationController.printNames(namesTextArea.getText());
        namesTextArea.getText();
    }

    @FXML
    protected void changeToTagView(){
        App.changeToTagView();
    }
}
