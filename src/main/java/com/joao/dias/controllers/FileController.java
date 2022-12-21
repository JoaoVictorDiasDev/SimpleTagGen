package com.joao.dias.controllers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileController {

    static final String savePath = "src/images/Print/";

    private static Font poppins;

    @SuppressWarnings("ConstantConditions")
    public void loadFont(){
        try{
            poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Poppins-Black.ttf"));
            poppins = poppins.deriveFont(80f);

        } catch(Exception e){
            System.out.println("Exception in placeTagsTitle: " + e.getMessage());
        }
    }

    public static void saveImage(BufferedImage imgToSave){
        Calendar cal = Calendar.getInstance();
        DateFormat dfDate = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat dfTime = new SimpleDateFormat("hh-mm-ss");
        File saveFile = new File(String.format("%s%s%s", savePath, String.format("Date(%s), Time(%s)", dfDate.format(cal.getTime()), dfTime.format(cal.getTime())), ".png"));

        try{
            ImageIO.write(imgToSave, "png", saveFile);
        } catch(IOException e){
            System.out.printf("Exception on SaveCurrentPage: %s\n- Couldn't save file", e.getMessage());
        }
    }

    public static Font getPoppins (){
        return poppins;
    }

    public static Font getRotatedPoppins(){
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(270), 0,0);

        return poppins.deriveFont(affineTransform);
    }


}
