package com.joao.dias.controllers;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class NameGenerationController {
    static int totalAmountOfNames = 0;
    static int totalAmountOfPages = 0;
    static String[] lines;
    static String[] names =  new String[20];
    static int[] amounts = new int[20];

    static BufferedImage currentImage;
    static BufferedImage[] printArray = new BufferedImage[5];

    static int sheetWidth = 4867;
    static int sheetHeight = 7014;
    static int tagHeight = 516; //2cm
    static int tagWidth = 930; //4cm
    static int marginTop = 151; //1cm
    static int marginLeft = 103; //0,5cm
    static int tagLateralGap = 5;

    static int currentPositionX = marginLeft;
    static int currentPositionY = marginTop;

    static int pageCounter = 0;
    static String namesText;

    public static void printNames(String namesText){
        populateArray(namesText);
        createNewPage();

        for(int i = 0; i < totalAmountOfNames; i++) {
            Color backGroundColor = getRandomColor(i);
            for(int j = 0; amounts[i] > 0; j++){
                System.out.println("Printed Names");
                placeName(names[i], backGroundColor);
                amounts[i]--;
                incrementPositionCounter();
                if(needNewPage()) {
                    System.out.println("Need New Page");
                    addPageToPrintArray(currentImage);
                    createNewPage();
                }

            }
        }

        addPageToPrintArray(currentImage);
        System.out.println("Printed All Names Successfully");
        printAllPages();
    }

    public static void placeName (String name, Color backGroundColor){
        Graphics2D graphics = (Graphics2D) currentImage.getGraphics();
        graphics.setFont(FileController.poppins);
        FontMetrics metrics = graphics.getFontMetrics(FileController.poppins);

        graphics.setColor(backGroundColor);
        Rectangle rect = new Rectangle(currentPositionX,currentPositionY, tagWidth, tagHeight);
        graphics.fillRect(rect.x, rect.y, rect.width, rect.height);

        graphics.setColor(Color.black);
        graphics.drawRect(rect.x, rect.y, rect.width, rect.height);

        graphics.setColor(Color.BLACK);
        int lineHeight = metrics.getHeight();
        int lineNumber = 0;

        for(String line : name.split("/")) {
            int x = rect.x + (rect.width - metrics.stringWidth(line)) / 2;
            int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
            graphics.drawString(line, x, y + (lineHeight*lineNumber));
            lineNumber++;
        }
    }

    public static void incrementPositionCounter(){
        if(currentPositionX == (tagWidth*4)+(tagLateralGap*4)+marginLeft){
            currentPositionX = marginLeft;
            currentPositionY+=tagHeight;
        } else{
            currentPositionX+=(tagWidth+tagLateralGap);
        }
    }

    public static void resetPositionCounter(){
        currentPositionX = marginLeft;
        currentPositionY = marginTop;
    }

    public static void createNewPage(){
        System.out.println("Created new Page");
        resetPositionCounter();
        currentImage = new BufferedImage(sheetWidth, sheetHeight, 1);
        Graphics2D graphics = (Graphics2D) currentImage.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0, sheetWidth, sheetHeight);
        graphics.drawRect(0,0, sheetWidth, sheetHeight);
        totalAmountOfPages++;
    }

    public static boolean needNewPage(){
        if(currentPositionY == ((tagHeight*12) + marginTop) && currentPositionX == ((tagWidth*5) + (tagLateralGap*5) + marginLeft)){
            return true;
        }  else return false;
    }

    public static void populateArray(String namesText){

        lines = namesText.split("\\n");
        totalAmountOfNames = lines.length;
        for(int i = 0; i < lines.length; i++){
            if(lines[i] != null) {
                names[i] = lines[i].replaceAll("[0-9()]","");
                amounts[i] = Integer.parseInt(lines[i].replaceAll("[^0-9]", ""));
            }
        }
    }

    public static Color getRandomColor(int i){
        Random random = new Random();
        final float hue = 0.100f*i;
        final float saturation = 0.5f;//1.0 for brilliant, 0.0 for dull
        final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
        Color backGroundColor = new Color(0, 0, 0);
        backGroundColor = Color.getHSBColor(hue, saturation, luminance);

        return backGroundColor;
  }

    public static void addPageToPrintArray(BufferedImage img){
       printArray[pageCounter] = img;
       pageCounter++;
    }

    public static void printAllPages(){
        for(int i = 0; i < totalAmountOfPages; i++){
            if(printArray[i] != null) {
                System.out.println("Printed Page: " + i);
                PrintController.CreatePrintJob(printArray[i]);
                FileController.saveImage(printArray[i]);
            }
        }
    }
     
}
