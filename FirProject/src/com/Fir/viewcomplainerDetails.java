package com.Fir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class viewcomplainerDetails extends JFrame implements ActionListener {

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
	String[] columnNames = { "Police Username", "Complainer ID", "First Name", "Middle Name", "Last Name", "DOB", "Age",
			"Mobile Number", "Email", "Address" };

	viewcomplainerDetails() {
		contentPane1 = new JPanel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("View Complainer Details");
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

		String PoliceUsername = "";

		String Complainer_id = "";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root", "Root#123");

			PreparedStatement ps = connection.prepareStatement(
					"select Police_username,Complainer_number, First_Name,Middle_Name,Last_Name,Date_of_birth,Age,Mobile_Number,email,Address from complainer_registration1 ");
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {

				FirstName = rs.getString("First_Name");
				MiddleName = rs.getString("Middle_Name");
				LastName = rs.getString("Last_Name");
				DOB = rs.getString("Date_of_birth");
				Age = rs.getString("Age");

				MobileNumber = rs.getString("Mobile_Number");
				Email = rs.getString("email");
				Address = rs.getString("Address");

				PoliceUsername = rs.getString("Police_username");
				Complainer_id = rs.getString("Complainer_number");
				Object[] newRow = { PoliceUsername, Complainer_id, FirstName, MiddleName, LastName, DOB, Age,
						MobileNumber, Email, Address, };
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
		viewcomplainerDetails f = new viewcomplainerDetails();

		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
