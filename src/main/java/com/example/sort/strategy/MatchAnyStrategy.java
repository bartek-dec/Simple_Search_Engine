package com.example.sort.strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MatchAnyStrategy implements SortingStrategy {

    private Map<String, Set<Integer>> invertedIndexes;
    private List<String> people;

    public MatchAnyStrategy(Map<String, Set<Integer>> invertedIndexes, List<String> people) {
        this.invertedIndexes = invertedIndexes;
        this.people = people;
    }

    @Override
    public List<String> sortPeople(List<String> list) {
        return null;
    }
}
