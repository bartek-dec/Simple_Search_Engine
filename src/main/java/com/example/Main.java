package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        System.out.println("Enter the number of search queries:");
        int numOfQueries = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numOfQueries; i++) {
            System.out.println("Enter data to search people:");
            String data = scanner.nextLine().toLowerCase().trim();

            List<String> foundData = searchData(people, data);
            printData(foundData);
        }
    }

    private static List<String> searchData(List<String> list, String data) {
        List<String> foundData = list.stream()
                .filter(s -> s.toLowerCase().contains(data))
                .collect(Collectors.toList());

        return foundData;
    }

    private static void printData(List<String> data) {
        if (data.size() == 0) {
            System.out.println("No matching people found.\n");
        } else {
            System.out.println("\nFound people:");
            data.forEach(System.out::println);
            System.out.println("\n");
        }
    }
}
