package com.example.data.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataPrinterTest {

    private Printer printer;
    private List<String> inputs;
    private String noResults;
    private String results;
    private StringBuilder builder;

    @BeforeEach
    void setUp() {
        printer = new DataPrinter();
        inputs = List.of("Katie Jacobs", "Erick Harrington harrington@gmail.com",
                "Myrtle Medina", "Erick Burgess");

        noResults = "No matching people found.\n";

        builder = new StringBuilder();
        builder.append("Katie Jacobs\n");
        builder.append("Erick Harrington harrington@gmail.com\n");
        builder.append("Myrtle Medina\n");
        builder.append("Erick Burgess\n");
        builder.append("\n");

        results = builder.toString();
    }

    @Test
    void printData() {
        assertEquals(results, printer.printData(inputs));
    }

    @Test
    void printDataEmptyList() {
        assertEquals(noResults, printer.printData(new ArrayList<>()));
    }

    @Test
    void printDataNull() {
        assertEquals(noResults, printer.printData(null));
    }
}