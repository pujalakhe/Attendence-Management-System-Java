package Attendence;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentView extends JFrame{
	DefaultTableModel model;
	 StudentView() {

			//-------------------Welcome---------------------------------
			JLabel welcome = new JLabel("Welcome Student");
			welcome.setForeground(Color.decode("#DEE4E7"));
			welcome.setBounds(10, 20, 250, 20);
			welcome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(welcome);
			//-------------------------
			
			//----------------TABLE---------------------------------
			JTable table=new JTable();
			model = (DefaultTableModel)table.getModel();
			model.addColumn("DATE");
			model.addColumn("STATUS");
			JScrollPane scPane=new JScrollPane(table);
			scPane.setBounds(480, 20, 480, 525);
			table.setFont(new Font("Times New Roman", Font.BOLD, 20));
			table.setRowHeight(50);
			add(scPane);
			//-----------------------
			
			//--------------------------INFO------------------------
			JLabel totalclass = new JLabel("TOTAL CLASSES : ");
			totalclass.setBounds(25, 120, 250, 20);
			totalclass.setForeground(Color.decode("#DEE4E7"));
			totalclass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(totalclass);
			JLabel ttbox = new JLabel("");
			ttbox.setBounds(60, 230, 250, 20);
			ttbox.setForeground(Color.decode("#DEE4E7"));
			ttbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(ttbox);
			
			JLabel classAtt = new JLabel("CLASSES ATTENDED : ");
			classAtt.setBounds(25, 280, 250, 20);
			classAtt.setForeground(Color.decode("#DEE4E7"));
			classAtt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(classAtt);
			JLabel atbox = new JLabel("");
			atbox.setBounds(60, 330, 250, 20);
			atbox.setForeground(Color.decode("#DEE4E7"));
			atbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(atbox);
			
			JLabel classAbs = new JLabel("CLASSES MISSED : ");
			classAbs.setBounds(25, 380, 250, 20);
			classAbs.setForeground(Color.decode("#DEE4E7"));
			classAbs.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(classAbs);
			JLabel mtbox = new JLabel("");
			mtbox.setBounds(60, 430, 250, 20);
			mtbox.setForeground(Color.decode("#DEE4E7"));
			mtbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(mtbox);
			
			JLabel AttPer = new JLabel("ATTENDANCE PERCENTAGE : ");
			AttPer.setBounds(25, 480, 300, 20);
			AttPer.setForeground(Color.decode("#DEE4E7"));
			AttPer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(AttPer);
			JLabel prbox = new JLabel("");
			prbox.setBounds(60, 530, 250, 20);
			prbox.setForeground(Color.decode("#DEE4E7"));
			prbox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			add(prbox);
			//---------------------------------
			
			//-------------------------------------------------------
			setSize(1000,600);
			setResizable(false);
			setLayout(null);
			setLocationRelativeTo(null);  
			setVisible(true);
			setFocusable(true);
			getContentPane().setBackground(Color.decode("#37474F"));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//--------------------------
	}
//	 public static void main(String[] args) {
//			new StudentView();
//		}
}
