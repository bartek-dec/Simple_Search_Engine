package com.example.data.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader implements Reader {

    @Override
    public List<String> readData(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }
}
