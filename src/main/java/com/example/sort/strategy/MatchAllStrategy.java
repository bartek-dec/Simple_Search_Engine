package com.example.sort.strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
        return null;
    }

    private List<String> findPerson(String data) {
        Set<Integer> indexes = invertedIndexes.get(data);

        if (indexes == null) {
            return null;
        }

        return indexes.stream()
                .map(i -> people.get(i))
                .collect(Collectors.toList());
    }
}
