package com.bridgelabz.streamproblems;

import java.io.*;

public class CopyingLargeFile {

    public static void main(String[] args) {
        String largeFile = "src/main/java/com/bridgelabz/streamproblems/largeFile.txt";
        String destinationFile = "src/main/java/com/bridgelabz/streamproblems/copiedLargeFile.txt";

        // Generate a 100MB file
        generateLargeFile(largeFile, 100 * 1024 * 1024); // 100MB

        // Copy the large file using buffered streams
        long startTime = System.nanoTime();
        copyLargeFile(largeFile, destinationFile);
        long endTime = System.nanoTime();

        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("File copy completed in %.3f seconds.\n", elapsedTimeInSeconds);
    }

    // Function to generate a large file of given size (in bytes)
    public static void generateLargeFile(String filePath, int sizeInBytes) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024]; // 1KB buffer
            int bytesWritten = 0;

            while (bytesWritten < sizeInBytes) {
                fos.write(buffer); // Write 1KB at a time
                bytesWritten += buffer.length;
            }
        } catch (IOException e) {
            System.err.println("Error generating file: " + e.getMessage());
        }
    }

    // Function to copy a large file using BufferedInputStream and BufferedOutputStream
    public static void copyLargeFile(String sourceFile, String destinationFile) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[4186]; // 4KB buffer for efficiency
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
