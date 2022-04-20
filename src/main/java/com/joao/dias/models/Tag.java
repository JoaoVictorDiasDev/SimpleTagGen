package com.joao.dias.models;

import com.joao.dias.controllers.AlertController;
import com.joao.dias.utils.ColorController;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;


public class Tag {
    private int id;
    private final String tagConfigFile = "src/main/resources/tagConfigFile.txt";
    private final String databaseURL = "jdbc:mysql://localhost:3306/nutrinicedb";

    private int tagWidth;
    private int tagHeight;

    private static String fullName;

    public Tag (int id){
        if (id > 10) this.id = id;
        this.tagWidth = 944;
        this.tagHeight = 1630;
    }

    public Tag (String fullName){
        this.fullName = fullName;
    }

    public String getTagTitle(){
        try {
            Connection connection = DriverManager.getConnection(databaseURL, "root", "123456");
            String query = String.format("SELECT TagTitle FROM tags_info WHERE TagID=%d", id);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            if(result != null && result.next()) {
                return result.getString("TagTitle");
            }
            connection.close();
        } catch (SQLException e){
            System.out.println("Couldn`t connect to server at getTagTitle: " + e.getMessage());
        }
        return "";
    }

    public String getTagDescription(){
        try {
            Connection connection = DriverManager.getConnection(databaseURL, "root", "123456");
            String query = String.format("SELECT TagDescription FROM tags_info WHERE TagID=%d", id);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            if(result != null && result.next()) {
                return result.getString("TagDescription");
            }
        } catch (SQLException e){
            System.out.println("Couldn`t connect to server at getTagTitle: " + e.getMessage());
        }
        return "";
    }

    public String getTagType(){
        try {
            Connection connection = DriverManager.getConnection(databaseURL, "root", "123456");
            String query = String.format("SELECT TagType FROM tags_info WHERE TagID=%d", id);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            if(result != null && result.next()) {
                return result.getString("TagType");
            }
        } catch (SQLException e){
            System.out.println("Couldn`t connect to server at getTagTitle: " + e.getMessage());
        }
        return "";
    }

    public String getTagBaseImgPath() {
        return new File(String.format("src/images/Bases/%s.png", getTagType())).getAbsolutePath();
    }

    public Color getTagColor(){
        switch (getTagType()){
            case "DD":
                return ColorController.DDOrange;
            case "LC":
                return ColorController.LCPurple;
        }
        return Color.black;
    }

    public int getTagNumber(){
        try {
            Connection connection = DriverManager.getConnection(databaseURL, "root", "123456");
            Statement statement = connection.createStatement();
            String query = String.format("SELECT TagNumber FROM tags_info WHERE TagID=%d", id);
            ResultSet result = statement.executeQuery(query);
            if(result != null && result.next()) {
                return result.getInt("TagNumber");
            }
        } catch (SQLException e){
            AlertController.createErrorDialog(e.getMessage(), e.getStackTrace().toString());
        }
        return 0;
    }

    public int getTagKCal(){
        try {
            Connection connection = DriverManager.getConnection(databaseURL, "root", "123456");
            Statement statement = connection.createStatement();
            String query = String.format("SELECT TagKCal FROM tags_info WHERE TagID=%d", id);
            ResultSet result = statement.executeQuery(query);
            if(result != null && result.next()) {
                return result.getInt("TagKCal");
            }
        } catch (SQLException e){
            AlertController.createErrorDialog(e.getMessage(), e.getStackTrace().toString());
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return fullName;
    }

    public int getTagWidth(){
        return tagWidth;
    }

    public int getTagHeight(){
        return tagHeight;
    }
}
