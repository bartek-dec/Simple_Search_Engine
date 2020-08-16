package com.example.data.print;

import java.util.List;

public class DataPrinter implements Printer {

    @Override
    public void printData(List<String> data) {
        if (data == null || data.size() == 0) {
            System.out.println("No matching people found.\n");
        } else {
            data.forEach(System.out::println);
            System.out.println("\n");
        }
    }
}
