import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField lblNewLabel_1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 5, 1026, 668);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setBackground(new Color(0, 0, 0));
		textField.setCaretColor(new Color(255, 255, 255));
		textField.setBorder(null);
		textField.setFocusable(false);
		textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		textField.setForeground(new Color(255, 255, 255));
		textField.setText("Spotify");
		textField.setBounds(496, 145, 113, 43);
		ImageIcon icon=new ImageIcon(Login.class.getResource("/Images/Spotify.png"));
		
		lblNewLabel_1 = new JTextField();
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setText("Millions of songs.");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblNewLabel_1.setFocusable(false);
		lblNewLabel_1.setColumns(10);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setBounds(403, 233, 279, 43);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("Free on Spotify.");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		textField_1.setFocusable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(413, 288, 247, 43);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				LoginPage l=new LoginPage();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBorder(null);
		ImageIcon icon1=new ImageIcon(Login.class.getResource("/Images/login.png"));
		btnNewButton.setIcon(icon1);
		btnNewButton.setBounds(453, 360, 156, 61);
		contentPane.add(btnNewButton);
		
		JTextField txtNewTo = new JTextField();
		txtNewTo.setBackground(new Color(0, 0, 0));
		txtNewTo.setText("New to Spotify?");
		txtNewTo.setForeground(new Color(255, 255, 255));
		txtNewTo.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		txtNewTo.setFocusable(false);
		txtNewTo.setColumns(10);
		txtNewTo.setBorder(null);
		txtNewTo.setBounds(341, 432, 177, 43);
		contentPane.add(txtNewTo);
		
		JButton btnNewButton_1 = new JButton("Sign up free");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SignUpPage s=new SignUpPage();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		btnNewButton_1.setBounds(520, 429, 197, 48);
		contentPane.add(btnNewButton_1);
		ImageIcon icon2=new ImageIcon(Login.class.getResource("/Images/black.jpeg"));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Login.class.getResource("/Images/Spotify.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(449, 142, 45, 51);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/black.jpeg")));
		lblNewLabel.setBounds(305, 125, 468, 384);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Images/background.png")));
		lblNewLabel_2.setBounds(10, 0, 992, 620);
		contentPane.add(lblNewLabel_2);
	}

}
