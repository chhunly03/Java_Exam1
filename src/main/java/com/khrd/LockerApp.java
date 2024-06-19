package com.khrd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LockerApp {
    private static String savedPassword = null;
    private static StringBuilder enteredPassword = new StringBuilder();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lock Class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);


        JTextField passwordField = new JTextField(20);
        passwordField.setEditable(false);


        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            addButton(buttonPanel, String.valueOf(i), passwordField);
        }

//        button
        JButton enterButton = new JButton("Enter");
        JButton clearButton = new JButton("Clear");


        JLabel statusLabel = new JLabel("Enter Password");

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (savedPassword == null) {
                    savedPassword = enteredPassword.toString();
                    statusLabel.setText("Password Set");
                } else {
                    if (savedPassword.equals(enteredPassword.toString())) {
                        statusLabel.setText("Correct Password");
                    } else {
                        statusLabel.setText("Incorrect Password");
                    }
                }
                enteredPassword.setLength(0);
                passwordField.setText("");

                if (savedPassword == null) {
                    statusLabel.setText("Enter Password");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enteredPassword.setLength(0);
                passwordField.setText("");
                statusLabel.setText("Enter Password");
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(passwordField, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(clearButton);
        inputPanel.add(passwordField);
        inputPanel.add(enterButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(statusLabel, BorderLayout.LINE_START);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);


        frame.getContentPane().add(mainPanel);


        frame.setVisible(true);
    }

    private static void addButton(JPanel panel, String label, JTextField passwordField) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enteredPassword.append(label);
                passwordField.setText(enteredPassword.toString());
            }
        });
        panel.add(button);
    }
}
