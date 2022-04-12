package com.joao.dias.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tag {
    private int id;
    private final String tagConfigFile = "src/main/resources/tagConfigFile.txt";

    public Tag (int id){
        if (id > 10) this.id = id;
    }

    //Possibler infoType: Title, Description, Number, KCal, Type
    public String getTagInfo(String infoType){
        try{
            Scanner scanner = new Scanner (new File(getTagConfigFileAbsolutePath()));
            while(scanner.nextLine().equals(String.format("%s %d:", infoType, id)) != true){
                if(scanner.nextLine().equals(String.format("%s %d:", infoType, id)) == true){
                    System.out.println("Found Searched Text !");
                    break;
                }
                scanner.nextLine();
            }
            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "Undefined";
    }


    public String getTagConfigFileAbsolutePath(){
        String absolutePath = new File(tagConfigFile).getAbsolutePath();
        return absolutePath;
    }

}
