package com.example.data.print;

import java.util.List;

public class DataPrinter implements Printer {

    @Override
    public String printData(List<String> data) {
        StringBuilder builder = new StringBuilder();

        if (data == null || data.size() == 0) {
            builder.append("No matching people found.\n");
        } else {
            data.forEach(s -> builder.append(s).append("\n"));
            builder.append("\n");
        }

        return builder.toString();
    }
}
