/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog2.main;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * DepartmentGUI class represents the graphical user interface for managing department details.
 * It provides functionalities to add, load, and display teacher and staff details.
 */
public class DepartmentGUI extends JFrame {

    /**
     * The department object associated with this GUI.
     */
    public Department department;

    /**
     * Constructs a DepartmentGUI object with the specified department.
     * @param department The department object to associate with this GUI.
     */
    public DepartmentGUI(Department department) {
        this.department = department;

        setTitle("Department Management System");
        setSize(900, 900);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
               super.paintComponent(g);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton addTeacherButton = new JButton("Add Teacher Details");
        JButton LoadTeacherButton = new JButton("Load Teacher Details");
        JButton addStaffButton = new JButton("Add Staff Details");
        JButton LoadStaffButton = new JButton("Load Staff Details");

        Font buttonFont = new Font("Arial", Font.BOLD, 50);
        Color buttonColor = new Color(23, 10, 200);
        addTeacherButton.setFont(buttonFont);
        addTeacherButton.setForeground(buttonColor);
        LoadTeacherButton.setFont(buttonFont);
        LoadTeacherButton.setForeground(buttonColor);
        addStaffButton.setFont(buttonFont);
        addStaffButton.setForeground(buttonColor);
        LoadStaffButton.setFont(buttonFont);
        LoadStaffButton.setForeground(buttonColor);

        panel.add(addTeacherButton);
        panel.add(LoadTeacherButton);
        panel.add(addStaffButton);
        panel.add(LoadStaffButton);

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        getContentPane().add(panel, gbc);

        add(backgroundPanel);
        setVisible(true);
        setLocationRelativeTo(null);

        addTeacherButton.addActionListener((ActionEvent e) -> {
            addTeacher();
        });

        LoadTeacherButton.addActionListener((ActionEvent e) -> {
            loadTeacher();
        });

        addStaffButton.addActionListener((ActionEvent e) -> {
            addStaff();
        });

        LoadStaffButton.addActionListener((ActionEvent e) -> {
            loadStaff();
        });
    }

    /**
     * Method to add a new teacher.
     */
    private void addTeacher() {
        // Implementation code omitted for brevity...
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(5);
        JTextField addressField = new JTextField(15);
        JTextField phoneNumberField = new JTextField(10);
        JTextField specialtyField = new JTextField(10);
        JTextField degreeField = new JTextField(10);
        JTextField hoursWorkedField = new JTextField(5);
        
        JCheckBox isFullTimeBox = new JCheckBox("Full Time");
        isFullTimeBox.setOpaque(false);
        isFullTimeBox.setFont(new Font("Arial", Font.BOLD, 14));
        isFullTimeBox.setForeground(Color.BLUE);
        
        JCheckBox isPartTimeBox = new JCheckBox("Part Time");
        isPartTimeBox.setOpaque(false);
        isPartTimeBox.setFont(new Font("Arial", Font.BOLD, 14));
        isPartTimeBox.setForeground(Color.BLUE);
    

        JPanel teacherPanel = new JPanel();
        teacherPanel.setLayout(new BoxLayout(teacherPanel, BoxLayout.PAGE_AXIS));
        teacherPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Enter Teacher Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        teacherPanel.add(titleLabel);
        teacherPanel.add(Box.createVerticalStrut(20));

        teacherPanel.add(new JLabel("ID:"));
        teacherPanel.add(idField);
        teacherPanel.add(new JLabel("Name:"));
        teacherPanel.add(nameField);
        teacherPanel.add(new JLabel("Age:"));
        teacherPanel.add(ageField);
        teacherPanel.add(new JLabel("Address:"));
        teacherPanel.add(addressField);
        teacherPanel.add(new JLabel("Phone Number:"));
        teacherPanel.add(phoneNumberField);
        teacherPanel.add(new JLabel("Specialty:"));
        teacherPanel.add(specialtyField);
        teacherPanel.add(new JLabel("Degree:"));
        teacherPanel.add(degreeField);
        teacherPanel.add(isFullTimeBox);
        teacherPanel.add(isPartTimeBox);
        teacherPanel.add(new JLabel("Hours Worked:"));
        teacherPanel.add(hoursWorkedField);

        int result = JOptionPane.showConfirmDialog(null, teacherPanel,
                "Enter Teacher Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String address = addressField.getText();
            int phoneNumber = Integer.parseInt(phoneNumberField.getText());
            String specialty = specialtyField.getText();
            String degree = degreeField.getText();
            boolean isFullTime = isFullTimeBox.isSelected();
            boolean isPartTime = isPartTimeBox.isSelected();
            int hoursWorked = Integer.parseInt(hoursWorkedField.getText());

            Teacher teacher = new Teacher(id, name, age, address, phoneNumber, specialty, degree, isFullTime, isPartTime, hoursWorked);
                department.addTeacher(teacher);
                JOptionPane.showMessageDialog(null, "Teacher added successfully.");

                String location = "C:\\Users\\User\\OneDrive\\Desktop\\Teacher.txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(location, true))) {
                    writer.write(teacher.toString());
                    writer.newLine();
                } catch (IOException e) {
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for ID, Age, Phone Number, and Hours Worked.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Department.DepartmentException | Department.DuplicatePersonException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

     /**
     * Method to load teacher details from file.
     */
    private void loadTeacher() {
        // Implementation code omitted for brevity...
        String teachersFilePath = "C:\\Users\\User\\OneDrive\\Desktop\\Teacher.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(teachersFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JOptionPane.showMessageDialog(null, line, "Teacher Details", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for ID, Age, Phone Number, and Hours Worked.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading teacher details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     /**
     * Method to add a new staff member.
     */
    private void addStaff() {
        // Implementation code omitted for brevity...
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(5);
        JTextField addressField = new JTextField(15);
        JTextField phoneNumberField = new JTextField(10);
        JTextField dutyField = new JTextField(15);
        JTextField workloadField = new JTextField(5);

        JPanel staffPanel = new JPanel();
        staffPanel.setLayout(new BoxLayout(staffPanel, BoxLayout.Y_AXIS));
        staffPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Enter Teacher Details");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        staffPanel.add(titleLabel);
        staffPanel.add(Box.createVerticalStrut(20));
        staffPanel.add(new JLabel("ID:"));
        staffPanel.add(idField);
        staffPanel.add(new JLabel("Name:"));
        staffPanel.add(nameField);
        staffPanel.add(new JLabel("Age:"));
        staffPanel.add(ageField);
        staffPanel.add(new JLabel("Address:"));
        staffPanel.add(addressField);
        staffPanel.add(new JLabel("Phone Number:"));
        staffPanel.add(phoneNumberField);
        staffPanel.add(new JLabel("Duty:"));
        staffPanel.add(dutyField);
        staffPanel.add(new JLabel("Workload:"));
        staffPanel.add(workloadField);

        int result = JOptionPane.showConfirmDialog(null, staffPanel,
                "Enter Staff Details", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String address = addressField.getText();
            int phoneNumber = Integer.parseInt(phoneNumberField.getText());
            String duty = dutyField.getText();
            int workload = Integer.parseInt(workloadField.getText());

            Staff staff = new Staff(id, name, age, address, phoneNumber, duty, workload);

            try {
                department.addStaff(staff);
                JOptionPane.showMessageDialog(null, "Staff member added successfully.");

                String locations = "C:\\Users\\User\\OneDrive\\Desktop\\Staff.txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(locations, true))) {
                    writer.write(staff.toString());
                    writer.newLine();
                } catch (IOException e) {
                    e.getMessage();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for ID, Age, Phone Number, and Hours Worked.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Department.DepartmentException | Department.DuplicatePersonException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

        /**
     * Method to load staff details from file.
     */
    private void loadStaff() {
        // Implementation code omitted for brevity...
            String staffFilePath = "C:\\Users\\User\\OneDrive\\Desktop\\Staff.txt";
            try (BufferedReader reader = new BufferedReader(new FileReader(staffFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    JOptionPane.showMessageDialog(null, line, "Staff Details", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for ID, Age, Phone Number, and Hours Worked.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error loading staff details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    /**
     * Main method to instantiate and display the DepartmentGUI.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Department department = new Department(65416, "Computer Science", null);
        new DepartmentGUI(department);
    }
}
