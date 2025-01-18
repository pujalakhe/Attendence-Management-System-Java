package Attendence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Homepage extends JFrame implements ActionListener{
	Font fontstyle = new Font("Times New Roman",Font.BOLD,20);
			
	JLabel welcome;
	JButton students, addAttendance, manageStudent, admin,classes;
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
		 students = new JButton("STUDENTS ATTENDANCE RECORD");
		students.setBounds(150, 70, 800, 50);
		students.setFont(fontstyle);
		students.setBackground(Color.decode("#DEE4E7"));
		students.setForeground(Color.decode("#37474F"));
		add(students);
		students.addActionListener(this);
		//----------------------------------------------------------
		
		//----------------------ADD ATTENDANCE----------------------------
		addAttendance = new JButton("Add Attendance");
		addAttendance.setBounds(150, 145, 400, 50);
		addAttendance.setFont(fontstyle);
		addAttendance.setBackground(Color.decode("#DEE4E7"));
		addAttendance.setForeground(Color.decode("#37474F"));
		add(addAttendance);
		addAttendance.addActionListener(this);
		//---------------------------
		
		//----------------------Edit ATTENDANCE----------------------------
		manageStudent = new JButton("Manage Student");
		manageStudent.setBounds(560, 145, 390, 50);
		manageStudent.setFont(fontstyle);
		manageStudent.setBackground(Color.decode("#DEE4E7"));
		manageStudent.setForeground(Color.decode("#37474F"));
		add(manageStudent);
		manageStudent.addActionListener(this);
		//---------------------------
		
		//----------------------Admin----------------------------
		admin = new JButton("Admin");
		admin.setBounds(150, 220, 400, 50);
		admin.setFont(fontstyle);
		admin.setBackground(Color.decode("#DEE4E7"));
		admin.setForeground(Color.decode("#37474F"));
		add(admin);
		admin.addActionListener(this);
		//---------------------------
		
		//----------------------class----------------------------
		classes = new JButton("Class");
				classes.setBounds(560, 220, 390, 50);
				classes.setFont(fontstyle);
				classes.setBackground(Color.decode("#DEE4E7"));
				classes.setForeground(Color.decode("#37474F"));
				add(classes);
				classes.addActionListener(this);
		//---------------------------

				setSize(1000,600);
				setLocation(70,0);
				setLayout(null);
				getContentPane().setBackground(Color.decode("#37474F"));
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Homepage();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==students) {
			new Student();
			setVisible(false);
		}
		else if(e.getSource()==addAttendance) {
			new AddAttendance();
			setVisible(false);
		}else if(e.getSource()==classes) {
			new Classes();
			setVisible(false);
		}else if(e.getSource()==manageStudent) {
			new ManageStudent();
			setVisible(false);
		}
	}
	
}
