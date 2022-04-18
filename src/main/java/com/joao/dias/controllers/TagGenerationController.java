package com.joao.dias.controllers;

import com.joao.dias.models.Sheet;
import com.joao.dias.models.Tag;
import com.joao.dias.utils.ColorController;
import com.joao.dias.utils.PrintRequest;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.LinkedList;

public class TagGenerationController {

    static Sheet currentSheet;
    private static List<Sheet> sheets = new LinkedList<Sheet>();

    public static void PrintTags(PrintRequest printRequest) {
        System.out.println("Iniciou A impressao de etiquetas");
        currentSheet = new Sheet("Tag");

        if(printRequest.needToPrintDD()) genericPrinter(printRequest.getPrintArrayDD(), 1);
        if(printRequest.needToPrintLC()) genericPrinter(printRequest.getPrintArrayLC(), 2);
        if(printRequest.needToPrintAC()) genericPrinter(printRequest.getPrintArrayAC(), 3);
        if(printRequest.needToPrintSP()) genericPrinter(printRequest.getPrintArraySP(), 4);
        if(printRequest.needToPrintDC()) genericPrinter(printRequest.getPrintArrayDC(), 5);
        if(printRequest.needToPrintPA()) genericPrinter(printRequest.getPrintArrayPA(), 6);
        if(printRequest.needToPrintSK()) genericPrinter(printRequest.getPrintArraySK(), 7);

        saveCurrentSheet();
        for(Sheet sheet : sheets){
            System.out.println("Saving Sheet !");
            FileController.saveImage(sheet.getImg());
        }

    }

    private static void genericPrinter(int [] printArray, int tagType){
        for(int i = 0; i < printArray.length; i++){
            if(printArray[i] != 0) {
                Tag tag = new Tag(Integer.valueOf(String.format("%d%02d", tagType, i)));
                while(printArray[i] != 0){
                    if(currentSheet.isSheetFull()){
                        saveCurrentSheet();
                        createNewSheet();
                    }
                    currentSheet.placeTagOnSheet(tag);
                    printArray[i]--;
                }
            }
        }
    }

    private static void createNewSheet() {
        currentSheet = new Sheet("Tag");
    }

    private static void saveCurrentSheet() {
        sheets.add(currentSheet);
    }
}

