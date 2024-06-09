import java.awt.EventQueue;
import java.sql.*;

import project.ConnectionProvider;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class returnBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBook window = new returnBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public returnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 892, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(125, 170, 107, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(125, 233, 107, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Issue Date");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(125, 297, 107, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Due Date");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(125, 365, 107, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBackground(new Color(255, 250, 205));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBounds(290, 157, 258, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBackground(new Color(255, 250, 205));
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setBounds(290, 230, 258, 43);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_2.setBackground(new Color(255, 250, 205));
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setBounds(290, 292, 258, 43);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_3.setBackground(new Color(255, 250, 205));
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_3.setBounds(290, 360, 258, 43);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bookID=textField.getText();
				String studentID=textField_1.getText();
				try{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select*from issue where bookID='"+bookID+"'and studentID='"+studentID+"'");
					if(rs.next()){
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField.setEditable(false);
						textField_1.setEditable(false);
					}
					else{
						JOptionPane.showMessageDialog(null,"Book is not issued to this Student..");
						
					}
				}
				catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null,"Connection Error");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\search.png"));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(584, 239, 107, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bookID=textField.getText();
				String studentID=textField_1.getText();
				try{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("update issue set returnBook='YES' where StudentID='"+studentID+"'and bookID='"+bookID+"'");
					JOptionPane.showMessageDialog(null,"Book sucessfully returned");
					setVisible(false);
					new returnBook().setVisible(true);
				}
				catch(Exception ae){
					JOptionPane.showConfirmDialog(null, "Connection Error");
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\return book png.png"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnNewButton_1.setBounds(359, 433, 107, 51);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\red-x-mark-transparent-background-3.png"));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnNewButton_2.setBounds(520, 432, 107, 51);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Return Book");
		lblNewLabel_4.setFont(new Font("Algerian", Font.BOLD, 32));
		lblNewLabel_4.setBounds(37, 63, 320, 43);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Pranali\\Downloads\\Webp.net-resizeimage.png"));
		lblNewLabel_5.setBounds(0, 0, 892, 576);
		frame.getContentPane().add(lblNewLabel_5);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
