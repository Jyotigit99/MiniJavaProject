package com.Fir;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class complainerRegistration extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField firstname;
	private JTextField middle_name;
	private JTextField lastname;
	private JTextField age;

	private JTextField date_of_birth;
	private JTextField email;
	private JTextField mob;
	private JTextField address;
	private JButton register;
	private JButton cancel;
	private JButton home;
	// private String s;
	private JLabel labelPoliceName;
	static complainerRegistration frame;

	public void getPoliceUsername(String policeUsername) {
		labelPoliceName.setText(policeUsername);
		// TODO Auto-generated method stub

	}

	complainerRegistration() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Complainer Registration");
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

		JLabel lblNewUserRegister = new JLabel("New Complainer Registration");
		lblNewUserRegister.setFont(new Font("georgia", Font.BOLD, 42));
		lblNewUserRegister.setBounds(442, 52, 700, 100);
		lblNewUserRegister.setForeground(Color.decode("#140551"));
		contentPane.add(lblNewUserRegister);

		JLabel lblName = new JLabel("First name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblName.setBounds(250, 171, 99, 43);
		contentPane.add(lblName);

		JLabel lblMiddleName = new JLabel(" Middle name");
		lblMiddleName.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMiddleName.setBounds(242, 221, 159, 43);
		contentPane.add(lblMiddleName);

		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(249, 280, 110, 29);
		contentPane.add(lblNewLabel);

		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Arial", Font.PLAIN, 20));
		lblage.setBounds(305, 340, 110, 29);
		contentPane.add(lblage);

		JLabel lbldob = new JLabel("Date of Birth");
		lbldob.setFont(new Font("Arial", Font.PLAIN, 20));
		lbldob.setBounds(765, 335, 150, 29);
		contentPane.add(lbldob);

		JLabel date_of_birth_correct = new JLabel("(yyyy-mm-dd)");
		date_of_birth_correct.setFont(new Font("Arial", Font.PLAIN, 12));
		date_of_birth_correct.setForeground(Color.red);
		date_of_birth_correct.setBounds(927, 370, 100, 18);
		contentPane.add(date_of_birth_correct);

		date_of_birth = new JTextField();
		date_of_birth.setFont(new Font("Arial", Font.PLAIN, 18));
		date_of_birth.setBounds(907, 330, 227, 40);
		contentPane.add(date_of_birth);
		date_of_birth.setColumns(10);

		JLabel lblEmailAddress = new JLabel("Email");
		lblEmailAddress.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmailAddress.setBounds(840, 221, 124, 36);
		contentPane.add(lblEmailAddress);

		firstname = new JTextField();
		firstname.setFont(new Font("Arial", Font.PLAIN, 18));
		firstname.setBounds(370, 171, 228, 40);
		contentPane.add(firstname);
		firstname.setColumns(10);

		middle_name = new JTextField();
		middle_name.setFont(new Font("Arial", Font.PLAIN, 18));
		middle_name.setBounds(370, 221, 228, 40);
		contentPane.add(middle_name);
		middle_name.setColumns(10);

		lastname = new JTextField();
		lastname.setFont(new Font("Arial", Font.PLAIN, 18));
		lastname.setBounds(370, 275, 228, 40);
		contentPane.add(lastname);
		lastname.setColumns(10);

		email = new JTextField();

		email.setFont(new Font("Arial", Font.PLAIN, 18));
		email.setBounds(907, 221, 228, 40);
		contentPane.add(email);
		email.setColumns(10);

		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMobileNumber.setBounds(760, 279, 139, 26);
		contentPane.add(lblMobileNumber);

		mob = new JTextField();
		mob.setFont(new Font("Arial", Font.PLAIN, 18));
		mob.setBounds(907, 275, 228, 40);
		contentPane.add(mob);
		mob.setColumns(10);

		age = new JTextField();
		age.setFont(new Font("Arial", Font.PLAIN, 18));
		age.setBounds(370, 330, 228, 40);
		contentPane.add(age);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setFont(new Font("Arial", Font.PLAIN, 20));
		lbladdress.setBounds(819, 175, 99, 29);
		contentPane.add(lbladdress);

		address = new JTextField();
		address.setFont(new Font("Arial", Font.PLAIN, 18));
		address.setBounds(907, 171, 228, 40);
		contentPane.add(address);
		address.setColumns(10);

		register = new JButton("REGISTER");
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		register.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String firstName = firstname.getText();
				String middleName = middle_name.getText();
				String lastName = lastname.getText();
				String emailId = email.getText();
				// String userName = username.getText();
				String mobileNumber = mob.getText();

				String Age = age.getText();
				String Address = address.getText();
				String policeUserName = labelPoliceName.getText();
				String complainer_dob = date_of_birth.getText();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String uuidGenerate="";
				
				String msg = "" + firstName;
				String Complainer_Name = firstName.concat(" " + middleName).concat(" " + lastName);

				msg += " \n";
				if (firstName.equals("") || middleName.equals("") || lastName.equals("") || emailId.equals("")
						|| mobileNumber.equals("") || Age.equals("") || Address.equals("")
						|| complainer_dob.equals("")) {
					JOptionPane.showMessageDialog(register, "Please Enter Details");
				} else if (!firstName.matches("[a-zA-Z]*") || !middleName.matches("[a-zA-Z]*")
						|| !lastName.matches("[a-zA-Z]*") || !emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
						|| !mobileNumber.matches("(0|91)?[6-9][0-9]{9}")
						|| !complainer_dob.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
					JOptionPane.showMessageDialog(register,
							"Invalid data , Please Check(if any)" + "\n"
									+ "1. First, Middle and Last name should contain Only Alphabets" + "\n"
									+ "2. Mobile number - 10 digits only" + "\n" + "3. Email format - abc@example.com"
									+ "\n" + "4. Date of birth yyyy-mm-dd");
				} else {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root",
								"Root#123");
						 uuidGenerate = firstName.concat(complainer_dob.substring(0, 4)).concat(dtf.format(now));
						System.out.println(uuidGenerate);
						String query = "INSERT INTO Complainer_Registration1 values('" + policeUserName + "','"
								+ firstName + "','" + middleName + "','" + lastName + "','" + complainer_dob + "','"
								+ Age + "','" + mobileNumber + "','" + emailId + "','" + Address + "','" + uuidGenerate
								+ "')";

						Statement registerDetails = connection.createStatement();

						int x = registerDetails.executeUpdate(query);
						if (x == 0) {
							JOptionPane.showMessageDialog(register, "This is alredy exist");
						} else {
							JOptionPane.showMessageDialog(register,
									"Welcome, " + msg + "Your account is sucessfully created");
						}

						connection.close();
					} catch (Exception exception) {
						exception.printStackTrace();
					}

					firRegistationPage f = new firRegistationPage();

					f.getComplainerDetailsFromRegistration(Complainer_Name, uuidGenerate);
					f.setVisible(true);
					dispose();
				}

			}
		});
		register.setFont(new Font("Tahoma", Font.BOLD, 18));
		register.setBackground(Color.cyan);
		register.setBounds(630, 440, 199, 54);
		contentPane.add(register);

		cancel = new JButton("CLEAR");
		cancel.setFont(new Font("tahoma", Font.BOLD, 18));
		cancel.setBackground(Color.orange);
		cancel.setBounds(850, 440, 200, 54);
		contentPane.add(cancel);
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstname.setText("");
				middle_name.setText("");
				lastname.setText("");
				email.setText("");

				mob.setText("");

				age.setText("");
				address.setText("");

				date_of_birth.setText("");

			}

		});

		home = new JButton("HOME");
		home.setFont(new Font("tahoma", Font.BOLD, 18));
		home.setBackground(Color.orange);
		home.setBounds(400, 440, 200, 54);
		contentPane.add(home);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int s = JOptionPane.showConfirmDialog(null, "Do you want to Continue");
				if (s == JOptionPane.YES_OPTION) {
					System.out.println("hello");
					dispose();
				}

			}

		});

		JLabel note = new JLabel("* NOTE: ALL THE FIELDS ARE MANDATORY *");
		note.setFont(new Font("Tahoma", Font.BOLD, 16));
		note.setForeground(Color.red);
		note.setBounds(60, 590, 500, 30);
		contentPane.add(note);

	}

	public static void main(String[] args)

	{
		// TODO Auto-generated method stub
		frame = new complainerRegistration();
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
