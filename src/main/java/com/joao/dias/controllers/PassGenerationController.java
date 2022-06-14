package com.joao.dias.controllers;

import com.joao.dias.utils.ClipBoardController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassGenerationController {
    private List<String> infos = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private List<String> contactNumber = new ArrayList<>();
    private Map<String, String> nameToNumberMap = new HashMap<>();
    private Map<String, String> nameToMessageMap = new HashMap<>();

    public void populateNameToNumberMap(String fullInfo){
        String[] lines = fullInfo.split("\n");
        for(String line : lines){
            nameToNumberMap.put(getFullName(line), getNumber(line));
        }
    }

    public void populateNameToMessageMap(String fullInfo){
        String[] lines = fullInfo.split("\n");
        for(String line : lines){
            nameToMessageMap.put(getFullName(line), getMessage(line));
        }
    }

    private String getNumber(String infoLine) {
        String[] lineComponents = infoLine.split("\t");
        return lineComponents[3];
    }

    public void populateNamesList (String fullInfo){
        String[] lines = fullInfo.split("\n");
        for(String line : lines){
            String[] lineComponents = line.split("\t");
            names.add(lineComponents[6]);
        }
    }

    public void populateMessageList(String fullInfo){
        String[] lines = fullInfo.split("\n");
        for (int i = 0; i < lines.length; i++){
            infos.add(i, getMessage(lines[i]));
        }
    }

    private String getMessage(String lineInfo){
        return String.format("Boa noite, %s \uD83D\uDE03\n\nPassando apenas para lembrar que seu pedido será entregue *amanhã*, no período da tarde, entre %s\n\n*Endereço de Entrega*: %s - %s\n\n*Forma de Pagamento*: %s", getName(lineInfo), getTime(lineInfo), getAdress(lineInfo), getDistrict(lineInfo), getPaymentMethod(lineInfo));
    }

    private String getTime(String infoLine) {
        String[] s = infoLine.split("\t");
        return s[7];
    }

    public String getFullName(String infoLine){
        String[] lineComponents = infoLine.split("\t");
        return lineComponents[6];
    }

    public static String getName (String infoLine){
        String[] s = infoLine.split("\t");
        String[] result = s[6].split(" ");
        return result[0];
    }

    public static String getAdress(String infoString){
        String[] s = infoString.split("\t");
        return s[2];
    }

    public static String getDistrict(String infoString){
        String[] s = infoString.split("\t");
        return s[1];
    }

    public static String getPaymentMethod(String infoString){
        String[] s = infoString.split("\t");
        return s[4];
    }

    public List<String> getNameList() {
        return this.names;

    }

    public Map<String, String> getNameToNumberMap() {
        return nameToNumberMap;
    }

    public Map<String, String> getNameToMessageMap() {
        return nameToMessageMap;
    }
}
