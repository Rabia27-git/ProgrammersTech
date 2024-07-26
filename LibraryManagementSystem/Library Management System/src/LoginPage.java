import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.border.MatteBorder;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLibraryManagementSystem;
	private JTextField textField;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JPasswordField passwordField;
	private JTextField message;
	private boolean passwordVisible = false;
	static String name;
	static String password;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 857, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/Images/background.png")));
		lblNewLabel.setBounds(0, 160, 487, 431);
		contentPane.add(lblNewLabel);
		
		txtLibraryManagementSystem = new JTextField();
		txtLibraryManagementSystem.setFocusable(false);
		txtLibraryManagementSystem.setBorder(null);
		txtLibraryManagementSystem.setForeground(new Color(255, 255, 255));
		txtLibraryManagementSystem.setBackground(new Color(0, 115, 81));
		txtLibraryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		txtLibraryManagementSystem.setText("Library Management System");
		txtLibraryManagementSystem.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 55));
		txtLibraryManagementSystem.setBounds(10, 11, 823, 77);
		contentPane.add(txtLibraryManagementSystem);
		txtLibraryManagementSystem.setColumns(10);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField.setBounds(497, 206, 325, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setFocusable(false);
		txtUsername.setText("Username:");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setForeground(Color.WHITE);
		txtUsername.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtUsername.setColumns(10);
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(0, 115, 81));
		txtUsername.setBounds(471, 157, 191, 48);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setFocusable(false);
		txtPassword.setText("Password:");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtPassword.setColumns(10);
		txtPassword.setBorder(null);
		txtPassword.setBackground(new Color(0, 115, 81));
		txtPassword.setBounds(471, 306, 191, 35);
		contentPane.add(txtPassword);
		
		ImageIcon ic1=new ImageIcon(SignUp.class.getResource("/Images/showPassword.png"));
		ImageIcon ic2=new ImageIcon(SignUp.class.getResource("/Images/hidePassword.png"));
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				name=textField.getText();
				password=passwordField.getText();
				if(name.isEmpty() || password.isEmpty()) {
					message.setText("Please fill the details.");
				}
				else {
					try {
						Database d=new Database();
						boolean check=d.validate(name,password);
						if(!check) {
							message.setText("Invalid username or password.");
							return;
						}
						Dashboard db=new Dashboard();
						db.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(LoginPage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
					
					
				}
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 115, 81));
		btnNewButton.setIcon(new ImageIcon(LoginPage.class.getResource("/Images/login.png")));
		btnNewButton.setBounds(488, 444, 174, 77);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SignUp s=new SignUp();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(0, 115, 81));
		btnNewButton_1.setIcon(new ImageIcon(LoginPage.class.getResource("/Images/signup.png")));
		btnNewButton_1.setBounds(668, 444, 165, 77);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		passwordField.setBorder(new MatteBorder(3, 3, 3, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(497, 346, 264, 59);
		contentPane.add(passwordField);
		
		message = new JTextField();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setForeground(new Color(0, 0, 0));
		message.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 27));
		message.setFocusable(false);
		message.setColumns(10);
		message.setBorder(null);
		message.setBackground(new Color(0, 115, 81));
		message.setBounds(442, 107, 377, 48);
		contentPane.add(message);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(761, 346, 61, 59);
		btnNewButton_2.setIcon(ic2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				passwordVisible = !passwordVisible;
                if (passwordVisible) {
                    // Show password
                    passwordField.setEchoChar((char) 0); 
                    btnNewButton_2.setIcon(ic1);
                   
                } else {
                    // Hide password
                    passwordField.setEchoChar('\u2022'); 
                    btnNewButton_2.setIcon(ic2);

                }
			}
		});
		contentPane.add(btnNewButton_2);
	}
	
	public static String getname() {
		return name;
	}
	
	public static String getPassword() {
		return password;
	}
	
}
