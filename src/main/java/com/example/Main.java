package com.example;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String path = "./src/main/resources/";
    private static final String command = "--data";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> commands = Arrays.asList(args);

        int index;
        String fileName = "";
        if (commands.contains(command)) {
            index = commands.indexOf(command);
            fileName = commands.get(index + 1);
        }

        File file = new File(path + fileName);
        Reader dataReader = new DataReader();
        List<String> people = dataReader.readData(file);

        Processor processor = new Processor(people, scanner);
        processor.runProgram();

    }
}
