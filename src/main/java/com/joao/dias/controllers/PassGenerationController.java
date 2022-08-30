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


    public void populateNamesList (String fullInfo){
        String[] lines = fullInfo.split("\n");
        for(String line : lines){
            names.add(getFullName(line));
        }
    }

    public void populateMessageList(String fullInfo){
        String[] lines = fullInfo.split("\n");
        for (int i = 0; i < lines.length; i++){
            infos.add(i, getMessage(lines[i]));
        }
    }

    private String getMessage(String lineInfo){
        if(getPaymentMethod(lineInfo).equals("dinheiro") || getPaymentMethod(lineInfo).equals("Dinheiro"))
            return String.format("Boa tarde, %s \uD83D\uDE03\n\n" +
                    "Passando apenas para lembrar que seu pedido será entregue amanhã, no período da %s, com previsão de chegada entre %s, tudo bem ? \uD83D\uDE0A\n" +
                    "Vamos confirmar os dados do seu pedido ?\n\n\uD83D\uDCCD *Endereço de entrega:* %s - %s - certifique-se de que o complemento está correto (se houver)\n" +
                    "\uD83D\uDCB3 *Forma de pagamento:* %s (Favor confirmar se devemos levar troco)\n " +
                    "\uD83D\uDCB2 *Valor total*: %s\n\nCaso seja necessário alterar alguma informação, basta nos responder essa mensagem \uD83D\uDE09\n" +
                    "Agradecemos e permanecemos à disposição ! \t", getName(lineInfo), getDeliveryPeriod(lineInfo),  getTime(lineInfo), getAdress(lineInfo), getDistrict(lineInfo), getPaymentMethod(lineInfo), getValue(lineInfo));
        return String.format("Boa tarde, %s \uD83D\uDE03\n\n" +
                "Passando apenas para lembrar que seu pedido será entregue amanhã, no período da %s, com previsão de chegada entre %s, tudo bem ? \uD83D\uDE0A\n" +
                "Vamos confirmar os dados do seu pedido ?\n\n\uD83D\uDCCD *Endereço de entrega:* %s - %s - certifique-se de que o complemento está correto (se houver)\n" +
                "\uD83D\uDCB3 *Forma de pagamento:* %s\n" +
                "\uD83D\uDCB2 *Valor total*: %s\n\nCaso seja necessário alterar alguma informação, basta nos responder essa mensagem \uD83D\uDE09\n" +
                "Agradecemos e permanecemos à disposição ! \t", getName(lineInfo), getDeliveryPeriod(lineInfo),  getTime(lineInfo), getAdress(lineInfo), getDistrict(lineInfo), getPaymentMethod(lineInfo), getValue(lineInfo));
    }

    private String getNumber(String infoLine) {
        String[] lineComponents = infoLine.split("\t");
        return lineComponents[4];
    }

    private String getTime(String infoLine) {
        String[] s = infoLine.split("\t");
        return s[8];
    }

    private String getDeliveryPeriod(String infoLine){
        String[] s = infoLine.split("\t");
        return s[9];
    }

    public String getFullName(String infoLine){
        String[] lineComponents = infoLine.split("\t");
        return lineComponents[7];
    }

    private String getValue(String infoLine) {
        String[] lineComponents = infoLine.split("\t");
        return lineComponents[6];
    }

    public String getName (String infoLine){
        String[] result = getFullName(infoLine).split(" ");
        return result[0];
    }

    public String getAdress(String infoString){
        String[] s = infoString.split("\t");
        return s[3];
    }

    public static String getDistrict(String infoString){
        String[] s = infoString.split("\t");
        return s[2];
    }

    public static String getPaymentMethod(String infoString){
        String[] s = infoString.split("\t");
        return s[5];
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
