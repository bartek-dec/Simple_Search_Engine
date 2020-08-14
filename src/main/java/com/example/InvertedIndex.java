package com.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InvertedIndex {

    Map<String, Set<Integer>> getInvertedIndexes(List<String> lines);
}
