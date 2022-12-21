package com.joao.dias.utils;

import java.util.ArrayList;

public class PrintRequest {
    private ArrayList<PrintData> printList = new ArrayList<>();

    public static class PrintData {
        private final String id;
        private final int copies;
        public PrintData(String id, int copies) {
            this.id = id;
            this.copies = copies;
        }

        public String getId() {
            return id;
        }

        public int getCopies(){
            return copies;
        }

    }

    public ArrayList<PrintData> getPrintList (){
        return this.printList;
    }

}
