package Attendence;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student extends JFrame implements ActionListener {
    JButton search;
    JTextField classname, name;
    JTable table;
    DefaultTableModel model;

    Student() {
        Font text = new Font("Times New Roman", Font.PLAIN, 18);
        JLabel title = new JLabel("ATTENDANCE RECORD");
        title.setFont(text);
        title.setBounds(25, 80, 220, 20);
        title.setForeground(Color.decode("#DEE4E7"));
        add(title);
        JLabel back = new JLabel("<BACK");
        back.setFont(text);
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
        //---------------------CLASS-------------------------
        JLabel classlabel = new JLabel("CLASS : ");
        classlabel.setFont(text);
        classlabel.setBounds(25, 120, 150, 20);
        classlabel.setForeground(Color.decode("#DEE4E7"));
        add(classlabel);

        classname = new JTextField();
        classname.setBounds(25, 160, 400, 35);
        classname.setBackground(Color.decode("#DEE4E7"));
        classname.setFont(text);
        classname.setForeground(Color.decode("#37474F"));
        add(classname);
        //------------------------------------------------------

        //-------------------NAME----------------------------------
        JLabel nm = new JLabel("NAME : ");
        nm.setFont(text);
        nm.setBounds(25, 240, 150, 20);
        nm.setForeground(Color.decode("#DEE4E7"));
        add(nm);

        name = new JTextField();
        name.setBounds(25, 270, 400, 35);
        name.setBackground(Color.decode("#DEE4E7"));
        name.setFont(text);
        name.setForeground(Color.decode("#37474F"));
        add(name);
        //--------------------------------------------------------

        //---------------------SEARCH BUTTON------------------------
        search = new JButton("SEARCH");
        search.setBounds(35, 330, 200, 35);
        search.setFont(text);
        search.setBackground(Color.decode("#DEE4E7"));
        search.setForeground(Color.decode("#37474F"));
        add(search);
        search.addActionListener(this);

        //-------------------TABLE----------------------------------
        table = new JTable();
        model = new DefaultTableModel();
        model.addColumn("Date");
        model.addColumn("Status");
        table.setModel(model);

        JScrollPane scPane = new JScrollPane(table);
        scPane.setBounds(25, 400, 600, 300);
        add(scPane);
        //--------------------------------------------------------

        setSize(700, 800);
        setResizable(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#37474F"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String studentName = name.getText();
            String className = classname.getText();
            model.setRowCount(0); // Clear previous data from the table
            try {
                Conn conn = new Conn();
                String query = "SELECT a.dt, a.status FROM attend a " +
                               "JOIN students s ON a.stid = s.id " +
//                               "JOIN class c ON s.class = c.id " +
                               "WHERE s.name = '" + studentName + "' AND s.class = '" + className + "'";
//                               "WHERE s.name= 'sagar'"+"AND c.name='bachelor'";
//                String query = "SELECT * from special WHERE name = '"+studentName+"' AND class ='"+className+"' ";
                ResultSet rs = conn.s.executeQuery(query);
//                String date = "2020-1-20";
//                String status = "present";
//                model.addRow(new Object[]{date, status});
                while (rs.next()) {
                    String date = rs.getString("dt");
                    String status = rs.getString("status");
                    System.out.println(date);
                    model.addRow(new Object[]{date, status});
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Student();
    }
}
