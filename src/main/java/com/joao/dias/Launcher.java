package com.joao.dias;

import com.joao.dias.controllers.FileController;

public class Launcher {
    public static void main(String[] args) {
        FileController.loadFont();
        App.main(args);

    }
}
