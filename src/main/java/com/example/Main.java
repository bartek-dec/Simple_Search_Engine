package com.example;

import com.example.data.print.DataPrinter;
import com.example.data.print.Printer;
import com.example.data.process.InvertedIndex;
import com.example.data.process.InvertedIndexImpl;
import com.example.data.read.DataReader;
import com.example.data.read.Reader;
import com.example.search.factory.StrategyFactory;

import java.io.File;
import java.util.*;

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

        if (people == null) {
            System.out.println("No data has been read from the file " + file.getName());
            return;
        }

        InvertedIndex invertedIndex = new InvertedIndexImpl();
        Map<String, Set<Integer>> indexes = invertedIndex.getInvertedIndexes(people);
        StrategyFactory factory = new StrategyFactory();
        Printer printer = new DataPrinter();

        Processor processor = new Processor(people, scanner, indexes, factory, printer);
        processor.runProgram();

    }
}
