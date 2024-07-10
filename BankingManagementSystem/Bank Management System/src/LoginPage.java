import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtWelcomeTo;
	private JTextField txtBankManagementSystem;
	private JTextField txtCardNo;
	private JTextField txtPin;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField txtDoesntHaveAn;
	private JButton btnSignUp;
	static String card;
	static int cid;
	static String pin;
	static int aid;

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
		setBounds(150, 25, 903, 645);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWelcomeTo = new JTextField();
		txtWelcomeTo.setFocusable(false);
		txtWelcomeTo.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 50));
		txtWelcomeTo.setBackground(new Color(204, 204, 204));
		txtWelcomeTo.setBorder(null);
		txtWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeTo.setText("WELCOME TO");
		txtWelcomeTo.setBounds(118, 22, 673, 63);
		contentPane.add(txtWelcomeTo);
		txtWelcomeTo.setColumns(10);
		
		txtBankManagementSystem = new JTextField();
		txtBankManagementSystem.setFocusable(false);
		txtBankManagementSystem.setText("BANK MANAGEMENT SYSTEM");
		txtBankManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		txtBankManagementSystem.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 50));
		txtBankManagementSystem.setColumns(10);
		txtBankManagementSystem.setBorder(null);
		txtBankManagementSystem.setBackground(new Color(204, 204, 204));
		txtBankManagementSystem.setBounds(118, 88, 673, 76);
		contentPane.add(txtBankManagementSystem);
		
		txtCardNo = new JTextField();
		txtCardNo.setFocusable(false);
		txtCardNo.setText("Card No:");
		txtCardNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCardNo.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 37));
		txtCardNo.setColumns(10);
		txtCardNo.setBorder(null);
		txtCardNo.setBackground(new Color(204, 204, 204));
		txtCardNo.setBounds(165, 219, 169, 63);
		contentPane.add(txtCardNo);
		
		txtPin = new JTextField();
		txtPin.setFocusable(false);
		txtPin.setText("Pin:");
		txtPin.setHorizontalAlignment(SwingConstants.CENTER);
		txtPin.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 37));
		txtPin.setColumns(10);
		txtPin.setBorder(null);
		txtPin.setBackground(new Color(204, 204, 204));
		txtPin.setBounds(165, 315, 169, 63);
		contentPane.add(txtPin);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBounds(344, 227, 386, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBounds(344, 323, 386, 55);
		contentPane.add(textField_1);
				
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				card=textField.getText();
				pin=textField_1.getText();
				if(card.isEmpty() || pin.isEmpty()) {
					JOptionPane.showMessageDialog(LoginPage.this, "Please enter all details.");
				}
				else {
					try {
						Database d=new Database();
						aid=d.getAccountID(card);
						cid=d.customerID(card);
						boolean check=d.validate(card,pin);
						if(!check) {
							JOptionPane.showMessageDialog(LoginPage.this, "Invalid Card No or Pin.");
						}
						else {
							Dashboard db=new Dashboard();
							db.setVisible(true);
							dispose();
						}
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(LoginPage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(174, 174, 174));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setBounds(363, 425, 151, 55);
		contentPane.add(btnNewButton);
		
		txtDoesntHaveAn = new JTextField();
		txtDoesntHaveAn.setText("Doesn't have an account?");
		txtDoesntHaveAn.setHorizontalAlignment(SwingConstants.CENTER);
		txtDoesntHaveAn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtDoesntHaveAn.setFocusable(false);
		txtDoesntHaveAn.setColumns(10);
		txtDoesntHaveAn.setBorder(null);
		txtDoesntHaveAn.setBackground(new Color(204, 204, 204));
		txtDoesntHaveAn.setBounds(183, 508, 315, 63);
		contentPane.add(txtDoesntHaveAn);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				AskAccount a=new AskAccount();
				a.setVisible(true);			
				}
		});
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 35));
		btnSignUp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSignUp.setBackground(new Color(174, 174, 174));
		btnSignUp.setBounds(498, 511, 151, 55);
		contentPane.add(btnSignUp);
		
	}
	
	public static String cardNO() {
		return card;
	}
	
	public static int customerID() {
		return cid;
	}
	
	public static int pin() {
		int p=Integer.parseInt(pin);
		return p;
	}
	
	public static int accountID() {
		return aid;
	}
}
