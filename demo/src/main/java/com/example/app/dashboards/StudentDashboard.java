package com.example.app.dashboards;

import javax.swing.*;

import com.example.app.app.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame {

    public StudentDashboard(String username) {
        setTitle("Student Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel welcomeLabel = new JLabel("Welcome, Student: " + username, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(welcomeLabel);

        JButton viewGradesButton = new JButton("View Grades");
        viewGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(StudentDashboard.this, "Viewing Grades...");
            }
        });
        panel.add(viewGradesButton);

        JButton viewCoursesButton = new JButton("View Courses");
        viewCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(StudentDashboard.this, "Viewing Courses...");
            }
        });
        panel.add(viewCoursesButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new main();
                dispose();
            }
        });
        panel.add(logoutButton);

        add(panel);
        setVisible(true);
    }
}
