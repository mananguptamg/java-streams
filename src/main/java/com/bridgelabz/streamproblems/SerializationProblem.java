package com.bridgelabz.streamproblems;

import java.io.*;

// Employee class implementing Serializable
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display method
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary:" + salary);
    }
}

public class SerializationProblem {
    private static final String FILE_NAME = "employee.ser";

    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee(101, "Manan", "SE", 55000);

        // Serialize the employee
        serializeEmployee(employee);

        // Deserialize and display the employee
        Employee retrievedEmployee = deserializeEmployee();
        if (retrievedEmployee != null) {
            System.out.println("\nDeserialized Employee:");
            retrievedEmployee.displayEmployee();
        }
    }

    // Serialize a single employee object to file
    public static void serializeEmployee(Employee employee) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employee);
            System.out.println("Employee serialized successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Serialization Error: " + e.getMessage());
        }
    }

    // Deserialize a single employee object from file
    public static Employee deserializeEmployee() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Employee) ois.readObject();
        } catch (IOException e) {
            System.err.println("Deserialization Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class Not Found Error: " + e.getMessage());
        }
        return null;
    }
}
