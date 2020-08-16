package com.example.sort.factory;

import com.example.sort.Type;
import com.example.sort.strategy.MatchAllStrategy;
import com.example.sort.strategy.MatchAnyStrategy;
import com.example.sort.strategy.MatchNoneStrategy;
import com.example.sort.strategy.SortingStrategy;

public class StrategyFactory {

    public SortingStrategy getStrategy(Type type) {
        switch (type) {
            case ALL:
                return new MatchAllStrategy();
            case ANY:
                return new MatchAnyStrategy();
            case NONE:
                return new MatchNoneStrategy();
            default:
                return null;
        }
    }
}
