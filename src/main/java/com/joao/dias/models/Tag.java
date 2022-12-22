package com.joao.dias.models;

import com.joao.dias.utils.ColorController;

import java.awt.*;
import java.io.File;


public class Tag {
    private String id;

    private String fullName;
    private int amountToPrint;

    private String tagType;
    private int tagWeight;


    public Tag (String id){
        this.id = id;

    }

    public Tag (String fullName, int amountToPrint){
        this.amountToPrint = amountToPrint;
        this.fullName = fullName;
    }

    public String getTagBaseImgPath() {
        return new File(String.format("src/images/Bases/%s.png", id)).getAbsolutePath();
    }

    public String getTagType() {
        return tagType;
    }

    public Color getTagColor(){
        switch (getTagType()){
            case "DD":
                return ColorController.DDOrange;
            case "LC":
                return ColorController.LCPurple;
            case "AC":
                return ColorController.ACBlue;
            case "SP":
                return ColorController.SPRed;
            case "PA":
                return ColorController.PAPurple;
            case "DC":
                return ColorController.DCGreen;
            case "SK":
                return ColorController.SKRed;
        }
        return Color.black;
    }

    public String getId() {
        return id;
    }

    public String getName(){
        return fullName;
    }

    public int getAmountToPrint(){ return amountToPrint; }

    public String getTagID(){
        return this.id;
    }

}
