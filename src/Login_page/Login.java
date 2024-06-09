package Login_page;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Point;

public class Login {

	private JFrame frame;
	private JTextField JTextField1;
	private JPasswordField JPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 22));
		frame.setBounds(150, 150, 1022, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LIBRARY MANAGEMENT BOOK ISSUING SYSTEM-LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pranali\\Downloads\\Hnet.com-image.png"));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
		lblNewLabel.setBounds(30, 13, 953, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pranali\\Downloads\\icons8-username-50.png"));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setBounds(331, 184, 200, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Pranali\\Downloads\\icons8-password-book-30.png"));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_2.setBounds(345, 259, 186, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextField1 = new JTextField();
		JTextField1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JTextField1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		JTextField1.setBackground(new Color(255, 250, 205));
		JTextField1.setBounds(538, 186, 218, 34);
		frame.getContentPane().add(JTextField1);
		JTextField1.setColumns(10);
		
		JPasswordField = new JPasswordField();
		JPasswordField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JPasswordField.setBackground(new Color(250, 250, 210));
		JPasswordField.setBounds(538, 260, 218, 34);
		frame.getContentPane().add(JPasswordField);
		
		
		JButton JButton1 = new JButton("Login");
		JButton1.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent arg0) {
				if(JTextField1.getText().equals("admin") && JPasswordField.getText().equals("admin"))
				{
				
					JOptionPane.showMessageDialog(null,"Login SuccessFully");
					frame.dispose();
					home info=new home();
					info.main(null);
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					JTextField1.setText(null);
					JPasswordField.setText(null);
					
				}
				
			}
		});
		JButton1.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\login.png"));
		JButton1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(105, 105, 105)));
		JButton1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		JButton1.setBounds(561, 311, 103, 44);
		frame.getContentPane().add(JButton1);
		
		JButton JButton2 = new JButton("Exit");
		JButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		JButton2.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\red-x-mark-transparent-background-3.png"));
		JButton2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(105, 105, 105)));
		JButton2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		JButton2.setBounds(685, 311, 103, 44);
		frame.getContentPane().add(JButton2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setLocation(new Point(325, 125));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Pranali\\Downloads\\Webp.net-resizeimage (1).png"));
		lblNewLabel_3.setBounds(0, 0, 1020, 529);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
