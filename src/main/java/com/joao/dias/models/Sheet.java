package com.joao.dias.models;

import com.joao.dias.controllers.FileController;
import com.joao.dias.controllers.PrintController;
import com.joao.dias.utils.ColorController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.spi.CalendarDataProvider;

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
    private final int numberOffsetY = 1480;
    private final int KCalOffsetX = 450;
    private final int KcalOffsetY = 420;
    private final int valOffSetX = 322;
    private final int valOffSetY = 210;
    private final int lotOffSetX = 390;
    private final int lotOffSetY = 290;

    private BufferedImage img;

    public Sheet(int sheetHeightInPx, int sheetWidthInPx, int startingXPosition, int startingYPosition){
        this.sheetHeightInPx = sheetHeightInPx;
        this.sheetWidthInPx = sheetWidthInPx;
        this.currentXPosition = startingXPosition;
        this.currentYPosition = startingYPosition;
        createNewSheet();

    }

    //sheetType: Tag or Name
    //This constructor automatically sets sheet specs depending on its purpose
    public Sheet(String sheetType){
        switch (sheetType){
            case "Tag":
                sheetHeightInPx = 7014;
                sheetWidthInPx = 4960;
                currentXPosition = 118;
                currentYPosition = 246;
                break;
        }
        createNewSheet();

    }
    public void placeTagOnSheet(Tag tag){
        try{
            Graphics2D graphics2D = (Graphics2D) img.getGraphics();
            Image tagBase = ImageIO.read(new File(tag.getTagBaseImgPath()));
            graphics2D.drawImage(tagBase, currentXPosition, currentYPosition, null);

            placeTagTitle(tag, graphics2D);
            placeTagDescription(tag, graphics2D);
            placeTagNumber(tag, graphics2D);
            placeTagKCal(tag, graphics2D);
            placeTagVal(tag, graphics2D);
            placeTagLot(tag, graphics2D);

            FileController.saveImage(img);
            System.out.println("Successfully");

        } catch (IOException e) {
            System.out.println("Erro ao tentar carregar imagem em placeTagOnSheet: " + e.getMessage());
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
        graphics2D.drawString(String.format("%02d", tag.getTagNumber()), currentXPosition + numberOffsetX, currentYPosition + numberOffsetY);
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

    public boolean isSheetFull(){
        return false;
    }

    void createNewSheet(){
        img = new BufferedImage(sheetWidthInPx, sheetHeightInPx, 1);
        Graphics2D graphics2D = (Graphics2D) img.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0, sheetWidthInPx, sheetHeightInPx);
        graphics2D.drawRect(0,0, sheetWidthInPx, sheetHeightInPx);
    }
}
