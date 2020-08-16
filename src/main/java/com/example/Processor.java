package com.example;

import com.example.data.print.Printer;
import com.example.sort.Type;
import com.example.sort.factory.StrategyFactory;
import com.example.sort.strategy.Context;
import com.example.sort.strategy.SortingStrategy;

import java.util.*;

public class Processor {

    private List<String> people;
    private Scanner scanner;
    private Map<String, Set<Integer>> invertedIndexes;
    private StrategyFactory factory;
    private Printer printer;

    public Processor(List<String> people, Scanner scanner, Map<String, Set<Integer>> invertedIndexes,
                     StrategyFactory factory, Printer printer) {
        this.people = people;
        this.scanner = scanner;
        this.invertedIndexes = invertedIndexes;
        this.factory = factory;
        this.printer = printer;
    }

    public void runProgram() {
        int menuItem;
        List<String> userInput;
        Type type;

        do {
            displayMenu();
            menuItem = Integer.parseInt(scanner.nextLine().trim());

            switch (menuItem) {
                case 1:
                    type = getSortingType();

                    SortingStrategy strategy = factory.getStrategy(type, invertedIndexes, people);
                    System.out.println("\nEnter a name or email to search all suitable people.");

                    userInput = List.of(scanner.nextLine().toLowerCase().split("\\s+"));
                    Context context = new Context();
                    List<String> foundPeople = context.sortPeople(strategy, userInput);

                    System.out.println(printer.printData(foundPeople));
                    break;
                case 2:
                    System.out.println("\n=== List of people ===");
                    System.out.println(printer.printData(people));
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
}
