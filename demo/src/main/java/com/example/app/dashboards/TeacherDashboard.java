
package com.example.app.dashboards;

import javax.swing.*;

import com.example.app.app.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherDashboard extends JFrame {

    public TeacherDashboard(String username) {
        setTitle("Teacher Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        JLabel welcomeLabel = new JLabel("Welcome, Teacher: " + username, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(welcomeLabel);

        JButton inputGradesButton = new JButton("Input Grades");
        inputGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TeacherDashboard.this, "Inputting Grades...");
            }
        });
        panel.add(inputGradesButton);

        JButton viewStudentsButton = new JButton("View Students");
        viewStudentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TeacherDashboard.this, "Viewing Students...");
            }
        });
        panel.add(viewStudentsButton);

        JButton viewGradesButton = new JButton("View Grades");
        viewGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TeacherDashboard.this, "Viewing Grades...");
            }
        });
        panel.add(viewGradesButton);

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
