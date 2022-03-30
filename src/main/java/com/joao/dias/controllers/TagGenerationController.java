package com.joao.dias.controllers;

import com.joao.dias.utils.ColorController;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TagGenerationController {

    static public int[] amountToPrintDD = new int[15];
    static public int[] amountToPrintLC = new int [16];
    static public int[] amountToPrintAC = new int[15];
    static public int[] amountToPrintPA = new int [10];
    static public int[] amountToPrintSP = new int[11];
    static public int[] amountToPrintDC = new int[3];
    static public int[] amountToPrintSK = new int [7];

    static int xoffset = 118;
    static int yoffset = 246;
    static int elementoffsetX = 140;
    static int elementoffsetY = 1300;
    static int currentPositionX = xoffset;
    static int currentPositionY = yoffset;

    static int positionCounter = 0;

    static int tagHeight = 1630;
    static int tagWidth = 944;
    static int sheetHeight = 7014;
    static int sheetWidth = 4960;

    static int pageCounter = 0;

    static BufferedImage[] imgsToPrint = new BufferedImage[20];
    static BufferedImage currentImage;

    static Graphics2D graphics;

    static boolean needToPrintDD = false;
    static boolean needToPrintLC = false;
    static boolean needToPrintAC = false;
    static boolean needToPrintSP = false;
    static boolean needToPrintDC = false;
    static boolean needToPrintPA = false;
    static boolean needToPrintSK = false;



    public static void PrintTags() {
        if(needToPrintDD) placeTagsBase(amountToPrintDD, FileController.ImgsBaseTagDD, "DD");
        if(needToPrintLC) placeTagsBase(amountToPrintLC, FileController.ImgsBaseTagLC, "LC");
        if(needToPrintAC) placeTagsBase(amountToPrintAC, FileController.ImgsBaseTagAC, "AC");
        if(needToPrintPA) placeTagsBase(amountToPrintPA, FileController.ImgsBaseTagPA, "PA");
        if(needToPrintSP) placeTagsBase(amountToPrintSP, FileController.ImgsBaseTagSP, "SP");
        if(needToPrintDC) placeTagsBase(amountToPrintDC, FileController.ImgsBaseTagDC, "DC");
        if(needToPrintSK) placeTagsBase(amountToPrintSK, FileController.ImgsBaseTagSK, "SK");

        if(!isPageBlank()){
            addCurrentPageToPrintArray();
            FileController.saveImage(currentImage);
        }
        printPages();
    }

    public static void placeValLot(Graphics2D graphics, String type, int tagNumber){

        //Rotate and Setup Font
        Font font = new Font("Gill Sans", Font.BOLD, 35);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(270), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        graphics.setFont(rotatedFont);

        switch (type){
            case "DD":
                graphics.setColor(ColorController.DDOrange);
                break;
            case "LC":
                graphics.setColor(ColorController.LCPurple);
                break;
            case "AC":
                graphics.setColor(ColorController.ACBlue);
                break;
            case "SP":
                graphics.setColor(ColorController.SPRed);
                break;
            case "DC":
                graphics.setColor(ColorController.DCGreen);
                break;
            case "PA":
                graphics.setColor(ColorController.PAPurple);
                break;
            case "SK":
                graphics.setColor(ColorController.SKRed);
                break;

        }

        //Gets valid Date and saves to DateString
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        DateFormat df = new SimpleDateFormat("MM/YY");
        String valDateString = df.format(cal.getTime());

        //Gets Lot and save to LotString
        df = new SimpleDateFormat("dd");
        String lotString = String.format("%s%s%s", df.format(cal.getTime()), (tagNumber < 10 ? "0" : ""), Integer.toString(tagNumber));

        //Print Val Date
        if(type == "SK"){
            graphics.drawString(valDateString, (currentPositionX+336), (currentPositionY+190));
        }else graphics.drawString(valDateString, (currentPositionX+322), (currentPositionY+190));
        //Print Lot Date
        graphics.drawString(lotString, (currentPositionX+390), (currentPositionY+184));

    }

    public static void placeTagsBase(int[] printArray, BufferedImage[] imgArray, String type){
        for(int i = 0; i < printArray.length; i++){
            if(printArray[i] != 0){
               for(int j = 0; j < printArray[i]; j++){
                   IncrementPositionCounter();
                   graphics.drawImage(imgArray[i], currentPositionX, currentPositionY, null);
                   placeValLot(graphics, type, i);
                   placeTagsElements(String.format("KIBE DE FORNO RECHEADO COM\nRICOTA E COBERTURA DE CASTANHAS"), graphics, type, "Title");
                   placeTagsElements(String.format("KIBE RECHEADO COM RICOTA E COBERTO DE\nCASTANHAS, LEGUMES REFOGADOS,\nARROZ COLORIDO."), graphics, type, "Description");
                   placeTagsElements(String.format("01"), graphics, type, "Number");
                   if(needNewPage()){
                       addCurrentPageToPrintArray();
                       FileController.saveImage(currentImage);
                       createNewPage();
                   }
               }
            }
        }
        System.out.printf("Placed Tags for Type %s\n", type);
    }

    public static void placeTagsElements (String title, Graphics2D graphics, String type, String position){
        int lineHeight = 0;
        int lineHeightIncrement = 0;

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(270), 0, 0);
        Font rotatedFont = FileController.poppins.deriveFont(affineTransform);
        Font resizedFont = rotatedFont;

        switch (position){
            case "Title":
                graphics.setColor(Color.WHITE);
                lineHeightIncrement = 65;
                resizedFont = rotatedFont.deriveFont(58.0f);
                elementoffsetX = 140;
                elementoffsetY = 1300;
                break;
            case "Description":
                if(type == "DD") graphics.setColor(ColorController.DDOrange);
                lineHeightIncrement = 50;
                resizedFont = rotatedFont.deriveFont(45.0f);
                elementoffsetX = 335;
                elementoffsetY = 1500;
                break;
            case "Number":
                graphics.setColor(Color.WHITE);
                resizedFont = rotatedFont.deriveFont(100f);
                elementoffsetX = 165;
                elementoffsetY = 1480;

        }

        graphics.setFont(resizedFont);

        for(String line: title.split("\n")) {
            System.out.println(line);
            graphics.drawString(line, currentPositionX + elementoffsetX + lineHeight, currentPositionY + elementoffsetY);
            lineHeight += lineHeightIncrement;
        }

    }

    private static void printPages() {
        for(int i = 0; i <= pageCounter; i++){
            if(imgsToPrint[i] != null) {
                PrintController.CreatePrintJob(imgsToPrint[i]);
                System.out.printf("Created PrintJob %d\n", i);
            }
        }
        pageCounter = 0;
    }

    private static boolean needNewPage() {
        if(positionCounter == 20){
            return true;
        }
        return false;
    }

    private static boolean isPageBlank(){
        if(positionCounter == 0 || positionCounter == 20){
            return true;
        }
        return false;
    }

    private static void addCurrentPageToPrintArray(){
        imgsToPrint[pageCounter] = currentImage;
        System.out.println("Added page to print array");
    }

    public static void createNewPage(){
        pageCounter++;

        //Creates Final Image with sheets dimensions
        currentImage = new BufferedImage(sheetWidth, sheetHeight, 1);
        graphics = (Graphics2D) currentImage.createGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0, sheetWidth, sheetHeight);
        graphics.drawRect(0,0, sheetWidth, sheetHeight);

        ResetPositionCounter();

    }

    private static void ResetPositionCounter() {
        positionCounter = 0;
        currentPositionX = xoffset;
        currentPositionY = yoffset;
    }

    public static void IncrementPositionCounter(){
        if((positionCounter) % 5 == 0 && positionCounter != 0 ) {
            currentPositionX = xoffset;
            currentPositionY += tagHeight;
        }else if (positionCounter != 0){
            currentPositionX += tagWidth;
        }
        positionCounter++;
    }

    public static void setNeedToPrintDD(boolean needToPrintDD) {
        TagGenerationController.needToPrintDD = needToPrintDD;
    }

    public static void setNeedToPrintLC(boolean needToPrintLC) {
        TagGenerationController.needToPrintLC = needToPrintLC;
    }

    public static void setNeedToPrintAC(boolean needToPrintAC) {
        TagGenerationController.needToPrintAC = needToPrintAC;
    }

    public static void setNeedToPrintSP(boolean needToPrintSP) {
        TagGenerationController.needToPrintSP = needToPrintSP;
    }

    public static void setNeedToPrintDC(boolean needToPrintDC) {
        TagGenerationController.needToPrintDC = needToPrintDC;
    }

    public static void setNeedToPrintPA(boolean needToPrintPA) {
        TagGenerationController.needToPrintPA = needToPrintPA;
    }

    public static void setNeedToPrintSK(boolean needToPrintSK) {
        TagGenerationController.needToPrintSK = needToPrintSK;
    }

    public static void reset(){
        imgsToPrint = new BufferedImage[20];
        for(int i = 0; i < amountToPrintAC.length; i++){
            amountToPrintAC[i] = 0;
        }
        for(int i = 0; i < amountToPrintDC.length; i++){
            amountToPrintDC[i] = 0;
        }
        for(int i = 0; i < amountToPrintDD.length; i++){
            amountToPrintDD[i] = 0;
        }
        for(int i = 0; i < amountToPrintLC.length; i++){
            amountToPrintLC[i] = 0;
        }
        for(int i = 0; i < amountToPrintPA.length; i++){
            amountToPrintPA[i] = 0;
        }
        for(int i = 0; i < amountToPrintSK.length; i++){
            amountToPrintSK[i] = 0;
        }
        for(int i = 0; i < amountToPrintSP.length; i++){
            amountToPrintSP[i] = 0;
        }
        AlertController.createConfirmationDialog("Restaurado com Sucesso", "Todos dados foram restaurados");
    }
}

