package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFiles {
    // reads a file and returns the contents as a string
    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    //    turns a file into a list of strings
    public static String[] fileToList(String path) throws IOException {
        return splitOnNewLines(readFile(path));
    }

    //    splits a string into an array of strings
    public static String[] splitOnNewLines(String s) {
        return s.split("\n");
    }
}
