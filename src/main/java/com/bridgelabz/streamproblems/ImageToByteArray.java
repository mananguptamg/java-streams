package com.bridgelabz.streamproblems;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputFilePath = "src/main/java/com/bridgelabz/streamproblems/originalLogo.jpeg";
        String outputFilePath = "src/main/java/com/bridgelabz/streamproblems/copiedLogo.jpeg";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(inputFilePath);

            // Write byte array back to new image file
            writeByteArrayToImage(imageBytes, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Reads an image file and converts it into a byte array.
    private static byte[] convertImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[8192]; // 8 KB buffer
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    //Writes a byte array back to an image file
    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[8192]; // 8 KB buffer
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image successfully copied.");
        }
    }
}
