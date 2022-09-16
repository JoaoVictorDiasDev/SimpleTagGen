package com.joao.dias.repositories;

import com.joao.dias.models.Tag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class tagInfoRepository {
    public String genericStringFinder(double id, int col) {
        try{
            File file = new File ("src/data/data.xlsx").getAbsoluteFile();

            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            for(Row row : sheet){
                Cell firstCell = row.getCell(0);
                if(firstCell.getCellType() == CellType.NUMERIC && firstCell.getNumericCellValue() == id){
                    return row.getCell(col).getStringCellValue();
               }
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public double genericDoubleFinder(double id, int col) {
        try{
            File file = new File("src/data/data.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            for(Row row : sheet){
                Cell firstCell = row.getCell(0);
                if(firstCell.getCellType() == CellType.NUMERIC && firstCell.getNumericCellValue() == id){
                    return row.getCell(col).getNumericCellValue();
                }
            }

        } catch(IOException e){
            System.out.println(e.getStackTrace());
        }
        return -1;
    }

    public void setupTag(Tag tag){
        int id = tag.getId();
        tag.setTagTitle(findTitleById(id));
        tag.setTagDescription(findDescriptionById(id));
        tag.setTagNumber(findTagNumberById(id));
        tag.setTagType(findTagTypeById(id));
        tag.setTagKCal(findTagKCalById(id));
        tag.setTagWeight(findTagWeightById(id));
    }

    public String findTitleById(double id){
        return genericStringFinder(id, 1);
    }
    public String findDescriptionById(double id){
        return genericStringFinder(id, 2);
    }

    public int findTagNumberById(double id){
        return (int) genericDoubleFinder(id, 3);
    }

    public String findTagTypeById(double id){
        return genericStringFinder(id, 4);
    }

    public int findTagKCalById(double id){
        return (int) genericDoubleFinder(id, 5);

    }

    public int findTagWeightById(double id){
        return (int) genericDoubleFinder(id, 6);
    }
}
