package com.github.akorelyakov.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File directory = new File(".\\src\\com\\github\\akorelyakov" +
                "\\webapp");
        printDirectoryDeeply(directory, "\t");
    }

    private static void printDirectoryDeeply(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    indent += "\t";
                    System.out.println(indent + "Directory: " + file.getName());
                    indent += "\t";
                    printDirectoryDeeply(file, indent);
                    indent = "\t";
                } else if (file.isFile()) {
                    System.out.println(indent + "File: " + file.getName());
                }

            }
        }
    }

}