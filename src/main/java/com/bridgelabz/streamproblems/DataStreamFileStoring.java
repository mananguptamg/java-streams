package com.bridgelabz.streamproblems;


import java.io.*;

// Class to write student data into binary file and retrieve it later using data streams
public class DataStreamFileStoring {
    public static void main(String[] args) {
        // File path to store student date
        String filePath = "src/main/java/com/bridgelabz/streamproblems/StudentData.dat";

        // Use try-catch to handle exceptions
        try {
            // Store details of students
            storeData(filePath);

            // Retrieve details of students
            retrieveData(filePath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // method to write student data to file
    public static void storeData(String filePath) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(101);
            dos.writeUTF("Name: Amit");
            dos.writeDouble(8.57);

            dos.writeInt(102);
            dos.writeUTF("Name: Arjun");
            dos.writeDouble(8.45);
        }
    }

    // method to read student data from a file
    public static void retrieveData(String filePath) throws IOException {
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while(dis.available()>0) {
                int roll_number = dis.readInt();
                String name = dis.readUTF();
                double cgpa = dis.readDouble();
                System.out.println("Roll Number: " + roll_number);
                System.out.println("Name: " + name);
                System.out.println("CGPA: " + cgpa);
                System.out.println();
            }
        }
    }
}