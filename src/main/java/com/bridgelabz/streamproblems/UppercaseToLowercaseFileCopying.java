package com.bridgelabz.streamproblems;

import java.io.*;

// Class to convert uppercase data of a text file to lowercase
class UppercaseToLowercaseFileCopy {
    public static void main(String[] args) {
        // Create paths to store source and destination file
        String sourceFile = "src/main/java/com/bridgelabz/streamproblems/UppercaseToLowercaseSource.txt";
        String destinationFile ="src/main/java/com/bridgelabz/streamproblems/UppercaseToLowercaseDestination.txt";

        // Use try-catch to handle exceptions
        try {
            convertToLowercase(sourceFile, destinationFile);
            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // method to convert uppercase file to lowercase
    public static void convertToLowercase(String sourceFile, String destinationFile) throws  IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {
            String line;
            while((line=br.readLine())!=null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
        }
    }
}
