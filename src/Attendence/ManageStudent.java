package Attendence;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.sql.*;

public class ManageStudent extends JFrame implements ActionListener {
    JTextField idField, nameField, classField;
    JButton addButton, deleteButton, updateButton, clearButton;

    ManageStudent() {
        // Frame settings
        setTitle("Manage Students");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#37474F"));
        setLayout(null);

        Font labelFont = new Font("Times New Roman", Font.BOLD, 16);
        Font textFieldFont = new Font("Times New Roman", Font.PLAIN, 14);
        JLabel back = new JLabel("<BACK");
        back.setFont(labelFont);
        back.setForeground(Color.WHITE);
        back.setBounds(10,25,130,20);
        add(back);
        back.addMouseListener(new MouseAdapter() {
		 
			
		
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new Homepage();
				setVisible(false);
			}
		});

        // ID Label and Field
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setFont(labelFont);
        idLabel.setForeground(Color.decode("#DEE4E7"));
        idLabel.setBounds(50, 50, 120, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setFont(textFieldFont);
        idField.setBounds(200, 50, 300, 30);
        add(idField);

        // Name Label and Field
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.decode("#DEE4E7"));
        nameLabel.setBounds(50, 100, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(textFieldFont);
        nameField.setBounds(200, 100, 300, 30);
        add(nameField);

        // Class Label and Field
        JLabel classLabel = new JLabel("Class:");
        classLabel.setFont(labelFont);
        classLabel.setForeground(Color.decode("#DEE4E7"));
        classLabel.setBounds(50, 150, 120, 25);
        add(classLabel);

        classField = new JTextField();
        classField.setFont(textFieldFont);
        classField.setBounds(200, 150, 300, 30);
        add(classField);

        // Buttons
        addButton = new JButton("Add");
        addButton.setFont(labelFont);
        addButton.setBounds(50, 250, 100, 35);
        addButton.setBackground(Color.decode("#DEE4E7"));
        addButton.setForeground(Color.decode("#37474F"));
        addButton.addActionListener(this);
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setFont(labelFont);
        updateButton.setBounds(180, 250, 100, 35);
        updateButton.setBackground(Color.decode("#DEE4E7"));
        updateButton.setForeground(Color.decode("#37474F"));
        updateButton.addActionListener(this);
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(labelFont);
        deleteButton.setBounds(310, 250, 100, 35);
        deleteButton.setBackground(Color.decode("#DEE4E7"));
        deleteButton.setForeground(Color.decode("#37474F"));
        deleteButton.addActionListener(this);
        add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setFont(labelFont);
        clearButton.setBounds(440, 250, 100, 35);
        clearButton.setBackground(Color.decode("#DEE4E7"));
        clearButton.setForeground(Color.decode("#37474F"));
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String className = classField.getText().trim();

        try {
            Conn conn = new Conn();

            if (e.getSource() == addButton) {
                if (id.isEmpty() || name.isEmpty() || className.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String query = "INSERT INTO students (id, name, class) VALUES (" + id + ", '" + name + "', '" + className + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else if (e.getSource() == updateButton) {
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Student ID is required for update!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String query = "UPDATE students SET name = '" + name + "', class = '" + className + "' WHERE id = " + id;
                int rowsUpdated = conn.s.executeUpdate(query);
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (e.getSource() == deleteButton) {
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Student ID is required for deletion!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String query = "DELETE FROM students WHERE id = " + id;
                int rowsDeleted = conn.s.executeUpdate(query);
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Student deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (e.getSource() == clearButton) {
                idField.setText("");
                nameField.setText("");
                classField.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format! ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ManageStudent();
    }
}
