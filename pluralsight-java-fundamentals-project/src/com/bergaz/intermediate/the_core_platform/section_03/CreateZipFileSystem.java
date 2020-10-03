package com.bergaz.intermediate.the_core_platform.section_03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateZipFileSystem {
    public static void main(String[] args) {
        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };

        String zipFilePath = LocalFilePath.getPath() + "/test_data.zip";
        String inputFilePath = LocalFilePath.getPath() + "/input.txt";

        try (FileSystem zipFileSystem = openZip(Paths.get(zipFilePath))) {
            copyToZip(inputFilePath, zipFileSystem);
            writeToZipOne(zipFileSystem, data);
            writeToZipTwo(zipFileSystem, data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void writeToZipTwo(FileSystem zipFileSystem, String[] data) throws IOException {
        Files.write(zipFileSystem.getPath("writeToZipTwo.txt"),
                Arrays.asList(data),
                Charset.defaultCharset(),
                StandardOpenOption.CREATE);
    }

    private static void writeToZipOne(FileSystem zipFileSystem, String[] data) throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(zipFileSystem.getPath("/writeToZipOne.txt"));
        for (String line : data) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static void copyToZip(String sourceFilePathString, FileSystem targetZipFs) throws IOException {
        /**
         * This two lines gives same source file path, Paths.get is just a shortcut
         */
        Path sourceFile = FileSystems.getDefault().getPath(sourceFilePathString);
        Path sameSourceFile = Paths.get(sourceFilePathString);

        Path destFile = targetZipFs.getPath("copied_file.txt");

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static FileSystem openZip(Path path) throws URISyntaxException, IOException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");
        URI zipUri = new URI("jar:file", path.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri, providerProps);
        return zipFs;
    }
}
