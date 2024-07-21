import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField name;
	private JTextField txtEmail;
	private JTextField email;
	private JTextField txtPassword;
	private JTextField password;
	private JTextField txtDateOfBirth;
	private JTextField dob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 5, 755, 661);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("Spotify");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setBackground(Color.BLACK);
		textField.setBounds(333, 21, 113, 43);
		contentPane.add(textField);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Profile.class.getResource("/Images/Spotify.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(278, 21, 45, 51);
		contentPane.add(btnNewButton_2);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Segoe UI Black", Font.PLAIN, 55));
		name.setFocusable(false);
		name.setColumns(10);
		name.setBorder(null);
		name.setBackground(Color.BLACK);
		name.setBounds(10, 100, 721, 60);
		contentPane.add(name);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email:");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		txtEmail.setFocusable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(Color.BLACK);
		txtEmail.setBounds(315, 204, 118, 51);
		contentPane.add(txtEmail);
		
		email = new JTextField();
		email.setFocusable(false);
		email.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		email.setColumns(10);
		email.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		email.setBounds(218, 255, 322, 51);
		contentPane.add(email);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password:");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		txtPassword.setFocusable(false);
		txtPassword.setColumns(10);
		txtPassword.setBorder(null);
		txtPassword.setBackground(Color.BLACK);
		txtPassword.setBounds(295, 341, 167, 51);
		contentPane.add(txtPassword);
		
		password = new JTextField();
		password.setFocusable(false);
		password.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		password.setColumns(10);
		password.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		password.setBounds(218, 390, 322, 51);
		contentPane.add(password);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setText("Date of Birth:");
		txtDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateOfBirth.setForeground(Color.WHITE);
		txtDateOfBirth.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		txtDateOfBirth.setFocusable(false);
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBorder(null);
		txtDateOfBirth.setBackground(Color.BLACK);
		txtDateOfBirth.setBounds(278, 486, 209, 51);
		contentPane.add(txtDateOfBirth);
		
		dob = new JTextField();
		dob.setFocusable(false);
		dob.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		dob.setColumns(10);
		dob.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		dob.setBounds(218, 536, 322, 51);
		contentPane.add(dob);
		
		try {
			String vemail=LoginPage.getEmail(); 
			Database d=new Database();
			 int userID=d.getUserID(vemail);
			 if(userID==0) {
				 vemail=d.getLastEmail();
			 }
			email.setText(vemail);
			String n=d.getName(vemail);
			n=n.toUpperCase();
			name.setText(n);
			String p=d.password(vemail);
			String ptext="";
			for(int i=0;i<p.length();i++) {
				ptext=ptext+"*";
			}
			password.setText(ptext);
			dob.setText(d.dob(vemail));
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblNewLabel.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					HomePage h=new HomePage();
					h.setVisible(true);
					dispose();
				}
			});
			lblNewLabel.setIcon(new ImageIcon(Profile.class.getResource("/Images/back.png")));
			lblNewLabel.setBounds(10, 11, 66, 65);
			contentPane.add(lblNewLabel);
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(Profile.this, "Exception occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
