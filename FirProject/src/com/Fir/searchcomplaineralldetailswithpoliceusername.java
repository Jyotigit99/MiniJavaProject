package com.Fir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class searchcomplaineralldetailswithpoliceusername extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JTextField textbox;
	JLabel label, labelPoliceName;
	JButton button, button1, back;
	JPanel panel, contentPane, contentPane1;
	static JTable table;
	String[] columnNames1 = { "Police Username", "Complainer Number", "Complainer Name", "DOB", "Age", "Mobile Number",
			"Email", "Address", "Date & Time of FIR", "Complain Type", "Occurence Date", "Details", "Suspect_Details" };

	String[] columnNames2 = { "Police Username", "First Name", "Middle Name", "Last Name", "DOB", "Age",
			"Mobile Number", "Email", "Address" };

	public void getPoliceUsername(String policeUsername) {
		labelPoliceName.setText(policeUsername);
		// TODO Auto-generated method stub

	}

	searchcomplaineralldetailswithpoliceusername() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Search complainer Here By Police Username ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#DAFF33"));
		contentPane.setLayout(null);

		JLabel welcome = new JLabel("Logged In User");
		welcome.setBounds(1360, 20, 123, 50);
		welcome.setFont(new Font("Calibri", Font.PLAIN, 20));
		welcome.setForeground(Color.blue);
		contentPane.add(welcome);

		labelPoliceName = new JLabel("Output"); // removed JLable from here.
		labelPoliceName.setBounds(1400, 40, 93, 50);
		labelPoliceName.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPoliceName.setForeground(Color.blue);
		contentPane.add(labelPoliceName);

		JLabel lblNewUserRegister = new JLabel("SEARCH ALL COMPLAINER DETAILS");
		lblNewUserRegister.setFont(new Font("georgia", Font.BOLD, 42));
		lblNewUserRegister.setBounds(400, 52, 1000, 100);
		lblNewUserRegister.setForeground(Color.decode("#140551"));
		contentPane.add(lblNewUserRegister);

		textbox = new JTextField();
		textbox.setFont(getFont());
		textbox.setFont(new Font("Calibri", Font.BOLD, 18));
		textbox.setBounds(740, 200, 228, 40);

		label = new JLabel("By Police Username");
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(550, 200, 300, 43);

		button = new JButton("SEARCH");
		button.setBounds(700, 340, 150, 40);
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBackground(Color.cyan);
		button.addActionListener(this);

		button1 = new JButton("RESET");
		button1.setBounds(860, 340, 150, 40);
		button1.setFont(new Font("Calibri", Font.BOLD, 18));
		button1.setBackground(Color.orange);
		button1.addActionListener(this);

		back = new JButton("BACK");
		back.setBounds(540, 340, 150, 40);
		back.setFont(new Font("Calibri", Font.BOLD, 18));
		back.setBackground(Color.orange);
		back.addActionListener(this);

		contentPane.add(textbox);
		contentPane.add(label);
		contentPane.add(button);
		contentPane.add(button1);
		contentPane.add(back);
		contentPane.setVisible(true);

	}

	public void showTableData() {

		contentPane1 = new JPanel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Details of complainers By Police Username ");
		contentPane1.setLayout(new BorderLayout());
		setContentPane(contentPane1);

		DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel model1 = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames1);
		model1.setColumnIdentifiers(columnNames2);

		table = new JTable();
		table.setModel(model);
		table.setModel(model1);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		String textvalue = textbox.getText();
		String PoliceUsername = "";

		String FirstName = "";
		String MiddleName = "";
		String LastName = "";
		String DOB = "";
		String Age = "";

		String MobileNumber = "";
		String Email = "";
		String Address = "";

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root", "Root#123");

			PreparedStatement ps1 = connection.prepareStatement(
					"select Police_username,First_Name,Middle_name,Last_Name,Date_of_birth,Age,Mobile_number,email,Address from complainer_registration1 where Police_username='"
							+ textvalue + "'");
			ResultSet rs1 = ps1.executeQuery();

			int i = 0;

			while (rs1.next()) {
				PoliceUsername = rs1.getString("Police_username");

				if (textvalue.equals(PoliceUsername)) {

					PoliceUsername = rs1.getString("Police_username");

					FirstName = rs1.getString("First_Name");
					MiddleName = rs1.getString("Middle_Name");
					LastName = rs1.getString("Last_Name");
					DOB = rs1.getString("Date_of_birth");
					Age = rs1.getString("Age");

					MobileNumber = rs1.getString("Mobile_number");
					Email = rs1.getString("email");
					Address = rs1.getString("Address");

					model1.addRow(new Object[] { PoliceUsername, FirstName, MiddleName, LastName, DOB, Age,
							MobileNumber, Email, Address });
					i++;

				}
			}

			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found");

			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		contentPane1.add(scroll);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchcomplaineralldetailswithpoliceusername f = new searchcomplaineralldetailswithpoliceusername();

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
		if (e.getSource() == back) {
			int s = JOptionPane.showConfirmDialog(null, "Do you want to Continue");
			if (s == JOptionPane.YES_OPTION) {
				System.out.println("hello");
				dispose();
			}

		}
	}
}
