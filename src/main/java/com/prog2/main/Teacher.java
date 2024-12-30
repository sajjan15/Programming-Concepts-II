/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.main;

/**
 *
 * @author User
 */
import java.util.Objects;

/**
 * Represents a teacher in an educational institution.
 */
public class Teacher extends Person {
    private String specialty;
    private String degree;
    private boolean isFullTime;
    private boolean isPartTime;
    private int hoursWorked;


    /**
     * Constructs a teacher with the specified attributes.
     *
     * @param id          The ID of the teacher.
     * @param name        The name of the teacher.
     * @param age         The age of the teacher.
     * @param address     The address of the teacher.
     * @param phoneNumber The phone number of the teacher.
     * @param degree      The degree of the teacher.
     * @param specialty   The specialty of the teacher.
     * @param isFullTime  Whether the teacher is full-time.
     * @param isPartTime  Whether the teacher is part-time.
     * @param hoursWorked The hours worked by the teacher.
     */
    public Teacher(int id, String name, int age, String address, int phoneNumber, String specialty, String degree, boolean isFullTime, boolean isPartTime, int hoursWorked) {
        super(id, name, age, address, phoneNumber);
        this.specialty = specialty;
        this.degree = degree;
        this.isFullTime = isFullTime;
        this.isPartTime = isPartTime;
        this.hoursWorked = hoursWorked;
    }

    /**
     * Sets the ID of the Teacher.
     *
     * @param id The ID of the Teacher.
     */
    @Override
    public void setId(int id) {
        super.setId(id);
    }

    /**
     * Gets the ID of the Teacher.
     *
     * @return The ID of the Teacher.
     */
    @Override
    public int getId() {
        return super.getId();
    }

    /**
     * Sets the name of the Teacher.
     *
     * @param name The ID of the Teacher.
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * Gets the ID of the Teacher.
     *
     * @return The ID of the Teacher.
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Sets the age of the Teacher.
     *
     * @param age The ID of the Teacher.
     */
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    /**
     * Gets the age of the Teacher.
     *
     * @return The age of the Teacher.
     */
    @Override
    public int getAge() {
        return super.getAge();
    }

    /**
     * Sets the address of the Teacher.
     *
     * @param address The ID of the Teacher.
     */
    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    /**
     * Gets the address of the Teacher.
     *
     * @return The address of the Teacher.
     */
    @Override
    public String getAddress() {
        return super.getAddress();
    }

    /**
     * Sets the phoneNumber of the Teacher.
     *
     * @param phoneNumber The ID of the Teacher.
     */
    @Override
    public void setPhoneNumber(int phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    /**
     * Gets the phoneNumber of the Teacher.
     *
     * @return The phoneNumber of the Teacher.
     */
    @Override
    public int getPhoneNumber() {
        return super.getPhoneNumber();
    }

/**
     * Sets the degree of the teacher.
     *
     * @param degree The degree of the teacher.
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * Gets the degree of the teacher.
     *
     * @return The degree of the teacher.
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Sets the specialty of the teacher.
     *
     * @param specialty The specialty of the teacher.
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Gets the specialty of the teacher.
     *
     * @return The specialty of the teacher.
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets whether the teacher is full-time.
     *
     * @param fullTime true if the teacher is full-time, false otherwise.
     */
    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    /**
     * Checks whether the teacher is full-time.
     *
     * @return true if the teacher is full-time, false otherwise.
     */
    public boolean isFullTime() {
        return isFullTime;
    }

    /**
     * Sets whether the teacher is part-time.
     *
     * @param partTime true if the teacher is part-time, false otherwise.
     */
    public void setPartTime(boolean partTime) {
        isPartTime = partTime;
    }

    /**
     * Checks whether the teacher is part-time.
     *
     * @return true if the teacher is part-time, false otherwise.
     */
    public boolean isPartTime() {
        return isPartTime;
    }

    /**
     * Sets the hours worked by the teacher.
     *
     * @param hoursWorked The hours worked by the teacher.
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Gets the hours worked by the teacher.
     *
     * @return The hours worked by the teacher.
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The object to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return isFullTime == teacher.isFullTime &&
                isPartTime == teacher.isPartTime &&
                hoursWorked == teacher.hoursWorked &&
                Objects.equals(specialty, teacher.specialty) &&
                Objects.equals(degree, teacher.degree);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialty, degree, isFullTime, isPartTime, hoursWorked);
    }

    /**
     * Gets the category of the person (Teacher).
     *
     * @return The category of the person (Teacher).
     */
    @Override
    public String getCategory() {
        return "Teacher";
    }
    
    /**
     * Computes the payroll for the staff member.
     *
     * @return The payroll for the staff member.
     */
    public double ComputePayRoll() {
        double DEGREE_RATE_PHD = 112;
        double DEGREE_RATE_MASTER = 82;
        double DEGREE_RATE_BACHELOR = 42;
        double degreeRate = 0;

        if (null == getDegree()) {
        } else {
            switch (getDegree()) {
                case "PhD" -> degreeRate = DEGREE_RATE_PHD;
                case "Master" -> degreeRate = DEGREE_RATE_MASTER;
                case "Bachelor" -> degreeRate = DEGREE_RATE_BACHELOR;
                default -> {
                }
            }
        }

        if (isFullTime) {
            return (32 * degreeRate * 2) * 0.85;
        } else {
            return (hoursWorked * degreeRate * 2) * 0.76;
        }
    }
    
    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        String teacherDetails = "Teacher Details: [" +
                super.toString() + ", " +
                "Specialty: " + specialty + ", " +
                "Degree: " + degree + ", " +
                "Full Time: " + isFullTime;
        
        if (isFullTime) {
            double salary = ComputePayRoll();
            teacherDetails += ", Salary (Full-Time";
            if (null == degree) {
                teacherDetails += " Unknown): N/A";
            } else switch (degree) {
                case "PhD" -> teacherDetails += " PhD): $" + salary;
                case "Master" -> teacherDetails += " Master): $" + salary;
                case "Bachelor" -> teacherDetails += " Bachelor): $" + salary;
                default -> teacherDetails += " Unknown): N/A";
            }
        } else {
            double salary = ComputePayRoll();
            teacherDetails += ", Salary (Part-Time): $" + salary;
        }

        teacherDetails += "]";
        return teacherDetails;
    }
    
    public static void main(String[] args) {
        Teacher teacher = new Teacher(22, "Chris cade", 27, "225 main street", 5142255, "Mathematics", "PhD", true, false, 36);
        System.out.println(teacher);
    }
}

