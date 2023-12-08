package com.Fir;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class firRegistationPage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField Date_time;
	private JTextField Occurrence;
	private JTextField Complain_type;
	private JTextArea Details_of_incident;
	private JTextArea suspect_details;

	private JButton btnNewButton1;
	static firRegistationPage frame;
	JScrollPane scrollTextArea;

	JLabel labelComplainer_Name, labelComplainerNumber;
	JFrame f;

	public void getComplainerDetailsFromRegistration(String Complainer_Name, String uuidGenerate) {
		labelComplainer_Name.setText(Complainer_Name);
		labelComplainerNumber.setText(uuidGenerate);
		// TODO Auto-generated method stub

	}

	firRegistationPage() {
		f = new JFrame();

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Fill Your FIR ");
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#DAFF33"));
		contentPane.setLayout(null);

		JLabel lblNewFirRegister = new JLabel("FIR Filling Form");
		lblNewFirRegister.setFont(new Font("Georgia", Font.BOLD, 42));
		lblNewFirRegister.setBounds(610, 30, 425, 100);
		lblNewFirRegister.setForeground(Color.decode("#140551"));
		contentPane.add(lblNewFirRegister);

		JLabel lblDate = new JLabel("Date & Time (FIR)");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDate.setBounds(60, 120, 200, 43);
		contentPane.add(lblDate);

		Date_time = new JTextField();
		Date_time.setFont(new Font("Calibri", Font.PLAIN, 18));
		Date_time.setBounds(240, 120, 228, 40);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		Date_time.setEditable(false);
		Date_time.setText(dtf.format(now));
		contentPane.add(Date_time);
		Date_time.setColumns(10);

		JLabel lblOccurrence = new JLabel("Occurrence Date");
		lblOccurrence.setFont(new Font("Arial", Font.PLAIN, 20));
		lblOccurrence.setBounds(80, 170, 200, 43);
		contentPane.add(lblOccurrence);

		Occurrence = new JTextField();
		Occurrence.setFont(new Font("Calibri", Font.PLAIN, 18));
		Occurrence.setBounds(240, 170, 228, 40);

		contentPane.add(Occurrence);
		Occurrence.setColumns(10);

		JLabel Occur = new JLabel("(yyyy-mm-dd)");
		Occur.setFont(new Font("Calibri", Font.PLAIN, 12));
		Occur.setForeground(Color.red);
		Occur.setBounds(240, 195, 200, 43);
		contentPane.add(Occur);

		JLabel lblNumber = new JLabel("Complainer Number");
		lblNumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNumber.setBounds(900, 120, 200, 43);
		contentPane.add(lblNumber);

		labelComplainerNumber = new JLabel("Output"); // removed JLable from here.
		labelComplainerNumber.setBounds(1100, 115, 500, 50);
		labelComplainerNumber.setFont(new Font("Calibri", Font.PLAIN, 26));
		labelComplainerNumber.setForeground(Color.blue);

		contentPane.add(labelComplainerNumber);

		JLabel lblName = new JLabel("Complainer Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(900, 170, 200, 43);
		contentPane.add(lblName);

		labelComplainer_Name = new JLabel("Output"); // removed JLable from here.
		labelComplainer_Name.setBounds(1100, 167, 300, 50);
		labelComplainer_Name.setFont(new Font("Calibri", Font.PLAIN, 26));
		labelComplainer_Name.setForeground(Color.blue);
		contentPane.add(labelComplainer_Name);

		JLabel lblType = new JLabel("Complain Type");
		lblType.setFont(new Font("Arial", Font.PLAIN, 20));
		lblType.setBounds(95, 220, 200, 43);
		contentPane.add(lblType);

		Complain_type = new JTextField();
		Complain_type.setFont(new Font("Calibri", Font.PLAIN, 18));
		Complain_type.setBounds(240, 225, 228, 40);
		contentPane.add(Complain_type);
		Complain_type.setColumns(10);

		JLabel lbldetails = new JLabel("Detail");
		lbldetails.setFont(new Font("Arial", Font.PLAIN, 20));
		lbldetails.setBounds(175, 280, 200, 43);
		contentPane.add(lbldetails);

		Details_of_incident = new JTextArea();
		Details_of_incident.setFont(new Font("Calibri", Font.PLAIN, 18));
		Details_of_incident.setBounds(240, 280, 1160, 130);
		contentPane.add(Details_of_incident);
		Details_of_incident.setColumns(10);

		JLabel lblsuspect = new JLabel("Suspect Details");
		lblsuspect.setFont(new Font("Arial", Font.PLAIN, 20));
		lblsuspect.setBounds(90, 430, 200, 43);
		contentPane.add(lblsuspect);

		suspect_details = new JTextArea();
		suspect_details.setFont(new Font("Calibri", Font.PLAIN, 18));
		suspect_details.setBounds(240, 430, 1160, 100);
		contentPane.add(suspect_details);
		suspect_details.setColumns(10);

		btnNewButton1 = new JButton("Submit");
		btnNewButton1.setFont(new Font("Arial", Font.PLAIN, 22));
		btnNewButton1.setBounds(640, 630, 199, 40);
		btnNewButton1.setBackground(Color.cyan);
		contentPane.add(btnNewButton1);
		btnNewButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ComplainerName = labelComplainer_Name.getText();
				String ComplainerNumber = labelComplainerNumber.getText();

				String occurence_date = Occurrence.getText();
				String Date_of_fir = Date_time.getText();
				String complain_type = Complain_type.getText();
				String details = Details_of_incident.getText();
				String suspectdetails = suspect_details.getText();

				String msg = "" + ComplainerName;

				msg += " \n";
				if (details.equals("") || suspectdetails.equals("") || complain_type.equals("")
						|| occurence_date.equals("")) {
					JOptionPane.showMessageDialog(btnNewButton1, "Please Enter Details");
				} else if (!occurence_date.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
					JOptionPane.showMessageDialog(btnNewButton1, "Invalid data , Check Occurence date format");
				} else {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root",
								"Root#123");

						String query = "INSERT INTO fir_report values('" + ComplainerNumber + "','" + ComplainerName
								+ "','" + Date_of_fir + "','" + complain_type + "','" + occurence_date + "','" + details
								+ "','" + suspectdetails + "')";

						Statement registerDetails = connection.createStatement();

						int x = registerDetails.executeUpdate(query);
						if (x == 0) {
							JOptionPane.showMessageDialog(btnNewButton1, "This is alredy exist");
						} else {
							JOptionPane.showMessageDialog(btnNewButton1, "Thank you, " + msg + "Your FIR is filed");
						}

						connection.close();

					} catch (Exception exception) {
						exception.printStackTrace();
					}

//Report page link
					firReportPage f = new firReportPage(ComplainerName, ComplainerNumber, occurence_date, Date_of_fir,
							complain_type, details, suspectdetails);

					f.setVisible(true);
					dispose();
				}
			}
		});
		JLabel note = new JLabel("* NOTE: ALL THE FIELDS ARE MANDATORY *");
		note.setFont(new Font("Tahoma", Font.BOLD, 16));
		note.setForeground(Color.red);
		note.setBounds(60, 690, 500, 30);
		contentPane.add(note);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frame = new firRegistationPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
