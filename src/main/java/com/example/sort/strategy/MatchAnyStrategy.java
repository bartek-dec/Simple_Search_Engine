package com.example.sort.strategy;

import java.util.*;
import java.util.stream.Collectors;

public class MatchAnyStrategy implements SortingStrategy {

    private Map<String, Set<Integer>> invertedIndexes;
    private List<String> people;

    public MatchAnyStrategy(Map<String, Set<Integer>> invertedIndexes, List<String> people) {
        this.invertedIndexes = invertedIndexes;
        this.people = people;
    }

    @Override
    public List<String> sortPeople(List<String> list) {
        if (list == null) {
            return null;
        }

        Set<String> foundPeople = new LinkedHashSet<>();

        for (String input : list) {
            Set<Integer> indexes = invertedIndexes.get(input.toLowerCase());

            if (indexes == null) {
                continue;
            }

            List<String> findingsForCurrentIndexes = indexes.stream()
                    .map(i -> people.get(i))
                    .collect(Collectors.toList());

            foundPeople.addAll(findingsForCurrentIndexes);
        }

        if (foundPeople.size() == 0) {
            return null;
        }
        return new ArrayList<>(foundPeople);
    }
}
