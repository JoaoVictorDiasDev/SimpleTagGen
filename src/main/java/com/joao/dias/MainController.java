package com.joao.dias;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainController {
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
    protected void imprimir() {
        try {
            resetInputInformation();
            getInputInformation(); //Gets Inputs From User

            ImageGenerator.CreateNewSheet(); //Creates Final Image
            ImageGenerator.PrintTags(); //Print Tags and Val / Lot
            ImageGenerator.CreatePrintJob(); //Creates print job

        } catch (Exception e){
            System.out.printf("Exception on MainController.Generate: %s\n", e.getMessage());
        }
    }

    @FXML
    protected void restaurar(){
        System.out.println("Restaurar");
    }

    //Update ImageGenerator variables to match inputs from user
    void getInputInformation(){
        if(!DD1.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[1] = Integer.valueOf(DD1.getText());
        if(!DD2.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[2] = Integer.valueOf(DD2.getText());
        if(!DD3.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[3] = Integer.valueOf(DD3.getText());
        if(!DD4.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[4] = Integer.valueOf(DD4.getText());
        if(!DD5.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[5] = Integer.valueOf(DD5.getText());
        if(!DD6.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[6] = Integer.valueOf(DD6.getText());
        if(!DD7.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[7] = Integer.valueOf(DD7.getText());
        if(!DD8.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[8] = Integer.valueOf(DD8.getText());
        if(!DD9.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[9] = Integer.valueOf(DD9.getText());
        if(!DD10.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[10] = Integer.valueOf(DD10.getText());
        if(!DD11.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[11] = Integer.valueOf(DD11.getText());
        if(!DD12.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[12] = Integer.valueOf(DD12.getText());
        if(!DD13.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[13] = Integer.valueOf(DD13.getText());
        if(!DD14.getText().isEmpty()) ImageGenerator.quantidadesDiaaDia[14] = Integer.valueOf(DD14.getText());

        if(!LC1.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[1] = Integer.valueOf(LC1.getText());
        if(!LC2.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[2] = Integer.valueOf(LC2.getText());
        if(!LC3.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[3] = Integer.valueOf(LC3.getText());
        if(!LC4.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[4] = Integer.valueOf(LC4.getText());
        if(!LC5.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[5] = Integer.valueOf(LC5.getText());
        if(!LC6.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[6] = Integer.valueOf(LC6.getText());
        if(!LC7.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[7] = Integer.valueOf(LC7.getText());
        if(!LC8.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[8] = Integer.valueOf(LC8.getText());
        if(!LC9.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[9] = Integer.valueOf(LC9.getText());
        if(!LC10.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[10] = Integer.valueOf(LC10.getText());
        if(!LC11.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[11] = Integer.valueOf(LC11.getText());
        if(!LC12.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[12] = Integer.valueOf(LC12.getText());
        if(!LC13.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[13] = Integer.valueOf(LC13.getText());
        if(!LC14.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[14] = Integer.valueOf(LC14.getText());
        if(!LC15.getText().isEmpty()) ImageGenerator.quantidadesLowCarb[15] = Integer.valueOf(LC15.getText());


        if(!AC1.getText().isEmpty()) ImageGenerator.quantidadesAcademia[1] = Integer.valueOf(AC1.getText());
        if(!AC2.getText().isEmpty()) ImageGenerator.quantidadesAcademia[2] = Integer.valueOf(AC2.getText());
        if(!AC3.getText().isEmpty()) ImageGenerator.quantidadesAcademia[3] = Integer.valueOf(AC3.getText());
        if(!AC4.getText().isEmpty()) ImageGenerator.quantidadesAcademia[4] = Integer.valueOf(AC4.getText());
        if(!AC5.getText().isEmpty()) ImageGenerator.quantidadesAcademia[5] = Integer.valueOf(AC5.getText());
        if(!AC6.getText().isEmpty()) ImageGenerator.quantidadesAcademia[6] = Integer.valueOf(AC6.getText());
        if(!AC7.getText().isEmpty()) ImageGenerator.quantidadesAcademia[7] = Integer.valueOf(AC7.getText());
        if(!AC8.getText().isEmpty()) ImageGenerator.quantidadesAcademia[8] = Integer.valueOf(AC8.getText());
        if(!AC9.getText().isEmpty()) ImageGenerator.quantidadesAcademia[9] = Integer.valueOf(AC9.getText());
        if(!AC10.getText().isEmpty()) ImageGenerator.quantidadesAcademia[10] = Integer.valueOf(AC10.getText());
        if(!AC11.getText().isEmpty()) ImageGenerator.quantidadesAcademia[11] = Integer.valueOf(AC11.getText());
        if(!AC12.getText().isEmpty()) ImageGenerator.quantidadesAcademia[12] = Integer.valueOf(AC12.getText());
        if(!AC13.getText().isEmpty()) ImageGenerator.quantidadesAcademia[13] = Integer.valueOf(AC13.getText());
        if(!AC14.getText().isEmpty()) ImageGenerator.quantidadesAcademia[14] = Integer.valueOf(AC14.getText());

    }
    void resetInputInformation (){

        ImageGenerator.quantidadesDiaaDia[1] = 0;
        ImageGenerator.quantidadesDiaaDia[2] = 0;
        ImageGenerator.quantidadesDiaaDia[3] = 0;
        ImageGenerator.quantidadesDiaaDia[4] = 0;
        ImageGenerator.quantidadesDiaaDia[5] = 0;
        ImageGenerator.quantidadesDiaaDia[6] = 0;
        ImageGenerator.quantidadesDiaaDia[7] = 0;
        ImageGenerator.quantidadesDiaaDia[8] = 0;
        ImageGenerator.quantidadesDiaaDia[9] = 0;
        ImageGenerator.quantidadesDiaaDia[10] = 0;
        ImageGenerator.quantidadesDiaaDia[11] = 0;
        ImageGenerator.quantidadesDiaaDia[12] = 0;
        ImageGenerator.quantidadesDiaaDia[13] = 0;
        ImageGenerator.quantidadesDiaaDia[14] = 0;

        ImageGenerator.quantidadesLowCarb[1] = 0;
        ImageGenerator.quantidadesLowCarb[2] = 0;
        ImageGenerator.quantidadesLowCarb[3] = 0;
        ImageGenerator.quantidadesLowCarb[4] = 0;
        ImageGenerator.quantidadesLowCarb[5] = 0;
        ImageGenerator.quantidadesLowCarb[6] = 0;
        ImageGenerator.quantidadesLowCarb[7] = 0;
        ImageGenerator.quantidadesLowCarb[8] = 0;
        ImageGenerator.quantidadesLowCarb[9] = 0;
        ImageGenerator.quantidadesLowCarb[10] = 0;
        ImageGenerator.quantidadesLowCarb[11] = 0;
        ImageGenerator.quantidadesLowCarb[12] = 0;
        ImageGenerator.quantidadesLowCarb[13] = 0;
        ImageGenerator.quantidadesLowCarb[14] = 0;
        ImageGenerator.quantidadesLowCarb[15] = 0;

        ImageGenerator.quantidadesAcademia[1] = 0;
        ImageGenerator.quantidadesAcademia[2] = 0;
        ImageGenerator.quantidadesAcademia[3] = 0;
        ImageGenerator.quantidadesAcademia[4] = 0;
        ImageGenerator.quantidadesAcademia[5] = 0;
        ImageGenerator.quantidadesAcademia[6] = 0;
        ImageGenerator.quantidadesAcademia[7] = 0;
        ImageGenerator.quantidadesAcademia[8] = 0;
        ImageGenerator.quantidadesAcademia[9] = 0;
        ImageGenerator.quantidadesAcademia[10] = 0;
        ImageGenerator.quantidadesAcademia[11] = 0;
        ImageGenerator.quantidadesAcademia[12] = 0;
        ImageGenerator.quantidadesAcademia[13] = 0;
        ImageGenerator.quantidadesAcademia[14] = 0;

    }
}
