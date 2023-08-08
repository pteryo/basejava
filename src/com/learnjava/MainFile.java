package com.learnjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printDirectoryDeeply(dir,0);
    }

    public static void printDirectoryDeeply(File dir, int deep) {
        File[] files = dir.listFiles();
        int nextDeep = deep + 2;
        char[] spaces = new char[deep];
        Arrays.fill(spaces, ' ');

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File:    " + new String(spaces) + file.getName());
                }
            }
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Dir:  " + new String(spaces) + file.getName());
                    printDirectoryDeeply(file, nextDeep);
                }
            }
        }
    }
}
