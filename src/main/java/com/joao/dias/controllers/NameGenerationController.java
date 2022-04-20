package com.joao.dias.controllers;

import com.joao.dias.models.Sheet;
import com.joao.dias.models.Tag;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class NameGenerationController {

    private String[] lines;

    int tagHeight = 516; //2cm
    int tagWidth = 930; //4cm
    int marginTop = 151; //1cm
    int marginLeft = 103; //0,5cm
    int tagLateralGap = 5;

    int currentPositionX;
    int currentPositionY;

    private Sheet currentSheet;
    private int colorCounter;

    private static List<Integer> namesAmounts = new ArrayList<Integer>();
    private static List<String> namesList = new ArrayList<String>();

    private List<Sheet> sheets = new ArrayList<Sheet>();

    public NameGenerationController (int startingTagPosition){
        createNewSheet();

        int line = (int) startingTagPosition/5;
        int col = (int) startingTagPosition%5;

        currentPositionX = marginLeft + col*currentSheet.getTagWidthInPx()+ (col*currentSheet.getNameTagLateralGap());
        currentPositionY = marginTop + (line*currentSheet.getTagHeightInPx());

        currentSheet.setCurrentXPosition(currentPositionX);
        currentSheet.setCurrentYPosition(currentPositionY);

    }

    public void printNames(String namesText){
        populateArray(namesText);

        for(int i = 0; i < namesList.size(); i++){
            genericPrinter(namesList.get(i), namesAmounts.get(i));
        }

        addCurrentSheetToPrintList();
        saveAllSheets();
        printAllSheets();
        resetPrintList();

    }

    private void resetPrintList() {
        sheets = new ArrayList<Sheet>();
    }

    private void genericPrinter(String fullName, int amount) {
        Color color = getRandomColor();
        Tag tag = new Tag(fullName);
        for(int i = 0; i < amount; i++){
            if(currentSheet.isSheetFull()){
                addCurrentSheetToPrintList();
                createNewSheet();
            }
            currentSheet.placeNameTag (tag, color);
        }
    }

    private void addCurrentSheetToPrintList() {
        sheets.add(currentSheet);
    }

    private void saveAllSheets(){
        for(Sheet sheet: sheets){
            FileController.saveImage(sheet.getImg());
        }
    }

    public void createNewSheet(){
        currentSheet = new Sheet("Name");
    }

    public void printAllSheets(){
        for(Sheet sheet : sheets){
           PrintController.createPrintJob(sheet.getImg());
        }
    }

    public void populateArray(String namesText){

        lines = namesText.split("\\n");
        for(int i = 0; i < lines.length; i++){
            if(lines[i] != null) {
                namesList.add(lines[i].replaceAll("[0-9()]",""));
                namesAmounts.add(Integer.parseInt(lines[i].replaceAll("[^0-9]", "")));
            }
        }
    }

    public Color getRandomColor(){
        final float hue = 0.100f*colorCounter;
        final float saturation = 0.5f;//1.0 for brilliant, 0.0 for dull
        final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
        Color backGroundColor = new Color(0, 0, 0);
        backGroundColor = Color.getHSBColor(hue, saturation, luminance);

        colorCounter++;
        return backGroundColor;
  }
}
