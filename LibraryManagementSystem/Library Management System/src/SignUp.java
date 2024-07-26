import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSignUp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private boolean passwordVisible = false;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 789, 639);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSignUp = new JTextField();
		txtSignUp.setText("Create an Account");
		txtSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignUp.setForeground(Color.WHITE);
		txtSignUp.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 55));
		txtSignUp.setFocusable(false);
		txtSignUp.setColumns(10);
		txtSignUp.setBorder(null);
		txtSignUp.setBackground(new Color(0, 115, 81));
		txtSignUp.setBounds(138, 11, 563, 77);
		contentPane.add(txtSignUp);
		
		textField = new JTextField();
		textField.setText("Username:");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(0, 115, 81));
		textField.setBounds(192, 181, 191, 48);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_1.setBounds(215, 240, 324, 59);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Password:");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField_2.setFocusable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 115, 81));
		textField_2.setBounds(192, 348, 191, 35);
		contentPane.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		passwordField.setBorder(new MatteBorder(3, 3, 3, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(215, 394, 264, 59);
		contentPane.add(passwordField);
		
		ImageIcon ic1=new ImageIcon(SignUp.class.getResource("/Images/showPassword.png"));
		ImageIcon ic2=new ImageIcon(SignUp.class.getResource("/Images/hidePassword.png"));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton.setIcon(ic2);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				passwordVisible = !passwordVisible;
                if (passwordVisible) {
                    // Show password
                    passwordField.setEchoChar((char) 0); 
                    btnNewButton.setIcon(ic1);
                   
                } else {
                    // Hide password
                    passwordField.setEchoChar('\u2022'); 
                    btnNewButton.setIcon(ic2);

                }
			}
		});
		btnNewButton.setBounds(478, 394, 61, 59);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LoginPage l=new LoginPage();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(new Color(0, 115, 81));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(SignUp.class.getResource("/Images/Back.png")));
		btnNewButton_1.setBounds(10, 25, 65, 65);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String name=textField_1.getText();
				String password=passwordField.getText();
				if(name.isEmpty() || password.isEmpty()) {
					message.setText("Please fill the  details.");
				}
				else {
					try {
						Database d=new Database();
						boolean check=d.validate(name,password);
						if(check) {
							message.setText("Please use another username or password.");
							return;
						}
						d.createAdmin(name,password);
						JOptionPane.showMessageDialog(SignUp.this, "Account created successfully");
						LoginPage l=new LoginPage();
						l.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(SignUp.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon(SignUp.class.getResource("/Images/next.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(0, 115, 81));
		btnNewButton_2.setBounds(267, 494, 212, 81);
		contentPane.add(btnNewButton_2);
		
		message = new JTextField();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setForeground(Color.BLACK);
		message.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		message.setFocusable(false);
		message.setColumns(10);
		message.setBorder(null);
		message.setBackground(new Color(0, 115, 81));
		message.setBounds(116, 115, 585, 48);
		contentPane.add(message);
	}
}
