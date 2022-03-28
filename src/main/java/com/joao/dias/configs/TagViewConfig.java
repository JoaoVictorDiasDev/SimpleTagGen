package com.joao.dias.configs;

import com.joao.dias.App;
import com.joao.dias.controllers.TagGenerationController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

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
    private TextArea SK1, SK2, SK3, SK4, SK5, SK6;

    @FXML
    private TextArea PA1, PA2, PA3, PA4, PA5, PA6, PA7, PA8, PA9;


    @FXML
    protected void imprimir() {
        try {
            resetInputInformation();
            getInputInformation(); //Gets Inputs From User

            TagGenerationController.createNewPage(); //Creates Final Image
            TagGenerationController.PrintTags(); //Print Tags and Val / Lot
            TagGenerationController.reset();

        } catch (Exception e){
            System.out.printf("Exception on MainController.Generate: %s\n", e.getMessage());
        }
    }

    @FXML
    protected void restaurar(){
        TagGenerationController.reset();
    }

    @FXML
    protected void changeToNameView () {
        App.changeToNameView();
    }

    //Update ImageGenerator variables to match inputs from user
    void getInputInformation(){
        //TODO: MUST BE A BETTER WAY OF DOING THIS
        if(!DD1.getText().isEmpty()){
            TagGenerationController.amountToPrintDD[1] = Integer.valueOf(DD1.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }

        if(!DD1.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[1] = Integer.valueOf(DD1.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD2.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[2] = Integer.valueOf(DD2.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD3.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[3] = Integer.valueOf(DD3.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD4.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[4] = Integer.valueOf(DD4.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD5.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[5] = Integer.valueOf(DD5.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD6.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[6] = Integer.valueOf(DD6.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD7.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[7] = Integer.valueOf(DD7.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD8.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[8] = Integer.valueOf(DD8.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD9.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[9] = Integer.valueOf(DD9.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD10.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[10] = Integer.valueOf(DD10.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD11.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[11] = Integer.valueOf(DD11.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD12.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[12] = Integer.valueOf(DD12.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD13.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[13] = Integer.valueOf(DD13.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }
        if(!DD14.getText().isEmpty()) {
            TagGenerationController.amountToPrintDD[14] = Integer.valueOf(DD14.getText());
            TagGenerationController.setNeedToPrintDD(true);
        }

        if(!LC1.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[1] = Integer.valueOf(LC1.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC2.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[2] = Integer.valueOf(LC2.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC3.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[3] = Integer.valueOf(LC3.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC4.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[4] = Integer.valueOf(LC4.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC5.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[5] = Integer.valueOf(LC5.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC6.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[6] = Integer.valueOf(LC6.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC7.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[7] = Integer.valueOf(LC7.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC8.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[8] = Integer.valueOf(LC8.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC9.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[9] = Integer.valueOf(LC9.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC10.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[10] = Integer.valueOf(LC10.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC11.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[11] = Integer.valueOf(LC11.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC12.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[12] = Integer.valueOf(LC12.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC13.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[13] = Integer.valueOf(LC13.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC14.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[14] = Integer.valueOf(LC14.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }
        if(!LC15.getText().isEmpty()) {
            TagGenerationController.amountToPrintLC[15] = Integer.valueOf(LC15.getText());
            TagGenerationController.setNeedToPrintLC(true);
        }


        if(!AC1.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[1] = Integer.valueOf(AC1.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC2.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[2] = Integer.valueOf(AC2.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC3.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[3] = Integer.valueOf(AC3.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC4.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[4] = Integer.valueOf(AC4.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC5.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[5] = Integer.valueOf(AC5.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC6.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[6] = Integer.valueOf(AC6.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC7.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[7] = Integer.valueOf(AC7.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC8.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[8] = Integer.valueOf(AC8.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC9.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[9] = Integer.valueOf(AC9.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC10.getText().isEmpty()){
            TagGenerationController.amountToPrintAC[10] = Integer.valueOf(AC10.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC11.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[11] = Integer.valueOf(AC11.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC12.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[12] = Integer.valueOf(AC12.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC13.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[13] = Integer.valueOf(AC13.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }
        if(!AC14.getText().isEmpty()) {
            TagGenerationController.amountToPrintAC[14] = Integer.valueOf(AC14.getText());
            TagGenerationController.setNeedToPrintAC(true);
        }

        if(!SP1.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[1] = Integer.valueOf(SP1.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP2.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[2] = Integer.valueOf(SP2.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP3.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[3] = Integer.valueOf(SP3.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP4.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[4] = Integer.valueOf(SP4.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP5.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[5] = Integer.valueOf(SP5.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP6.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[6] = Integer.valueOf(SP6.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP7.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[7] = Integer.valueOf(SP7.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP8.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[8] = Integer.valueOf(SP8.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP9.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[9] = Integer.valueOf(SP9.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }
        if(!SP10.getText().isEmpty()) {
            TagGenerationController.amountToPrintSP[10] = Integer.valueOf(SP10.getText());
            TagGenerationController.setNeedToPrintSP(true);
        }

        if(!DC1.getText().isEmpty()) {
            TagGenerationController.amountToPrintDC[1] = Integer.valueOf(DC1.getText());
            TagGenerationController.setNeedToPrintDC(true);
        }
        if(!DC2.getText().isEmpty()) {
            TagGenerationController.amountToPrintDC[2] = Integer.valueOf(DC2.getText());
            TagGenerationController.setNeedToPrintDC(true);
        }

       if(!PA1.getText().isEmpty()){
           TagGenerationController.amountToPrintPA[1] = Integer.valueOf(PA1.getText());
           TagGenerationController.setNeedToPrintPA(true);
       }
        if(!PA2.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[2] = Integer.valueOf(PA2.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }
        if(!PA3.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[3] = Integer.valueOf(PA3.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }
        if(!PA4.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[4] = Integer.valueOf(PA4.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }
        if(!PA5.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[5] = Integer.valueOf(PA5.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }
        if(!PA6.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[6] = Integer.valueOf(PA6.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }
        if(!PA7.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[7] = Integer.valueOf(PA7.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }
        if(!PA8.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[8] = Integer.valueOf(PA8.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }
        if(!PA9.getText().isEmpty()){
            TagGenerationController.amountToPrintPA[9] = Integer.valueOf(PA9.getText());
            TagGenerationController.setNeedToPrintPA(true);
        }


        if(!SK1.getText().isEmpty()) {
            TagGenerationController.amountToPrintSK[1] = Integer.valueOf(SK1.getText());
            TagGenerationController.setNeedToPrintSK(true);
        }
        if(!SK2.getText().isEmpty()) {
            TagGenerationController.amountToPrintSK[2] = Integer.valueOf(SK2.getText());
            TagGenerationController.setNeedToPrintSK(true);
        }
        if(!SK3.getText().isEmpty()) {
            TagGenerationController.amountToPrintSK[3] = Integer.valueOf(SK3.getText());
            TagGenerationController.setNeedToPrintSK(true);
        }
        if(!SK4.getText().isEmpty()) {
            TagGenerationController.amountToPrintSK[4] = Integer.valueOf(SK4.getText());
            TagGenerationController.setNeedToPrintSK(true);
        }
        if(!SK5.getText().isEmpty()) {
            TagGenerationController.amountToPrintSK[5] = Integer.valueOf(SK5.getText());
            TagGenerationController.setNeedToPrintSK(true);
        }
        if(!SK6.getText().isEmpty()) {
            TagGenerationController.amountToPrintSK[6] = Integer.valueOf(SK6.getText());
            TagGenerationController.setNeedToPrintSK(true);
        }

    }
    void resetInputInformation (){

        TagGenerationController.amountToPrintDD[1] = 0;
        TagGenerationController.amountToPrintDD[2] = 0;
        TagGenerationController.amountToPrintDD[3] = 0;
        TagGenerationController.amountToPrintDD[4] = 0;
        TagGenerationController.amountToPrintDD[5] = 0;
        TagGenerationController.amountToPrintDD[6] = 0;
        TagGenerationController.amountToPrintDD[7] = 0;
        TagGenerationController.amountToPrintDD[8] = 0;
        TagGenerationController.amountToPrintDD[9] = 0;
        TagGenerationController.amountToPrintDD[10] = 0;
        TagGenerationController.amountToPrintDD[11] = 0;
        TagGenerationController.amountToPrintDD[12] = 0;
        TagGenerationController.amountToPrintDD[13] = 0;
        TagGenerationController.amountToPrintDD[14] = 0;

        TagGenerationController.amountToPrintLC[1] = 0;
        TagGenerationController.amountToPrintLC[2] = 0;
        TagGenerationController.amountToPrintLC[3] = 0;
        TagGenerationController.amountToPrintLC[4] = 0;
        TagGenerationController.amountToPrintLC[5] = 0;
        TagGenerationController.amountToPrintLC[6] = 0;
        TagGenerationController.amountToPrintLC[7] = 0;
        TagGenerationController.amountToPrintLC[8] = 0;
        TagGenerationController.amountToPrintLC[9] = 0;
        TagGenerationController.amountToPrintLC[10] = 0;
        TagGenerationController.amountToPrintLC[11] = 0;
        TagGenerationController.amountToPrintLC[12] = 0;
        TagGenerationController.amountToPrintLC[13] = 0;
        TagGenerationController.amountToPrintLC[14] = 0;
        TagGenerationController.amountToPrintLC[15] = 0;

        TagGenerationController.amountToPrintAC[1] = 0;
        TagGenerationController.amountToPrintAC[2] = 0;
        TagGenerationController.amountToPrintAC[3] = 0;
        TagGenerationController.amountToPrintAC[4] = 0;
        TagGenerationController.amountToPrintAC[5] = 0;
        TagGenerationController.amountToPrintAC[6] = 0;
        TagGenerationController.amountToPrintAC[7] = 0;
        TagGenerationController.amountToPrintAC[8] = 0;
        TagGenerationController.amountToPrintAC[9] = 0;
        TagGenerationController.amountToPrintAC[10] = 0;
        TagGenerationController.amountToPrintAC[11] = 0;
        TagGenerationController.amountToPrintAC[12] = 0;
        TagGenerationController.amountToPrintAC[13] = 0;
        TagGenerationController.amountToPrintAC[14] = 0;

    }
}
