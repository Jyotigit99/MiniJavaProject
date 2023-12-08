package com.Fir;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class firReportPage extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea firPreport;
	JPanel contentPane;
	JLabel ComplainerName, ComplainerNumber, OccurenceDate, DateofFir, ComplaintType, Details, SuspectDetails;
	JButton Final_submit, Update;
	static String complainerName;
	static String complainerNumber;
	static String occurence_date;
	static String date_of_fir;
	static String complain_type;
	static String details;
	static String suspectdetails;
	static firReportPage frame;

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

	firReportPage(String complainerName2, String complainerNumber2, String occurence_date, String date_of_fir,
			String complain_type, String details2, String suspectdetails)

	{
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("FIR Report Page");
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout());

		ComplainerNumber = new JLabel();
		ComplainerNumber.setBounds(300, 60, 93, 50);
		ComplainerNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ComplainerNumber.setForeground(Color.blue);
		ComplainerNumber.setVisible(false);
		contentPane.add(ComplainerNumber);

		ComplainerName = new JLabel(); // removed JLable from here.
		ComplainerName.setBounds(300, 60, 93, 50);
		ComplainerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ComplainerName.setForeground(Color.blue);
		ComplainerName.setVisible(false);
		contentPane.add(ComplainerName);

		OccurenceDate = new JLabel(); // removed JLable from here.
		OccurenceDate.setBounds(300, 60, 93, 50);
		OccurenceDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		OccurenceDate.setForeground(Color.blue);
		OccurenceDate.setVisible(false);
		contentPane.add(OccurenceDate);

		DateofFir = new JLabel(); // removed JLable from here.
		DateofFir.setBounds(300, 60, 93, 50);
		DateofFir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DateofFir.setForeground(Color.blue);
		DateofFir.setVisible(false);
		contentPane.add(DateofFir);

		ComplaintType = new JLabel(); // removed JLable from here.
		ComplaintType.setBounds(300, 60, 93, 50);
		ComplaintType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ComplaintType.setForeground(Color.blue);
		ComplaintType.setVisible(false);
		contentPane.add(ComplaintType);

		SuspectDetails = new JLabel(); // removed JLable from here.
		SuspectDetails.setBounds(300, 60, 93, 50);
		SuspectDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SuspectDetails.setForeground(Color.blue);
		SuspectDetails.setVisible(false);
		contentPane.add(SuspectDetails);

		Details = new JLabel(); // removed JLable from here.
		Details.setBounds(300, 60, 93, 50);
		Details.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Details.setForeground(Color.blue);
		Details.setVisible(false);
		contentPane.add(Details);

		firPreport = new JTextArea();

		firPreport.setFont(new Font("Calibri", Font.PLAIN, 18));
		firPreport.setBounds(200, 200, 400, 600);
		firPreport.setColumns(10);
		JScrollPane scroll;
		scroll = new JScrollPane(firPreport, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setMinimumSize(new Dimension(800, 900));
		scroll.setPreferredSize(new Dimension(800, 700));
		firPreport.setLineWrap(true);

		contentPane.add(scroll);
		final String ComplainerNameData = complainerName2;
		final String ComplainerNumberData = complainerNumber2;
		final String OccurenceDateData = occurence_date;
		final String DateofFirData = date_of_fir;
		final String ComplaintTypeData = complain_type;
		final String DetailsData = details2;
		final String SuspectDetailsData = suspectdetails;
		String data = "\r" + "\r" + "\r" + "\r" + "*************************************" + "FIR REPORT"
				+ "****************************************" + "\n" + "\n" + "\n" + "Complainer Name : "
				+ ComplainerNameData + "\n" + "\n" + "\n" + "Complainer Number : " + ComplainerNumberData + "\n" + "\n"
				+ "\n" + "Incidence Date: " + OccurenceDateData + "\n" + "\n" + "\n" + "Date Of FIR : " + DateofFirData
				+ "\n" + "\n" + "\n" + "Complaint Type : " + ComplaintTypeData + "\n" + "\n" + "\n" + "Details : "
				+ DetailsData + "\n" + "\n" + "\n" + "Susspect Details : " + SuspectDetailsData + "\n";
		firPreport.setText(data);
		firPreport.setEditable(false);
		Update = new JButton("UPDATE");

		Update.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Update.setBounds(640, 700, 199, 40);
		Update.setBackground(Color.cyan);
		contentPane.add(Update);

		Final_submit = new JButton("FINAL SUBMIT");

		Final_submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Final_submit.setBounds(640, 800, 199, 40);
		Final_submit.setBackground(Color.orange);
		contentPane.add(Final_submit);
		Final_submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Final_submit,
						"Thank you, Your Complain is filed with Complain Id " + ComplainerNumberData);
			
				dispose();	
			}
			
		});
		Update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				updateFirfilling f = new updateFirfilling(ComplainerNameData, ComplainerNumberData, OccurenceDateData,
						DateofFirData, ComplaintTypeData, DetailsData, SuspectDetailsData);
				f.getComplainerDetailsFromRegistration(ComplainerNameData, ComplainerNumberData);
				f.setVisible(true);
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frame = new firReportPage(complainerName, complainerNumber, occurence_date, date_of_fir, complain_type,
					details, suspectdetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}

}
