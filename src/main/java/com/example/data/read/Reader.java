package com.example.data.read;

import java.io.File;
import java.util.List;

public interface Reader {

    List<String> readData(File file);
}
