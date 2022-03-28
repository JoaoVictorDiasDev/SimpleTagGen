package com.joao.dias.controllers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class FileController {
    static BufferedImage[] ImgsBaseTagDD = new BufferedImage[15];
    static BufferedImage[] ImgsBaseTagLC = new BufferedImage[16];
    static BufferedImage[] ImgsBaseTagAC = new BufferedImage[15];
    static BufferedImage[] ImgsBaseTagSP = new BufferedImage[11];
    static BufferedImage[] ImgsBaseTagDC = new BufferedImage[3];
    static BufferedImage[] ImgsBaseTagSK = new BufferedImage[7];
    static BufferedImage[] ImgsBaseTagPA = new BufferedImage[10];

    static String ACPath;
    static String DCPath;
    static String DDPath;
    static String LCPath;
    static String PAPath;
    static String SPPath;
    static String SKPath;

    static String savePath;


    static Font poppins;
    static File configFile;

    public static void loadPaths(){
        configFile = new File ("src/main/resources/com/joao/dias/configFile.txt");
        try{
            Scanner sc = new Scanner(configFile);
            if(sc.nextLine().equals("Path AC")) ACPath = sc.nextLine();
            if(sc.nextLine().equals("Path DC")) DCPath = sc.nextLine();
            if(sc.nextLine().equals("Path DD")) DDPath = sc.nextLine();
            if(sc.nextLine().equals("Path LC")) LCPath = sc.nextLine();
            if(sc.nextLine().equals("Path PA")) PAPath = sc.nextLine();
            if(sc.nextLine().equals("Path SK")) SKPath = sc.nextLine();
            if(sc.nextLine().equals("Path SP")) SPPath = sc.nextLine();
            if(sc.nextLine().equals("Save Path")) savePath = sc.nextLine();
        } catch(Exception e){
            System.out.println("Exception in loadPaths: " + e.getMessage());
        }
    }

    public static void loadTagsBase (){
        try{


            for(int i = 1; i <= ImgsBaseTagAC.length-1; i++){
                ImgsBaseTagAC[i] = ImageIO.read(new File(String.format("%s%dAC.png", ACPath, i)));
            }

            for(int i = 1; i <= ImgsBaseTagDC.length-1; i++){
                ImgsBaseTagDC[i] = ImageIO.read(new File(String.format("%s%dDC.png", DCPath, i)));
            }
            for(int i = 1; i <= ImgsBaseTagDD.length-1; i++){
                ImgsBaseTagDD[i] = ImageIO.read(new File(String.format("%s%dDD.png", DDPath, i)));
            }
            for(int i = 1; i <= ImgsBaseTagLC.length-1; i++){
                ImgsBaseTagLC[i] = ImageIO.read(new File(String.format("%s%dLC.png", LCPath, i)));
            }
            for(int i = 1; i <= ImgsBaseTagPA.length-1; i++){
                ImgsBaseTagPA[i] = ImageIO.read(new File(String.format("%s%dPA.png", PAPath, i)));
            }
            for(int i = 1; i <= ImgsBaseTagSK.length-1; i++){
                ImgsBaseTagSK[i] = ImageIO.read(new File(String.format("%s%dSK.png", SKPath, i)));
            }
            for(int i = 1; i <= ImgsBaseTagSP.length-1; i++){
                ImgsBaseTagSP[i] = ImageIO.read(new File(String.format("%s%dSP.png", SPPath, i)));
            }


        } catch (Exception e){
            System.out.printf("Excepction in loadTagsBase: %s", e.getMessage());
        }
    }

    public static void loadFont(){
        try{
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\joaov\\AppData\\Local\\Microsoft\\Windows\\Fonts\\Poppins-Black.ttf")).deriveFont(80f);
            System.out.println(poppins.getFamily());
        } catch(Exception e){
            System.out.println("Exception in placeTagsTitle: " + e.getMessage());
        }
    }

    public static void saveImage(BufferedImage imgToSave){
        Calendar cal = Calendar.getInstance();
        DateFormat dfDate = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat dfTime = new SimpleDateFormat("hh-mm-ss");
        File saveFile = new File(String.format("%s%s%s", savePath, String.format("Date(%s), Time(%s)", dfDate.format(cal.getTime()), dfTime.format(cal.getTime())), ".png"));;

        try{
            ImageIO.write(imgToSave, "png", saveFile);
        } catch(IOException e){
            System.out.printf("Exception on SaveCurrentPage: %s\n- Couldn't save file", e.getMessage());
        }
    }


}
