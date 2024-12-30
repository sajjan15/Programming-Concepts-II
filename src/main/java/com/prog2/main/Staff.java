/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.main;

/**
 *
 * @author User
 */
/**
 * Represents a staff member in an educational institution.
 */
public class Staff extends Person {
    private String duty;
    private int workload;

    /**
     * Constructs a staff member with the specified attributes.
     *
     * @param id          The ID of the staff member.
     * @param name        The name of the staff member.
     * @param age         The age of the staff member.
     * @param address     The address of the staff member.
     * @param phoneNumber The phone number of the staff member.
     * @param duty        The duty or role of the staff member.
     * @param workload    The workload of the staff member.
     */
    public Staff(int id, String name, int age, String address, int phoneNumber, String duty, int workload) {
        super(id, name, age, address, phoneNumber);
        this.duty = duty;
        this.workload = workload;
    }

    /**
     * Sets the ID of the staff member.
     *
     * @param id The ID of the staff member.
     */
    @Override
    public void setId(int id) {
        super.setId(id);
    }

    /**
     * Gets the ID of the staff member.
     *
     * @return The ID of the staff member.
     */
    @Override
    public int getId() {
        return super.getId();
    }

    /**
     * Sets the name of the staff member.
     *
     * @param name The ID of the staff member.
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * Gets the ID of the staff member.
     *
     * @return The ID of the staff member.
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Sets the age of the staff member.
     *
     * @param age The ID of the staff member.
     */
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    /**
     * Gets the age of the staff member.
     *
     * @return The age of the staff member.
     */
    @Override
    public int getAge() {
        return super.getAge();
    }

    /**
     * Sets the address of the staff member.
     *
     * @param address The ID of the staff member.
     */
    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    /**
     * Gets the address of the staff member.
     *
     * @return The address of the staff member.
     */
    @Override
    public String getAddress() {
        return super.getAddress();
    }

    /**
     * Sets the phoneNumber of the staff member.
     *
     * @param phoneNumber The ID of the staff member.
     */
    @Override
    public void setPhoneNumber(int phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    /**
     * Gets the phoneNumber of the staff member.
     *
     * @return The phoneNumber of the staff member.
     */
    @Override
    public int getPhoneNumber() {
        return super.getPhoneNumber();
    }

    /**
     * Sets the duty of the staff member.
     *
     * @param duty The duty or role of the staff member.
     */
    public void setDuty(String duty) {

        this.duty = duty;
    }

    /**
     * Gets the duty of the staff member.
     *
     * @return The duty of the staff member.
     */
    public String getDuty() {

        return duty;
    }

    /**
     * Sets the workload of the staff member.
     *
     * @param workload The workload of the staff member.
     */
    public void setWorkload(int workload) {

        this.workload = workload;
    }

    /**
     * Gets the workload of the staff member.
     *
     * @return The workload of the staff member.
     */
    public int getWorkload() {

        return workload;
    }

    /**
     * Gets the category of the person (Staff).
     *
     * @return The category of the person (Staff).
     */
    @Override
    public String getCategory() {

        return "Staff";
    }

    /**
     * Computes the payroll for the staff member.
     *
     * @return The payroll for the staff member.
     */
    public double ComputePayRoll() {

        return (workload * 32 * 2) *0.75;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Staff [" + super.toString() +
                ", Duty :'" + duty + '\'' +
                ", Workload :" + workload + ", weekly pay: $" + this.ComputePayRoll() +
                ", " + ']';
    }
    public static void main(String[] args) {
        Staff staff = new Staff(25, "david", 255, "186 evelyn st", 5142266, "Adminidtrator", 38);
        System.out.println(staff);
    }
}

