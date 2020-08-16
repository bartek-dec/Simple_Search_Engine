package com.example.data.process;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InvertedIndexImplTest {

    private InvertedIndex invertedIndex;
    private List<String> inputs;
    private Map<String, Set<Integer>> expectedData;

    @BeforeEach
    void setUp() {
        invertedIndex = new InvertedIndexImpl();

        inputs = List.of("Katie Jacobs", "Erick Harrington harrington@gmail.com",
                "Myrtle Medina", "Erick Burgess");

        expectedData = new HashMap<>();
        expectedData.put("Katie", Set.of(0));
        expectedData.put("Jacobs", Set.of(0));
        expectedData.put("Erick", Set.of(1, 3));
        expectedData.put("Harrington", Set.of(1));
        expectedData.put("harrington@gmail.com", Set.of(1));
        expectedData.put("Myrtle", Set.of(2));
        expectedData.put("Medina", Set.of(2));
        expectedData.put("Burgess", Set.of(3));
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