package com.joao.dias.controllers;

import com.joao.dias.utils.PrintJob;

import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.Graphics;

public class PrintController {

    public static void createPrintJob(BufferedImage imgToPrint){
        try {
            Graphics graphics =  imgToPrint.getGraphics();
            PageFormat pageFormat = new PageFormat();
            PrintJob pj = new PrintJob(imgToPrint, graphics, pageFormat, 0);
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(pj);
            job.printDialog();
            job.print();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
