package com.example;

import com.example.data.process.InvertedIndex;
import com.example.data.process.InvertedIndexImpl;
import com.example.data.read.DataReader;
import com.example.data.read.Reader;
import com.example.sort.factory.StrategyFactory;

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
        InvertedIndex invertedIndex = new InvertedIndexImpl();
        Map<String, Set<Integer>> indexes = invertedIndex.getInvertedIndexes(people);
        StrategyFactory factory = new StrategyFactory();

        Processor processor = new Processor(people, scanner, indexes,factory);
        processor.runProgram();

    }
}
