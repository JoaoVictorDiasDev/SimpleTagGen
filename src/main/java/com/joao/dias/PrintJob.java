package com.joao.dias;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintJob implements Printable{
    BufferedImage printImage;
    public PrintJob(BufferedImage printImage){
        this.printImage = printImage;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
        try{
            graphics.drawImage(printImage, 0, 0, 595, 842, null);
        } catch (Exception e ){
            System.out.printf("Exception in PrinterJob.print: %s\n", e.getMessage());
        }
        return PAGE_EXISTS;
    }
}
