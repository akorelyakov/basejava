package com.github.akorelyakov.webapp;

import java.io.File;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) {
        File directory = new File(".\\src\\com\\github\\akorelyakov" +
                "\\webapp");
        directoryListPrinter(directory);
    }

    private static void directoryListPrinter(File directory) {
        if (directory.isDirectory()) {
            for (File item : Objects.requireNonNull(directory.listFiles())) {
                if (item.isDirectory()) {
                    System.out.println();
                    System.out.println("=====FOLDER: " + item.getName().toUpperCase() + " ======");
                    directoryListPrinter(item);
                    System.out.println();
                } else {
                    System.out.println(item.getName());
                }
            }
        }
    }
}