package com.example.sort.strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MatchNoneStrategy implements SortingStrategy {

    private Map<String, Set<Integer>> invertedIndexes;

    public MatchNoneStrategy(Map<String, Set<Integer>> invertedIndexes) {
        this.invertedIndexes = invertedIndexes;
    }

    @Override
    public List<String> sortPeople(List<String> list) {
        return null;
    }
}
