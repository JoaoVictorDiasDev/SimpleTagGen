package com.joao.dias.configs;

import com.joao.dias.App;
import com.joao.dias.utils.ClipBoardController;
import com.joao.dias.controllers.TagGenerationController;
import com.joao.dias.utils.PrintRequest;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TagViewConfig {
    @FXML
    private TextArea DD1, DD2, DD3, DD4, DD5, DD6, DD7, DD8,
            DD9, DD10, DD11, DD12, DD13, DD14;
    @FXML
    private TextArea LC1, LC2, LC3, LC4, LC5, LC6, LC7, LC8,
            LC9, LC10, LC11, LC12, LC13, LC14, LC15;
    @FXML
    private TextArea AC1, AC2, AC3, AC4, AC5, AC6, AC7, AC8,
            AC9, AC10, AC11, AC12, AC13, AC14;
    @FXML
    private TextArea SP1, SP2, SP3,SP4, SP5, SP6,SP7, SP8,
            SP9, SP10;
    @FXML
    private TextArea DC1, DC2;

    @FXML
    private TextArea SK1, SK2, SK3, SK5, SK6;

    @FXML
    private TextArea PA1, PA2, PA3, PA4, PA5, PA6, PA7, PA8, PA9;

    @FXML
    protected void print() {
        try {
            getInputInformation();
            TagGenerationController.PrintTags(getInputInformation());

        } catch (Exception e){
            System.out.printf("Exception on TagViewConfig.print: %s\n", e.getMessage());
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

    PrintRequest getInputInformation(){
        PrintRequest printRequest = new PrintRequest();

        List<TextArea> DDTextArea = new ArrayList<>();
        List<TextArea> LCTextArea = new ArrayList<>();
        List<TextArea> ACTextArea = new ArrayList<>();
        List<TextArea> PATextArea = new ArrayList<>();
        List<TextArea> SPTextArea = new ArrayList<>();
        List<TextArea> DCTextArea = new ArrayList<>();
        List<TextArea> SKTextArea = new ArrayList<>();

        Collections.addAll(DDTextArea, DD1, DD2, DD3, DD4, DD5, DD6, DD7, DD8, DD9,
                                       DD10, DD11, DD12, DD13, DD14);

        Collections.addAll(LCTextArea, LC1, LC2, LC3, LC4, LC5, LC6, LC7, LC8, LC9,
                LC10, LC11, LC12, LC13, LC14, LC15);

        Collections.addAll(ACTextArea, AC1, AC2, AC3, AC4, AC5, AC6, AC7, AC8, AC9,
                AC10, AC11, AC12, AC13, AC14);

        Collections.addAll(PATextArea, PA1, PA2, PA3, PA4, PA5, PA6, PA7, PA8, PA9);

        Collections.addAll(SPTextArea, SP1, SP2, SP3, SP4, SP5, SP6, SP7, SP8, SP9, SP10);

        Collections.addAll(DCTextArea, DC1, DC2);

        Collections.addAll(SKTextArea, SK1, SK2, SK3, SK5, SK6);

        printRequest.setPrintArrayDD(extractInformation(DDTextArea));
        printRequest.setPrintArrayLC(extractInformation(LCTextArea));
        printRequest.setPrintArrayAC(extractInformation(ACTextArea));
        printRequest.setPrintArrayPA(extractInformation(PATextArea));
        printRequest.setPrintArraySP(extractInformation(SPTextArea));
        printRequest.setPrintArrayDC(extractInformation(DCTextArea));
        printRequest.setPrintArraySK(extractInformation(SKTextArea));

        return printRequest;
    }

    int [] extractInformation (List<TextArea> textAreaList){
        int [] Array = new int[16];
        int counter = 1;
        for(TextArea textArea : textAreaList) {
            if (!textArea.getText().isEmpty()) {
                Array[counter] = Integer.valueOf(textArea.getText());
            }
            counter++;
        }
        return Array;
    }
}
