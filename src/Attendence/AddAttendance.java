package Attendence;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddAttendance extends JFrame implements ActionListener {
    JButton addButton, clearButton;
    JTextField classField, nameField, dateField;

    AddAttendance() {
        // ---------------- Window Setup ----------------
        setTitle("Add Attendance");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#37474F"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ---------------- Fonts ----------------
        Font labelFont = new Font("Times New Roman", Font.BOLD, 18);
        Font inputFont = new Font("Times New Roman", Font.PLAIN, 16);
        JLabel back = new JLabel("<BACK");
        back.setFont(inputFont);
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

        // ---------------- Class Field ----------------
        JLabel classLabel = new JLabel("Class:");
        classLabel.setBounds(50, 50, 100, 30);
        classLabel.setFont(labelFont);
        classLabel.setForeground(Color.decode("#DEE4E7"));
        add(classLabel);

        classField = new JTextField();
        classField.setBounds(150, 50, 250, 30);
        classField.setFont(inputFont);
        classField.setForeground(Color.decode("#37474F"));
        classField.setBackground(Color.decode("#DEE4E7"));
        add(classField);

        // ---------------- Name Field ----------------
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.decode("#DEE4E7"));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 100, 250, 30);
        nameField.setFont(inputFont);
        nameField.setForeground(Color.decode("#37474F"));
        nameField.setBackground(Color.decode("#DEE4E7"));
        add(nameField);

        // ---------------- Date Field ----------------
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 150, 100, 30);
        dateLabel.setFont(labelFont);
        dateLabel.setForeground(Color.decode("#DEE4E7"));
        add(dateLabel);

        dateField = new JTextField(LocalDate.now().toString());
        dateField.setBounds(150, 150, 250, 30);
        dateField.setFont(inputFont);
        dateField.setForeground(Color.decode("#37474F"));
        dateField.setBackground(Color.decode("#DEE4E7"));
        dateField.setEditable(false);
        add(dateField);

        // ---------------- Add Button ----------------
        addButton = new JButton("Add");
        addButton.setBounds(150, 200, 100, 30);
        addButton.setFont(labelFont);
        addButton.setBackground(Color.decode("#DEE4E7"));
        addButton.setForeground(Color.decode("#37474F"));
        addButton.addActionListener(this);
        add(addButton);

        // ---------------- Clear Button ----------------
        clearButton = new JButton("Clear");
        clearButton.setBounds(300, 200, 100, 30);
        clearButton.setFont(labelFont);
        clearButton.setBackground(Color.decode("#DEE4E7"));
        clearButton.setForeground(Color.decode("#37474F"));
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String className = classField.getText();
            String studentName = nameField.getText();
            String currentDate = dateField.getText();

            if (className.isEmpty() || studentName.isEmpty()) {
                System.out.println("Class and Name fields cannot be empty.");
                return;
            }

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO attend (stid, dt, status, class) " +
                               "SELECT id, '" + currentDate + "', 'Present', '" + className + "' " +
                               "FROM students WHERE name = '" + studentName + "';";
                int rowsAffected = conn.s.executeUpdate(query);

                if (rowsAffected > 0) {
                    System.out.println("Attendance added successfully.");
                    JOptionPane.showMessageDialog(addButton, "Added successfully");
                    classField.setText("");
                    
                } else {
                    System.out.println("No matching student found or attendance not added.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == clearButton) {
            classField.setText("");
            nameField.setText("");
        }
    }

    public static void main(String[] args) {
        new AddAttendance();
    }
}
