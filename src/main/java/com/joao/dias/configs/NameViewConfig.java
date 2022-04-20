package com.joao.dias.configs;

import com.joao.dias.App;
import com.joao.dias.controllers.NameGenerationController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class NameViewConfig {
    @FXML
    protected TextField startPositionTxt;

    @FXML
    public TextArea namesTextArea;

    @FXML
    protected void printNames(){
        NameGenerationController nameGenerationController = new NameGenerationController(Integer.parseInt(startPositionTxt.getText()));
        nameGenerationController.printNames(namesTextArea.getText());
        namesTextArea.getText();
    }

    @FXML
    protected void changeToTagView(){
        App.changeToTagView();
    }
}
