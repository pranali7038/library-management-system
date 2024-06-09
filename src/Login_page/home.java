package Login_page;

import issue_book;
import new_Student;
import returnBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import java.awt.Dimension;

public class home {

	private static final String MAXIMIZED = null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	public home() {
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(600, 600, 1113,687 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton jButton1 = new JButton("New");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new_Student info=new new_Student();
				info.main(null);
			}
		});
		jButton1.setBounds(33, 13, 134, 59);
		jButton1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		jButton1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton1.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\member-add-on-300x300.png"));
		frame.getContentPane().add(jButton1);
		
		JButton jButton2 = new JButton("New Book");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new_Student info=new new_Student();
				 info.main(null);
			}
		});
		jButton2.setBounds(230, 13, 174, 59);
		jButton2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		jButton2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton2.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\New book.png"));
		frame.getContentPane().add(jButton2);
		
		JButton jButton4 = new JButton("Issue Book");
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				issue_book info=new issue_book();
				info.main(null);
			}
		});
		jButton4.setBounds(468, 13, 179, 59);
		jButton4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		jButton4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton4.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\issue.png"));
		frame.getContentPane().add(jButton4);
		
		JButton jButton5 = new JButton("Return Book");
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				returnBook info=new returnBook();
				info.main(null);
			}
		});
		jButton5.setBounds(688, 13, 193, 59);
		jButton5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		jButton5.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\return-book-1-560407.png"));
		jButton5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(jButton5);
		
		JButton jButton6 = new JButton("Log Out");
		jButton6.setBounds(924, 13, 164, 59);
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login info=new Login();
				info.main(null);
			}
		});
		jButton6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		jButton6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton6.setBackground(new Color(240, 240, 240));
		jButton6.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\exit.png"));
		frame.getContentPane().add(jButton6);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setSize(new Dimension(1366, 740));
		lblNewLabel.setBounds(0, 0, 1112, 683);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pranali\\Desktop\\Library Management\\Icon 1\\Library_Book_532388_1366x768.jpg"));
		frame.getContentPane().add(lblNewLabel);
	}
}
