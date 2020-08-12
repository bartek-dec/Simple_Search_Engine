package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        String wordToFind = scanner.nextLine().trim();

        String word = null;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(wordToFind)) {
                System.out.println(i + 1);
                word = wordToFind;
            }
        }
        if (word == null) {
            System.out.println("Not found");
        }
    }
}
