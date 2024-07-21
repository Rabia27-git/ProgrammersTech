import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEnterUsernameOr;
	private JTextField textField;
	private JTextField txtEnterPassword;
	private JTextField message;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	static String email;
	String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 1026, 668);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterUsernameOr = new JTextField();
		txtEnterUsernameOr.setBounds(353, 204, 209, 42);
		txtEnterUsernameOr.setText("Enter email:");
		txtEnterUsernameOr.setForeground(Color.WHITE);
		txtEnterUsernameOr.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtEnterUsernameOr.setFocusable(false);
		txtEnterUsernameOr.setColumns(10);
		txtEnterUsernameOr.setBorder(null);
		txtEnterUsernameOr.setBackground(Color.BLACK);
		contentPane.add(txtEnterUsernameOr);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		textField.setBounds(353, 244, 393, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtEnterPassword = new JTextField();
		txtEnterPassword.setText("Enter password:");
		txtEnterPassword.setForeground(Color.WHITE);
		txtEnterPassword.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtEnterPassword.setFocusable(false);
		txtEnterPassword.setColumns(10);
		txtEnterPassword.setBorder(null);
		txtEnterPassword.setBackground(Color.BLACK);
		txtEnterPassword.setBounds(353, 310, 209, 42);
		contentPane.add(txtEnterPassword);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				email=textField.getText();
				password=passwordField.getText();
				if(email.isEmpty() || password.equals("")) {
					JOptionPane.showMessageDialog(LoginPage.this, "Please enter all details.");
				}
				else {
					try {
						Database d=new Database();
						boolean check=d.validate(email, password);
						if(!check) {
							message.setText("Invalid email or password");
							return;
						}
						else {
							message.setText(" ");
							HomePage h=new HomePage();
							h.setVisible(true);
							dispose();
						}
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(LoginPage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
					
				}
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setIcon(new ImageIcon(LoginPage.class.getResource("/Images/done.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(454, 417, 156, 68);
		contentPane.add(btnNewButton);
		
		message = new JTextField();
		message.setForeground(new Color(234, 0, 0));
		message.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		message.setFocusable(false);
		message.setColumns(10);
		message.setBorder(null);
		message.setBackground(Color.BLACK);
		message.setBounds(353, 151, 393, 42);
		contentPane.add(message);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		passwordField.setBounds(353, 351, 393, 42);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/Images/black.jpeg")));
		lblNewLabel.setBounds(305, 125, 468, 384);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginPage.class.getResource("/Images/background.png")));
		lblNewLabel_1.setBounds(10, 0, 992, 631);
		contentPane.add(lblNewLabel_1);
	}
	
	public static String getEmail() {
		return email;
	}
}
