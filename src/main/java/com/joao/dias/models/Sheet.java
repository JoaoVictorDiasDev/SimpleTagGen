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

    private final int nameTagLateralGap = 5;

    private int tagWidthInPx;
    private int tagHeightInPx;

    private BufferedImage sheetImg;

    private boolean isSheetFull = false;


    //sheetType: Tag or Name
    //This constructor automatically sets sheet specs depending on its purpose
    public Sheet(String sheetType){
        switch (sheetType){
            case "Tag":
                sheetHeightInPx = 1654;
                sheetWidthInPx = 2362;
                currentXPosition = 0;
                currentYPosition = 0;
                tagHeightInPx = 1654;
                tagWidthInPx = 2362;
                break;
            case "Name":
                sheetHeightInPx = 7014;
                sheetWidthInPx = 4867;
                currentXPosition = 103; //1 cm
                currentYPosition = 151; //0.5 cm
                tagHeightInPx = 516;
                tagWidthInPx = 930;
                break;
        }
        createNewSheet();
    }

    public void placeTagOnSheet(Tag tag){
        Graphics2D graphics2D = (Graphics2D) sheetImg.getGraphics();

        placeTagBase(tag, graphics2D);
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
            graphics2D.drawImage(tagBase, 0, 0, null);
        } catch (IOException e){
            AlertController.createErrorDialog(e.getMessage(), e.getMessage());
        }
    }


    public void placeTagVal (Tag tag, Graphics2D graphics2D){
        Font font = FileController.getRotatedPoppins().deriveFont(35f);
        graphics2D.setFont(font);
        graphics2D.setColor(tag.getTagColor());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        DateFormat df = new SimpleDateFormat("MM/yy");
        String val = df.format(cal.getTime());

        int valOffSetX = 0;
        int valOffSetY = 0;
        graphics2D.drawString(val, currentXPosition + valOffSetX, currentYPosition + valOffSetY);
    }

    public void placeTagLot (Tag tag, Graphics2D graphics2D){
        Font font = FileController.getRotatedPoppins().deriveFont(35f);
        graphics2D.setFont(font);
        graphics2D.setColor(tag.getTagColor());

        DateFormat df = new SimpleDateFormat("MMyydd");
        //TODO: FIX LOT FORMATING FOR NEW TAG ID
        String lot = String.format("%s%s", tag.getId(), df.format(Calendar.getInstance().getTime()));
        int lotOffSetX = 0;
        int lotOffSetY = 0;
        graphics2D.drawString(lot, currentXPosition + lotOffSetX, currentYPosition + lotOffSetY);
    }

    public void placeNameTag (Tag tag, Color color, int counter){
        FileController fc = new FileController();
        fc.loadFont();

        Graphics2D graphics2D = (Graphics2D) sheetImg.getGraphics();
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
        sheetImg = new BufferedImage(sheetWidthInPx, sheetHeightInPx, 1);
        Graphics2D graphics2D = sheetImg.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0, sheetWidthInPx, sheetHeightInPx);
        graphics2D.drawRect(0,0, sheetWidthInPx, sheetHeightInPx);
    }

    public BufferedImage getSheetImg(){
        return sheetImg;
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
