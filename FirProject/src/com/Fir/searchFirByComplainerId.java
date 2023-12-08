package com.Fir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class searchFirByComplainerId extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label, labelPoliceName;
	JButton search, reset, back;
	JPanel panel, contentPane, contentPane1;
	static JTable table;
	String ComplainerNumber = "";
	String ComplainerName = "";

	String dateTimeOfFir = "";
	String complaintType = "";

	String occurenceDate = "";
	String details = "";
	String suspectDetails = "";

	public void getPoliceUsername(String policeUsername) {
		labelPoliceName.setText(policeUsername);
		// TODO Auto-generated method stub

	}

	searchFirByComplainerId() {

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

		labelPoliceName = new JLabel("Output");
		labelPoliceName.setBounds(1400, 40, 93, 50);
		labelPoliceName.setFont(new Font("Arial", Font.PLAIN, 20));
		labelPoliceName.setForeground(Color.blue);
		contentPane.add(labelPoliceName);

		JLabel lblNewUserRegister = new JLabel("SEARCH FIR DETAILS");
		lblNewUserRegister.setFont(new Font("georgia", Font.BOLD, 42));
		lblNewUserRegister.setBounds(540, 52, 800, 100);
		lblNewUserRegister.setForeground(Color.decode("#140551"));
		contentPane.add(lblNewUserRegister);

		textbox = new JTextField();
		textbox.setFont(getFont());
		textbox.setFont(new Font("Calibri", Font.BOLD, 18));
		textbox.setBounds(770, 200, 228, 40);

		label = new JLabel("Enter Complainer ID");
		label.setFont(new Font("arial", Font.PLAIN, 20));
		label.setBounds(570, 200, 300, 43);

		search = new JButton("SEARCH");
		search.setBounds(700, 340, 150, 40);
		search.setFont(new Font("Calibri", Font.BOLD, 18));
		search.setBackground(Color.cyan);
		search.addActionListener(this);

		reset = new JButton("RESET");
		reset.setBounds(860, 340, 150, 40);
		reset.setFont(new Font("Calibri", Font.BOLD, 18));
		reset.setBackground(Color.orange);
		reset.addActionListener(this);

		back = new JButton("BACK");
		back.setBounds(540, 340, 150, 40);
		back.setFont(new Font("Calibri", Font.BOLD, 18));
		back.setBackground(Color.orange);
		back.addActionListener(this);

		contentPane.add(textbox);
		contentPane.add(label);
		contentPane.add(search);
		contentPane.add(reset);
		contentPane.add(back);
		contentPane.setVisible(true);
		contentPane.setSize(500, 400);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == search) {

			Connection connection;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root", "Root#123");

				PreparedStatement ps;

				ps = connection.prepareStatement(
						"select Complainer_Name,Date_time_of_fir,complain_type,occurence_date,details_of_incident,Suspect_details from fir_report where Complainer_Number='"
								+ textbox.getText() + "'");

				ResultSet rs = ps.executeQuery();
				int i = 0;
				if (rs.next()) {
					ComplainerName = rs.getString("Complainer_Name");
					dateTimeOfFir = rs.getString("Date_time_of_fir");
					complaintType = rs.getString("complain_type");

					occurenceDate = rs.getString("occurence_date");
					details = rs.getString("details_of_incident");
					suspectDetails = rs.getString("Suspect_details");
					firReportPage f = new firReportPage(ComplainerName, textbox.getText(), occurenceDate, dateTimeOfFir,
							complaintType, details, suspectDetails);

					f.setVisible(true);
					dispose();
					i++;
					connection.close();
				}
				if (i < 1) {
					JOptionPane.showMessageDialog(null, "No Record Found");

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == reset) {
			textbox.setText("");
		}
		if (e.getSource() == back) {
			int s = JOptionPane.showConfirmDialog(null, "Do you want to Continue");
			if (s == JOptionPane.YES_OPTION) {
				System.out.println("hello");
				dispose();
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchFirByComplainerId f = new searchFirByComplainerId();

		f.setVisible(true);

	}
}
