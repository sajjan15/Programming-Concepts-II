/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.prog2.main.Department;
import com.prog2.main.Department.DuplicatePersonException;
import com.prog2.main.Staff;
import com.prog2.main.Teacher;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
/**
 * Test class for the Driver class.
 */
public class DriverTest {
    
    /**
     * Test case to verify adding a new teacher to the department.
     */
    @Test
    public void testAddTeacher() {
        // Create a department with an initial teacher
        Department department = new Department(28, "Mathematics", new Teacher(27, "sajjan Gautam", 25, "3361 Evelyn st", 514576125, "Math", "PhD", true, false, 40));

        try {
            // Add a new teacher
            department.addTeacher(new Teacher(29, "james Bond", 30, "870 Laurent St", 514866522, "Physics", "Master", false, true, 39));
        } catch (Department.DepartmentException | DuplicatePersonException e) {
            fail("Exception should not be thrown");
        }

        // Verify that the teacher is added successfully
        assertEquals(1, department.getTeachers().size());
    }

    /**
     * Test case to verify adding a duplicate teacher to the department.
     */
    @Test
    public void testAddDuplicateTeacher() {
       try {
           // Create a department with an initial teacher
           Department department = new Department(30, "Physics", new Teacher(30, "Bruce Lee", 35, "536 Boleuvard Road", 514255566, "Physics", "Masters", true, false, 34));
           
           // Try to add a duplicate teacher
           department.addTeacher(new Teacher(31, "Dave cole", 30, "456 Elm St", 514236658, "Physics", "Master", false, true, 37));
       } catch (Department.DepartmentException | DuplicatePersonException ex) {
           Logger.getLogger(DriverTest.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    /**
     * Test case to verify adding a new staff member to the department.
     */
    @Test
    public void testAddStaff() {
        // Create a department with an initial teacher
        Department department = new Department(33, "Computer Science", new Teacher(32, "Chris Hemsworth", 35, "236 Laval Road", 514226555, "Computer Science", "PhD", true, false, 36));

        try {
            // Add a new staff member
            department.addStaff(new Staff(34, "Tom Cruise", 33, "893 saint-croix", 51422545, "Administrator", 25));
        } catch (Department.DepartmentException | DuplicatePersonException e) {
            fail("Exception should not be thrown");
        }

        // Verify that the staff member is added successfully
        assertEquals(1, department.getStaff().size());
    }

    /**
     * Test case to verify adding a duplicate staff member to the department.
     */
    @Test
    public void testAddDuplicateStaff() {
        // Create a department with an initial teacher
        Department department = new Department(35, "Computer Science", new Teacher(36, "John Doe", 35, "2559 verdun de cassie", 514226545, "Computer Science", "Bachelor", true, false, 40));
        try {
            // Try to add a duplicate staff member
            department.addStaff(new Staff(37, "Angelina Jolie", 28, "455 vanier street", 5142233, "Assistant Administrator", 38));
        } catch (Department.DepartmentException | DuplicatePersonException e) {
            fail("Exception should not be thrown");
        }

    }
}