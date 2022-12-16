package com.joao.dias.controllers;

import com.joao.dias.utils.PrintJob;

import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;

public class PrintController {

    public static void createPrintJob(BufferedImage imgToPrint){
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            if (job.printDialog()){
                PageFormat pf = job.defaultPage();
                Paper paper = pf.getPaper();
                double width = 3.9*72;
                double height = 2.7*72;
                paper.setSize(width, height);
                paper.setImageableArea(0,0,width, height);
                pf.setOrientation(PageFormat.LANDSCAPE);
                pf.setPaper(paper);

                Book pBook = new Book();
                pBook.append(new PrintJob(imgToPrint), pf);
                job.setPageable(pBook);
                job.print();

            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
