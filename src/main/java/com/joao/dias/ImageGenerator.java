package com.joao.dias;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ImageGenerator {

    static int[] quantidadesDiaaDia = new int[15];
    static int[] quantidadesLowCarb = new int [16];
    static int[] quantidadesAcademia = new int[15];

    //Tag / Sheet measures (All in px)
    static int xoffset = 118;
    static int yoffset = 246;
    static int currentPositionX = xoffset;
    static int currentPositionY = yoffset;
    static int positionCounter = 1;
    static int tagHeight = 1630;
    static int tagWidth = 944;
    static int sheetWidth = 4960;
    static int sheetHeight = 7014;

    static BufferedImage[] DDImgs = new BufferedImage[15];
    static BufferedImage[] LCImgs = new BufferedImage[16];
    static BufferedImage[] ACImgs = new BufferedImage[15];


    static BufferedImage currentImage;
    static File currentImageFile;

    static Graphics2D graphics;
    static boolean multPage = false;

    //Load Tags from Files
    public static void LoadTagsFiles(){
        try{
            //TODO: Load From Config File
            DDImgs[1] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\1DD.png"));
            DDImgs[2] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\2DD.png"));
            DDImgs[3] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\3DD.png"));
            DDImgs[4] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\4DD.png"));
            DDImgs[5] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\5DD.png"));
            DDImgs[6] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\6DD.png"));
            DDImgs[7] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\7DD.png"));
            DDImgs[8] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\8DD.png"));
            DDImgs[9] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\9DD.png"));
            DDImgs[10] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\10DD.png"));
            DDImgs[11] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\11DD.png"));
            DDImgs[12] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\12DD.png"));
            DDImgs[13] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\13DD.png"));
            DDImgs[14] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\14DD.png"));

            LCImgs[1] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\1LC.png"));
            LCImgs[2] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\2LC.png"));
            LCImgs[3] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\3LC.png"));
            LCImgs[4] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\4LC.png"));
            LCImgs[5] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\5LC.png"));
            LCImgs[6] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\6LC.png"));
            LCImgs[7] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\7LC.png"));
            LCImgs[8] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\8LC.png"));
            LCImgs[9] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\9LC.png"));
            LCImgs[10] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\10LC.png"));
            LCImgs[11] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\11LC.png"));
            LCImgs[12] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\12LC.png"));
            LCImgs[13] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\13LC.png"));
            LCImgs[14] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\14LC.png"));
            LCImgs[15] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\15LC.png"));

            ACImgs[1] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\1AC.png"));
            ACImgs[2] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\2AC.png"));
            ACImgs[3] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\3AC.png"));
            ACImgs[4] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\4AC.png"));
            ACImgs[5] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\5AC.png"));
            ACImgs[6] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\6AC.png"));
            ACImgs[7] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\7AC.png"));
            ACImgs[8] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\8AC.png"));
            ACImgs[9] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\9AC.png"));
            ACImgs[10] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\10AC.png"));
            ACImgs[11] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\11AC.png"));
            ACImgs[12] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\12AC.png"));
            ACImgs[13] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\13AC.png"));
            ACImgs[14] = ImageIO.read(new File("C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\14AC.png"));




        } catch (Exception e){
            System.out.printf("Excepction in loadFile: %s", e.getMessage());
        }
    }

    public static void CreateNewSheet(){
        //Creates Final Image with sheets dimensions
        currentImage = new BufferedImage(sheetWidth, sheetHeight, 1);
        graphics = (Graphics2D) currentImage.createGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0, sheetWidth, sheetHeight);
        graphics.drawRect(0,0, sheetWidth, sheetHeight);

        ResetPositionCounter();

    }

    private static void ResetPositionCounter() {
        positionCounter = 1;
        currentPositionX = xoffset;
        currentPositionY = yoffset;
    }

    //Places tags on the sheet and print ValDate and LotDate
    public static void PrintTags() {

        //Place tags on the sheet for DD
        for(int i = 0; i < quantidadesDiaaDia.length; i++){
            if(quantidadesDiaaDia[i] != 0){
                for(int j = 0; j < quantidadesDiaaDia[i]; j++){
                    System.out.printf("Printed Tag - PC: %d X: %d, Y: %d\n", positionCounter, currentPositionX, currentPositionY);
                    graphics.drawImage(DDImgs[i], currentPositionX, currentPositionY, null);
                    PrintValLotDate(graphics, "DD", i);
                    IncrementPositionCounter();
                }
            }
        }
        //Place tags on the sheet for LC
        for(int i = 0; i < quantidadesLowCarb.length; i++){
            if(quantidadesLowCarb[i] != 0){
                for(int j = 0; j < quantidadesLowCarb[i]; j++){
                    System.out.printf("Printed Tag - PC: %d X: %d, Y: %d\n", positionCounter, currentPositionX, currentPositionY);
                    graphics.drawImage(LCImgs[i], currentPositionX, currentPositionY, null);
                    PrintValLotDate(graphics, "LC", i);
                    IncrementPositionCounter();
                }
            }
        }
        //Place tags on the sheet for AC
        for(int i = 0; i < quantidadesAcademia.length; i++){
            if(quantidadesAcademia[i] != 0){
                for(int j = 0; j < quantidadesAcademia[i]; j++){
                    System.out.printf("Printed Tag - PC: %d X: %d, Y: %d\n", positionCounter, currentPositionX, currentPositionY);
                    graphics.drawImage(ACImgs[i], currentPositionX, currentPositionY, null);
                    PrintValLotDate(graphics, "AC", i);
                    IncrementPositionCounter();
                }
            }
        }

        //Printed All Tags... Save Current Image and Print
        //if(!multPage){
        SaveCurrentImage();
        CreatePrintJob();
        //}
    }

    //Print ValDate and LotDate
    public static void PrintValLotDate(Graphics2D graphics, String type, int tagNumber){

        //Rotate and Setup Font
        Font font = new Font("Gill Sans", Font.BOLD, 35);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(270), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        graphics.setFont(rotatedFont);

        switch (type){
            case "DD":
                graphics.setColor(new Color (255, 89, 0));
                break;
            case "LC":
                graphics.setColor(new Color(131, 0, 232));
                break;
            case "AC":
                graphics.setColor(new Color(0, 208, 255));
                break;
        }

        //Gets valid Date and saves to DateString
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        DateFormat df = new SimpleDateFormat("MM/YY");
        String valDateString = df.format(cal.getTime());
        System.out.println(valDateString);

        //Gets Lot and save to LotString
        df = new SimpleDateFormat("dd");
        String lotString = String.format("%s%s%s", df.format(cal.getTime()), (tagNumber < 10 ? "0" : ""), Integer.toString(tagNumber));
        System.out.println(lotString);

        //Print Val Date
        graphics.drawString(valDateString, (currentPositionX+322), (currentPositionY+190));
        //Print Lot Date
        graphics.drawString(lotString, (currentPositionX+390), (currentPositionY+184));

    }

    //Saves Final Image and reset PositionCounter
    public static void SaveCurrentImage() {
        try{
            Calendar cal = Calendar.getInstance();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
            currentImageFile = new File(String.format("%s%s%s", "C:\\Users\\JD\\IdeaProjects\\TagGenerator\\src\\images\\print\\", df.format(cal.getTime()), ".png"));
            ImageIO.write(currentImage, "png", currentImageFile);

        } catch(IOException e){
            System.out.printf("Exception on CompileFinalImage: %s", e.getMessage());
        }
    }

    //Increments PositionCounter
    public static void IncrementPositionCounter(){
        //TODO: Deal With
        //Creates new Sheet
        if(positionCounter == 20){
            multPage = true;
            SaveCurrentImage();
            CreateNewSheet();
            return;
        }

        if((positionCounter) % 5 == 0 ) {
            currentPositionX = xoffset;
            currentPositionY += tagHeight;
        }else{
            currentPositionX += tagWidth;
        }

        positionCounter++;
    }

    //Create PrintJob ob and sends request to printer
    public static void CreatePrintJob(){
        PrintJob pj = new PrintJob(currentImage);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(pj);
        boolean ok = job.printDialog();
        if(ok){
            try{
                job.print();
            } catch (PrinterException e){
                System.out.printf("Exception in ImageGenerator.CreatePrintJob: %s\n", e.getMessage());
            }
        }
    }
}

