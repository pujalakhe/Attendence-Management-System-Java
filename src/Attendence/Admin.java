package Attendence;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame{
	DefaultTableModel model;
	
	int check;
	JButton edit;
	JButton delete;
	Font text = new Font("Times New Roman",Font.PLAIN,18);
			
	Admin(){
		 
		 
		 
			//-----------------------BACK---------------------------------
			JLabel back = new JLabel("BACK");
			back.setForeground(Color.decode("#ffffff"));
			back.setFont(new Font("Times New Roman", Font.BOLD, 17));
			back.setBounds(18, 10, 100, 20);
			add(back);
			//...........................
			
			//----------------TABLE---------------------------------
			@SuppressWarnings("serial")
			JTable table=new JTable(){
				public boolean isCellEditable(int row,int column){
					return false;
				}
			};
			model = new DefaultTableModel();
			model = (DefaultTableModel)table.getModel();
			model.addColumn("ID");
			model.addColumn("USERNAME");
			model.addColumn("NAME");
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(200);
			JScrollPane scPane=new JScrollPane(table);
			scPane.setBounds(500, 20, 480, 525);
			add(scPane);
			//-----------------------
			
			//--------------------ID-----------------------------------
			JLabel id = new JLabel("ID : ");
			id.setFont(text);
			id.setBounds(25, 60, 40, 20);
			id.setForeground(Color.decode("#DEE4E7"));
			add(id);
			JTextField idbox= new JTextField();
			idbox.setBounds(60, 60, 50, 25);
			idbox.setBackground(Color.decode("#DEE4E7"));
			idbox.setFont(text);
			idbox.setForeground(Color.decode("#37474F"));
			idbox.setEditable(false);
			add(idbox);
			//--------------------------------------------------------
			
			//---------------------USERNAME-------------------------
			JLabel user = new JLabel("USERNAME : ");
			user.setFont(text);
			user.setBounds(25, 120, 150, 20);
			user.setForeground(Color.decode("#DEE4E7"));
			add(user);
			JTextField username= new JTextField();
			username.setBounds(25, 160, 400, 35);
			username.setBackground(Color.decode("#DEE4E7"));
			username.setFont(text);
			username.setForeground(Color.decode("#37474F"));
			username.setEditable(false);
			add(username);
			//------------------------------------------------------
			
			//-------------------NAME----------------------------------
			JLabel nm = new JLabel("NAME : ");
			nm.setFont(text);
			nm.setBounds(25, 240, 150, 20);
			nm.setForeground(Color.decode("#DEE4E7"));
			add(nm);
			JTextField name= new JTextField();
			name.setBounds(25, 270, 400, 35);
			name.setBackground(Color.decode("#DEE4E7"));
			name.setFont(text);
			name.setForeground(Color.decode("#37474F"));
			name.setEditable(false);
			add(name);
			//--------------------------------------------------------
			
			//---------------------PASS--------------------------------
			JLabel pass = new JLabel("PASSWORD : ");
			pass.setFont(text);
			pass.setBounds(25, 350, 150, 20);
			pass.setForeground(Color.decode("#DEE4E7"));
			add(pass);
			JTextField password= new JTextField();
			password.setBounds(25, 380, 400, 35);
			password.setBackground(Color.decode("#DEE4E7"));
			password.setFont(text);
			password.setForeground(Color.decode("#37474F"));
			password.setEditable(false);
			add(password);
			//--------------------------
			
			//-------------------------------------------------------
			setSize(1000,800);
			setResizable(true);
			setLayout(null);
			setLocationRelativeTo(null);  
			setVisible(true);
			getContentPane().setBackground(Color.decode("#37474F"));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//--------------------------
	
	
	}
	 public static void main(String[] args) {
			new Admin();
		}

}
