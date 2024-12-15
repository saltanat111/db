package com.example.app.dashboards;

import javax.swing.*;

import com.example.app.app.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParentDashboard extends JFrame {

    public ParentDashboard(String username) {
        setTitle("Parent Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel welcomeLabel = new JLabel("Welcome, Parent: " + username, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(welcomeLabel);

        JButton viewChildGradesButton = new JButton("View Child's Grades");
        viewChildGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ParentDashboard.this, "Viewing Child's Grades...");
            }
        });
        panel.add(viewChildGradesButton);

        JButton viewChildCoursesButton = new JButton("View Child's Courses");
        viewChildCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ParentDashboard.this, "Viewing Child's Courses...");
            }
        });
        panel.add(viewChildCoursesButton);

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
