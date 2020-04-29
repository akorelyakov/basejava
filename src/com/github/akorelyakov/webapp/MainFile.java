package com.github.akorelyakov.webapp;

import com.github.akorelyakov.webapp.exception.StorageException;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File directory = new File("C:\\dev\\javaops\\basejava\\src\\com\\github\\akorelyakov" +
                "\\webapp");
        directoryListPrinter(directory);
    }

    private static void directoryListPrinter(File directory) {
        if (directory.isDirectory()) {
            if (directory == null) {
                throw new StorageException("directory must not be null", null);
            }
            for (File item : directory.listFiles()) {
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