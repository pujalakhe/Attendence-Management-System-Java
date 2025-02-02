package Attendence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JPanel p1,p2;
	JLabel attendance,management,username,password,lgtxt,warning;
	JTextField userTextField;
	JPasswordField pwdfield;
	JButton loginBtn;
	Login(){
		setTitle("Login");
		setSize(900,500);
		setLocation(300,200);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-----start of panel 1
		p1=new JPanel();
		p1.setPreferredSize(new Dimension(450,0));
		//-------------------------LOGO--------------------------
		 attendance = new JLabel("ATTENDANCE");
		p1.setLayout(null);
		attendance.setForeground(Color.decode("#37474F"));
		attendance.setBounds(55, 115, 400, 50);
		attendance.setFont(new Font("Times New Roman", Font.BOLD, 50));
		p1.add(attendance);
		//--management
		 management = new JLabel("MANAGEMENT SYSTEM");
		management.setForeground(Color.decode("#37474F"));
		management.setBounds(210, 160, 400, 50);
		management.setFont(new Font("Verdana", Font.BOLD, 15));
		p1.add(management);
		//-------
		//----------end of Logo--------------
		add(p1,BorderLayout.WEST);
		///---end of panel 1----
		
		
//		------start of panel 2
		p2= new JPanel();
		p2.setBackground(Color.decode("#37474f"));
		p2.setPreferredSize(new Dimension(450,0));
		p2.setLayout(null);
		//--------------------------LOGINTEXT---------------------------
		lgtxt = new JLabel("LOGIN");
		lgtxt.setForeground(Color.decode("#DEE4E7"));
		lgtxt.setBounds(100, 50, 350, 75);
		lgtxt.setFont(new Font("Times New Roman", Font.BOLD, 50));
		p2.add(lgtxt);
		//-----------end of login Text-----------------
//		-----User
		username = new JLabel("Username:");
		username.setForeground(Color.decode("#DEE4E7"));
		username.setFont(new Font("Times New Roman",Font.PLAIN, 15));
		username.setBounds(35,150,80,20);
		p2.add(username);
//		-------
		//Username text field
		userTextField = new JTextField();
		userTextField.setBounds(100,150,250,25);
		p2.add(userTextField);
		//--user text field
		
		//----password
		password = new JLabel("Password:");
		password.setForeground(Color.decode("#DEE4E7"));
		password.setFont(new Font("Times New Roman",Font.PLAIN, 15));
		password.setBounds(35,200,80,20);
		p2.add(password);		
		//----password
		
		//password  field
		pwdfield = new JPasswordField();
		pwdfield.setBounds(100,200,250,25);
		p2.add(pwdfield);
		//--password field
		
		//-------------------------WARNING--------------------------
		 warning = new JLabel();
		warning.setForeground(Color.RED);
		warning.setBounds(100, 230, 250, 20);
		warning.setHorizontalAlignment(warning.CENTER);
		p2.add(warning);
		//----------------------
//		---login button
		loginBtn = new JButton("Login");
		loginBtn.setBounds(150, 260, 150, 50);
		loginBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		loginBtn.setBackground(Color.decode("#DEE4E7"));
		loginBtn.setForeground(Color.decode("#37474f"));
		loginBtn.addActionListener(this);
		p2.add(loginBtn);
//		------
		add(p2,BorderLayout.EAST);
//	-------end of panel 2
		
		setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginBtn) {
			String user = userTextField.getText();
			String pass = new String(pwdfield.getText());
			try {
			Conn con = new Conn();
			String query = "select * from user where username='"+user+"' and password ='"+pass+"' ";
			ResultSet rs;
			
				rs = con.s.executeQuery(query);
			
				if(rs.next()) {
					new Homepage();
					setVisible(false);
				}
				else {
					warning.setText("Invalid User");
				}
			} 
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
	}
}
