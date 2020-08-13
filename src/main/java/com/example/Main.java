package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        int numOfPeople = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter all people:");
        List<String> people = new ArrayList<>();
        for (int i = 0; i < numOfPeople; i++) {
            people.add(scanner.nextLine());
        }

        Processor processor = new Processor(people, scanner);
        processor.runProgram();
    }
}
