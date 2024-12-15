package com.example.app.dashboards;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.app.Admin.DBUtils;
import com.example.app.app.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDashboard extends JFrame {

    private JPanel panel;

    public AdminDashboard(String username) {
        setTitle("Admin Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JButton viewTeachersBtn = new JButton("View Teachers");
        JButton viewStudentsBtn = new JButton("View Students");
        JButton viewGradesBtn = new JButton("View Grades");
        JButton addTeacherBtn = new JButton("Add Teacher");
        JButton addStudentBtn = new JButton("Add Student");
        JButton deleteTeacherBtn = new JButton("Delete Teacher");

        panel.add(viewTeachersBtn);
        panel.add(viewStudentsBtn);
        panel.add(viewGradesBtn);
        panel.add(addTeacherBtn);
        panel.add(addStudentBtn);
        panel.add(deleteTeacherBtn);

        add(panel, BorderLayout.CENTER);

        viewTeachersBtn.addActionListener(e -> displayTable("Teachers", "SELECT teacher_username,teacher_password,teacher_course,teacher_course_id FROM teachers", new String[]{"Name", "Password","Course", "Course_id"}));
        viewStudentsBtn.addActionListener(e -> displayTable("Students", "SELECT student_id,student_username,student_password FROM students", new String[]{"ID", "Name", "Password"}));
        viewGradesBtn.addActionListener(e -> displayTable("Grades", "SELECT student_id,teacher_course,mark FROM marks", new String[]{"Student ID", "Course", "Grade"}));
        addTeacherBtn.addActionListener(e -> addTeacher());
        addStudentBtn.addActionListener(e -> addStudent());
        deleteTeacherBtn.addActionListener(e -> deleteTeacher());
        setVisible(true);
    }

    private void displayTable(String title, String query, String[] columnNames) {
       
        JFrame frame = new JFrame(title);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        try (Connection connection = DBUtils.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Object[] rowData = new Object[columnNames.length];
                for (int i = 0; i < columnNames.length; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addTeacher() {
        JTextField nameField = new JTextField();
        JTextField passField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField cIdField = new JTextField();
       
        Object[] fields = {
            "Teacher Username:", nameField,
            "Teacher Password:", passField,
            "Course Course:", courseField,
            "Course Id:", cIdField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Add Teacher", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String query = "INSERT INTO teachers (teacher_username,teacher_password,teacher_course,teacher_course_id) VALUES (?, ?, ?, ?)";
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(query)) {

                stmt.setString(1, nameField.getText());
                stmt.setString(2, passField.getText());
                stmt.setString(3, courseField.getText());
                stmt.setString(4, cIdField.getText());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Teacher added successfully!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    private void addStudent() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField courseField = new JTextField();

        Object[] fields = {
            "Student ID:", idField,
            "Student Name:", nameField,
            "Course:", courseField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String query = "INSERT INTO students (student_id, student_name, student_course) VALUES (?, ?, ?)";
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(query)) {

                stmt.setInt(1, Integer.parseInt(idField.getText()));
                stmt.setString(2, nameField.getText());
                stmt.setString(3, courseField.getText());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Student added successfully!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    private void deleteTeacher() {
        String teacherID = JOptionPane.showInputDialog("Enter Teacher ID to Delete:");

        if (teacherID != null) {
            String query = "DELETE FROM teachers WHERE id = ?";
            try (Connection connection = DBUtils.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(query)) {

                stmt.setInt(1, Integer.parseInt(teacherID));
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Teacher deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Teacher not found.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }

    }
}