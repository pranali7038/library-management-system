import java.awt.EventQueue;
import java.sql.*;

import project.ConnectionProvider;

import javax.swing.JFrame;
import javax.swing.JLabel;



import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class new_Student {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_Student window = new new_Student();
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
	public new_Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 894, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(133, 122, 105, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(121, 186, 124, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(121, 259, 116, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(121, 317, 124, 34);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Branch Name");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(121, 379, 124, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBackground(new Color(255, 250, 205));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBounds(294, 124, 223, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBackground(new Color(255, 250, 205));
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setBounds(294, 188, 223, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_2.setBackground(new Color(255, 250, 205));
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setBounds(294, 253, 223, 34);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BTech"}));
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox.setBackground(new Color(255, 250, 205));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox.setBounds(294, 319, 223, 30);
		frame.getContentPane().add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"CSE", "IT", "CIVIL", "MECHANICAL"}));
		comboBox_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox_1.setBackground(new Color(255, 250, 205));
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox_1.setBounds(294, 381, 223, 30);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String StudentID=textField.getText();
				String Name=textField_1.getText();
				String LastName=textField_2.getText();
				String CourseName=(String)comboBox.getSelectedItem();
				String Branch=(String)comboBox_1.getSelectedItem();
				
				try{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("insert into student values('"+StudentID+"','"+Name+"','"+LastName+"','"+CourseName+"','"+Branch+"')");
					JOptionPane.showMessageDialog(null, "Successfully Updated!!..");
				}
				catch(Exception ae){
					JOptionPane.showMessageDialog(null, "Student Id Already Exists!!");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\save-icon--1.png"));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(364, 440, 105, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\red-x-mark-transparent-background-3.png"));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1.setBounds(510, 440, 105, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("ADD NEW STUDENT HERE");
		lblNewLabel_5.setFont(new Font("Algerian", Font.BOLD, 28));
		lblNewLabel_5.setBounds(54, 37, 382, 54);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Pranali\\Downloads\\Webp.net-resizeimage.png"));
		lblNewLabel_6.setBounds(0, 0, 894, 562);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
