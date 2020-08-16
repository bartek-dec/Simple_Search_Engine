package com.example.sort.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MatchAllStrategyTest {

    private List<String> people;
    private Map<String, Set<Integer>> indexes;
    private SortingStrategy strategy;
    private List<String> userInputs_1;
    private List<String> userInputs_2;
    private List<String> expectedResult_1;

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

        strategy = new MatchAllStrategy(indexes, people);

        userInputs_1 = List.of("Harrington", "Erick");
        userInputs_2 = List.of("Harrington", "qwerty");

        expectedResult_1 = List.of("Erick Harrington harrington@gmail.com");
    }

    @Test
    void sortPeople() {
        assertEquals(expectedResult_1, strategy.sortPeople(userInputs_1));
    }

    @Test
    void sortPeoplePassedListIsNull() {
        assertNull(strategy.sortPeople(null));
    }

    @Test
    void sortPeopleNothingFoundInInvertedIndexes() {
        assertNull(strategy.sortPeople(List.of("qwerty")));
    }

    @Test
    void sortPeopleNothingFound() {
        assertNull(strategy.sortPeople(userInputs_2));
    }
}