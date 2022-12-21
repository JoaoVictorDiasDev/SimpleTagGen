package com.joao.dias.controllers;

import com.joao.dias.models.Sheet;
import com.joao.dias.models.Tag;
import com.joao.dias.utils.PrintRequest;


public class TagGenerationController {

    static Sheet currentSheet;

    public static void PrintTags(PrintRequest printRequest) {
        createNewSheet();

        //TODO: SET NEEDTOPRINT TRUE WHEN NEEDED
        for(PrintRequest.PrintData data : printRequest.getPrintList()) {
            genericPrinter(data.getId(), data.getCopies());
        }
    }

    private static void genericPrinter(String id, int copies){
            Tag tag = new Tag(id);
            currentSheet.placeTagOnSheet(tag);
            PrintController.createPrintJob(currentSheet.getSheetImg(), copies);
    }

    private static void createNewSheet() {
        currentSheet = new Sheet("Tag");
    }

}

