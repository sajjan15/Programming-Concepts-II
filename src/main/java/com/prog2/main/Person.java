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

public abstract class Person {
    private int id;
    private String name;
    private int age;
    private String address;
    private int phoneNumber;

    /**
     * Constructs a person with the specified attributes.
     *
     * @param id          The ID of the person.
     * @param name        The name of the person.
     * @param age         The age of the person.
     * @param address     The address of the person.
     * @param phoneNumber The phone number of the person.
     */
    public Person(int id, String name, int age, String address, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the ID of the person.
     *
     * @param id The ID of the person.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the person.
     *
     * @return The ID of the person.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the address of the person.
     *
     * @param address The address of the person.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the address of the person.
     *
     * @return The address of the person.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber The phone number of the person.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return The phone number of the person.
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the category of the person (abstract method to be implemented by subclasses).
     *
     * @return The category of the person.
     */
    public abstract String getCategory();

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The object to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(address, person.address) &&
                Objects.equals(phoneNumber, person.phoneNumber);

    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, address, phoneNumber);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Person [" +
                "Id :'" + id + '\'' +
                ", Name :'" + name + '\'' +
                ", Age :" + age +
                ", Address :'" + address + '\'' +
                ", PhoneNumber :'" + phoneNumber + '\'' +
                ']';
    }
  }

