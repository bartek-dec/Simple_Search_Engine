package com.example.search.strategy;

import java.util.*;
import java.util.stream.Collectors;

public class MatchAllStrategy implements SortingStrategy {

    private Map<String, Set<Integer>> invertedIndexes;
    private List<String> people;

    public MatchAllStrategy(Map<String, Set<Integer>> invertedIndexes, List<String> people) {
        this.invertedIndexes = invertedIndexes;
        this.people = people;
    }

    @Override
    public List<String> sortPeople(List<String> list) {
        if (list == null) {
            return null;
        }

        List<String> foundPeople;
        Set<Integer> indexes = invertedIndexes.get(list.get(0).toLowerCase());

        if (indexes == null) {
            return null;
        } else {
            foundPeople = indexes.stream()
                    .map(e -> people.get(e))
                    .collect(Collectors.toList());
        }

        int size = list.size();
        for (int i = 1; i < size; i++) {
            int index = i;
            foundPeople = foundPeople.stream()
                    .filter(e -> e.toLowerCase().contains(list.get(index).toLowerCase()))
                    .collect(Collectors.toList());

            if (foundPeople.size() == 0) {
                return null;
            }
        }

        return foundPeople;
    }
}
