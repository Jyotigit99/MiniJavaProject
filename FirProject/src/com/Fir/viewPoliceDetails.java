package com.Fir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class viewPoliceDetails extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button;
	JPanel panel, contentPane, contentPane1;
	static JTable table;
	String[] columnNames = { "First Name", "Middle Name", "Last Name", "DOB", "Age", "Post", "Mobile Number", "Email",
			"Address", "Date Of Joining", "UserName", "Passwords" };

	viewPoliceDetails() {
		contentPane1 = new JPanel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("View Police Details");
		contentPane1.setLayout(new BorderLayout());

		setContentPane(contentPane1);

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);

		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		String FirstName = "";
		String MiddleName = "";
		String LastName = "";
		String DOB = "";
		String Age = "";
		String Post = "";
		String MobileNumber = "";
		String Email = "";
		String Address = "";
		String DOJ = "";
		String Username = "";
		String Password = "";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root", "Root#123");

			PreparedStatement ps = connection.prepareStatement(
					"select First_Name,Middle_Name,Last_Name,Date_of_birth,Age,Post,Mobile_Number,email,Address,Date_of_Joining,Username,Passwords from Police_Registration ");
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {

				FirstName = rs.getString("First_Name");
				MiddleName = rs.getString("Middle_Name");
				LastName = rs.getString("Last_Name");
				DOB = rs.getString("Date_of_birth");
				Age = rs.getString("Age");
				Post = rs.getString("Post");
				MobileNumber = rs.getString("Mobile_number");
				Email = rs.getString("email");
				Address = rs.getString("Address");
				DOJ = rs.getString("Date_Of_Joining");
				Username = rs.getString("Username");
				Password = rs.getString("Passwords");
				Object[] newRow = { FirstName, MiddleName, LastName, DOB, Age, Post, MobileNumber, Email, Address, DOJ,
						Username, Password };
				model.addRow(newRow);

				i++;
			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found");

			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		contentPane1.add(scroll);
		contentPane1.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		viewPoliceDetails f = new viewPoliceDetails();

		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
