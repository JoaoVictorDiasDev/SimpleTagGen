package com.joao.dias.utils;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

public class PrintJob implements Printable{
    BufferedImage printImage;
    public PrintJob(BufferedImage printImage){
        this.printImage = printImage;
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
        if(pageIndex >= 1) return Printable.NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

        double pageWidth = pageFormat.getImageableWidth();
        double pageHeight = pageFormat.getImageableHeight();
        double imageWidth = printImage.getWidth();
        double imageHeight = printImage.getHeight();
        double scaleX = pageWidth / imageWidth;
        double scaleY = pageHeight / imageHeight;
        double scaleFactor = Math.min(scaleX, scaleY);
        g2d.scale(0.24, 0.25);
        g.drawImage(printImage, 0, 20, null);


        return Printable.PAGE_EXISTS;
    }
}
