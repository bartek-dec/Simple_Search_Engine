package com.example.data.process;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InvertedIndexImplTest {

    private InvertedIndex invertedIndex;
    private List<String> inputs;
    private Map<String, Set<Integer>> expectedData;

    @BeforeEach
    void setUp() {
        invertedIndex = new InvertedIndexImpl();

        inputs = List.of("Katie Jacobs", "Erick Harrington harrington@gmail.com",
                "Myrtle Medina", "Erick Burgess");

        Set<Integer> integers = new LinkedHashSet<>();
        integers.add(1);
        integers.add(3);
        expectedData = new HashMap<>();
        expectedData.put("katie", Set.of(0));
        expectedData.put("jacobs", Set.of(0));
        expectedData.put("erick", integers);
        expectedData.put("harrington", Set.of(1));
        expectedData.put("harrington@gmail.com", Set.of(1));
        expectedData.put("myrtle", Set.of(2));
        expectedData.put("medina", Set.of(2));
        expectedData.put("burgess", Set.of(3));
    }

    @Test
    void getInvertedIndexes() {
        assertEquals(expectedData, invertedIndex.getInvertedIndexes(inputs));
    }

    @Test
    void getInvertedIndexesExpectedNull() {
        assertNull(invertedIndex.getInvertedIndexes(null));
    }
}