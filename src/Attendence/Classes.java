package Attendence;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Classes extends JFrame implements ActionListener {
    JButton addButton, deleteButton;
    JTextField idField, classField;

    Classes() {
        // ---------------- Window Setup ----------------
        setTitle("Manage Classes");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#37474F"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ---------------- Fonts ----------------
        Font labelFont = new Font("Times New Roman", Font.BOLD, 18);
        Font inputFont = new Font("Times New Roman", Font.PLAIN, 16);
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

        // ---------------- ID Field ----------------
        JLabel idLabel = new JLabel("Class ID:");
        idLabel.setBounds(50, 50, 120, 30);
        idLabel.setFont(labelFont);
        idLabel.setForeground(Color.decode("#DEE4E7"));
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(180, 50, 150, 30);
        idField.setFont(inputFont);
        idField.setForeground(Color.decode("#37474F"));
        idField.setBackground(Color.decode("#DEE4E7"));
        add(idField);

        // ---------------- Class Name Field ----------------
        JLabel classLabel = new JLabel("Class Name:");
        classLabel.setBounds(50, 120, 120, 30);
        classLabel.setFont(labelFont);
        classLabel.setForeground(Color.decode("#DEE4E7"));
        add(classLabel);

        classField = new JTextField();
        classField.setBounds(180, 120, 150, 30);
        classField.setFont(inputFont);
        classField.setForeground(Color.decode("#37474F"));
        classField.setBackground(Color.decode("#DEE4E7"));
        add(classField);

        // ---------------- Add Button ----------------
        addButton = new JButton("Add Class");
        addButton.setBounds(50, 200, 120, 30);
        addButton.setFont(labelFont);
        addButton.setBackground(Color.decode("#DEE4E7"));
        addButton.setForeground(Color.decode("#37474F"));
        addButton.addActionListener(this);
        add(addButton);

        // ---------------- Delete Button ----------------
        deleteButton = new JButton("Delete Class");
        deleteButton.setBounds(200, 200, 150, 30);
        deleteButton.setFont(labelFont);
        deleteButton.setBackground(Color.decode("#DEE4E7"));
        deleteButton.setForeground(Color.decode("#37474F"));
        deleteButton.addActionListener(this);
        add(deleteButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = idField.getText().trim();
        String className = classField.getText().trim();

        if (e.getSource() == addButton) {
            if (id.isEmpty() || className.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Both ID and Class Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int classId = Integer.parseInt(id);
                Conn conn = new Conn();
                String query = "INSERT INTO class (id, name) VALUES (" + classId + ", '" + className + "')";
                int rowsAffected = conn.s.executeUpdate(query);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Class added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add class.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == deleteButton) {
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID is required to delete a class.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int classId = Integer.parseInt(id);
                Conn conn = new Conn();
                String query = "DELETE FROM class WHERE id = " + classId;
                int rowsAffected = conn.s.executeUpdate(query);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Class deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Class not found or could not be deleted.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Clear input fields
        idField.setText("");
        classField.setText("");
    }

    public static void main(String[] args) {
        new Classes();
    }
}
