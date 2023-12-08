package com.Fir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchPoliceDetails extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button, button1;
	JPanel panel, contentPane, contentPane1;
	static JTable table;
	String[] columnNames = { "First Name", "Middle Name", "Last Name", "DOB", "Age", "Post", "Mobile Number", "Email",
			"Address", "Date Of Joining", "UserName", "Passwords" };

	SearchPoliceDetails() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Search Police details ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#DAFF33"));

		JLabel lblNewUserRegister = new JLabel("SEARCH POLICE DETAILS");
		lblNewUserRegister.setFont(new Font("georgia", Font.BOLD, 42));
		lblNewUserRegister.setBounds(542, 52, 700, 100);
		lblNewUserRegister.setForeground(Color.decode("#140551"));
		contentPane.add(lblNewUserRegister);

		textbox = new JTextField();
		textbox.setFont(getFont());
		textbox.setFont(new Font("Calibri", Font.BOLD, 18));
		textbox.setBounds(780, 260, 228, 40);

		label = new JLabel("Enter Username");
		label.setFont(new Font("arial", Font.PLAIN, 20));
		label.setBounds(610, 260, 200, 43);

		button = new JButton("SEARCH");
		button.setBounds(680, 340, 150, 40);
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBackground(Color.cyan);
		button.addActionListener(this);

		button1 = new JButton("RESET");
		button1.setBounds(850, 340, 150, 40);
		button1.setFont(new Font("Calibri", Font.BOLD, 18));
		button1.setBackground(Color.orange);
		button1.addActionListener(this);

		contentPane.add(textbox);
		contentPane.add(label);
		contentPane.add(button);
		contentPane.add(button1);
		contentPane.setVisible(true);
		contentPane.setSize(500, 400);
	}

	public void showTableData() {

		contentPane1 = new JPanel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Result of Police details ");
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
		String textvalue = textbox.getText();
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
					"select First_Name,Middle_Name,Last_Name,Date_of_birth,Age,Post,Mobile_Number,email,Address,Date_of_Joining,Username,Passwords from Police_Registration where Username='"
							+ textvalue + "'");
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

				model.addRow(new Object[] { FirstName, MiddleName, LastName, DOB, Age, Post, MobileNumber, Email,
						Address, DOJ, Username, Password });
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
		// frame1.setSize(400, 300);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchPoliceDetails f = new SearchPoliceDetails();

		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == button) {
			showTableData();

		}
		if (e.getSource() == button1) {
			textbox.setText("");// resetting the value of username text field
		}

	}

}
