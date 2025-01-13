package Attendence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Homepage extends JFrame{
	Font fontstyle = new Font("Times New Roman",Font.BOLD,20);
			
	JLabel welcome;
	JButton students, addAttendance, editAttendance, admin,classes;
	Homepage()
	{
		//-------------------Welcome---------------------------------
		 welcome = new JLabel("Welcome Admin");
		welcome.setForeground(Color.decode("#DEE4E7"));
		welcome.setBounds(460, 10, 250, 20);
		welcome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(welcome);
		//-------------------------
		
		
		//----------------------STUDENTS----------------------------
		 students = new JButton("STUDENTS");
		students.setBounds(150, 70, 800, 50);
		students.setFont(fontstyle);
		students.setBackground(Color.decode("#DEE4E7"));
		students.setForeground(Color.decode("#37474F"));
		add(students);
		//----------------------------------------------------------
		
		//----------------------ADD ATTENDANCE----------------------------
		addAttendance = new JButton("Add Attendance");
		addAttendance.setBounds(150, 145, 400, 50);
		addAttendance.setFont(fontstyle);
		addAttendance.setBackground(Color.decode("#DEE4E7"));
		addAttendance.setForeground(Color.decode("#37474F"));
		add(addAttendance);
		//---------------------------
		
		//----------------------Edit ATTENDANCE----------------------------
		editAttendance = new JButton("Edit Attendance");
		editAttendance.setBounds(560, 145, 390, 50);
		editAttendance.setFont(fontstyle);
		editAttendance.setBackground(Color.decode("#DEE4E7"));
		editAttendance.setForeground(Color.decode("#37474F"));
		add(editAttendance);
		//---------------------------
		
		//----------------------Admin----------------------------
		admin = new JButton("Admin");
		admin.setBounds(150, 220, 400, 50);
		admin.setFont(fontstyle);
		admin.setBackground(Color.decode("#DEE4E7"));
		admin.setForeground(Color.decode("#37474F"));
		add(admin);
		//---------------------------
		
		//----------------------class----------------------------
		classes = new JButton("Class");
				classes.setBounds(560, 220, 390, 50);
				classes.setFont(fontstyle);
				classes.setBackground(Color.decode("#DEE4E7"));
				classes.setForeground(Color.decode("#37474F"));
				add(classes);
		//---------------------------

				setSize(1000,600);
				setLocation(70,0);
				setLayout(null);
				getContentPane().setBackground(Color.decode("#37474F"));
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
//	public static void main(String[] args) {
//		new Homepage();
//	}
	
}
