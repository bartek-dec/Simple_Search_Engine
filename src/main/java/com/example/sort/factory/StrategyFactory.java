package com.example.sort.factory;

import com.example.sort.Type;
import com.example.sort.strategy.MatchAllStrategy;
import com.example.sort.strategy.MatchAnyStrategy;
import com.example.sort.strategy.MatchNoneStrategy;
import com.example.sort.strategy.SortingStrategy;

import java.util.Map;
import java.util.Set;

public class StrategyFactory {

    public SortingStrategy getStrategy(Type type, Map<String, Set<Integer>> invertedIndexes) {
        switch (type) {
            case ALL:
                return new MatchAllStrategy(invertedIndexes);
            case ANY:
                return new MatchAnyStrategy(invertedIndexes);
            case NONE:
                return new MatchNoneStrategy(invertedIndexes);
            default:
                return null;
        }
    }
}
