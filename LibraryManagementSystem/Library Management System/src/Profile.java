import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProfile;
	private JTextField txtAdminId;
	private JTextField textField_1;
	private JTextField txtUsername;
	private JTextField textField_2;
	private JTextField textField;
	private JPasswordField passwordField;
	private boolean passwordVisible = false;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 719, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 115, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtProfile = new JTextField();
		txtProfile.setText("Profile");
		txtProfile.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfile.setForeground(new Color(255, 255, 255));
		txtProfile.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 50));
		txtProfile.setFocusable(false);
		txtProfile.setColumns(10);
		txtProfile.setBorder(null);
		txtProfile.setBackground(new Color(0, 115, 81));
		txtProfile.setBounds(161, 33, 377, 48);
		contentPane.add(txtProfile);
		
		txtAdminId = new JTextField();
		txtAdminId.setText("Admin ID:");
		txtAdminId.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdminId.setForeground(Color.WHITE);
		txtAdminId.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtAdminId.setFocusable(false);
		txtAdminId.setColumns(10);
		txtAdminId.setBorder(null);
		txtAdminId.setBackground(new Color(0, 115, 81));
		txtAdminId.setBounds(197, 150, 191, 48);
		contentPane.add(txtAdminId);
		
		textField_1 = new JTextField();
		textField_1.setFocusable(false);
		textField_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_1.setBounds(213, 202, 325, 59);
		contentPane.add(textField_1);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username:");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setForeground(Color.WHITE);
		txtUsername.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		txtUsername.setFocusable(false);
		txtUsername.setColumns(10);
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(0, 115, 81));
		txtUsername.setBounds(197, 287, 191, 48);
		contentPane.add(txtUsername);
		
		textField_2 = new JTextField();
		textField_2.setFocusable(false);
		textField_2.setText(LoginPage.getname());
		textField_2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 27));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textField_2.setBounds(213, 338, 325, 59);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Dashboard d=new Dashboard();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Profile.class.getResource("/Images/Back.png")));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(0, 115, 81));
		btnNewButton_1.setBounds(10, 29, 65, 65);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setText("Password:");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(0, 115, 81));
		textField.setBounds(197, 434, 191, 35);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFocusable(false);
		passwordField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		passwordField.setBorder(new MatteBorder(3, 3, 3, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(213, 473, 264, 59);
		passwordField.setText(LoginPage.getPassword());
		contentPane.add(passwordField);
		
		ImageIcon ic1=new ImageIcon(SignUp.class.getResource("/Images/showPassword.png"));
		ImageIcon ic2=new ImageIcon(SignUp.class.getResource("/Images/hidePassword.png"));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(new MatteBorder(3, 0, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(477, 473, 61, 59);
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
		
		
		try {
			Database d=new Database();
			int aid=d.getAdminID(LoginPage.getname(),LoginPage.getPassword());
			textField_1.setText(aid+"");
		} catch (SQLException e1) {
			 JOptionPane.showMessageDialog(Profile.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		
	}
}
