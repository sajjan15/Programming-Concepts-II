/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.main;

/**
 *
 * @author User
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileReader;

/**
 * The Department class represents a department in an educational institution.
 * It manages information about teachers and staff members associated with the department.
 */
public class Department {
    private int departmentId;
    private String name;
    private Teacher dean;
    private List<Teacher> teachers;
    private List<Staff> staff;

     /**
     * Constructs a department with the specified ID, name, and dean.
     *
     * @param departmentId The ID of the department.
     * @param name         The name of the department.
     * @param dean         The dean of the department.
     */
    public Department(int departmentId, String name, Teacher dean) {
        this.departmentId = departmentId;
        this.name = name;
        this.dean = dean;
        this.teachers = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    /**
     * Sets the ID of the department.
     *
     * @param departmentId The ID of the department.
     */
    public void setId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets the ID of the department.
     *
     * @return The ID of the department.
     */
    public int getId() {
        return departmentId;
    }

    /**
     * Sets the name of the department.
     *
     * @param name The name of the department.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the department.
     *
     * @return The name of the department.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the dean of the department.
     *
     * @param dean The dean of the department.
     */
    public void setDean(Teacher dean) {
        this.dean = dean;
    }

    /**
     * Gets the dean of the department.
     *
     * @return The dean of the department.
     */
    public Teacher getDean() {
        return dean;
    }

    /**
     * Sets the list of teachers in the department.
     *
     * @param teachers The list of teachers in the department.
     */
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * Gets the list of teachers in the department.
     *
     * @return The list of teachers in the department.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Sets the list of staff members in the department.
     *
     * @param staff The list of staff members in the department.
     */
    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    /**
     * Gets the list of staff members in the department.
     *
     * @return The list of staff members in the department.
     */
    public List<Staff> getStaff() {
        return staff;
    }
    
    /**
     * Assigns a new dean to the department.
     * @param newDean The new dean to be assigned.
     */
    public void assignDean(Teacher newDean) {
        this.dean = newDean;
        System.out.println("New dean assigned to the department: " + newDean.getId());
    }

    /**
     * The DepartmentException class represents an exception specific to the Department class.
     */
    public static class DepartmentException extends Exception {
        public DepartmentException(String message) {
            super(message);
        }
    }

    /**
     * The DuplicatePersonException class represents an exception thrown when a duplicate person is added to the department.
     */
    public static class DuplicatePersonException extends Exception {
        public DuplicatePersonException(String message) {
            super(message);
        }
    }
     /**
     * Reads teacher details from a file and returns a list of teachers.
     * @return A list of Teacher objects read from the file.
     */
    public static List<Teacher> readTeachersFromFile() {
    List<Teacher> teachersList = new ArrayList<>();
    String teachersFilePath = "C:\\Users\\User\\OneDrive\\Desktop\\Teacher.txt";
    try (BufferedReader tch = new BufferedReader(new FileReader(teachersFilePath))) {
        String line;
        while ((line = tch.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 10) {
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                String address = parts[3].trim();
                int phoneNumber = Integer.parseInt(parts[4].trim());
                String specialty = parts[5].trim();
                String degree = parts[6].trim();
                boolean isFullTime = Boolean.parseBoolean(parts[7].trim());
                boolean isPartTime = Boolean.parseBoolean(parts[8].trim());
                int hoursWorked = Integer.parseInt(parts[9].trim());
                
                Teacher teacher = new Teacher(id, name, age, address, phoneNumber, specialty, degree, isFullTime, isPartTime, hoursWorked);
                teachersList.add(teacher);
            }
        }
    } catch (IOException e) {
        System.out.println("Error Message: " + e.getMessage());
    }
    return teachersList;
}

    /**
     * Writes teacher details to a file based on user input.
     */
    public static void writeTeachersFromFile() {
        String location = "C:\\Users\\User\\OneDrive\\Desktop\\Teacher.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(location)))
        {
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Enter details for Teacher:");
            System.out.print("Id: ");
            int Id = Integer.parseInt(inputScanner.nextLine());
            System.out.print("Name: ");
            String Name = inputScanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(inputScanner.nextLine());
            System.out.print("Address: ");
            String address = inputScanner.nextLine();
            System.out.print("phoneNumber: ");
            int phoneNumber = Integer.parseInt(inputScanner.nextLine());
            System.out.print("Specialty: ");
            String specialty = inputScanner.nextLine();
            System.out.print("Degree: ");
            String degree = inputScanner.nextLine();
            System.out.print("Is Full Time (true/false): ");
            boolean isFullTime = Boolean.parseBoolean(inputScanner.nextLine());
            System.out.print("Is Part Time (true/false): ");
            boolean isPartTime = Boolean.parseBoolean(inputScanner.nextLine());
            System.out.print("Hours Worked: ");
            int hoursWorked = Integer.parseInt(inputScanner.nextLine());

            Teacher teacher = new Teacher(Id, Name,age,address,phoneNumber,specialty,degree,isFullTime,isPartTime,hoursWorked);
            System.out.println("");
            System.out.println(teacher.toString());
            writer.write(teacher.toString());
            writer.newLine();

            System.out.println("\nData has been written to the file\n");

        } catch (IOException e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        }
    }

    /**
     * Adds a teacher to the department.
     *
     * @param teacher The teacher to be added.
     * @throws DepartmentException    If there is an issue with the department.
     * @throws DuplicatePersonException If the teacher already exists in the department.
     */
    public void addTeacher(Teacher teacher) throws DepartmentException, DuplicatePersonException {
        for (Object obj : teachers) {
            if (obj instanceof Teacher existingTeacher) {
                if (Objects.equals(existingTeacher.getId(), teacher.getId())) {
                    throw new DuplicatePersonException("Teacher with ID " + teacher.getId() + " already exists in the department.");
                }
            }
        }
        teachers.add(teacher);
    }

    /**
     * Reads staff data from a file and returns a list of staff members.
     *
     * @return A list of staff members read from the file.
     */
    public static List<Staff> readStaffFromFile() {
     List<Staff> staffList = new ArrayList<>();  
    String staffFilePath = "C:\\Users\\User\\OneDrive\\Desktop\\Staff.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(staffFilePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >=  7) {
                 int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                String address = parts[3].trim();
                int phoneNumber = Integer.parseInt(parts[4].trim());
                String duty = parts[5].trim();
                int workload = Integer.parseInt(parts[6].trim());

                Staff staff = new Staff(id, name, age, address, phoneNumber, duty, workload);
                 staffList.add(staff);
                
            }
        }
    } catch (IOException e) {
        System.out.println("Error Message: " + e.getMessage());
    }
    return staffList;
}

    /**
     * Writes staff data to a file.
     */
    public static void writeStaffFromFile() {
        String location = "C:\\Users\\User\\OneDrive\\Desktop\\Staff.txt";
        try(BufferedWriter writers = new BufferedWriter(new FileWriter(location)))
        {
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Enter details for Staff:");
            System.out.print("Id: ");
            int Id = Integer.parseInt(inputScanner.nextLine());
            System.out.print("Name: ");
            String Name = inputScanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(inputScanner.nextLine());
            System.out.print("Address: ");
            String address = inputScanner.nextLine();
            System.out.print("phoneNumber: ");
            int phoneNumber = Integer.parseInt(inputScanner.nextLine());
            System.out.print("Duty: ");
            String duty = inputScanner.nextLine();
            System.out.print("Workload: ");
            int workload = Integer.parseInt(inputScanner.nextLine());

            Staff staff = new Staff(Id, Name,age,address,phoneNumber,duty,workload);
            System.out.println("");
            System.out.println(staff.toString());
            writers.write(staff.toString());
            writers.newLine();

            System.out.println("\nData has been written to the file\n");

        } catch (IOException e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        }
    }

    /**
     * Adds a staff member to the department.
     *
     * @param staffmember The staff member to be added.
     * @throws DepartmentException    If there is an issue with the department.
     * @throws DuplicatePersonException If the staff member already exists in the department.
     */
    public void addStaff(Staff staffmember) throws DepartmentException, DuplicatePersonException {
        for (Object obj : staff) {
            if (obj instanceof Staff existingStaff) {
                if (Objects.equals(existingStaff.getId(), staffmember.getId())) {
                    throw new DuplicatePersonException("Teacher with ID " + staffmember.getId() + " already exists in the department.");
                }
            }
        }
        staff.add(staffmember);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Department [" +
                "Id : '" + departmentId + '\'' +
                ", Name :'" + name + '\'' +
                ", Dean :" + dean +
                ", Teachers :" + teachers +
                ", Staff :" + staff +
                ']';
         }

    public static void main(String[] args) {
     
       // Department one = new Department(255, "sajjan", new Teacher(255, "sajjan", 15, "3361 rue st" , 514552265, "Mathematics", "Masters", true, false, 25));
       // System.out.println(one);
        writeTeachersFromFile(); 
      //  writeStaffFromFile();
       // readStaffFromFile();
       // readTeachersFromFile();  
        
      }
    }


