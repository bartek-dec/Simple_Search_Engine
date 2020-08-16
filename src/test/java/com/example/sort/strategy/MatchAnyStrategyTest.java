package com.example.sort.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MatchAnyStrategyTest {

    private List<String> people;
    private Map<String, Set<Integer>> indexes;
    private SortingStrategy strategy;
    private List<String> userInputs;
    private List<String> expectedResult;

    @BeforeEach
    void setUp() {
        people = List.of("Katie Jacobs", "Erick Harrington harrington@gmail.com",
                "Myrtle Medina webb@gmail.com", "Erick Burgess");

        Set<Integer> integers = new LinkedHashSet<>();
        integers.add(1);
        integers.add(3);
        indexes = new HashMap<>();
        indexes.put("katie", Set.of(0));
        indexes.put("jacobs", Set.of(0));
        indexes.put("erick", integers);
        indexes.put("harrington", Set.of(1));
        indexes.put("harrington@gmail.com", Set.of(1));
        indexes.put("myrtle", Set.of(2));
        indexes.put("medina", Set.of(2));
        indexes.put("webb@gmail.com", Set.of(2));
        indexes.put("burgess", Set.of(3));

        strategy = new MatchAnyStrategy(indexes, people);

        userInputs = List.of("Erick", "Jacobs", "webb@gmail.com");

        expectedResult = List.of("Erick Harrington harrington@gmail.com", "Erick Burgess",
                "Katie Jacobs", "Myrtle Medina webb@gmail.com");
    }

    @Test
    void sortPeople() {
        assertEquals(expectedResult, strategy.sortPeople(userInputs));
    }

    @Test
    void sortPeopleExpectedNull() {
        assertNull(strategy.sortPeople(List.of("qwerty")));
    }
}