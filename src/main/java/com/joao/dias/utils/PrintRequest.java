package com.joao.dias.utils;

import java.util.List;

public class PrintRequest {
    private boolean finished = false;
    private int [] printArrayDD = new int[15];
    private int [] printArrayLC = new int[16];
    private int [] printArrayAC = new int[15];
    private int [] printArrayPA = new int[11];
    private int [] printArraySP = new int[11];
    private int [] printArrayDC = new int[3];
    private int [] printArraySK = new int[7];

    private boolean needToPrintDD = true;
    private boolean needToPrintLC = true;
    private boolean needToPrintAC = true;
    private boolean needToPrintPA = true;
    private boolean needToPrintSP = true;
    private boolean needToPrintDC = true;
    private boolean needToPrintSK = true;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int[] getPrintArrayDD() {
        return printArrayDD;
    }

    public void setPrintArrayDD(int[] printArrayDD) {
        this.printArrayDD = printArrayDD;
    }

    public int[] getPrintArrayLC() {
        return printArrayLC;
    }

    public void setPrintArrayLC(int[] printArrayLC) {
        this.printArrayLC = printArrayLC;
    }

    public int[] getPrintArrayAC() {
        return printArrayAC;
    }

    public void setPrintArrayAC(int[] printArrayAC) {
        this.printArrayAC = printArrayAC;
    }

    public int[] getPrintArrayPA() {
        return printArrayPA;
    }

    public void setPrintArrayPA(int[] printArrayPA) {
        this.printArrayPA = printArrayPA;
    }

    public int[] getPrintArraySP() {
        return printArraySP;
    }

    public void setPrintArraySP(int[] printArraySP) {
        this.printArraySP = printArraySP;
    }

    public int[] getPrintArrayDC() {
        return printArrayDC;
    }

    public void setPrintArrayDC(int[] printArrayDC) {
        this.printArrayDC = printArrayDC;
    }

    public int[] getPrintArraySK() {
        return printArraySK;
    }

    public void setPrintArraySK(int[] printArraySK) {
        this.printArraySK = printArraySK;
    }

    public boolean needToPrintDD() {
        return needToPrintDD;
    }

    public void setNeedToPrintDD(boolean needToPrintDD) {
        this.needToPrintDD = needToPrintDD;
    }

    public boolean needToPrintLC() {
        return needToPrintLC;
    }

    public void setNeedToPrintLC(boolean needToPrintLC) {
        this.needToPrintLC = needToPrintLC;
    }

    public boolean needToPrintAC() {
        return needToPrintAC;
    }

    public void setNeedToPrintAC(boolean needToPrintAC) {
        this.needToPrintAC = needToPrintAC;
    }

    public boolean needToPrintPA() {
        return needToPrintPA;
    }

    public void needToPrintPA(boolean needToPrintPA) {
        this.needToPrintPA = needToPrintPA;
    }

    public boolean needToPrintSP() {
        return needToPrintSP;
    }

    public void setNeedToPrintSP(boolean needToPrintSP) {
        this.needToPrintSP = needToPrintSP;
    }

    public boolean needToPrintDC() {
        return needToPrintDC;
    }

    public void setNeedToPrintDC(boolean needToPrintDC) {
        this.needToPrintDC = needToPrintDC;
    }

    public boolean needToPrintSK() {
        return needToPrintSK;
    }

    public void setNeedToPrintSK(boolean needToPrintSK) {
        this.needToPrintSK = needToPrintSK;
    }
}
