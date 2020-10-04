package com.bergaz.intermediate.the_core_platform.section_04;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Formatter;

public class WriteFormattedContentOnStream {
    public static void main(String[] args) {
        String inputFileLocation = LocalFilePath.getPath() + "/input.txt";

        try (Writer writer = Files.newBufferedWriter(Paths.get(inputFileLocation));
             Formatter formatter = new Formatter(writer)) {
            formatter.format("Hello this is a formatter test on writer %d %f %e \n", 123, 123.123f, 1234.77);
            formatter.format("Hello this is a formatter test on writer %d %f %e \n", 9123, 9123.123f, 91234.77);
            formatter.format(">% 10d< >%-10d< >%,010d< >%,( 010d< \n", 11, 222, 3333, 4444);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
