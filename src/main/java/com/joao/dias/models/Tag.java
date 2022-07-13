package com.joao.dias.models;

import com.joao.dias.controllers.AlertController;
import com.joao.dias.repositories.tagInfoRepository;
import com.joao.dias.utils.ColorController;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;


public class Tag {
    private int id;

    private int tagWidth;
    private int tagHeight;

    private static String fullName;
    private static int amountToPrint;

    private String tagTitle;
    private String tagDescription;
    private int tagNumber;
    private String tagType;
    private int tagKCal;
    private int tagWeigth;


    public Tag (int id){
        if (id > 10) this.id = id;
        this.tagWidth = 944;
        this.tagHeight = 1630;

        tagInfoRepository repo = new tagInfoRepository();
        repo.setupTag(this);

    }

    public Tag (String fullName, int amountToPrint){
        this.amountToPrint = amountToPrint;
        this.fullName = fullName;
    }

    public String getTagBaseImgPath() {
        return new File(String.format("src/images/Bases/%s.png", getTagType())).getAbsolutePath();
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public int getTagNumber() {
        return tagNumber;
    }

    public String getTagType() {
        return tagType;
    }

    public int getTagKCal() {
        return tagKCal;
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

    public int getId() {
        return id;
    }

    public String getName(){
        return fullName;
    }

    public int getAmountToPrint(){ return amountToPrint; }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public void setTagNumber(int tagNumber) {
        this.tagNumber = tagNumber;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public void setTagKCal(int tagKCal) {
        this.tagKCal = tagKCal;
    }

    public void setTagWeigth(int tagWeigth) {
        this.tagWeigth = tagWeigth;
    }
}
