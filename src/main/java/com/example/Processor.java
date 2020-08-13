package com.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Processor {

    private List<String> people;
    private Scanner scanner;

    public Processor(List<String> people, Scanner scanner) {
        this.people = people;
        this.scanner = scanner;
    }

    public void runProgram() {
        int menuItem;
        String userInput;

        do {
            displayMenu();
            menuItem = Integer.parseInt(scanner.nextLine().trim());

            switch (menuItem) {
                case 1:
                    System.out.println("\nEnter a name or email to search all suitable people.");
                    userInput = scanner.nextLine().toLowerCase().trim();
                    List<String> foundPeople = findPerson(userInput);
                    printData(foundPeople);
                    break;
                case 2:
                    System.out.println("\n=== List of people ===");
                    printData(people);
                case 0:
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
            }

        } while (menuItem != 0);

        System.out.println("\nBye!");
    }

    private void displayMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private List<String> findPerson(String data) {
        List<String> foundData = people.stream()
                .filter(s -> s.toLowerCase().contains(data))
                .collect(Collectors.toList());

        return foundData;
    }

    private void printData(List<String> data) {
        if (data.size() == 0) {
            System.out.println("No matching people found.\n");
        } else {
            data.forEach(System.out::println);
            System.out.println("\n");
        }
    }
}
