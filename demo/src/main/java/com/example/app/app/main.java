package com.example.app.app;

import com.example.app.Admin.DBUtils;
import com.example.app.Admin.admin;
import com.example.app.Parent.parent;
import com.example.app.Teacher.teacher;
import com.example.app.Student.student;
import com.example.app.dashboards.*;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

    private static JFrame frame;

    public static void main(String[] args) {
        
        frame = new JFrame("Student Marking System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel loginPanel = createLoginPanel();
        frame.add(loginPanel);
        frame.setVisible(true);
    }

    private static JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(null);

        JLabel titleLabel = new JLabel("Login to Student Marking System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 20, 300, 30);
        loginPanel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(150, 80, 80, 25);
        loginPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(250, 80, 150, 25);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 120, 80, 25);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 120, 150, 25);
        loginPanel.add(passwordField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(150, 160, 80, 25);
        loginPanel.add(roleLabel);

        String[] roles = {"Admin", "Teacher", "Student", "Parent"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(250, 160, 150, 25);
        loginPanel.add(roleComboBox);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 200, 100, 30);
        loginPanel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) roleComboBox.getSelectedItem();

            if (validateLogin(role, username, password)) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                navigateToRoleDashboard(role, username);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return loginPanel;
    }

    private static boolean validateLogin(String role, String username, String password) {
        boolean isValid = false;
        String query = null;

        switch (role) {
            case "Admin":
                query = "SELECT admin_password FROM admins WHERE admin_username = ?";
                break;
            case "Teacher":
                query = "SELECT teacher_password FROM teachers WHERE teacher_username = ?";
                break;
            case "Student":
                query = "SELECT student_password FROM students WHERE student_username = ?";
                break;
            case "Parent":
                query = "SELECT parent_password FROM parents WHERE parent_username = ?";
                break;
        }

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next() && password.equals(rs.getString(1))) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }

    private static void navigateToRoleDashboard(String role, String username) {
        frame.setVisible(false);

        switch (role) {
            case "Admin":
                new AdminDashboard(username);
                break;
            case "Teacher":
                new TeacherDashboard(username); 
                break;
            case "Student":
                new StudentDashboard(username);
                break;
            case "Parent":
                new ParentDashboard(username);
                break;
        }
    }
}
