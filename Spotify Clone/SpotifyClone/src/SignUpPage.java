import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Cursor;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;

public class SignUpPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField txtName;
	private JTextField txtThisNameWill;
	private JTextField textField_4;
	private JTextField txtDateOfBirth;
	private JTextField txtDd;
	private JTextField txtYyyy;
	private JTextField txtGender;
	private JRadioButton rdbtnPreferNotTo;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 5, 875, 668);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(SignUpPage.class.getResource("/Images/Spotify.png")));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(350, 31, 45, 51);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setText("Spotify");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setBackground(Color.BLACK);
		textField.setBounds(404, 31, 113, 43);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter email:");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		textField_1.setFocusable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(57, 122, 209, 42);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_2.setBounds(57, 175, 322, 51);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("Enter password:");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		textField_3.setFocusable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBounds(57, 259, 209, 42);
		contentPane.add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		passwordField.setBounds(57, 312, 330, 51);
		contentPane.add(passwordField);
		
		txtName = new JTextField();
		txtName.setText("Name:");
		txtName.setForeground(Color.WHITE);
		txtName.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtName.setFocusable(false);
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBackground(Color.BLACK);
		txtName.setBounds(57, 394, 97, 42);
		contentPane.add(txtName);
		
		txtThisNameWill = new JTextField();
		txtThisNameWill.setText("This name will appear on your profile.");
		txtThisNameWill.setForeground(Color.WHITE);
		txtThisNameWill.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtThisNameWill.setFocusable(false);
		txtThisNameWill.setColumns(10);
		txtThisNameWill.setBorder(null);
		txtThisNameWill.setBackground(Color.BLACK);
		txtThisNameWill.setBounds(57, 432, 348, 28);
		contentPane.add(txtThisNameWill);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textField_4.setBounds(57, 464, 330, 51);
		contentPane.add(textField_4);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setText("Date of birth:");
		txtDateOfBirth.setForeground(Color.WHITE);
		txtDateOfBirth.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtDateOfBirth.setFocusable(false);
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBorder(null);
		txtDateOfBirth.setBackground(Color.BLACK);
		txtDateOfBirth.setBounds(473, 122, 186, 42);
		contentPane.add(txtDateOfBirth);
		
		txtDd = new JTextField();
		txtDd.setHorizontalAlignment(SwingConstants.LEADING);
		txtDd.setForeground(new Color(192, 192, 192));
		txtDd.setText("dd");
		txtDd.setBackground(new Color(0, 0, 0));
		txtDd.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtDd.setColumns(10);
		txtDd.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		txtDd.setBounds(473, 175, 76, 51);
		contentPane.add(txtDd);
		txtDd.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtDd.setText(" ");
			}
		});
		
		
		txtYyyy = new JTextField();
		txtYyyy.setText("yyyy");
		txtYyyy.setForeground(new Color(192, 192, 192));
		txtYyyy.setHorizontalAlignment(SwingConstants.LEADING);
		txtYyyy.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtYyyy.setColumns(10);
		txtYyyy.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		txtYyyy.setBackground(Color.BLACK);
		txtYyyy.setBounds(732, 175, 97, 51);
		contentPane.add(txtYyyy);
		txtYyyy.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				txtYyyy.setText(" ");
			}
		});

		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBounds(559, 175, 163, 51);
		contentPane.add(comboBox);
		
		txtGender = new JTextField();
		txtGender.setText("Gender:");
		txtGender.setForeground(Color.WHITE);
		txtGender.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		txtGender.setFocusable(false);
		txtGender.setColumns(10);
		txtGender.setBorder(null);
		txtGender.setBackground(Color.BLACK);
		txtGender.setBounds(473, 259, 186, 42);
		contentPane.add(txtGender);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Man");
		rdbtnNewRadioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		rdbtnNewRadioButton.setBounds(470, 312, 97, 37);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnWoman = new JRadioButton("Woman");
		rdbtnWoman.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnWoman.setForeground(Color.WHITE);
		rdbtnWoman.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		rdbtnWoman.setBackground(Color.BLACK);
		rdbtnWoman.setBounds(626, 312, 128, 37);
		contentPane.add(rdbtnWoman);
		
		rdbtnPreferNotTo = new JRadioButton("Prefer not to say");
		rdbtnPreferNotTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnPreferNotTo.setForeground(Color.WHITE);
		rdbtnPreferNotTo.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		rdbtnPreferNotTo.setBackground(Color.BLACK);
		rdbtnPreferNotTo.setBounds(473, 362, 249, 37);
		contentPane.add(rdbtnPreferNotTo);
		
		btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String email=textField_2.getText();
				String password=passwordField.getText();
				String name=textField_4.getText();
				String dob;
				String gender="";
				String day=txtDd.getText().trim();
				int iday=Integer.parseInt(day);
				String month=(String) comboBox.getSelectedItem();
				int imonth=getMonthNumberFromName(month);
				if (imonth == -1) {
                    JOptionPane.showMessageDialog(SignUpPage.this, "Invalid month.");
                    return;
                }
				String year=txtYyyy.getText().trim();
				int iyear=Integer.parseInt(year);
				if(email.isEmpty() || password.isEmpty() ||  name.isEmpty() || day.isEmpty() || year.isEmpty()) {
					JOptionPane.showMessageDialog(SignUpPage.this, "Please fill all  details.");
				}
				else {
					try {
						Database d=new Database();
						String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
						if (!email.matches(emailRegex)) {
							JOptionPane.showMessageDialog(SignUpPage.this, "Invalid email format.");
							return;
						}
						if(d.checkEmail(email)) {
							JOptionPane.showMessageDialog(SignUpPage.this, "Email already exists.");
							return;
						}
						if(rdbtnNewRadioButton.isSelected()) {
							gender="man";
						}
						else if(rdbtnWoman.isSelected()) {
							gender="woman";
						}
						else if(rdbtnPreferNotTo.isSelected()) {
							gender="not mentioned";
						}
						else {
							JOptionPane.showMessageDialog(SignUpPage.this, "Please select your gender.");
						}
						if(iday<1 ||  iday>31) {
							JOptionPane.showMessageDialog(SignUpPage.this, "Invalid day.");
							return;
						}
						
						if(!year.matches("\\d{4}") || iyear>2024){
							JOptionPane.showMessageDialog(SignUpPage.this, "Invalid year.");
							return;
						}
						dob=String.format("%04d-%02d-%02d", iyear, imonth, iday);
						d.addUser(email,password,name,dob,gender);
						HomePage h=new HomePage();
						h.setVisible(true);
						dispose();
						
					}catch (SQLException e1) {
						 JOptionPane.showMessageDialog(SignUpPage.this, "Exception occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
					catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(SignUpPage.this, "Invalid number format: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
					

				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(SignUpPage.class.getResource("/Images/next.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(295, 543, 300, 60);
		contentPane.add(btnNewButton);
		
		ButtonGroup g=new ButtonGroup();
		g.add(rdbtnNewRadioButton);
		g.add(rdbtnWoman);
		g.add(rdbtnPreferNotTo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Login l=new Login();
				l.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(SignUpPage.class.getResource("/Images/back.png")));
		lblNewLabel.setBounds(20, 24, 66, 65);
		contentPane.add(lblNewLabel);
	}
	
	 private int getMonthNumberFromName(String month) {
	        switch (month.toLowerCase()) {
	            case "january":
	                return 1;
	            case "february":
	                return 2;
	            case "march":
	                return 3;
	            case "april":
	                return 4;
	            case "may":
	                return 5;
	            case "june":
	                return 6;
	            case "july":
	                return 7;
	            case "august":
	                return 8;
	            case "september":
	                return 9;
	            case "october":
	                return 10;
	            case "november":
	                return 11;
	            case "december":
	                return 12;
	            default:
	                return -1; // Invalid month name
	        }
	    }
	}
