package com.bridgelabz.streamproblems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class ReadingFile {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/com/bridgelabz/streamproblems/OriginalFile.txt";
        String destinationFile = "src/main/java/com/bridgelabz/streamproblems/CopiedFile.txt";

        // Check if the source file exists
        File file = new File(sourceFile);
        if (!file.exists()) {
            System.out.println("Error: Source file '" + sourceFile + "' does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
