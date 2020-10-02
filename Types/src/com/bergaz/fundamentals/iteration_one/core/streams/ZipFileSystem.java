package com.bergaz.fundamentals.iteration_one.core.streams;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZipFileSystem {
    public static void main(String[] args) {
        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5",
        };

        try(FileSystem zipFs = openZip(Paths.get("C:/Pluralsight/pluralsight-java-fundamentals/Types/files/myData.zip"));) {
            copyZip(zipFs, "C:/Pluralsight/pluralsight-java-fundamentals/Types/files/file.txt");
            writeToFleInZip1(zipFs, data);
            writeToFleInZip2(zipFs, data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri, providerProps);
        return zipFs;
    }

    private static FileSystem copyZip(FileSystem zipFs, String sourceFilePathStr) throws IOException {
        //Path sourceFile = Paths.get(sourceFilePathStr);
        Path sourceFile = FileSystems.getDefault().getPath(sourceFilePathStr);
        Path destFile = zipFs.getPath("/copiedFile.txt");

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
        return null;
    }

    private static void writeToFleInZip1(FileSystem zipFs, String[] data) throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"));) {
            for(String line : data) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void writeToFleInZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data),
                Charset.defaultCharset(), StandardOpenOption.CREATE_NEW);
    }
}
