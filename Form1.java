//package test1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Form1 extends JFrame implements ActionListener
{
	JButton submitBt;
	JTextField nameTf, rollnoTf, stateTf;
	JLabel nameLb, rollnoLb,stateLb;
	Form1()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "***", "****");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from stu_table");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		nameLb=new JLabel("Name");
		rollnoLb=new JLabel("Roll NO:");
		stateLb=new JLabel("State");

		nameTf=new JTextField(20);
		rollnoTf=new JTextField(20);
		stateTf=new JTextField(20);

		submitBt=new JButton("submit");
		submitBt.addActionListener(this);
		setLayout(new FlowLayout());
		add(nameLb);
		add(nameTf);
		add(rollnoLb);
		add(rollnoTf);
		add(stateLb);
		add(stateTf);
		add(submitBt);

		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submitBt)
		{
			String name = nameTf.getText();
			String rollno = rollnoTf.getText();
			String state = stateTf.getText();
			System.out.println("Button has been pressed.");
			System.out.println("Name: "+name);
			System.out.println("RollNo.: "+rollno);
			System.out.println("State: "+state);
		}
	}
	public static void main(String args[])
	{
		System.out.println("test print");
		Form1 f1=new Form1();
		f1.setSize(600,400);
		f1.setVisible(true);
	}
}
