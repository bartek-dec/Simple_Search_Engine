package com.example.search.strategy;

import java.util.*;
import java.util.stream.Collectors;

public class MatchNoneStrategy implements SortingStrategy {

    private Map<String, Set<Integer>> invertedIndexes;
    private List<String> people;

    public MatchNoneStrategy(Map<String, Set<Integer>> invertedIndexes, List<String> people) {
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
            return people;
        }

        List<String> results = new ArrayList<>(people);
        results.removeAll(foundPeople);

        if (results.size() == 0) {
            return null;
        }
        return results;
    }
}
