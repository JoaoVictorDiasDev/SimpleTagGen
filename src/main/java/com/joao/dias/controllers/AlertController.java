package com.joao.dias.controllers;

import javafx.scene.control.Alert;

public class AlertController {
    public static void createConfirmationDialog(String title, String desc){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(desc);
        alert.show();
    }
    public static void createErrorDialog(String title, String desc){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(desc);
        alert.show();
    }
}
