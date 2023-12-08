package com.Fir;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PoliceRegistration extends JFrame implements ActionListener {
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
	private JTextField date_of_birth;
	private JTextField date_of_joining;
	private JTextField email;
	private JTextField mob;
	private JTextField address;
	private JButton btnNewButton;

	
	JMenuBar bar;
	JMenu p, v, s, l;
	JMenuItem p1, p2, v1, v2, s1;
	static PoliceRegistration frame;

	PoliceRegistration() {
		
		
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Register Police details Here ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#DAFF33"));
		contentPane.setLayout(null);

		JLabel lblNewUserRegister = new JLabel("New Police Registration");
		lblNewUserRegister.setFont(new Font("georgia", Font.BOLD, 42));
		lblNewUserRegister.setBounds(510, 52, 600, 100);
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

		JLabel lblpost = new JLabel("Post");
		lblpost.setFont(new Font("Arial", Font.PLAIN, 20));
		lblpost.setBounds(305, 383, 110, 29);
		contentPane.add(lblpost);

		JLabel lbldob = new JLabel("Date of Birth");
		lbldob.setFont(new Font("Arial", Font.PLAIN, 20));
		lbldob.setBounds(240, 430, 150, 29);
		contentPane.add(lbldob);

		date_of_birth = new JTextField();
		date_of_birth.setFont(new Font("Calibri", Font.PLAIN, 18));
		date_of_birth.setBounds(370, 430, 228, 40);
		contentPane.add(date_of_birth);
		date_of_birth.setColumns(10);

		JLabel date_of_birth_correct1 = new JLabel("(yyyy-mm-dd)");
		date_of_birth_correct1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date_of_birth_correct1.setForeground(Color.red);
		date_of_birth_correct1.setBounds(515, 470, 100, 18);
		contentPane.add(date_of_birth_correct1);

		post = new JTextField();
		post.setFont(new Font("Calibri", Font.PLAIN, 18));
		post.setBounds(370, 382, 228, 40);
		contentPane.add(post);
		post.setColumns(10);

		JLabel lblEmailAddress = new JLabel("Email");
		lblEmailAddress.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEmailAddress.setBounds(830, 280, 124, 36);
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
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsername.setBounds(802, 179, 99, 29);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword.setBounds(802, 235, 99, 24);
		contentPane.add(lblPassword);

		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Arial", Font.PLAIN, 20));
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
		lbladdress.setFont(new Font("Arial", Font.PLAIN, 20));
		lbladdress.setBounds(819, 385, 99, 29);
		contentPane.add(lbladdress);

		address = new JTextField();
		address.setFont(new Font("Calibri", Font.PLAIN, 18));
		address.setBounds(907, 380, 228, 40);
		contentPane.add(address);
		address.setColumns(10);

		date_of_joining = new JTextField();
		date_of_joining.setFont(new Font("Calibri", Font.PLAIN, 18));
		date_of_joining.setBounds(907, 430, 228, 40);
		contentPane.add(date_of_joining);
		date_of_joining.setColumns(10);

		JLabel lbljoining = new JLabel("Date of Joining");
		lbljoining.setFont(new Font("Arial", Font.PLAIN, 20));
		lbljoining.setBounds(753, 435, 150, 29);
		contentPane.add(lbljoining);

		JLabel date_of_birth_correct = new JLabel("(yyyy-mm-dd)");
		date_of_birth_correct.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date_of_birth_correct.setForeground(Color.red);
		date_of_birth_correct.setBounds(1060, 470, 100, 18);
		contentPane.add(date_of_birth_correct);

		JLabel note = new JLabel("* NOTE: ALL THE FIELDS ARE MANDATORY *");
		note.setFont(new Font("Tahoma", Font.BOLD, 16));
		note.setForeground(Color.red);
		note.setBounds(60, 630, 500, 30);
		contentPane.add(note);

		btnNewButton = new JButton("Register");
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String firstName = firstname.getText();
				String middleName = middle_name.getText();
				String lastName = lastname.getText();
				String emailId = email.getText();
				String userName = username.getText();
				String mobileNumber = mob.getText();
				
				String Age = age.getText();
				String Address = address.getText();
				String Post = post.getText();

				String DATE_OF_BIRTH = date_of_birth.getText();
				String Date_of_Joining = date_of_joining.getText();
				String password = passwordField.getText();

				String msg = "" + firstName;
				msg += " \n";

				if (firstName.equals("") || middleName.equals("") || lastName.equals("") || emailId.equals("")
						|| userName.equals("") || mobileNumber.equals("") || Age.equals("") || Address.equals("")
						|| Post.equals("") || DATE_OF_BIRTH.equals("") || Date_of_Joining.equals("")
						|| password.equals("")) {
					JOptionPane.showMessageDialog(btnNewButton, "Please Enter Details");
				} else if (!firstName.matches("[a-zA-Z]*") || !middleName.matches("[a-zA-Z]*")
						|| !lastName.matches("[a-zA-Z]*") || !Post.matches("[a-zA-Z]*")
						|| !emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
						|| !mobileNumber.matches("(0|91)?[6-9][0-9]{9}")
						|| !DATE_OF_BIRTH.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
						|| !Date_of_Joining.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
					JOptionPane.showMessageDialog(btnNewButton, "Invalid data , Please Check(if any)" + "\n"
							+ "1. First, Middle and Last name should contain Only Alphabets" + "\n"
							+ "2. Mobile number - 10 digits only" + "\n" + "3. Email format - abc@example.com" + "\n"
							+ "4. Every Date Format yyyy-mm-dd" + "\n" + "5.Post should conatin Alphabet");
				} else {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root",
								"Root#123");
						PreparedStatement searchPoliceUser = connection.prepareStatement(
								"select Username from Police_Registration  where Username='" + userName + "'");
						ResultSet rsPolice = searchPoliceUser.executeQuery();
						String userPoliceCounter;
						if (rsPolice.next()) {
							userPoliceCounter = rsPolice.getString("Username");
							if (userPoliceCounter.equalsIgnoreCase(userName)) {
								JOptionPane.showMessageDialog(btnNewButton, "Username already exists");

							}
						}

						else {

							String query = "INSERT INTO Police_Registration values('" + firstName + "','" + middleName
									+ "','" + lastName + "','" + DATE_OF_BIRTH + "','" + Age + "','" + Post + "','"
									+ mobileNumber + "','" + emailId + "','" + Address + "','" + Date_of_Joining + "','"
									+ userName + "','" + password + "')";

							Statement registerDetails = connection.createStatement();
							int x = registerDetails.executeUpdate(query);
							JOptionPane.showMessageDialog(btnNewButton,
									"Welcome, " + msg + "Your account is sucessfully created");
						

							connection.close();
						}
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBackground(Color.cyan);
		btnNewButton.setBounds(620, 540, 199, 54);
		contentPane.add(btnNewButton);

		JButton home = new JButton("HOME");
		home.setFont(new Font("tahoma", Font.BOLD, 18));
		home.setBackground(Color.orange);
		home.setBounds(400, 540, 200, 54);
		contentPane.add(home);

		JButton cancel = new JButton("CLEAR");
		cancel.setFont(new Font("tahoma", Font.BOLD, 18));
		cancel.setBackground(Color.orange);
		cancel.setBounds(840, 540, 200, 54);
		contentPane.add(cancel);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		home.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int s=JOptionPane.showConfirmDialog(null,"Do you want to Continue");
				if(s==JOptionPane.YES_OPTION) {
					System.out.println("hello");
					dispose();
				}
			
				}

		});
		
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				firstname.setText("");
				middle_name.setText("");
				lastname.setText("");
				email.setText("");
				username.setText("");
				mob.setText("");

				age.setText("");
				address.setText("");
				post.setText("");

				date_of_birth.setText("");
				date_of_joining.setText("");
				passwordField.setText("");
			}

		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frame = new PoliceRegistration();
		
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
