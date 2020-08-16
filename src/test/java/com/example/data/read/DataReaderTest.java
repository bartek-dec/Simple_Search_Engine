package com.example.data.read;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    private final String path = "./src/test/resources/test.txt";
    private final String incorrectPath = "./src/test/resources/t.txt";

    private Reader reader;
    private File testFile;
    private File nonExistingFile;
    private List<String> expectedInputs;

    @BeforeEach
    void setUp() {
        reader = new DataReader();
        testFile = new File(path);
        nonExistingFile = new File(incorrectPath);
        expectedInputs = List.of("Katie Jacobs", "Erick Harrington harrington@gmail.com",
                "Myrtle Medina", "Erick Burgess");
    }

    @Test
    void readData() {
        assertEquals(expectedInputs, reader.readData(testFile));
    }

    @Test
    void readDataExpectedNull() {
        assertNull(reader.readData(nonExistingFile));
    }
}