package com.example;

import com.example.sort.Type;
import com.example.sort.factory.StrategyFactory;
import com.example.sort.strategy.SortingStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Processor {

    private List<String> people;
    private Scanner scanner;
    private Map<String, Set<Integer>> invertedIndexes;
    private StrategyFactory factory;

    public Processor(List<String> people, Scanner scanner, Map<String, Set<Integer>> invertedIndexes, StrategyFactory factory) {
        this.people = people;
        this.scanner = scanner;
        this.invertedIndexes = invertedIndexes;
        this.factory = factory;
    }

    public void runProgram() {
        int menuItem;
        String userInput;
        Type type;

        do {
            displayMenu();
            menuItem = Integer.parseInt(scanner.nextLine().trim());

            switch (menuItem) {
                case 1:
                    type = getSortingType();

                    SortingStrategy strategy = factory.getStrategy(type, invertedIndexes);

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

    private Type getSortingType() {
        Type type = null;
        do {
            displaySubmenu();
            try {
                type = Type.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect sorting strategy");
            }
        } while (!Objects.equals(type, Type.ALL) &&
                !Objects.equals(type, Type.ANY) &&
                !Objects.equals(type, Type.NONE));

        return type;
    }

    private void displayMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private void displaySubmenu() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
    }

    private List<String> findPerson(String data) {
        Set<Integer> indexes = invertedIndexes.get(data);

        if (indexes == null) {
            return null;
        }

        return indexes.stream()
                .map(i -> people.get(i))
                .collect(Collectors.toList());
    }

    private void printData(List<String> data) {
        if (data == null || data.size() == 0) {
            System.out.println("No matching people found.\n");
        } else {
            data.forEach(System.out::println);
            System.out.println("\n");
        }
    }
}
