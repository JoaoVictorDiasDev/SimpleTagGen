package com.joao.dias.controllers;

import com.joao.dias.models.Sheet;
import com.joao.dias.models.Tag;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameGenerationController {

    int tagHeight = 516; //2cm
    int tagWidth = 930; //4cm
    int marginTop = 151; //1cm
    int marginLeft = 103; //0,5cm
    int tagLateralGap = 5;

    int currentPositionX;
    int currentPositionY;

    private Sheet currentSheet;
    private int colorCounter;

    private List<Tag> tagsToPrint = new ArrayList<>();
    private List<Sheet> sheets = new ArrayList<Sheet>();

    public NameGenerationController (int startingTagPosition){
        createNewSheet();

        int line = startingTagPosition/5;
        int col = startingTagPosition%5;

        currentPositionX = marginLeft + col*currentSheet.getTagWidthInPx()+ (col*currentSheet.getNameTagLateralGap());
        currentPositionY = marginTop + (line*currentSheet.getTagHeightInPx());

        currentSheet.setCurrentXPosition(currentPositionX);
        currentSheet.setCurrentYPosition(currentPositionY);

    }

    public void printNames(String namesText){
        populateTagsToPrint(namesText);

        for(int i = 0; i < tagsToPrint.size(); i++){
            genericPrinter(tagsToPrint.get(i));
        }

        addCurrentSheetToPrintList();
        //saveAllSheets();
        printAllSheets();
        resetPrintList();
        resetTagList();

    }

    private void resetPrintList() {
        sheets.clear();
    }

    private void resetTagList(){
        tagsToPrint.clear();
    }

    private void genericPrinter(Tag tagToPrint) {
        Color color = getRandomColor();
        for(int counter = 0; counter < tagToPrint.getAmountToPrint(); counter++){
            if(currentSheet.isSheetFull()){
                addCurrentSheetToPrintList();
                createNewSheet();
            }
            currentSheet.placeNameTag (tagToPrint, color, counter);
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

    public void populateTagsToPrint(String namesText){
        String [] lines = namesText.split("\\n");
        for(int i = 0; i < lines.length; i++){
            if(lines[i] != null) {
                String fullName = lines[i].replaceAll("[0-9()]", "");
                String name = fullName.split(" ")[0] + " " + fullName.split(" ")[1].charAt(0) + ".";
                int amount = Integer.parseInt(lines[i].replaceAll("[^0-9]", ""));
                System.out.printf("Creating new tag with name: %s, amount: %d", name, amount);
                Tag tag = new Tag(name, amount);
                tagsToPrint.add(tag);
            }
        }
    }

    public Color getRandomColor(){
        final float hue = 0.200f*colorCounter;
        final float saturation = 0.7f;//1.0 for brilliant, 0.0 for dull
        final float luminance = 0.9f; //1.0 for brighter, 0.0 for black
        Color backGroundColor = Color.getHSBColor(hue, saturation, luminance);

        colorCounter++;
        return backGroundColor;
  }
}
