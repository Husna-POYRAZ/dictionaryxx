package org.example;

import org.example.util.FileOperation;

import java.io.IOException;

public class Main {
    public static final String tureng = "./assets/tureng.txt";
    public static final String engtur = "./assets/engtur.txt";

    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        try {
            fileOperation.readFileOperation(tureng);
            String w = fileOperation.getWordMeaining("aç");
            System.out.println(w);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}