package com.joao.dias.controllers;

import com.joao.dias.models.Sheet;
import com.joao.dias.models.Tag;
import com.joao.dias.utils.PrintRequest;

import java.util.List;
import java.util.LinkedList;

public class TagGenerationController {

    static Sheet currentSheet;
    private static List<Sheet> sheets = new LinkedList<>();

    public static void PrintTags(PrintRequest printRequest) {
        createNewSheet();

        //TODO: SET NEEDTOPRINT TRUE WHEN NEEDED
        for(PrintRequest.PrintData data : printRequest.getPrintList()) {
            genericPrinter(data.getId(), data.getCopies());
        }

        addCurrentSheetToPrintList();
        resetPrintList();
    }

    private static void resetPrintList() {
        sheets = new LinkedList<>();
    }

    private static void genericPrinter(String id, int copies){
            Tag tag = new Tag(id);
            currentSheet.placeTagOnSheet(tag);
            PrintController.createPrintJob(currentSheet.getSheetImg(), copies);
    }

    private static void createNewSheet() {
        currentSheet = new Sheet("Tag");
    }

    private static void addCurrentSheetToPrintList() {
        sheets.add(currentSheet);
    }

    private static void saveAllSheets(){
        for(Sheet sheet : sheets){
            FileController.saveImage(sheet.getSheetImg());
        }
    }
}

