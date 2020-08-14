package com.example;

import java.util.*;

public class InvertedIndexImpl implements InvertedIndex {

    @Override
    public Map<String, Set<Integer>> getInvertedIndexes(List<String> lines) {
        if (lines == null) {
            return null;
        }

        Map<String, Set<Integer>> invertedIndexes = new HashMap<>();
        int size = lines.size();

        for (int i = 0; i < size; i++) {
            String[] words = lines.get(i).split("\\s+");
            int wordsQuantity = words.length;

            for (int j = 0; j < wordsQuantity; j++) {
                String currentWord = words[j].toLowerCase();

                if (invertedIndexes.containsKey(currentWord)) {
                    Set<Integer> indexes = invertedIndexes.get(currentWord);
                    indexes.add(i);
                } else {
                    Set<Integer> indexes = new LinkedHashSet<>();
                    indexes.add(i);
                    invertedIndexes.put(currentWord, indexes);
                }
            }
        }
        return invertedIndexes;
    }
}
