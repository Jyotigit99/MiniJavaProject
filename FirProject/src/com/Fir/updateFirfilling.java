package com.Fir;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class updateFirfilling extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField Date_time;
	private JTextField Occurrence;
	private JTextField Complain_type;
	private JTextArea Details_of_incident;
	private JTextArea suspect_details;

	private JButton btnNewButton1;

	JScrollPane scrollTextArea;

	JLabel labelComplainer_Name, labelComplainerNumber;
	JFrame f;
	JLabel ComplainerName, ComplainerNumber, OccurenceDate, DateofFir, ComplaintType, Details, SusspectDetails;
	JButton Final_submit, Update;
	static String complainerName;
	static String complainerNumber;
	static String occurence_date;
	static String date_of_fir;
	static String complain_type;
	static String details;
	static String suspectdetails;
	static updateFirfilling frame;

	public void getComplainerDetailsFromRegistration(String Complainer_Name, String uuidGenerate) {
		labelComplainer_Name.setText(Complainer_Name);
		labelComplainerNumber.setText(uuidGenerate);
		// TODO Auto-generated method stub

	}

	public String getComplainerName() {
		return complainerName;
	}

	public void setComplainerName(String complainerName) {
		this.complainerName = complainerName;
	}

	public String getComplainerNumber() {
		return complainerNumber;
	}

	public void setComplainerNumber(String complainerNumber) {
		this.complainerNumber = complainerNumber;
	}

	public String getOccurence_date() {
		return occurence_date;
	}

	public void setOccurence_date(String occurence_date) {
		this.occurence_date = occurence_date;
	}

	public String getDate_of_fir() {
		return date_of_fir;
	}

	public void setDate_of_fir(String date_of_fir) {
		this.date_of_fir = date_of_fir;
	}

	public String getComplain_type() {
		return complain_type;
	}

	public void setComplain_type(String complain_type) {
		this.complain_type = complain_type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getSuspectdetails() {
		return suspectdetails;
	}

	public void setSuspectdetails(String suspectdetails) {
		this.suspectdetails = suspectdetails;
	}

	updateFirfilling(String ComplainerName, String ComplainerNumber, String occurence_date, String Date_of_fir,
			String complain_type, String details, String suspectdetails) {
		f = new JFrame();

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Update Your FIR");
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#DAFF33"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewFirRegister = new JLabel("Update your FIR");
		lblNewFirRegister.setFont(new Font("Georgia", Font.BOLD, 42));
		lblNewFirRegister.setBounds(670, 30, 425, 100);
		lblNewFirRegister.setForeground(Color.decode("#140551"));
		contentPane.add(lblNewFirRegister);

		JLabel lblDate = new JLabel("Date & Time (FIR)");
		lblDate.setFont(new Font("arial", Font.PLAIN, 20));
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
		lblOccurrence.setFont(new Font("arial", Font.PLAIN, 20));
		lblOccurrence.setBounds(69, 170, 180, 43);
		contentPane.add(lblOccurrence);

		Occurrence = new JTextField();
		Occurrence.setFont(new Font("Calibri", Font.PLAIN, 18));
		Occurrence.setBounds(240, 170, 228, 40);
		Occurrence.setText(occurence_date);
		Occurrence.setEditable(false);
		contentPane.add(Occurrence);
		Occurrence.setColumns(10);

		JLabel lblNumber = new JLabel("Complainer Number");
		lblNumber.setFont(new Font("arial", Font.PLAIN, 20));
		lblNumber.setBounds(900, 120, 200, 43);
		contentPane.add(lblNumber);

		labelComplainerNumber = new JLabel("Output"); // removed JLable from here.
		labelComplainerNumber.setBounds(1100, 115, 500, 50);
		labelComplainerNumber.setFont(new Font("calibri", Font.PLAIN, 26));
		labelComplainerNumber.setForeground(Color.blue);

		contentPane.add(labelComplainerNumber);

		JLabel lblName = new JLabel("Complainer Name");
		lblName.setFont(new Font("arial", Font.PLAIN, 20));
		lblName.setBounds(900, 170, 200, 43);
		contentPane.add(lblName);

		labelComplainer_Name = new JLabel("Output"); // removed JLable from here.
		labelComplainer_Name.setBounds(1100, 165, 300, 50);
		labelComplainer_Name.setFont(new Font("calibri", Font.PLAIN, 26));
		labelComplainer_Name.setForeground(Color.blue);
		contentPane.add(labelComplainer_Name);

		JLabel lblType = new JLabel("Complain Type");
		lblType.setFont(new Font("arial", Font.PLAIN, 20));
		lblType.setBounds(95, 220, 200, 43);
		contentPane.add(lblType);

		Complain_type = new JTextField();
		Complain_type.setFont(new Font("Calibri", Font.PLAIN, 18));
		Complain_type.setBounds(240, 225, 228, 40);
		Complain_type.setText(complain_type);
		Complain_type.setEditable(false);
		contentPane.add(Complain_type);
		Complain_type.setColumns(10);

		JLabel lbldetails = new JLabel("Detail");
		lbldetails.setFont(new Font("arial", Font.PLAIN, 20));
		lbldetails.setBounds(175, 280, 200, 43);
		contentPane.add(lbldetails);

		Details_of_incident = new JTextArea();
		Details_of_incident.setFont(new Font("Calibri", Font.PLAIN, 18));
		Details_of_incident.setBounds(240, 280, 1160, 130);
		Details_of_incident.setText(details);

		contentPane.add(Details_of_incident);
		Details_of_incident.setColumns(10);

		JLabel lblsuspect = new JLabel("Suspect Details");
		lblsuspect.setFont(new Font("arial", Font.PLAIN, 20));
		lblsuspect.setBounds(90, 430, 200, 43);
		contentPane.add(lblsuspect);

		suspect_details = new JTextArea();
		suspect_details.setFont(new Font("Calibri", Font.PLAIN, 18));
		suspect_details.setBounds(240, 430, 1160, 100);
		suspect_details.setText(suspectdetails);

		contentPane.add(suspect_details);
		suspect_details.setColumns(10);

		btnNewButton1 = new JButton("Submit");
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 22));
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

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root",
							"Root#123");

					PreparedStatement update = connection.prepareStatement(
							"UPDATE fir_report SET details_of_incident= ? , Suspect_details= ? where Complainer_number =?");
					update.setString(1, details);
					update.setString(2, suspectdetails);
					update.setString(3, ComplainerNumber);
					int x = update.executeUpdate();
					
						JOptionPane.showMessageDialog(btnNewButton1, "Thank you, " + msg + "Your FIR is Updated");
					

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
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			frame = new updateFirfilling(complainerName, complainerNumber, occurence_date, date_of_fir, complain_type,
					details, suspectdetails);
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
