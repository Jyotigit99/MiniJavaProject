package com.Fir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class searchComplainerDetails extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label, labelPoliceName;
	JButton button, button1, back;
	JPanel panel, contentPane, contentPane1;
	static JTable table;

	String[] columnNames = { "Police Username", "Complainer Number", "Complainer Name", "DOB", "Age", "Mobile Number",
			"Email", "Address" };

	public void getPoliceUsername(String policeUsername) {
		labelPoliceName.setText(policeUsername);
		// TODO Auto-generated method stub

	}

	searchComplainerDetails() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Search complainer Here");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#DAFF33"));
		setContentPane(contentPane);
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

		JLabel lblNewUserRegister = new JLabel("SEARCH COMPLAINER DETAILS");
		lblNewUserRegister.setFont(new Font("georgia", Font.BOLD, 42));
		lblNewUserRegister.setBounds(430, 52, 800, 100);
		lblNewUserRegister.setForeground(Color.decode("#140551"));
		contentPane.add(lblNewUserRegister);

		textbox = new JTextField();
		textbox.setFont(getFont());
		textbox.setFont(new Font("Calibri", Font.BOLD, 18));
		textbox.setBounds(750, 200, 228, 40);

		label = new JLabel("Enter Complainer ID");
		label.setFont(new Font("arial", Font.PLAIN, 20));
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
		contentPane.setSize(500, 400);
	}

	public void showTableData() {

		contentPane1 = new JPanel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Details of complainer Here");
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
		String PoliceUsername = "";
		String ComplainerNumber = "";
		String ComplainerName = "";

		String DOB = "";
		String Age = "";

		String MobileNumber = "";
		String Email = "";
		String Address = "";

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root", "Root#123");

			PreparedStatement ps = connection.prepareStatement(
					"select Police_username,Complainer_number,concat(First_Name,\" \",Middle_Name,\" \",Last_Name) AS Complainer_Name,Date_of_birth,Age,Mobile_number,email,Address from complainer_registration1 where Complainer_Number='"
							+ textvalue + "'");
			ResultSet rs = ps.executeQuery();

			int i = 0;
			if (rs.next()) {
				PoliceUsername = rs.getString("Police_username");
				ComplainerNumber = textvalue;
				ComplainerName = rs.getString("Complainer_Name");
				DOB = rs.getString("Date_of_birth");
				Age = rs.getString("Age");

				MobileNumber = rs.getString("Mobile_number");
				Email = rs.getString("email");
				Address = rs.getString("Address");

				model.addRow(new Object[] { PoliceUsername, ComplainerNumber, ComplainerName, DOB, Age, MobileNumber,
						Email, Address });
				i++;
			}

			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found");

			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		contentPane1.add(scroll, BorderLayout.CENTER);

		contentPane1.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchComplainerDetails f = new searchComplainerDetails();

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
