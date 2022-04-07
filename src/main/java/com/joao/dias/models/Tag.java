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

    public String getTitle(){
        return "Not Found";
    }

    public String getDescription(){
       return "Not Found";
    }

    public String getType(){
        return "Undefined";
    }

    public int getNumber(){
        return -1;
    }

    public int getKCal(){
        return -1;
    }

}
