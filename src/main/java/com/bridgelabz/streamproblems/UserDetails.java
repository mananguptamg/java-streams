package com.bridgelabz.streamproblems;

import java.io.*;

public class UserDetails {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/bridgelabz/streamproblems/user_info.txt"; // File to save user data

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) { // Append mode

            // Ask for user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Write to file
            writer.write("User Name: " + name + "\n");
            writer.write("User Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User information saved successfully");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
