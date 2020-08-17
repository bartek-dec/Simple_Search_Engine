package com.example.sort.factory;

import com.example.sort.Type;
import com.example.sort.strategy.MatchAllStrategy;
import com.example.sort.strategy.MatchAnyStrategy;
import com.example.sort.strategy.MatchNoneStrategy;
import com.example.sort.strategy.SortingStrategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StrategyFactory {

    public SortingStrategy getStrategy(Type type, Map<String, Set<Integer>> invertedIndexes, List<String> people) {
        switch (type) {
            case ALL:
                return new MatchAllStrategy(invertedIndexes, people);
            case ANY:
                return new MatchAnyStrategy(invertedIndexes, people);
            case NONE:
                return new MatchNoneStrategy(invertedIndexes, people);
            default:
                return null;
        }
    }
}
