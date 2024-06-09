import java.awt.EventQueue;
import java.sql.*;

import project.ConnectionProvider;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Point;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;


public class new_Book {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_Book window = new new_Book();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public new_Book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLocation(new Point(325, 125));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(86, 140, 90, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(86, 193, 76, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Publisher");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(86, 236, 90, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(86, 276, 76, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Published Year");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_4.setBounds(86, 331, 151, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ADD BOOK HERE....");
		lblNewLabel_5.setFont(new Font("Algerian", Font.BOLD, 31));
		lblNewLabel_5.setBounds(72, 42, 292, 49);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField.setBackground(new Color(255, 250, 205));
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setInheritsPopupMenu(true);
		textField.setBounds(261, 143, 204, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField_1.setBackground(new Color(255, 250, 205));
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBounds(261, 196, 204, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField_2.setBackground(new Color(255, 250, 205));
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_2.setBounds(261, 239, 204, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField_3.setBackground(new Color(255, 250, 205));
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_3.setBounds(261, 283, 204, 27);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField_4.setBackground(new Color(255, 250, 205));
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_4.setBounds(261, 334, 204, 27);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String BookID=textField.getText();
				String Name=textField_1.getText();
				String Publisher=textField_2.getText();
				String Price=textField_3.getText();
				String PublishedYear=textField_4.getText();
				try{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("insert into book values('"+BookID+"','"+Name+"','"+Publisher+"','"+Price+"','"+PublishedYear+"')");
					JOptionPane.showMessageDialog(null, "Successfully Updated!!");
					
					
					
				}
				catch(Exception ae){
					JOptionPane.showMessageDialog(null, "Book ID Already exist!!..");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\save-icon--1.png"));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(302, 374, 106, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\red-x-mark-transparent-background-3.png"));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}

			
		});
		btnNewButton_1.setBounds(444, 374, 113, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\123456.png"));
		lblNewLabel_6.setBounds(0, 0, 700, 450);
		frame.getContentPane().add(lblNewLabel_6);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
