package Attendence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
Connection con;
Statement s;
Conn(){
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence","root","root");
		s=con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
