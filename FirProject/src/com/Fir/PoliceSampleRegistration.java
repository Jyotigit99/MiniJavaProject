package com.Fir;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;
import java.util.Calendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PoliceSampleRegistration extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static final long JTextField =1L;
	private JPanel contentPane;

	private JTextField username;
	private JPasswordField passwordField;
	private JTextField firstname;
	private JTextField middle_name;
	private JTextField lastname;
	private JTextField age;
	private JTextField post;

	private JTextField email;
	private JTextField mob;
	private JTextField address;
	private JButton btnNewButton;

	JRadioButton jRadioButton1;

	JRadioButton jRadioButton2;

	ButtonGroup G1;

	JFrame f;
	JMenuBar bar;
	JMenu p, v, s, l;
	JMenuItem p1, p2, v1, v2, s1;

	PoliceSampleRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		bar = new JMenuBar();

		p = new JMenu("Police Details");

		v = new JMenu("View");
		s = new JMenu("Search");

		bar.add(p);

		bar.add(v);
		bar.add(s);

		p1 = new JMenuItem("Add Police Details");
		p.add(p1);

		p2 = new JMenuItem("Update");
		p.add(p2);

		v1 = new JMenuItem("Police Details");
		v.add(v1);
		s1 = new JMenuItem("Police");

		s.add(s1);

		JLabel lblNewUserRegister = new JLabel("New Police Registration");
		lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewUserRegister.setBounds(542, 52, 425, 100);
		contentPane.add(lblNewUserRegister);

		JLabel lblName = new JLabel("First name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(250, 171, 99, 43);
		contentPane.add(lblName);

		JLabel lblMiddleName = new JLabel(" Middle name");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMiddleName.setBounds(242, 221, 159, 43);
		contentPane.add(lblMiddleName);

		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(249, 280, 110, 29);
		contentPane.add(lblNewLabel);

		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblage.setBounds(305, 340, 110, 29);
		contentPane.add(lblage);

		JLabel lblpost = new JLabel("Post");
		lblpost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpost.setBounds(305, 383, 110, 29);
		contentPane.add(lblpost);

		JLabel lbldob = new JLabel("Date of Birth");
		lbldob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldob.setBounds(240, 430, 150, 29);
		contentPane.add(lbldob);

		final JXDatePicker picker = new JXDatePicker();

		picker.setBounds(370, 430, 227, 40);
		picker.setFormats(new String[] { "yyyy-mm-dd" });

		contentPane.add(picker);

		post = new JTextField();
		post.setFont(new Font("Calibri", Font.PLAIN, 18));
		post.setBounds(370, 382, 228, 40);
		contentPane.add(post);
		post.setColumns(10);

		JLabel lblEmailAddress = new JLabel("Email\r\n address");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailAddress.setBounds(765, 280, 124, 36);
		contentPane.add(lblEmailAddress);

		firstname = new JTextField();
		firstname.setFont(new Font("Calibri", Font.PLAIN, 18));
		firstname.setBounds(370, 171, 228, 40);
		contentPane.add(firstname);
		firstname.setColumns(10);

		middle_name = new JTextField();
		middle_name.setFont(new Font("Calibri", Font.PLAIN, 18));
		middle_name.setBounds(370, 221, 228, 40);
		contentPane.add(middle_name);
		middle_name.setColumns(10);

		lastname = new JTextField();
		lastname.setFont(new Font("Calibri", Font.PLAIN, 18));
		lastname.setBounds(370, 275, 228, 40);
		contentPane.add(lastname);
		lastname.setColumns(10);

		email = new JTextField();

		email.setFont(new Font("Calibri", Font.PLAIN, 18));
		email.setBounds(907, 280, 228, 40);
		contentPane.add(email);
		email.setColumns(10);

		username = new JTextField();
		username.setFont(new Font("Calibri", Font.PLAIN, 18));
		username.setBounds(907, 171, 228, 40);
		contentPane.add(username);
		username.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(802, 179, 99, 29);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(802, 235, 99, 24);
		contentPane.add(lblPassword);

		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(760, 335, 139, 26);
		contentPane.add(lblMobileNumber);

		mob = new JTextField();
		mob.setFont(new Font("Calibri", Font.PLAIN, 18));
		mob.setBounds(907, 330, 228, 40);
		contentPane.add(mob);
		mob.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 18));
		passwordField.setBounds(907, 225, 228, 40);
		contentPane.add(passwordField);

		age = new JTextField();
		age.setFont(new Font("Calibri", Font.PLAIN, 18));
		age.setBounds(370, 330, 228, 40);
		contentPane.add(age);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbladdress.setBounds(819, 385, 99, 29);
		contentPane.add(lbladdress);

		address = new JTextField();
		address.setFont(new Font("Calibri", Font.PLAIN, 18));
		address.setBounds(907, 380, 228, 40);
		contentPane.add(address);
		address.setColumns(10);

		JLabel lbljoining = new JLabel("Date of Joining");
		lbljoining.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbljoining.setBounds(753, 435, 150, 29);
		contentPane.add(lbljoining);

		final JXDatePicker picker1 = new JXDatePicker();
		picker1.setDate(Calendar.getInstance().getTime());
		picker1.setBounds(907, 430, 227, 40);

		contentPane.add(picker1);

		jRadioButton1 = new JRadioButton();

		jRadioButton2 = new JRadioButton("Male");

		G1 = new ButtonGroup();

		jRadioButton1.setText("Female");
		jRadioButton1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jRadioButton2.setText("Male");
		jRadioButton2.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jRadioButton1.setBounds(600, 480, 240, 100);

		jRadioButton2.setBounds(680, 480, 240, 100);

		G1.add(jRadioButton1);
		G1.add(jRadioButton2);

		contentPane.add(jRadioButton1);
		contentPane.add(jRadioButton2);

		btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String firstName = firstname.getText();
				String middleName = firstname.getText();
				String lastName = lastname.getText();
				String emailId = email.getText();
				String userName = username.getText();
				String mobileNumber = mob.getText();

				String Age = age.getText();
				String Address = address.getText();
				String Post = post.getText();

				String password = passwordField.getText();

				String msg = "" + firstName;
				msg += " \n";

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root",
							"Root#123");

					String query = "INSERT INTO Police_Registration values('" + firstName + "','" + middleName + "','"
							+ lastName + "','" + "2023-01-23" + "','" + Age + "','" + Post + "','" + mobileNumber
							+ "','" + emailId + "','" + Address + "','" + "2023-01-23" + "','" + userName + "','"
							+ password + "')";

					Statement registerDetails = connection.createStatement();
					int x = registerDetails.executeUpdate(query);
					if (x == 0) {
						JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
					} else {
						JOptionPane.showMessageDialog(btnNewButton,
								"Welcome, " + msg + "Your account is sucessfully created");
					}

					connection.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(620, 580, 199, 54);
		contentPane.add(btnNewButton);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PoliceRegistration frame = new PoliceRegistration();

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
