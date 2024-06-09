import java.awt.EventQueue;
import java.sql.*;

import project.ConnectionProvider;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




public class issue_book {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issue_book window = new issue_book();
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
	public issue_book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 886, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(132, 137, 139, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(132, 200, 139, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Issue Date");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(132, 259, 139, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Due Date");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(132, 322, 139, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBackground(new Color(255, 248, 220));
		textField.setBounds(283, 139, 235, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setBounds(283, 198, 235, 40);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		 final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		dateChooser.setBackground(new Color(255, 248, 220));
		dateChooser.setBounds(283, 262, 235, 40);
		frame.getContentPane().add(dateChooser);
		
		 final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		dateChooser_1.setBackground(new Color(255, 248, 220));
		dateChooser_1.setBounds(283, 322, 235, 40);
		frame.getContentPane().add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Issue");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				DateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
				String bookID=textField.getText();
				String studentID=textField_1.getText();
				String returnBook="No";
				
				String issueDate=dFormat.format(dateChooser.getDate());
				String dueDate=dFormat.format(dateChooser_1.getDate());
				
				try{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select*from book where book_id='"+bookID+"'");
					if(rs.next()){
						ResultSet rs1=st.executeQuery("select*from student where Student_Id='"+studentID+"'");
						if(rs1.next()){
							st.executeUpdate("insert into issue values('"+bookID+"','"+studentID+"','"+issueDate+"','"+dueDate+"','"+returnBook+"')");
							JOptionPane.showMessageDialog(null, "Book Successfully issued");
							
						}
						else{
							JOptionPane.showConfirmDialog(null, "Incorrect StudentID");
							textField.setText(null);
							textField_1.setText(null);
							dateChooser.setCalendar(null);
							dateChooser_1.setCalendar(null);
						}
					}
					else{
						JOptionPane.showConfirmDialog(null, "Incorrect BookID");
						textField.setText(null);
						textField_1.setText(null);
						dateChooser.setCalendar(null);
						dateChooser_1.setCalendar(null);
					}
				}
				catch(Exception ae){
					JOptionPane.showConfirmDialog(null, "Connection Error");
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\issue.png"));
		btnNewButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(335, 392, 127, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\red-x-mark-transparent-background-3.png"));
		btnNewButton_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_1.setBounds(500, 392, 121, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("ISSUE BOOK HERE");
		lblNewLabel_4.setFont(new Font("Algerian", Font.BOLD, 34));
		lblNewLabel_4.setBounds(34, 46, 324, 40);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Pranali\\Downloads\\Webp.net-resizeimage.png"));
		lblNewLabel_5.setBounds(0, 0, 888, 566);
		frame.getContentPane().add(lblNewLabel_5);
	}

	

	
}
