package com.bergaz.intermediate.the_core_platform.section_03;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathSamples {
    public static void main(String[] args) {
        Path path = Paths.get("/documents/data/foo.txt");
        Path path1h = Paths.get("/documents", "/data", "/foo.txt");
    }
}
