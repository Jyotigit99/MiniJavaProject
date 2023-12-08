package com.Fir;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class onlyMenuPageAdmin extends JFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	JFrame f;
	JMenuBar bar;
	JMenu p, v, s, l;
	JMenuItem p1, p2, v1, v2, s1;
	JPanel contentPane;
	JButton Logout;

	static onlyMenuPageAdmin frame;

	onlyMenuPageAdmin() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Menu Page Admin");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.decode("#DAFFFF"));
		JLabel b = new JLabel(new ImageIcon("D:\\image\\logo1.png"));
		b.setBounds(500, 50, 900, 830);
		contentPane.add(b);
		Logout = new JButton("Logout");
		Logout.setBounds(1380, 50, 100, 25);
		Logout.setFont(new Font("Arial", Font.BOLD, 15));
		Logout.setBackground(Color.orange);
		Logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Logout, BorderLayout.NORTH);

		bar = new JMenuBar();
		bar.setBackground(Color.orange);
		contentPane.add(bar, BorderLayout.NORTH);
		p = new JMenu("Police Details");
		p.setFont(new Font("arial", Font.PLAIN, 15));
		p.setCursor(new Cursor(Cursor.HAND_CURSOR));
		v = new JMenu("View");
		v.setFont(new Font("arial", Font.PLAIN, 15));
		v.setCursor(new Cursor(Cursor.HAND_CURSOR));
		s = new JMenu("Search");
		s.setFont(new Font("arial", Font.PLAIN, 15));
		s.setCursor(new Cursor(Cursor.HAND_CURSOR));

		bar.add(p);

		bar.add(v);
		bar.add(s);

		p1 = new JMenuItem("Add Police Details");
		p1.setFont(new Font("arial", Font.PLAIN, 15));
		p.add(p1);

		p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PoliceRegistration Frame = new PoliceRegistration();

				Frame.setVisible(true);

			}
		});

		v1 = new JMenuItem("Police Details");
		v1.setFont(new Font("arial", Font.PLAIN, 15));
		v.add(v1);
		v1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				viewPoliceDetails f = new viewPoliceDetails();
				f.setVisible(true);
			}

		});

		s1 = new JMenuItem("Police");
		s1.setFont(new Font("arial", Font.PLAIN, 15));

		s.add(s1);
		s1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				SearchPoliceDetails f = new SearchPoliceDetails();
				f.setVisible(true);
			}

		});
		Logout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int s = JOptionPane.showConfirmDialog(null, "Do you want to Continue");
				if (s == JOptionPane.YES_OPTION) {
					loginPage frame1 = new loginPage();
					frame1.setVisible(true);
					dispose();
				}

			}

		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				loginPage frame1 = new loginPage();
				frame1.setVisible(true);
				dispose();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			frame = new onlyMenuPageAdmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
	}

}
