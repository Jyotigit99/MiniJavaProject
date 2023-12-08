package com.Fir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.jdesktop.swingx.JXDatePicker;
import java.util.Calendar;
import java.util.Date;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;

import java.util.UUID;
import java.util.Vector;

public class searchexample extends JFrame implements ActionListener {
	//final Vector data = new Vector();
	//final Vector columnNames = new Vector();
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button,button1;
	JPanel panel, contentPane, contentPane1;
	static JTable table;
	String[] columnNames1 = { "Police Username", "Complainer Number", "Complainer Name", "DOB", "Age", "Mobile Number",
			"Email", "Address", "Date & Time of FIR", "Complain Type", "Occurence Date", "Details", "Suspect_Details" };
	
	String[] columnNames2 = { "Police Username", "First Name", "Middle Name","Last Name","DOB", "Age", "Mobile Number",
			"Email", "Address"  };

	public void createUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// frame = new JFrame("Database Search Result");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setLayout(null);
		JLabel lblNewUserRegister = new JLabel("SEARCH COMPLAINER DETAILS");
		lblNewUserRegister.setFont(new Font("georgia", Font.PLAIN, 42));
		lblNewUserRegister.setBounds(530, 52, 800, 100);
		contentPane.add(lblNewUserRegister);

		textbox = new JTextField();
		textbox.setFont(getFont());
		textbox.setFont(new Font("Calibri", Font.BOLD, 18));
		textbox.setBounds(850, 260, 228, 40);

		label = new JLabel("Enter Complainer Name");
		label.setFont(new Font("tahoma", Font.PLAIN, 20));
		label.setBounds(600, 260, 300, 43);

		button = new JButton("SEARCH");
		button.setBounds(690, 340, 150, 40);
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

		// frame1 = new JFrame();
		contentPane1 = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		contentPane1.setLayout(new BorderLayout());
		setContentPane(contentPane1);
		// TableModel tm = new TableModel();
		DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel model1 = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames1);
		model1.setColumnIdentifiers(columnNames2);
		// DefaultTableModel model = new DefaultTableModel(tm.getData1(),
		// tm.getColumnNames());
		// table = new JTable(model);
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
		String ComplainerName = "";
		String occurrence = "";
		String FirstName = "";
		String MiddleName = "";
		String LastName = "";
		String DOB = "";
		String Age = "";
		String ComplainType = "";
		String MobileNumber = "";
		String Email = "";
		String Address = "";
		String DOFir = "";
		String Username = "";
		// String complainerNumber ;
		String details = "";
		String suspectDetails = "";
		 String ids;
		 //JScrollPane sp=new JScrollPane(table);   
		// contentPane.add(sp);
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root", "Root#123");

			// String sql = "select * from police_Registration where Username = " +
			// textvalue;
			PreparedStatement ps = connection.prepareStatement(
					"select Police_username,Complainer_Name,Date_of_birth,Age,Mobile_number,email,Address,Date_time_of_fir,complain_type,occurence_date,details_of_incident,Suspect_details from complainer_registration1,fir_report where fir_report.Complainer_Name='"
							+ textvalue + "'");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps1 = connection.prepareStatement(
					"select Police_username,First_Name,Middle_name,Last_Name,Date_of_birth,Age,Mobile_number,email,Address from complainer_registration1 where Police_username='"
							+ textvalue + "'");
			ResultSet rs1 = ps1.executeQuery();
			//String userNamePolice;
			

			int i = 0;
			//while(rs.next()) {
		   if (rs.next()) {

				
				PoliceUsername = rs.getString("Police_username");
				// complainerNumber = rs.getString("Complainer_number");
				ComplainerName = rs.getString("Complainer_Name");
				DOB = rs.getString("Date_of_birth");
				Age = rs.getString("Age");
				// Post = rs.getString("Post");
				MobileNumber = rs.getString("Mobile_number");
				Email = rs.getString("email");
				Address = rs.getString("Address");
				DOFir = rs.getString("Date_time_of_fir");
				ComplainType = rs.getString("complain_type");
				occurrence = rs.getString("occurence_date");
				details = rs.getString("details_of_incident");
				suspectDetails = rs.getString("suspect_details");

				model.addRow(new Object[] { PoliceUsername, ComplainerName, DOB, Age, MobileNumber, Email, Address,
						DOFir, ComplainType, occurrence, details, suspectDetails });
				i++;
			}
             // while(rs.next()){
			//if (rs1.next())
               while(rs1.next())
			{
				PoliceUsername = rs1.getString("Police_username");

				if (textvalue.equals(PoliceUsername)) {
					
					//userNamePolice = rs1.getString("Police_username");
					PoliceUsername = rs1.getString("Police_username");
					// complainerNumber = rs.getString("Complainer_number");
					FirstName = rs1.getString("First_Name");
					MiddleName = rs1.getString("Middle_Name");
					LastName = rs1.getString("Last_Name");
					DOB = rs1.getString("Date_of_birth");
					Age = rs1.getString("Age");
					// Post = rs.getString("Post");
					MobileNumber = rs1.getString("Mobile_number");
					Email = rs1.getString("email");
					Address = rs1.getString("Address");
					

					model1.addRow(new Object[] { PoliceUsername, FirstName, MiddleName, LastName, DOB, Age, MobileNumber,
							Email, Address });
					i++;

				}
			}

			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found");

			}
			/*if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}*/
            
              } catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		contentPane1.add(scroll);
		contentPane1.setVisible(true);
		// frame1.setSize(400, 300);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		searchexample f = new searchexample();
		f.createUI();
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == button) {
			showTableData();
			
		}
		if (e.getSource() == button1) {
			textbox.setText("");//resetting the value of username text field
        }
	}

}
