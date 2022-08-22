package com.joao.dias.models;

import com.joao.dias.controllers.AlertController;
import com.joao.dias.controllers.FileController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sheet {
    private int sheetHeightInPx;
    private int sheetWidthInPx;

    private int currentXPosition;
    private int currentYPosition;

    private final int titleOffsetX = 140;
    private final int titleOffsetY = 1300;
    private final int descriptionOffsetX = 335;
    private final int descriptionOffsetY = 1500;
    private final int numberOffsetX = 165;
    private final int numberOffsetY = 1500;
    private final int KCalOffsetX = 450;
    private final int KcalOffsetY = 400;
    private final int valOffSetX = 323;
    private final int valOffSetY = 210;
    private final int lotOffSetX = 385;
    private final int lotOffSetY = 290;
    private final int nameTagLateralGap = 5;

    private int tagWidthInPx;
    private int tagHeightInPx;

    private BufferedImage img;

    private boolean isSheetFull = false;

/*
    public Sheet(int sheetHeightInPx, int sheetWidthInPx, int startingXPosition, int startingYPosition){
        this.sheetHeightInPx = sheetHeightInPx;
        this.sheetWidthInPx = sheetWidthInPx;
        this.currentXPosition = startingXPosition;
        this.currentYPosition = startingYPosition;
        createNewSheet();

    }
*/

    //sheetType: Tag or Name
    //This constructor automatically sets sheet specs depending on its purpose
    public Sheet(String sheetType){
        switch (sheetType){
            case "Tag":
                sheetHeightInPx = 7014;
                sheetWidthInPx = 4960;
                currentXPosition = 118;
                currentYPosition = 246;
                tagHeightInPx = 1630;
                tagWidthInPx = 940;
                break;
            case "Name":
                sheetHeightInPx = 7014;
                sheetWidthInPx = 4867;
                currentXPosition = 103; //1cm
                currentYPosition = 151; //0.5cm
                tagHeightInPx = 516;
                tagWidthInPx = 930;
                break;
        }
        createNewSheet();
    }

    public void placeTagOnSheet(Tag tag){
        Graphics2D graphics2D = (Graphics2D) img.getGraphics();

        placeTagBase (tag, graphics2D);
        placeTagTitle(tag, graphics2D);
        placeTagDescription(tag, graphics2D);
        placeTagNumber(tag, graphics2D);
        placeTagKCal(tag, graphics2D);
        placeTagVal(tag, graphics2D);
        placeTagLot(tag, graphics2D);
        incrementTagPosition();
    }

    private void incrementTagPosition() {
        //Sheet is of type tag
        if(sheetWidthInPx == 4960) {
            System.out.println("Sheet is of type Tag!");
            if(currentXPosition != tagWidthInPx*4+118) {
                System.out.println("Incremented Position to the Right");
                currentXPosition += tagWidthInPx;
            } else {
                System.out.println("Incremented Position to the Left");
                currentXPosition = 118;
                currentYPosition+= tagHeightInPx;
            }
            if(currentYPosition > 5136){
                isSheetFull = true;
            }
        }

        //Sheet is of type name
        if(sheetWidthInPx == 4867){
            if(currentXPosition != (tagWidthInPx*4)+(nameTagLateralGap*4)+103){
                currentXPosition+=(tagWidthInPx+nameTagLateralGap);
            } else{
                currentXPosition = 103;
                currentYPosition+=tagHeightInPx;
                System.out.println(currentYPosition);
            }
            if(currentYPosition > 6343){
                isSheetFull = true;
            }
        }

    }

    public void placeTagBase (Tag tag, Graphics2D graphics2D){
        try {
            Image tagBase = ImageIO.read(new File(tag.getTagBaseImgPath()));
            graphics2D.drawImage(tagBase, currentXPosition, currentYPosition, null);
        } catch (IOException e){
            AlertController.createErrorDialog(e.getMessage(), e.getStackTrace().toString());
        }
    }

    public void placeTagTitle(Tag tag, Graphics2D graphics2D){
        int lineHeightIncrement = 65;
        int lineHeigth = 0;
        Font font = FileController.getRotatedPoppins().deriveFont(58.0f);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.WHITE);

        for (String line : tag.getTagTitle().split("\n")) {
            graphics2D.drawString(line, currentXPosition + titleOffsetX + lineHeigth, currentYPosition + titleOffsetY);
            lineHeigth += lineHeightIncrement;
        }
    }

    public void placeTagDescription(Tag tag, Graphics2D graphics2D){
        int lineHeightIncrement = 50;
        int lineHeigth = 0;
        Font font = FileController.getRotatedPoppins().deriveFont(45.0f);
        graphics2D.setFont(font);
        graphics2D.setColor(tag.getTagColor());

        for (String line : tag.getTagDescription().split("\n")) {
            graphics2D.drawString(line, currentXPosition + descriptionOffsetX + lineHeigth, currentYPosition + descriptionOffsetY);
            lineHeigth += lineHeightIncrement;
        }
    }

    public void placeTagNumber (Tag tag, Graphics2D graphics2D){
        Font font = FileController.getRotatedPoppins().deriveFont(100f);
        graphics2D.setFont(font);
        graphics2D.setColor(Color.WHITE);
        if(tag.getTagNumber() >= 10)
            graphics2D.drawString(String.format("%02d", tag.getTagNumber()), currentXPosition + numberOffsetX, currentYPosition + numberOffsetY - 20);
        else graphics2D.drawString(String.format("%02d", tag.getTagNumber()), currentXPosition + numberOffsetX, currentYPosition + numberOffsetY);
    }

    public void placeTagKCal (Tag tag, Graphics2D graphics2D){
        Font font = FileController.getRotatedPoppins().deriveFont(35f);
        graphics2D.setFont(font);
        graphics2D.setColor(tag.getTagColor());
        graphics2D.drawString(String.format("%02d", tag.getTagKCal()), currentXPosition + KCalOffsetX, currentYPosition + KcalOffsetY);
    }

    public void placeTagVal (Tag tag, Graphics2D graphics2D){
        Font font = FileController.getRotatedPoppins().deriveFont(35f);
        graphics2D.setFont(font);
        graphics2D.setColor(tag.getTagColor());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        DateFormat df = new SimpleDateFormat("MM/YY");
        String val = df.format(cal.getTime());

        graphics2D.drawString(val, currentXPosition + valOffSetX, currentYPosition + valOffSetY);
    }

    public void placeTagLot (Tag tag, Graphics2D graphics2D){
        Font font = FileController.getRotatedPoppins().deriveFont(35f);
        graphics2D.setFont(font);
        graphics2D.setColor(tag.getTagColor());

        DateFormat df = new SimpleDateFormat("MMYYdd");
        String lot = String.format("%03d%s", tag.getId(), df.format(Calendar.getInstance().getTime()));
        graphics2D.drawString(lot, currentXPosition + lotOffSetX, currentYPosition + lotOffSetY);
    }

    public void placeNameTag (Tag tag, Color color, int counter){
        Graphics2D graphics2D = (Graphics2D) img.getGraphics();
        graphics2D.setFont(FileController.getPoppins());
        FontMetrics metrics = graphics2D.getFontMetrics(FileController.getPoppins());
        Rectangle rect = new Rectangle(currentXPosition, currentYPosition, 930, 516);

        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(rect.x, rect.y, rect.width, rect.height);
        int lineHeight = metrics.getHeight();
        int lineNumber = 0;

        graphics2D.setColor(color);
        for(String line : tag.getName().split("/")){
            System.out.println(line);
            int x = rect.x + (rect.width - metrics.stringWidth(line)) / 2;
            int y = rect.y + ((rect.height - metrics.getHeight()) / 3) + metrics.getAscent();
            graphics2D.drawString(line, x, y + (lineHeight * lineNumber));
            lineNumber++;
        }

        String bagCounter = String.format("%d/%d", (counter+1), tag.getAmountToPrint());
        int x = rect.x + (rect.width - metrics.stringWidth(bagCounter)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 3) + metrics.getAscent();
        graphics2D.drawString(bagCounter, x, y + (lineHeight * lineNumber));
        incrementTagPosition();

    }

    public boolean isSheetFull(){
        return isSheetFull;
    }

    void createNewSheet(){
        img = new BufferedImage(sheetWidthInPx, sheetHeightInPx, 1);
        Graphics2D graphics2D = (Graphics2D) img.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0, sheetWidthInPx, sheetHeightInPx);
        graphics2D.drawRect(0,0, sheetWidthInPx, sheetHeightInPx);
    }

    public BufferedImage getImg(){
        return img;
    }

    public int getTagWidthInPx() {
        return tagWidthInPx;
    }

    public int getTagHeightInPx(){
        return tagHeightInPx;
    }

    public int getNameTagLateralGap(){
        return nameTagLateralGap;
    }

    public void setCurrentXPosition(int currentXPosition){
       this.currentXPosition = currentXPosition;
    }

    public void setCurrentYPosition(int currentYPosition){
        this.currentYPosition = currentYPosition;
    }
}
