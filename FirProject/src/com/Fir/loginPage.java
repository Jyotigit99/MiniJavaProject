package com.Fir;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginPage extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submit, cancel;
	JPanel contentPane;

	// Connection connection;
	static loginPage frame;

	final JTextField username, password;

	loginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Login Page");
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#DAFF33"));
		contentPane.setLayout(null);

		JLabel lblNewUserRegister = new JLabel("Welcome to the Login(FIR) Page");
		lblNewUserRegister.setFont(new Font("ARIAL", Font.BOLD, 42));
		lblNewUserRegister.setForeground(Color.decode("#140551"));
		lblNewUserRegister.setBounds(480, 52, 700, 150);
		contentPane.add(lblNewUserRegister);
		JLabel b = new JLabel(new ImageIcon("D:\\image\\login.png"));
		b.setBounds(250, 72, 200, 150);

		contentPane.add(b);
		JLabel lbluser = new JLabel("UserName");
		lbluser.setFont(new Font("Arial", Font.PLAIN, 20));
		lbluser.setBounds(570, 270, 99, 43);
		contentPane.add(lbluser);

		JLabel lblpass = new JLabel("Password");
		lblpass.setFont(new Font("Arial", Font.PLAIN, 20));
		lblpass.setBounds(570, 330, 99, 43);
		contentPane.add(lblpass);

		username = new JTextField();
		username.setFont(new Font("Calibri", Font.PLAIN, 18));
		username.setBounds(680, 270, 228, 40);
		contentPane.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setFont(new Font("Calibri", Font.PLAIN, 18));
		password.setBounds(680, 330, 228, 40);
		contentPane.add(password);
		password.setColumns(10);

		submit = new JButton("LOGIN");
		submit.setBounds(690, 400, 99, 40);
		submit.setFont(new Font("Calibri", Font.BOLD, 18));
		submit.setBackground(Color.cyan);

		contentPane.add(submit);

		cancel = new JButton("RESET");
		cancel.setBounds(800, 400, 99, 40);
		cancel.setFont(new Font("Calibri", Font.BOLD, 18));
		cancel.setBackground(Color.orange);
		contentPane.add(cancel);
		submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submit.addActionListener(this);

		cancel.addActionListener(this);

	}

	public static void main(String[] args) {

		try {
			frame = new loginPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submit) {
			String userValueFromTextField = username.getText();
			String passValueFromTextField = password.getText();

			if (userValueFromTextField.equals("") && passValueFromTextField.equals("")) {
				JOptionPane.showMessageDialog(submit, "Please Enter Details");
			}

			else if (userValueFromTextField.equals("admin") && passValueFromTextField.equals("admin"))

			{

				onlyMenuPageAdmin adminMenuPage = new onlyMenuPageAdmin();

				// make page visible to the user
				adminMenuPage.setVisible(true);
				dispose();
			} else if (!userValueFromTextField.equals("admin") && !passValueFromTextField.equals("admin")) {

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fir", "root",
							"Root#123");

					PreparedStatement pState = connection
							.prepareStatement("select Username, Passwords from Police_Registration where Username='"
									+ userValueFromTextField + "' and Passwords='" + passValueFromTextField + "'");

					ResultSet checkPoliceSet = pState.executeQuery();
					String userNamePolice, passwordPolice;

					if (checkPoliceSet.next()) {

						userNamePolice = checkPoliceSet.getString("Username");
						passwordPolice = checkPoliceSet.getString("Passwords");
						if (userValueFromTextField.equals(userNamePolice)
								&& passValueFromTextField.equals(passwordPolice)) {

							onlyMenuPagePolice policeMenuPage = new onlyMenuPagePolice();
							policeMenuPage.my_update(userValueFromTextField);
							// make page visible to the user
							policeMenuPage.setVisible(true);
							dispose();
						}

					} else {
						JOptionPane.showMessageDialog(submit, "INVALID USERNAME or PASSWORD");
					}

					connection.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(submit, "INVALID USERNAME or PASSWORD");
			}

		} else if (e.getSource() == cancel) {
			String def = "";
			username.setText(def);
			password.setText(def);
		}
	}
}
