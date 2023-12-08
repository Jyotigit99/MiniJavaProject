package com.Fir;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class onlyMenuPagePolice extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f;
	JMenuBar bar;
	JMenu p, v, s, l;
	JLabel l1;
	JLabel l2;
	JMenuItem p1, p2, v1, v2, s1, s2, s3;
	JPanel contentPane;
	JButton Logout;

	public void my_update(String str) {
		l1.setText(str);
	}

	onlyMenuPagePolice() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(true);
		setTitle("Menu Page Police");
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#DAFFFF"));
		JLabel b = new JLabel(new ImageIcon("D:\\image\\logo.png"));
		b.setBounds(500,50,500,830);
		contentPane.add(b);
		l2 = new JLabel("Logged In User" + " ");
		l2.setBounds(1380, 70, 150, 50);
		l2.setForeground(Color.blue);
		l2.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(l2);

		l1 = new JLabel("Output"); // removed JLable from here.
		l1.setBounds(1390, 90, 250, 50);
		l1.setFont(new Font("Calibri", Font.BOLD, 25));
		l1.setForeground(Color.blue);
		contentPane.add(l1);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		Logout = new JButton("Logout");
		Logout.setBounds(1380, 50, 100, 25);
		Logout.setFont(new Font("Arial", Font.BOLD, 15));
		Logout.setBackground(Color.orange);
		Logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Logout, BorderLayout.NORTH);

		bar = new JMenuBar();
		bar.setBackground(Color.orange);
		contentPane.add(bar, BorderLayout.NORTH);
		p = new JMenu("Complainer Details");
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

		p1 = new JMenuItem("Add Complainer Details");
		p1.setFont(new Font("arial", Font.PLAIN, 15));
		p.add(p1);
		p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				complainerRegistration Frame1 = new complainerRegistration();

				Frame1.getPoliceUsername(l1.getText());

				Frame1.setVisible(true);
			}
		});

		v1 = new JMenuItem("Complainer Details");
		v1.setFont(new Font("arial", Font.PLAIN, 15));
		v.add(v1);
		v1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewcomplainerDetails Frame1 = new viewcomplainerDetails();

				Frame1.setVisible(true);
			}
		});

		s1 = new JMenuItem("Complainer");
		s1.setFont(new Font("arial", Font.PLAIN, 15));
		s.add(s1);
		s1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchComplainerDetails Frame1 = new searchComplainerDetails();
				Frame1.getPoliceUsername(l1.getText());
				Frame1.setVisible(true);
			}

		});
		s2 = new JMenuItem("Police");
		s2.setFont(new Font("arial", Font.PLAIN, 15));
		s.add(s2);
		s2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchcomplaineralldetailswithpoliceusername Frame1 = new searchcomplaineralldetailswithpoliceusername();
				Frame1.getPoliceUsername(l1.getText());
				Frame1.setVisible(true);
			}

		});
		s3 = new JMenuItem("Search FIR");
		s3.setFont(new Font("arial", Font.PLAIN, 15));
		s.add(s3);
		s3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchFirByComplainerId Frame1 = new searchFirByComplainerId();
				Frame1.getPoliceUsername(l1.getText());
				Frame1.setVisible(true);
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
		  addWindowListener (new WindowAdapter() {    
	            public void windowClosing (WindowEvent e) {   
	            	loginPage frame1 = new loginPage();
					frame1.setVisible(true);
	                dispose();    
	            }    
	        }); 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onlyMenuPagePolice frame = new onlyMenuPagePolice();

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
