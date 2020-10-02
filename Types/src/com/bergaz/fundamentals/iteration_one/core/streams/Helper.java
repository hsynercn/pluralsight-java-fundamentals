package com.bergaz.fundamentals.iteration_one.core.streams;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    static public Reader openReader(String fileName) throws IOException {
        return Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8);
    }

    static public Writer openWriter(String fileName) throws IOException {
        return Files.newBufferedWriter(Paths.get(fileName),  StandardCharsets.UTF_8);
    }

}
