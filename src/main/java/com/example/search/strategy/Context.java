package com.example.search.strategy;

import java.util.List;

public class Context {

    public List<String> sortPeople(SortingStrategy strategy, List<String> inputs) {
        return strategy.sortPeople(inputs);
    }
}
